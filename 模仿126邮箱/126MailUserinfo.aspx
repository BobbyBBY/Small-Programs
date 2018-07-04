<%@ Page Title="" Language="C#" MasterPageFile="~/126MailMaster.Master" AutoEventWireup="true" CodeBehind="126MailUserinfo.aspx.cs" Inherits="WebApplication1.userinfo" %>
<%@ Register assembly="System.Web.DataVisualization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35" namespace="System.Web.UI.DataVisualization.Charting" tagprefix="asp" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style>
        #Table{
	        height: 300px;
            float:left;
            width: 1400px;
            left: 50%;
            top: 50%;
        }
        #welcome{
            width: 1400px;
            height: 50px;
            float:left;
            margin-left:600px;
        }
        #AddUser{
            width: 600px;
            height: 170px;
            float:left;
            margin-left:400px;
            background-color:antiquewhite;
        }
        #AddUserB{
            height: 50px;
            width: 100px;
            background: green;
            float:left;
        }
        </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="Main" runat="server">
    <div id="welcome">
        <asp:Label ID="welcomeL" runat="server" Text="管理员你好！">
            
        </asp:Label>
    </div>

    <div id="Table">
    <asp:GridView ID="GridView1" runat="server" clientIDMode="Static" AutoGenerateColumns="False" DataKeyNames="Username" DataSourceID="SqlDataSource1" CellPadding="4" ForeColor="#333333" GridLines="None" AllowPaging="True" HorizontalAlign="Center" PageIndex="5" Width="800px">
        <AlternatingRowStyle BackColor="White" />
        <Columns>
            <asp:BoundField DataField="Username" HeaderText="用户名" ReadOnly="True" SortExpression="Username" />
            <asp:BoundField DataField="Password" HeaderText="密码" SortExpression="Password" />
            <asp:ButtonField ButtonType="Button" CommandName="Delete" HeaderText="删除此账户" ShowHeader="True" Text="删除" >
            <ItemStyle Width="100px" />
            </asp:ButtonField>
            <asp:CommandField ButtonType="Button" HeaderText="修改账户信息" ShowEditButton="True">
            <ItemStyle Width="100px" />
            </asp:CommandField>
        </Columns>

        <EditRowStyle BackColor="#7C6F57" />
        <FooterStyle BackColor="#1C5E55" Font-Bold="True" ForeColor="White" />
        <HeaderStyle BackColor="#1C5E55" Font-Bold="True" ForeColor="White" />
        <PagerStyle BackColor="#666666" ForeColor="White" HorizontalAlign="Center" />
        <RowStyle BackColor="#E3EAEB" />
        <SelectedRowStyle BackColor="#C5BBAF" Font-Bold="True" ForeColor="#333333" />
        <SortedAscendingCellStyle BackColor="#F8FAFA" />
        <SortedAscendingHeaderStyle BackColor="#246B61" />
        <SortedDescendingCellStyle BackColor="#D4DFE1" />
        <SortedDescendingHeaderStyle BackColor="#15524A" />
    </asp:GridView>
    </div>

    <div id="AddUser">
        <asp:Label ID="Label4" runat="server" Text="添加用户"></asp:Label>
        <br />
        <asp:Label ID="Label1" runat="server" Text="用户名"></asp:Label>
        <asp:TextBox ID="username" runat="server"></asp:TextBox>
        <br />
        <asp:RequiredFieldValidator ID="RFVUserName"  clientIDMode="Static" runat="server" ValidationGroup="NamePassword"  
                  　ControlToValidate="username"
                  　ErrorMessage="必须填入邮箱地址"
                  　Display="Dynamic"
        ></asp:RequiredFieldValidator>
        <asp:RegularExpressionValidator ID="REVUserName"  clientIDMode="Static" runat="server" ValidationGroup="NamePassword"
                    ControlToValidate="username"
                    ValidationExpression="[a-zA-Z0-9]+[@]{1,1}[a-zA-Z0-9]+[.]{1,1}[a-zA-Z0-9]+"
                    errorMessage="请输入正确格式的邮箱地址"
                    display="Dynamic"
         ></asp:RegularExpressionValidator>

        <br />
        <asp:Label ID="Label2" runat="server" Text="密码"></asp:Label>
        <asp:TextBox ID="password" runat="server"></asp:TextBox>
        <br />
        <asp:RequiredFieldValidator ID="RFVPassword" runat="server" ValidationGroup="NamePassword"
                    ControlToValidate="password"
                    ErrorMessage="必须填入密码"
                  　Display="Dynamic"
        ></asp:RequiredFieldValidator>
        <br />

        <asp:Button ID="AddUserB" runat="server" Text="添加" OnClick="AddUserB_Click" ValidationGroup="NamePassword"/>

    </div>










    <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:Mail126ConnectionString2 %>" SelectCommand="SELECT * FROM [User_Info]" ConflictDetection="CompareAllValues" DeleteCommand="DELETE FROM [User_Info] WHERE [Username] = @original_Username AND [Password] = @original_Password" InsertCommand="INSERT INTO [User_Info] ([Username], [Password]) VALUES (@Username, @Password)" OldValuesParameterFormatString="original_{0}" UpdateCommand="UPDATE [User_Info] SET [Password] = @Password WHERE [Username] = @original_Username AND [Password] = @original_Password">
        <DeleteParameters>
            <asp:Parameter Name="original_Username" Type="String" />
            <asp:Parameter Name="original_Password" Type="String" />
        </DeleteParameters>
        <InsertParameters>
            <asp:Parameter Name="Username" Type="String" />
            <asp:Parameter Name="Password" Type="String" />
        </InsertParameters>
        <UpdateParameters>
            <asp:Parameter Name="Password" Type="String" />
            <asp:Parameter Name="original_Username" Type="String" />
            <asp:Parameter Name="original_Password" Type="String" />
        </UpdateParameters>
    </asp:SqlDataSource>








</asp:Content>
