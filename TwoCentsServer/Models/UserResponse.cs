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

        public static UserResponse FromModel(User user)
        {
            return new UserResponse
            {
                Id = user.Id,
                UserName = user.UserName,
                ProfilePic = user.ProfilePic,
                Phone = user.Phone,
                NRIC = user.NRIC,
                Location = user.Location,
                Year = user.Year,
                Timestamp = user.Timestamp
            };
        }
    }
}