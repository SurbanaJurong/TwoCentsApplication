using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace TwoCentsServer.Models
{
    public class VenueResponse : Venue
    {
        public List<Slot> Slots { get; set; }
    }
}