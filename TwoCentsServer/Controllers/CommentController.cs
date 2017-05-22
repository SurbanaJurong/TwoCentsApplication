using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Results;
using TwoCentsServer.Models;

namespace TwoCentsServer.Controllers
{
    public class CommentController : ApiController
    {
        public IHttpActionResult Get()
        {
            using (var db = new LocalDBDataContext())
            {
                var body = db.Comments.ToList();
                return Json(body);
            }
        }

        public IHttpActionResult Get(string userId, string eventId)
        {
            using (var db = new LocalDBDataContext())
            {
                int parsedUserId, parsedEventId;
                int.TryParse(userId, out parsedUserId);
                int.TryParse(eventId, out parsedEventId);

                var body = db.Comments.AsEnumerable()
                    .Where(r => parsedUserId != 0 ? r.UserId == parsedUserId : true)
                    .Where(r => parsedEventId != 0 ? r.EventId == parsedEventId : true)
                    .ToList();

                return Json(body);
            }
        }

        public IHttpActionResult Post([FromBody] Comment data)
        {
            using (var db = new LocalDBDataContext())
            {
                db.Comments.InsertOnSubmit(data);
                db.SubmitChanges();
                return Json(data);
            }
        }

        public IHttpActionResult Delete([FromBody] Comment data)
        {
            using (var db = new LocalDBDataContext())
            {
                db.Comments.DeleteOnSubmit(db.Comments.FirstOrDefault(r => r.Id == data.Id));
                db.SubmitChanges();
                return Json(data);
            }
        }
    }
}
