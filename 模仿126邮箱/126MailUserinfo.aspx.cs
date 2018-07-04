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
    public partial class userinfo : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

            if (Session["manager"] == null || Session["manager"].Equals(false))
                Response.Redirect("126MailLogin.aspx");

        }
        protected void GridView_Delete(object sender, GridViewDeletedEventArgs e)
        {
            //string un = GridView1.DataKeys[e.AffectedRows].Values[0].ToString();//获取Gridview的主键
            //Model.Userinfo DU = new Model.Userinfo();
            //DU.Name = un;
            //BLL.Userinfo LA = new BLL.Userinfo();
            //LA.DeleteUser(DU);
        }

        protected void AddUserB_Click(object sender, EventArgs e)
        {
            string usernamestr = username.Text;
            string userpassword = password.Text;

            Model.Userinfo RM = new Model.Userinfo();
            RM.Name = username.Text;
            BLL.Userinfo RB = new BLL.Userinfo();
            bool repeated = true;

            repeated = RB.RepeatedName(RM);////////////////////////////////////下面的注释是断开连接

            //SqlConnection sqlConn = new SqlConnection();
            //sqlConn.ConnectionString = ConfigurationManager.ConnectionStrings["Mail126ConnectionString2"].ConnectionString;
            //SqlDataAdapter adapter = new SqlDataAdapter("select * from User_Info", sqlConn);
            //SqlCommandBuilder cb = new SqlCommandBuilder(adapter);
            //sqlConn.Open();
            //DataSet ds = new DataSet();
            //adapter.Fill(ds);
            //sqlConn.Close();
            //DataTable table = ds.Tables[0];
            //string expression;
            //expression = "Username ='" + usernamestr + "'";
            //DataRow[] foundRows;
            //foundRows = table.Select(expression);
            //if (foundRows.Length == 0)
            //    repeated = false;
            //else repeated = true;


            if (repeated)
            {
                Response.Write(" <script language='JavaScript' type='text/javascript'>alert('用户已存在') </script>");
                
            }
            else
            {
                RM.Password = password.Text;
                bool register = RB.Register(RM);
                if (register)
                {
                    Response.Write(" <script language='JavaScript' type='text/javascript'>alert('添加成功') </script>");
                    Response.Redirect("126MailUserinfo.aspx");
                }
                else Response.Write(" <script language='JavaScript' type='text/javascript'>alert('添加失败') </script>");
            }
        }
        
    }
}