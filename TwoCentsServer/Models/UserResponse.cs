using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace TwoCentsServer.Models
{
    public class UserResponse : User
    {
        public List<Interest> Interests { get; set; }
        public List<Notification> Notifications { get; set; }
        public List<Attendance> Attendances { get; set; }
        public List<Event> EventRegistered { get; set; }
        public List<User> UserBookmarked { get; set; }
    }
}