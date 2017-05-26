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

        public static EventResponse FromModel(Event e)
        {
            return new EventResponse
            {
                Id = e.Id,
                Host = e.Host,
                Description = e.Description,
                IsRecurring = e.IsRecurring,
                Timestamp = e.Timestamp,
                Venue = e.Venue,
                MinCapacity = e.MinCapacity,
                MaxCapacity = e.MaxCapacity,
                IsCancelled = e.IsCancelled,
                StartTime = e.StartTime,
                Duration = e.Duration,
                Name = e.Name,
                Category = e.Category
            };
        }
    }
}