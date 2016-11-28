<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: lkq
  Date: 2016/11/21
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>聊天室用户列表</title>
</head>
<body bgcolor="#CCCC99">
    <b><font size="+2" color="#000033">blueriver</font></b><br/>
    <b><font color="#000033" size="+3">聊天室</font></b><br/>
    <font color="#FF0033"><b>总人数</b></font>
    <font color="#0000FF" size="2"><b>
        <%
            Vector tempuser=(Vector) getServletConfig().getServletContext().getAttribute("chatUSer");
            out.println(tempuser.size());
        %>
    </b></font><br/><br/><br/>
    <b><font color="red" size="2">用户列表</font><br/>
    <font size="2" color="#0000FF">
        <%
            for (int i=0;i<tempuser.size();i++){
                out.println(tempuser.elementAt(tempuser.size()-i-1).toString());
                out.println("<br/>");
            }
        %>
    </font></b>
    <br/>
</body>
</html>
