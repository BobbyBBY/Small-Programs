using System;
using System.Collections.Generic;
using System.Configuration;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.Optimization;
using System.Web.Routing;
using System.Web.Security;
using System.Web.SessionState;

namespace WebApplication1
{
    public class Global : HttpApplication
    {
        private static string path = ConfigurationManager.ConnectionStrings["conntxt"].ToString();
        void Application_Start(object sender, EventArgs e)
        {
            // 在应用程序启动时运行的代码
            RouteConfig.RegisterRoutes(RouteTable.Routes);
            BundleConfig.RegisterBundles(BundleTable.Bundles);
            IniTxt();

        }
        void Session_Start(object sender, EventArgs e)
        {
            StreamReader sr = new StreamReader(path);
            string numstr;
            int numint = 0;
            numstr = sr.ReadLine();
            sr.Close();
            if (numstr != null)
                numint = Convert.ToInt32(numstr);
            numint++;

            StreamWriter sw = new StreamWriter(path, false, System.Text.Encoding.Default);
            numstr = numint.ToString();
            sw.Write(numstr);
            sw.Close();

        }
        void IniTxt()
        {
            if (!File.Exists(path))//如果文件不存在
            {
                FileStream fs = new FileStream(path, FileMode.Create, FileAccess.Write);
                fs.Close();
                StreamWriter strmsave = new StreamWriter(path, false, System.Text.Encoding.Default);
                strmsave.Write("0");
                strmsave.Close();
            }
            else
            {
                StreamReader sr = new StreamReader(path);
                if (sr.ReadLine() == null)//如果文件没有内容
                {
                    StreamWriter strmsave = new StreamWriter(path, false, System.Text.Encoding.Default);
                    strmsave.Write("0");
                    strmsave.Close();
                }
                sr.Close();//有内容就close，暂不能分辨文件内容的合法性，如果txt中不是整数则会出错

            }
        }
    }
}