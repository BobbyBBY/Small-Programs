using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using WebApplication1;

namespace Model
{
    public class Manager
    {
        public string Name;
        public string Password;
        public Manager()
        {
            Name = null;
            Password = null;
        }
    }
}
namespace BLL
{
    public class Manager
    {

        public bool ValidatePassword(Model.Manager MM)
        {
            DAL.Manager VP = new DAL.Manager();
            return VP.SelectCount(MM);
        }
    }
}
namespace DAL
{
    public class Manager
    {
        public bool SelectCount(Model.Manager MM)
        {
            string sqlstr;
            SqlParameter[] pms;
            if (MM.Password == null)
            {
                pms = new SqlParameter[1];
                sqlstr = "select Username from Manager where Username=@UN";
            }
            else
            {
                sqlstr = "select Username from Manager where Username=@UN and Password=@PWD";
                pms = new SqlParameter[2];
                pms[1] = new SqlParameter("@PWD", MM.Password);
            }
            pms[0] = new SqlParameter("@UN", MM.Name);

            SqlDataReader dr = SqlHelper.ExecuteReader(sqlstr, CommandType.Text, pms);
            return dr.HasRows;
        }
    }
}