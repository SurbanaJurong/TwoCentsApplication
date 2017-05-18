using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TwoCentsServer.Models;

namespace TwoCentsServer.Controllers
{
    public abstract class BaseController<T, TRes> : ApiController where T: class
    {
        [HttpGet]
        public abstract IHttpActionResult Get();

        [HttpGet]
        public abstract IHttpActionResult Get(int id);

        [HttpPost]
        public abstract IHttpActionResult Post([FromBody]TRes data);
    }
}
