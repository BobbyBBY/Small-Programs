using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApplication1
{
    public partial class _126MailManagerLogin : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void ButtonLogin_Click(object sender, EventArgs e)
        {
            if (LoginAuto(username.Text, password.Text))
            {
                Session["manager"] = true;
                Response.Redirect("126MailUserinfo.aspx");
            }
            else
            {
                PasswordIncorrect.IsValid = false;
            }
        }
        protected bool LoginAuto(string un, string pwd)
        {
            bool userpassword = false;

            Model.Manager LAM = new Model.Manager();
            LAM.Name = un;
            LAM.Password = pwd;
            BLL.Manager LA = new BLL.Manager();
            userpassword = LA.ValidatePassword(LAM);
            return userpassword;
        }
        }
    }