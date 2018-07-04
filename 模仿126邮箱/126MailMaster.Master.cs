using System;
using System.Collections.Generic;
using System.Configuration;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApplication1
{
    public partial class MTest1 : System.Web.UI.MasterPage
    {
        private static string path = ConfigurationManager.ConnectionStrings["conntxt"].ToString();
        protected void Page_Load(object sender, EventArgs e)
        {
            setvisit();

        }
        protected void setvisit()
        {
            StreamReader sr = new StreamReader(path);
            string numstr;
            numstr = sr.ReadLine();
            sr.Close();
            visit2.Text = numstr;
        }
    }
}