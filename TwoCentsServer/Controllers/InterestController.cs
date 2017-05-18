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
    public class InterestController : BaseController<Interest, Interest>
    {
        public override IHttpActionResult Get()
        {
            using (var db = new LocalDBDataContext())
            {
                var body = db.Interests.ToList();
                return Json(body);
            }
        }

        [HttpGet]
        public override IHttpActionResult Get(int id)
        {
            using (var db = new LocalDBDataContext())
            {
                var body = db.Interests.FirstOrDefault(r => r.Id == id);
                return Json(body);
            }
        }

        public override IHttpActionResult Post([FromBody] Interest data)
        {
            using (var db = new LocalDBDataContext())
            {
                db.Interests.InsertOnSubmit(data);
                db.SubmitChanges();
                return Json(data);
            }
        }
    }
}
