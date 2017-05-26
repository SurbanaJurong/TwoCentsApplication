using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web;

namespace TwoCentsServer.Models
{
    public class CommentResponse : Comment
    {
        public new string Timestamp { get; set; }

        public static CommentResponse FromModel(Comment cmt)
        {
            return new CommentResponse
            {
                Id = cmt.Id,
                Timestamp = cmt.Timestamp.ToString("yyyy-MM-dd HH:mm:ss.fff", CultureInfo.InvariantCulture),
                UserId = cmt.UserId,
                Content = cmt.Content,
                EventId = cmt.EventId
            };
        }

        public Comment ToModel()
        {
            return new Comment
            {
                Id = Id,
                Timestamp = DateTime.ParseExact(Timestamp, "yyyy-MM-dd HH:mm:ss.fff", CultureInfo.InvariantCulture),
                UserId = UserId,
                Content = Content,
                EventId = EventId
            };
        }
    }
}