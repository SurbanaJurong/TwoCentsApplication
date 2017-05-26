using Albireo.Otp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Twilio;
using Twilio.Rest.Api.V2010.Account;
using TwoCentsServer.Models;

namespace TwoCentsServer.Services
{
    public class TwilioServiceHandler
    {
        private static List<OTPInfo> _pendingUsers = new List<OTPInfo>();

        public bool AddRequest(string username, string phone)
        {
            try
            {
                int otpNum = Hotp.GetCode(
                    HashAlgorithm.Sha256,
                    username + DateTime.UtcNow.ToString(),
                    username.Length,
                    4
                );
                string sid = "AC078f6008e40dcfd1441d8cb9ac28c6a3";
                string token = "2fdf4658665f49a195b554e9fa1aad0d";
                string apiPhoneNumber = "+12609186078";

                TwilioClient.Init(sid, token);

                var message = MessageResource.Create(
                    to: new Twilio.Types.PhoneNumber(phone),
                    from: new Twilio.Types.PhoneNumber(apiPhoneNumber),
                    body: "Your OTP is " + string.Format("{0:0000}", otpNum)
                );

                _pendingUsers.Add(new OTPInfo { username = username, otp = otpNum });

                return true;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                return false;
            }
        }

        public bool Validate(OTPInfo info)
        {
            var target = _pendingUsers.Where(u => u.username == info.username && u.otp == info.otp);
            bool res = target.Count() == 1;
            if (res) _pendingUsers.Remove(target.First());
            return res;
        }
    }

    public class OTPInfo
    {
        public string username { get; set; }
        public int otp { get; set; }
    }
}