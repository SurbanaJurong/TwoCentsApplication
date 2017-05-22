using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TwoCentsServer.Models;

namespace TwoCentsServer.Controllers
{
    public class BookmarkUserController : ApiController
    {
        [HttpGet]
        public IHttpActionResult Get()
        {
            using (var db = new LocalDBDataContext())
            {
                var body = db.BookmarkUsers.ToList();
                return Json(body);
            }
        }

        public IHttpActionResult Get(string userId, string targetId)
        {
            using (var db = new LocalDBDataContext())
            {
                int parsedUserId, parsedTargetId;
                int.TryParse(userId, out parsedUserId);
                int.TryParse(targetId, out parsedTargetId);

                var body = db.BookmarkUsers.AsEnumerable()
                    .Where(r => parsedUserId != 0 ? r.UserId == parsedUserId : true)
                    .Where(r => parsedTargetId != 0 ? r.TargetId == parsedTargetId : true)
                    .ToList();

                return Json(body);
            }
        }

        public IHttpActionResult Post([FromBody] List<BookmarkUser> data)
        {
            using (var db = new LocalDBDataContext())
            {
                db.BookmarkUsers.InsertAllOnSubmit(data);
                db.SubmitChanges();
                return Json(data);
            }
        }

        public IHttpActionResult Delete([FromBody] List<BookmarkUser> data)
        {
            using (var db = new LocalDBDataContext())
            {
                db.BookmarkUsers.DeleteAllOnSubmit(data);
                db.SubmitChanges();
                return Json(data);
            }
        }
    }
}
