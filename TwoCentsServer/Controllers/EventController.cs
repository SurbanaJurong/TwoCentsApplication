using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TwoCentsServer.Models;

namespace TwoCentsServer.Controllers
{
    public class EventController : BaseController<Event, EventResponse>
    {
        private EventResponse _ToResponse(Event entry, LocalDBDataContext db)
        {
            EventResponse res = (EventResponse)entry;
            res.UserRegistered = db.Users.Where(u =>
                db.Registrations
                    .Where(p => p.EventId == entry.Id)
                    .Select(p => p.UserId)
                .Contains(u.Id)
            ).ToList();
            res.Participants = db.Users.Where(u =>
                db.Participations
                    .Where(p => p.EventId == entry.Id)
                    .Select(p => p.UserId)
                .Contains(u.Id)
            ).ToList();
                
            res.Comments = db.Comments.Where(c => c.EventId == entry.Id).ToList();
            return res;
        }

        public override IHttpActionResult Get()
        {
            using (var db = new LocalDBDataContext())
            {
                var body = db.Events.Select(r => _ToResponse(r, db)).ToList();
                return Json(body);
            }
        }

        public override IHttpActionResult Get(int id)
        {
            using (var db = new LocalDBDataContext())
            {
                var body = _ToResponse(db.Events.FirstOrDefault(r => r.Id == id), db);
                return Json(body);
            }
        }

        public override IHttpActionResult Post([FromBody] EventResponse data)
        {
            using (var db = new LocalDBDataContext())
            {
                db.Events.InsertOnSubmit(data);
                db.SubmitChanges();
                return Json(data);
            }
        }
    }
}
