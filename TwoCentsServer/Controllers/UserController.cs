using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TwoCentsServer.Models;
using TwoCentsServer.Repositories;

namespace TwoCentsServer.Controllers
{
    public class UserController : BaseController<User, UserResponse>
    {
        public override IHttpActionResult Get()
        {
            using (var db = LinqRepository.DataCtx())
            {
                var body = db.Users.AsEnumerable().Select(r => LinqRepository.ToUserResponse(r, db)).ToList();
                return Json(body);
            }
        }

        [HttpGet]
        public override IHttpActionResult Get(int id)
        {
            using (var db = LinqRepository.DataCtx())
            {
                var body = LinqRepository.ToUserResponse(db.Users.FirstOrDefault(r => r.Id == id), db);
                return Json(body);
            }
        }
        [HttpGet]
        public IHttpActionResult Get(string query)
        {
            using (var db = LinqRepository.DataCtx())
            {
                var body = db.Users.Where(r => r.UserName.Contains(query)).ToList();
                return Json(body);
            }
        }

        public override IHttpActionResult Post([FromBody] UserResponse data)
        {
            using (var db = LinqRepository.DataCtx())
            {
                db.Users.InsertOnSubmit(data);
                db.SubmitChanges();
                return Json(data);
            }
        }
    }
}
