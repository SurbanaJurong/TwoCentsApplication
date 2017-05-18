using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TwoCentsServer.Models;

namespace TwoCentsServer.Controllers
{
    public class VenueController : BaseController<Venue, VenueResponse>
    {
        private VenueResponse _ToResponse(Venue entry, LocalDBDataContext db)
        {
            VenueResponse res = (VenueResponse)entry;
            res.Slots = db.Slots.Where(s => s.VenueId == entry.Id).ToList();
            return res;
        }

        public override IHttpActionResult Get()
        {
            using (var db = new LocalDBDataContext())
            {
                var body = db.Venues.Select(r => _ToResponse(r, db)).ToList();
                return Json(body);
            }
        }

        public override IHttpActionResult Get(int id)
        {
            using (var db = new LocalDBDataContext())
            {
                var body = _ToResponse(db.Venues.FirstOrDefault(r => r.Id == id), db);
                return Json(body);
            }
        }

        public override IHttpActionResult Post([FromBody] VenueResponse data)
        {
            using (var db = new LocalDBDataContext())
            {
                db.Venues.InsertOnSubmit(data);
                db.SubmitChanges();
                return Json(data);
            }
        }
    }
}
