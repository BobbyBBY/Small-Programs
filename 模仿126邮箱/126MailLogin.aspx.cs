using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;
using System.Configuration;

namespace WebApplication1
{
    public partial class _126MailWM : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

            if (!Page.IsPostBack)
            {
                if (Request.Cookies["Username"] != null&& Request.Cookies["Username"].Value!="")
                {
                    username.Text = Request.Cookies["Username"].Value;
                }
                if(Request.Cookies["Password"] != null&& Request.Cookies["Password"].Value != "")
                {
                    if (LoginAuto(Request.Cookies["Username"].Value , Request.Cookies["Password"].Value))
                    {
                        username.Text = Request.Cookies["Username"].Value;
                        Response.Redirect("126MailWelcome.aspx");
                    }
                }
                
            }
        }
        protected void ButtonLogin_Click(object sender, EventArgs e)
        {
            if (LoginAuto(username.Text,password.Text))
            {
                Response.Redirect("126MailWelcome.aspx");
            }
        }
        protected bool LoginAuto(string un,string pwd)
        {
            bool userpassword = false;


            Model.Userinfo LAM = new Model.Userinfo();
            LAM.Name = un;
            LAM.Password = pwd;
            BLL.Userinfo LA = new BLL.Userinfo();
            userpassword=LA.ValidatePassword(LAM);
               
            if (userpassword)
            {
                Session["User"] = true;
                Response.Cookies["Username"].Value = un;
                Response.Cookies["Username"].Expires.AddDays(10);
                if (TenDays.Checked == true)
                {
                    Response.Cookies["Password"].Value = pwd;
                    Response.Cookies["Password"].Expires.AddDays(10);
                }
                return true;
            }
            else
            {
                Response.Cookies["Username"].Value = null;
                PasswordIncorrect.IsValid = false;
            }
            return false;
        }
        public string showCode()
        {
            //  VCode a = new VCode();
            //a.printCheckCodeImg2();
            // if (Session["CheckCode"] != null)
            // return Session["CheckCode"].ToString();
            return CheckCode;
            //return   Request.Cookies["CheckCode"].Value;
            //return VCode.code;
            //return "asf";
            //if (VCode.code == null)
            //    return "1234";
            //else return VCode.code;
        }
        private string CheckCode;
        public string CreateVerifyUrl()
        {
            CreateVerifyCode();
            String urll = "VCode.aspx?abc=";
            urll = urll + CheckCode;
            return urll;
        }
        public string CreateVerifyCode()
        {
            string codeSerial = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";//62
            Random rd = new Random();
            string Code = "";
            for (int i = 0; i < 6; i++)
                Code = Code + codeSerial.Substring(rd.Next(62), 1);
            CheckCode = Code;
            return Code;
        }
        protected void CheckCodeImg_Click1(object sender, ImageClickEventArgs e)
        {
            CheckCodeImg.Attributes["src"] = CreateVerifyUrl();
            // var urlImg = document.getElementById("CheckCodeImg").src = "<%= CreateVerifyUrl()%>";
        }
        public string IniCheckCode()
        {
            CheckCodeImg.Attributes["src"] = CreateVerifyUrl();
            return "";

        }
        protected void sqlLink()//test函数,不会被调用
        {
            SqlConnection conn = new SqlConnection();
            conn.ConnectionString = ConfigurationManager.ConnectionStrings["connsql"].ToString();
            SqlCommand comm = new SqlCommand();
            comm.Connection = conn;
            string usernamestr = username.Text;
            string commstr = "select Password from User where Username="+usernamestr;
            conn.Open();
            SqlDataReader reader = comm.ExecuteReader();
            if (reader.Read())
            {
                if (reader["Password"].ToString() == password.Text)
                {; }//creact}
                else {; }//wrong
            }
            else {; }//not exist
            conn.Close();



            if (conn.State==ConnectionState.Open)
            {
              //  sqlstate.Text = "open";
            }
            else if(conn.State == ConnectionState.Closed)
            {
               // sqlstate.Text = "close";
            }
            else
            {
              //  sqlstate.Text = "unknown2";
            }
            //Selecte * from userinfo where name=@name and pwd=@password
            //using system.web.seurity//自带的加密算法 
            //Data Source = (localdb)\MSSQLLocalDB; Initial Catalog = Mail126; Integrated Security = True; MultipleActiveResultSets = False; Connect Timeout = 30; Encrypt = False; TrustServerCertificate = False
        }
        protected void ButtonRegister_Click(object sender, EventArgs e)
        {
            Response.Redirect("126MailRegister.aspx");
        }
        protected void Forget_Click(object sender, EventArgs e)
        {
            Response.Redirect("126MailForget.aspx");
        }
    }
}
