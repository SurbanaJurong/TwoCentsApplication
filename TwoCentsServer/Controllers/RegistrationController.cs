using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TwoCentsServer.Models;
using TwoCentsServer.Services;

namespace TwoCentsServer.Controllers
{
    public class RegistrationController : ApiController
    {
        [HttpGet]
        public IHttpActionResult Get()
        {
            using (var db = LinqRepository.DataCtx())
            {
                var body = db.Registrations.ToList();
                return Ok(body);
            }
        }

        public IHttpActionResult Get(string userId, string eventId)
        {
            using (var db = LinqRepository.DataCtx())
            {
                int parsedUserId, parsedEventId;
                int.TryParse(userId, out parsedUserId);
                int.TryParse(eventId, out parsedEventId);

                var body = db.Registrations.AsEnumerable()
                    .Where(r => parsedUserId != 0 ? r.UserId == parsedUserId : true)
                    .Where(r => parsedEventId != 0 ? r.EventId == parsedEventId : true)
                    .ToList();

                return Ok(body);
            }
        }

        public IHttpActionResult Post([FromBody] Registration data)
        {
            using (var db = LinqRepository.DataCtx())
            {
                db.Registrations.InsertOnSubmit(data);
                db.SubmitChanges();
                return Ok(data);
            }
        }
    }
}
