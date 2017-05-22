using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TwoCentsServer.Models;

namespace TwoCentsServer.Controllers
{
    public class ParticipationController : ApiController
    {
        [HttpGet]
        public IHttpActionResult Get()
        {
            using (var db = new LocalDBDataContext())
            {
                var body = db.Participations.ToList();
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

                var body = db.Participations.AsEnumerable()
                    .Where(r => parsedUserId != 0 ? r.UserId == parsedUserId : true)
                    .Where(r => parsedEventId != 0 ? r.EventId == parsedEventId : true)
                    .ToList();

                return Json(body);
            }
        }

        public IHttpActionResult Post([FromBody] Participation data)
        {
            using (var db = new LocalDBDataContext())
            {
                db.Participations.InsertOnSubmit(data);
                
                int? interestId = db.Events.First(r => r.Id == data.EventId).Category;
                if (interestId != null)
                {
                    Attendance att = db.Attendances.FirstOrDefault(r => r.InterestId == interestId && r.UserId == data.UserId);
                    if (att != null)
                    {
                        att.Count++;
                    }
                    else
                    {
                        db.Attendances.InsertOnSubmit(new Attendance
                        {
                            InterestId = interestId,
                            UserId = data.UserId,
                            Count = 1
                        });
                    }
                }

                db.SubmitChanges();
                return Json(data);
            }
        }
    }
}
