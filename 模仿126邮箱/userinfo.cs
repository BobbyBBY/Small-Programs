using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using WebApplication1;

namespace Model
{
    public class Userinfo
    {
        public string Name;
        public string Password;
        public Userinfo()
        {
            Name = null;
            Password = null;
        }
    }
}

namespace BLL
{
    public class Userinfo
    {
        
        public bool ValidatePassword(Model.Userinfo MUS)
        {
            DAL.Userinfo VP = new DAL.Userinfo();
            return VP.SelectCount(MUS);
        }
        public bool ForgetPassword(Model.Userinfo MUS)
        {
            DAL.Userinfo FP = new DAL.Userinfo();
            if (FP.Update(MUS) == 1)
                return true;
            else return false;
        }
        public bool UpdateUser(Model.Userinfo MUS)
        {
            return ForgetPassword(MUS);
        }
        public bool RepeatedName(Model.Userinfo MUS)
        {
            MUS.Password = null;
            DAL.Userinfo RN = new DAL.Userinfo();
            return RN.SelectCount(MUS);
        }
        public bool Register(Model.Userinfo MUS)
        {
            DAL.Userinfo R = new DAL.Userinfo();
            if (R.Insert(MUS) == 1)
                return true;
            else return false;
        }
        public bool DeleteUser(Model.Userinfo MUS)
        {
            DAL.Userinfo DU = new DAL.Userinfo();
            if (DU.Delete(MUS) == 1)
                return true;
            else return false;
        }
    }
}

namespace DAL
{
    public class Userinfo
    {
        public bool SelectCount(Model.Userinfo MUS)
        {
            string sqlstr;
            SqlParameter[] pms;
            if (MUS.Password == null)
            {
                pms = new SqlParameter[1];
                sqlstr = "select Username from User_Info where Username=@UN";
            }
            else
            {
                sqlstr = "select Username from User_Info where Username=@UN and Password=@PWD";
                pms = new SqlParameter[2];
                pms[1] = new SqlParameter("@PWD", MUS.Password);
            }
            pms[0] = new SqlParameter("@UN", MUS.Name);

            SqlDataReader dr =SqlHelper.ExecuteReader(sqlstr,CommandType.Text,pms);
            return dr.HasRows;
        }
        public int Update(Model.Userinfo MUS)
        {
            string sqlstr = "update User_Info set Password=@PWD where Username=@UN";
            SqlParameter[] pms = new SqlParameter[2];
            pms[0] = new SqlParameter("@UN", MUS.Name);
            pms[1] = new SqlParameter("@PWD", MUS.Password);
            int rows = SqlHelper.ExecuteNonQuery(sqlstr, CommandType.Text, pms);
            return rows;
        }
        public int Insert(Model.Userinfo MUS)
        {
            string sqlstr = "insert into User_Info(Username, Password) values(@UN ,@PWD)";
            SqlParameter[] pms = new SqlParameter[2];
            pms[0] = new SqlParameter("@UN", MUS.Name);
            pms[1] = new SqlParameter("@PWD", MUS.Password);
            int rows = SqlHelper.ExecuteNonQuery(sqlstr, CommandType.Text, pms);
            return rows;
        }
        public int Delete(Model.Userinfo MUS)
        {
            string sqlstr = "DELETE FROM User_Info WHERE Username=@UN";
            SqlParameter[] pms = new SqlParameter[1];
            pms[0] = new SqlParameter("@UN", MUS.Name);
            int rows = SqlHelper.ExecuteNonQuery(sqlstr, CommandType.Text, pms);
            return rows;
        }
    }
}