using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TwoCentsServer.Models;

namespace TwoCentsServer.Controllers
{
    public class RegistrationController : ApiController
    {
        [HttpGet]
        public IHttpActionResult Get()
        {
            using (var db = new LocalDBDataContext())
            {
                var body = db.Registrations.ToList();
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

                var body = db.Registrations.AsEnumerable()
                    .Where(r => parsedUserId != 0 ? r.UserId == parsedUserId : true)
                    .Where(r => parsedEventId != 0 ? r.EventId == parsedEventId : true)
                    .ToList();

                return Json(body);
            }
        }

        public IHttpActionResult Post([FromBody] Registration data)
        {
            using (var db = new LocalDBDataContext())
            {
                db.Registrations.InsertOnSubmit(data);
                db.SubmitChanges();
                return Json(data);
            }
        }
    }
}
