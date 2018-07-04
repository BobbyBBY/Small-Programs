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
    public partial class _126MailForget : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void ButtonRegister_Click(object sender, EventArgs e)
        {
            Model.Userinfo FM = new Model.Userinfo();
            FM.Name = username.Text;
            BLL.Userinfo FB = new BLL.Userinfo();
            bool Exist = FB.RepeatedName(FM);
            if (!Exist)
            {
                Response.Write(" <script language='JavaScript' type='text/javascript'>alert('用户不存在') </script>");
            }
            else
            {

                FM.Password = password.Text;
                bool update = FB.ForgetPassword(FM);
               if(update)
                    Response.Write(" <script language='JavaScript' type='text/javascript'>alert('修改成功') </script>");
               else Response.Write(" <script language='JavaScript' type='text/javascript'>alert('修改失败') </script>");
            }
            
        }
        protected void ButtonLogin_Click(object sender, EventArgs e)
        {
            Response.Redirect("126MailLogin.aspx");
        }
    }
}