using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApplication1
{
    public partial class _126MailRegister : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void ButtonLogin_Click(object sender, EventArgs e)
        {
            Response.Redirect("126MailLogin.aspx");
        }

        protected void ButtonRegister_Click(object sender, EventArgs e)
        {
            string usernamestr = username.Text;
            string userpassword = password.Text;

            Model.Userinfo RM = new Model.Userinfo();
            RM.Name = username.Text;
            //RM.Password = password.Text;
            BLL.Userinfo RB = new BLL.Userinfo();
            bool repeated = RB.RepeatedName(RM);
            if (repeated)
            {
                Response.Write(" <script language='JavaScript' type='text/javascript'>alert('用户已存在') </script>");
            }
            else
            {
                RM.Password = password.Text;
                bool register = RB.Register(RM);
                if (register)
                    Response.Write(" <script language='JavaScript' type='text/javascript'>alert('注册成功') </script>");
                else Response.Write(" <script language='JavaScript' type='text/javascript'>alert('注册失败') </script>");
            }
        }
    }
}