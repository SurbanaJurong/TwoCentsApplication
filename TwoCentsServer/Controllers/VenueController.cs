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
    public class VenueController : ApiController
    {
        public IHttpActionResult Get()
        {
            using (var db = LinqRepository.DataCtx())
            {
                var body = db.Venues.Select(r => LinqRepository.ToVenueResponse(r, db)).ToList();
                return Json(body);
            }
        }

        public IHttpActionResult Get(int id)
        {
            using (var db = LinqRepository.DataCtx())
            {
                var body = LinqRepository.ToVenueResponse(db.Venues.FirstOrDefault(r => r.Id == id), db);
                return Json(body);
            }
        }

        public IHttpActionResult Post([FromBody] Venue data)
        {
            using (var db = LinqRepository.DataCtx())
            {
                db.Venues.InsertOnSubmit(data);
                db.SubmitChanges();
                return Json(data);
            }
        }
    }
}
