using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web;

namespace TwoCentsServer.Models
{
    public class EventResponse : Event
    {
        public List<User> UserRegistered { get; set; }
        public List<User> Participants { get; set; }
        public List<Comment> Comments { get; set; }
        public new string Timestamp { get; set; }
        public new string StartTime { get; set; }
        public new string Duration { get; set; }

        public static EventResponse FromModel(Event e)
        {
            return new EventResponse
            {
                Id = e.Id,
                Host = e.Host,
                Description = e.Description,
                IsRecurring = e.IsRecurring,
                Timestamp = e.Timestamp.ToString("yyyy-MM-dd HH:mm:ss.fff", CultureInfo.InvariantCulture),
                VenueId = e.VenueId,
                MinCapacity = e.MinCapacity,
                MaxCapacity = e.MaxCapacity,
                IsCancelled = e.IsCancelled,
                StartTime = e.StartTime.ToString("yyyy-MM-dd HH:mm:ss.fff", CultureInfo.InvariantCulture),
                Duration = e.Duration.ToString(),
                Name = e.Name,
                Category = e.Category
            };
        }

        public Event ToModel()
        {
            return new Event
            {
                Id = Id,
                Host = Host,
                Description = Description,
                IsRecurring = IsRecurring,
                Timestamp = DateTime.ParseExact(Timestamp, "yyyy-MM-dd HH:mm:ss.fff", CultureInfo.InvariantCulture),
                VenueId = VenueId,
                MinCapacity = MinCapacity,
                MaxCapacity = MaxCapacity,
                IsCancelled = IsCancelled,
                StartTime = DateTime.ParseExact(StartTime, "yyyy-MM-dd HH:mm:ss.fff", CultureInfo.InvariantCulture),
                Duration = TimeSpan.Parse(Duration),
                Name = Name,
                Category = Category
            };
        }
    }
}