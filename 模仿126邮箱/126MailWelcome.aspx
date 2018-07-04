<%@ Page Title="" Language="C#" MasterPageFile="~/126MailMaster.Master" AutoEventWireup="true" CodeBehind="126MailWelcome.aspx.cs" Inherits="WebApplication1._126MailWelcom" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style>
        #welcome{
            float:left;
            margin-left:500px;
            margin-right:700px;
    }
        #logout{
            float:right;
        }
        #welcomegreeting{
            float:left;
            margin-left:500px;
            Width:52px;
        }
        #welcomename{
            float:left;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="Main" runat="server">
    <asp:Label ID="welcome" clientIDMode="Static" runat="server" Text="Welcome"  Height="48px"  Width="126px" Font-Size="XX-Large"></asp:Label>
    <br />
    <asp:Label ID="welcomegreeting" clientIDMode="Static" runat="server" Text="你好，" ></asp:Label>
    <asp:Label ID="welcomename" clientIDMode="Static" runat="server" Text="unknown"></asp:Label>
     <br />
    <asp:Button ID="logout" clientIDMode="Static"  runat="server" Text="注销" OnClick="logout_Click" />
</asp:Content>
