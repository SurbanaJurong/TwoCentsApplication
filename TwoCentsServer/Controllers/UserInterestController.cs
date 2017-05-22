﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TwoCentsServer.Models;

namespace TwoCentsServer.Controllers
{
    public class UserInterestController : ApiController
    {
        public IHttpActionResult Get()
        {
            using (var db = new LocalDBDataContext())
            {
                var body = db.UserInterests.ToList();
                return Json(body);
            }
        }

        public IHttpActionResult Get(string userId, string interestId)
        {
            using (var db = new LocalDBDataContext())
            {
                int parsedUserId, parsedInterestId;
                int.TryParse(userId, out parsedUserId);
                int.TryParse(interestId, out parsedInterestId);

                var body = db.UserInterests.AsEnumerable()
                    .Where(r => parsedUserId != 0 ? r.UserId == parsedUserId : true)
                    .Where(r => parsedInterestId != 0 ? r.InterestId == parsedInterestId : true)
                    .ToList();

                return Json(body);
            }
        }

        //public IHttpActionResult Post([FromBody] UserInterest data)
        //{
        //    using (var db = new LocalDBDataContext())
        //    {
        //        db.UserInterests.InsertOnSubmit(data);
        //        db.SubmitChanges();
        //        return Json(data);
        //    }
        //}

        public IHttpActionResult Post([FromBody] List<UserInterest> data)
        {
            using (var db = new LocalDBDataContext())
            {
                db.UserInterests.InsertAllOnSubmit(data);
                db.SubmitChanges();
                return Json(data);
            }
        }

        public IHttpActionResult Delete([FromBody] List<UserInterest> data)
        {
            using (var db = new LocalDBDataContext())
            {
                db.UserInterests.DeleteAllOnSubmit(data);
                db.SubmitChanges();
                return Json(data);
            }
        }
    }
}
