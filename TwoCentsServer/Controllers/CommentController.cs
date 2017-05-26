using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Results;
using TwoCentsServer.Models;
using TwoCentsServer.Services;

namespace TwoCentsServer.Controllers
{
    public class CommentController : ApiController
    {
        public IHttpActionResult Get()
        {
            using (var db = LinqRepository.DataCtx())
            {
                var body = db.Comments.Select(r => CommentResponse.FromModel(r)).ToList();
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

                var body = db.Comments.AsEnumerable()
                    .Where(r => parsedUserId != 0 ? r.UserId == parsedUserId : true)
                    .Where(r => parsedEventId != 0 ? r.EventId == parsedEventId : true)
                    .Select(r => CommentResponse.FromModel(r))
                    .ToList();

                return Ok(body);
            }
        }

        public IHttpActionResult Post([FromBody] Comment data)
        {
            using (var db = LinqRepository.DataCtx())
            {
                data.Timestamp = DateTime.UtcNow;
                db.Comments.InsertOnSubmit(data);
                db.SubmitChanges();
                return Ok(data);
            }
        }

        public IHttpActionResult Delete([FromBody] Comment data)
        {
            using (var db = LinqRepository.DataCtx())
            {
                db.Comments.DeleteOnSubmit(db.Comments.FirstOrDefault(r => r.Id == data.Id));
                db.SubmitChanges();
                return Ok(data);
            }
        }
    }
}
