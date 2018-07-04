using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApplication1
{
    public partial class _126MailWelcom : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["User"]!=null&&Session["User"].Equals(true))
            {; }
            else Response.Redirect("126MailLogin.aspx");
            if (Request.Cookies["Username"] != null)
                welcomename.Text = Request.Cookies["Username"].Value;
        }

        protected void logout_Click(object sender, EventArgs e)
        {
            Response.Cookies["Password"].Value=null;
            Session["User"]=false;
            Response.Redirect("126MailLogin.aspx");
        }
    }
}