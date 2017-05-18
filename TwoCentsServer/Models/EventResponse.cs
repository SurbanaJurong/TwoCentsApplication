using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace TwoCentsServer.Models
{
    public class EventResponse : Event
    {
        public List<User> UserRegistered { get; set; }
        public List<User> Participants { get; set; }
        public List<Comment> Comments { get; set; }
    }
}