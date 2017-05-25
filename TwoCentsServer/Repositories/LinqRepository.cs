using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using TwoCentsServer.Models;

namespace TwoCentsServer.Repositories
{
    public static class LinqRepository
    {
        public static AzureDBDataContext DataCtx()
        {
            return new AzureDBDataContext();
        }

        public static EventResponse ToEventResponse(Event entry, AzureDBDataContext db)
        {
            EventResponse res = (EventResponse)entry;
            res.UserRegistered = db.Users.Where(u =>
                db.Registrations
                    .Where(p => p.EventId == entry.Id)
                    .Select(p => p.UserId)
                .Contains(u.Id)
            ).ToList();
            res.Participants = db.Users.Where(u =>
                db.Participations
                    .Where(p => p.EventId == entry.Id)
                    .Select(p => p.UserId)
                .Contains(u.Id)
            ).ToList();

            res.Comments = db.Comments.Where(c => c.EventId == entry.Id).ToList();
            return res;
        }
        public static UserResponse ToUserResponse(User entry, AzureDBDataContext db)
        {
            UserResponse res = (UserResponse)entry;
            res.Interests = db.Interests.Where(i =>
                db.UserInterests
                    .Where(ui => ui.UserId == entry.Id)
                    .Select(ui => ui.InterestId)
                .Contains(i.Id)
            ).ToList();
            res.Notifications = db.Notifications.Where(n => n.SenderId == entry.Id).ToList();
            res.Attendances = db.Attendances.Where(a => a.UserId == entry.Id).ToList();
            res.EventRegistered = db.Events.Where(e =>
                db.Registrations
                    .Where(reg => reg.UserId == reg.Id)
                    .Select(reg => reg.EventId)
                .Contains(e.Id)
            ).ToList();
            res.UserBookmarked = db.Users.Where(u =>
                db.BookmarkUsers
                    .Where(b => b.UserId == entry.Id)
                    .Select(b => b.TargetId)
                .Contains(u.Id)
            ).ToList();
            return res;
        }
        public static VenueResponse ToVenueResponse(Venue entry, AzureDBDataContext db)
        {
            VenueResponse res = (VenueResponse)entry;
            res.Slots = db.Slots.Where(s => s.VenueId == entry.Id).ToList();
            return res;
        }
    }
}