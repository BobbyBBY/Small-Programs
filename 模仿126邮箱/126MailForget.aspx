<%@ Page Title="" Language="C#" MasterPageFile="~/126MailMaster.Master" AutoEventWireup="true" CodeBehind="126MailForget.aspx.cs" Inherits="WebApplication1._126MailForget" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style>
        #MidImage{
             width: 30%;
	        height: 600px;
            margin: 0 15% 0 15%;
            float:left;
        }
        #login_register{
            width: 350px;
	        height: 400px;
            margin-top:60px;
            margin-bottom:50px;
            margin-right:90px;
            float: right;
            background:white;
            text-align:center;
        }
        #username {
            height: 37px;
            width: 223px;
            float: none;
            margin-top:40px;
            margin-right:20px;
        }
        #user{
             width: 350px;
	        height:300px;
            display: block;
            margin-top:50px;
        }
        #password {
           height: 37px;
            width: 223px;
            float: none;
            margin-top:15px;
            margin-right:20px;
        }
        #VailidateMessage{
            height: 37px;
            width: 223px;
            float: none;
            margin-top:15px;
            margin-right:20px;
        }

        #buttonLR {
             margin-top:50px;
            height: 98px;
        }
        #ButtonLogin {
            height: 50px;
            width: 100px;
            background: green;
            float:left;
            margin-top:20px;
            margin-left:50px;
        }
        #ButtonRegister {
            height: 50px;
            width: 100px;
            background: white;
            float:right;
            margin-top:20px;
            margin-right:50px;
        }
        #CheckBoxTenDays{
             float:left;
            margin-left:40px;
        }
        #ForgetCode{
            float:right;
            margin-right:40px;
        }
        #UserNav{
            width:350px;
            height: 50px;
            float:left;
            margin-left:4px;
            background-color:grey;
            text-align: center;
            line-height: 50px;
        }
        #ButtonLogin {
            height: 50px;
            width: 100px;
            background: green;
            float:left;
            margin-top:20px;
            margin-left:50px;
        }
        </style>
    <script type="text/javascript" >

        function MessageValidJS (obj,args){
            args.IsValid = true;
        }
         </script>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="Main" runat="server">

    <div id="MidImage">
            <img id="MidImage_" alt="126 Mail" src="https://mimg.127.net/m/lc/img/LoginBackgroundPic/1513/3/promPic.jpg" >
        </div>
        <div id="login_register">
            
            <div id="UserNav">
                <font size="4" color="black">找回密码</font>
            </div>
            <div id="user">
             
                <asp:TextBox ID="username"  clientIDMode="Static" runat="server" placeHolder="请输入邮箱账户"></asp:TextBox>
                <br />
                <asp:RequiredFieldValidator ID="RFVUserName"  clientIDMode="Static" runat="server" ValidationGroup="NamePassword"  
                    　ControlToValidate="username"
                    　ErrorMessage="必须填入邮箱地址"
                    　Display="Dynamic"
                    >
                </asp:RequiredFieldValidator>
                <br />
                <asp:RegularExpressionValidator ID="REVUserName"  clientIDMode="Static" runat="server" ValidationGroup="NamePassword"
                    ControlToValidate="username"
                    ValidationExpression="[a-zA-Z0-9]+[@]{1,1}[a-zA-Z0-9]+[.]{1,1}[a-zA-Z0-9]+"
                    errorMessage="请输入正确格式的邮箱地址"
                    display="Dynamic"
                    ></asp:RegularExpressionValidator>
                <br />
                
                <asp:TextBox ID="VailidateMessage"  clientIDMode="Static" runat="server" placeHolder="请输入短信验证码(输什么都正确)"></asp:TextBox>
                <br />
                <asp:CustomValidator ID="CustomValidator1" runat="server" clientIDMode="Static"
                    ValidationGroup="NamePassword"
                    ControlToValidate="VailidateMessage"
                    ErrorMessage="验证码错误"
                     ClientValidationFunction="MessageValidJS"
                    Display="Dynamic"

                    ></asp:CustomValidator>
                <br />
                <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" clientIDMode="Static"
                    ValidationGroup="NamePassword"
                    ControlToValidate="VailidateMessage"
                    ErrorMessage="必须输入验证码"
                     Display="Dynamic"
                    ></asp:RequiredFieldValidator>

                <br />
                <asp:TextBox ID="password" runat="server" clientIDMode="Static"  placeHolder="请输入新的密码"></asp:TextBox>
               <br />
                <asp:RequiredFieldValidator ID="RFVPassword" runat="server" ValidationGroup="NamePassword"
                    　ControlToValidate="password"
                    　ErrorMessage="必须填入密码"
                    　Display="Dynamic"
                    >
                </asp:RequiredFieldValidator>

            <div id="buttonLR">

                <asp:Button ID="ButtonLogin" clientIDMode="Static"  runat="server" Text="更改" OnClick="ButtonRegister_Click"  ValidationGroup="NamePassword"/>
                <asp:Button ID="ButtonRegister" clientIDMode="Static" runat="server" Text="去登陆" OnClick="ButtonLogin_Click"/>
            </div>
        </div>


</asp:Content>
