using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace TwoCentsServer.Models
{
    public class VenueResponse : Venue
    {
        public List<Slot> Slots { get; set; }

        public static VenueResponse FromModel(Venue venue)
        {
            return new VenueResponse
            {
                Id = venue.Id,
                Name = venue.Name,
                InterestId = venue.InterestId,
                Location = venue.Location
            };
        }
    }
}