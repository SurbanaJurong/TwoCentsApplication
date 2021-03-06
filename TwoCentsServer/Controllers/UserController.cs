﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TwoCentsServer.Models;
using TwoCentsServer.Services;

namespace TwoCentsServer.Controllers
{
    public class UserController : ApiController
    {
        private TwilioServiceHandler _smsHdlr;
        private static List<User> _pendingUsers = new List<User>();

        public UserController()
        {
            _smsHdlr = new TwilioServiceHandler();
        }

        public IHttpActionResult Get()
        {
            using (var db = LinqRepository.DataCtx())
            {
                var body = db.Users.AsEnumerable().Select(r => LinqRepository.ToUserResponse(r, db)).ToList();
                return Ok(body);
            }
        }

        [HttpGet]
        public IHttpActionResult Get(int id)
        {
            using (var db = LinqRepository.DataCtx())
            {
                var body = LinqRepository.ToUserResponse(db.Users.FirstOrDefault(r => r.Id == id), db);
                return Ok(body);
            }
        }
        [HttpGet]
        public IHttpActionResult Get(string query)
        {
            using (var db = LinqRepository.DataCtx())
            {
                var body = db.Users.Where(r => r.UserName.Contains(query)).ToList();
                return Ok(body);
            }
        }
        [HttpPost]
        public IHttpActionResult Post([FromBody] User data)
        {
            bool result = _smsHdlr.AddRequest(data.UserName, data.Phone);
            if (result)
            {
                data.Timestamp = DateTime.UtcNow;
                _pendingUsers.Add(data);
                return Ok(new { message = "Request queued & OTP sent. Awaiting confirmation." });
            }
            else
            {
                return BadRequest("An error has occured while processing request.");
            }

        }
        [HttpPut]
        public IHttpActionResult Put([FromBody] OTPInfo data)
        {
            bool result = _smsHdlr.Validate(data);
            if (result)
            {
                using (var db = LinqRepository.DataCtx())
                {

                    User target = _pendingUsers.First(u => u.UserName == data.username);
                    _pendingUsers.Remove(target);
                    db.Users.InsertOnSubmit(target);
                    db.SubmitChanges();
                    return Ok(target);
                }
            }
            else
            {
                return BadRequest("An error has occured while validating OTP.");
            }
        }

    }
}
