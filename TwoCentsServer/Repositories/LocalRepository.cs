using System;
using System.Collections.Generic;
using System.Data.Linq;
using System.Linq;
using System.Web;
using TwoCentsServer.Models;

namespace TwoCentsServer.Repositories
{
    public class LocalRepository
    {
        private LocalDBDataContext db;

        public LocalRepository()
        {
            Load();
        }

        public void Load()
        {
            db = new LocalDBDataContext();
        }

        public void Dispose()
        {
            db.Dispose();
        }

        public Table<T> GetTable<T>() where T: class
        {
            return db.GetTable<T>();
        }
    }
}