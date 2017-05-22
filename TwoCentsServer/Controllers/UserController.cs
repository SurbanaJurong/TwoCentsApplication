using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TwoCentsServer.Models;

namespace TwoCentsServer.Controllers
{
    public class UserController : BaseController<User, UserResponse>
    {
        private UserResponse _ToResponse(User entry, LocalDBDataContext db)
        {
            UserResponse res = (UserResponse)entry;
            res.Interests = db.Interests.Where(i =>
                db.UserInterests
                    .Where(ui => ui.UserId == entry.Id)
                    .Select(ui => ui.InterestId)
                .Contains(i.Id)
            ).ToList();
            res.Notifications = db.Notifications.Where(n => n.SenderId == entry.Id).ToList();
            res.Attendances = db.Attendances.Where(a => a.UserId == entry.Id).ToList();
            res.EventRegistered = db.Events.Where(e =>
                db.Registrations
                    .Where(reg => reg.UserId == reg.Id)
                    .Select(reg => reg.EventId)
                .Contains(e.Id)
            ).ToList();
            res.UserBookmarked = db.Users.Where(u =>
                db.BookmarkUsers
                    .Where(b => b.UserId == entry.Id)
                    .Select(b => b.TargetId)
                .Contains(u.Id)
            ).ToList();
            return res;
        }

        public override IHttpActionResult Get()
        {
            using (var db = new LocalDBDataContext())
            {
                var body = db.Users.AsEnumerable().Select(r => _ToResponse(r, db)).ToList();
                return Json(body);
            }
        }

        [HttpGet]
        public override IHttpActionResult Get(int id)
        {
            using (var db = new LocalDBDataContext())
            {
                var body = _ToResponse(db.Users.FirstOrDefault(r => r.Id == id), db);
                return Json(body);
            }
        }
        [HttpGet]
        public IHttpActionResult Get(string query)
        {
            using (var db = new LocalDBDataContext())
            {
                var body = db.Users.Where(r => r.UserName.Contains(query)).ToList();
                return Json(body);
            }
        }

        public override IHttpActionResult Post([FromBody] UserResponse data)
        {
            using (var db = new LocalDBDataContext())
            {
                db.Users.InsertOnSubmit(data);
                db.SubmitChanges();
                return Json(data);
            }
        }
    }
}
