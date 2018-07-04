<%@ Page Title="" Language="C#" MasterPageFile="~/126MailMaster.Master" AutoEventWireup="true" CodeBehind="126MailLogin.aspx.cs" Inherits="WebApplication1._126MailWM" %>
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
        #QRCodeNav{
            width:173px;
            height: 50px;
             float:left;
             background-color:grey;
             text-align: center;
             line-height: 50px;
        }
        #UserNav{
            width:173px;
            height: 50px;
            float:left;
            margin-left:4px;
            background-color:grey;
            text-align: center;
            line-height: 50px;
        }
        #QRCode{
            margin-top:50px;
            width: 350px;
	        height:300px;
            display: none;
        }
        #QRCodeImg{
            margin-top:50px;
            width:180px ;
            height:180px;

        }
        #CheckCodeImg{
            height:50px;
            width:140px;
            float:left;
            margin-left:50px;
            margin-top:15px;
        }
        #CheckCodeInput{
            float:left;
            margin-left:50px;
            margin-top:15px;
        }
        #CheckCode{
             width: 350px;
	        height:100px;
        }
    </style>
    <script type="text/javascript" >
        function omoverQR() {
            var divlist = document.getElementById("QRCode");
            divlist.style.display = "block";
            var divlist = document.getElementById("user");
            divlist.style.display = "none";
        }
         function omoverU() {
            var divlist = document.getElementById("user");
             divlist.style.display = "block";
             var divlist = document.getElementById("QRCode");
            divlist.style.display = "none";
        }
        window.onload=function(){
            <%= IniCheckCode() %>;
        }
        function CheckCodeValidJS(obj,args)
       {
           var Code0 = "<%=showCode()%>";
           var var1 = document.getElementById ("CheckCodeInput");
           var Codes = var1.value;
               if (Codes==Code0) {
                   args.IsValid = true;
                   //window.alert(Code0);
               }
               else if(Codes!=Code0){
                   args.IsValid = false;
                   //window.alert(Code0);
           }
           else args.IsValid = true;
        }
    </script>

</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="Main" runat="server">

        <div id="MidImage">
            <img id="MidImage_" alt="126 Mail" src="https://mimg.127.net/m/lc/img/LoginBackgroundPic/1513/3/promPic.jpg" >
        </div>
        <div id="login_register">
            
            <div id="QRCodeNav" onmouseover="omoverQR();" >
                <font size="4" color="black">二维码登陆</font>
            </div>
            <div id="UserNav"onmouseover="omoverU();">
                <font size="4" color="black">邮箱账号登陆</font>
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
                <asp:CustomValidator ID="Inexistent" runat="server" 
                    errorMessage="用户不存在"
                    display="Dynamic"
                    ></asp:CustomValidator>
                <asp:RegularExpressionValidator ID="REVUserName"  clientIDMode="Static" runat="server" ValidationGroup="NamePassword"
                    ControlToValidate="username"
                    ValidationExpression="[a-zA-Z0-9]+[@]{1,1}[a-zA-Z0-9]+[.]{1,1}[a-zA-Z0-9]+"
                    errorMessage="请输入正确格式的邮箱地址"
                    display="Dynamic"
                    ></asp:RegularExpressionValidator>
                <br />
                
                <asp:TextBox ID="password" runat="server" clientIDMode="Static"  placeHolder="请输入密码"  TextMode=Password></asp:TextBox>
               <br />
                <asp:RequiredFieldValidator ID="RFVPassword" runat="server" ValidationGroup="NamePassword"
                    　ControlToValidate="password"
                    　ErrorMessage="必须填入密码"
                    　Display="Dynamic"
                    >
                </asp:RequiredFieldValidator>
                <asp:CustomValidator ID="PasswordIncorrect" runat="server" 
                    ErrorMessage="密码错误"
                    display="Dynamic"
                    ></asp:CustomValidator>
                <div id="CheckCode" >
                    <asp:ImageButton ID="CheckCodeImg" runat="server" clientIDMode="Static" src="VCode.aspx?abc=123456" OnClick="CheckCodeImg_Click1"/>
                <br />
                <asp:TextBox ID="CheckCodeInput" clientIDMode="Static"  runat="server" placeHolder="请输入验证码" Height="23px"></asp:TextBox>
                <br />
                <asp:RequiredFieldValidator ID="RFVCheckCode" clientIDMode="Static"  runat="server" ValidationGroup="NamePassword"
                    ControlToValidate="CheckCodeInput"
                    ErrorMessage="必须输入验证码"
                    Display="Dynamic"
                    ></asp:RequiredFieldValidator>
                <br />
                <asp:CustomValidator ID="CVCheckCode" clientIDMode="Static"  runat="server" ValidationGroup="NamePassword"
                    ControlToValidate="CheckCodeInput"
                    ErrorMessage="验证码错误"
                    ClientValidationFunction="CheckCodeValidJS"
                    Display="Dynamic"
                        ></asp:CustomValidator>
                    </div>
            </div>
            <div id="QRCode" >
                <img   id="QRCodeImg" src="http://pic.caigoubao.cc/599633/1521789896.png">

            </div>
            

            <div id="CheckBoxTenDays">
             <asp:CheckBox ID="TenDays"  clientIDMode="Static" runat="server"  />
             <label for="TenDays">十天登陆免密码</label>
                <%--<asp:Label ID="sqlstate" runat="server" Text="unknown1"></asp:Label>--%>
            </div>
            <div id="ForgetCode">
                <asp:Button ID="Forget" runat="server" Text="忘记密码？" clientIDMode="Static" OnClick="Forget_Click" />
            </div>

            <div id="buttonLR">
                <asp:Button ID="ButtonLogin" clientIDMode="Static"  runat="server" Text="登 陆" OnClick="ButtonLogin_Click" ValidationGroup="NamePassword"/>
                <asp:Button ID="ButtonRegister" clientIDMode="Static"  runat="server" Text="去注册" OnClick="ButtonRegister_Click"/>

            </div>
        </div>
        </a><!--不知道为什么总是会自己出现“</a>” -->
</asp:Content>
