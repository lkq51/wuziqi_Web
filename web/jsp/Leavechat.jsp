<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: lkq
  Date: 2016/11/21
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>离开</title>
</head>
<body>
    <%
        String user=(String) session.getAttribute("username");
        Vector temp=(Vector) getServletConfig().getServletContext().getAttribute("chatUser");
        temp.removeElement(user);
        getServletConfig().getServletContext().setAttribute("chatuser",temp);
    %>
    <%
        temp=(Vector) getServletConfig().getServletContext().getAttribute("chatMsg");
        temp.addElement("<font color='#0000FF' size='2'>blueriver 管理员通告：");
        temp.addElement(user+"离开了本聊天室,欢迎下次再来...<br/></font>");
        getServletConfig().getServletContext().setAttribute("chatMsg",temp);
    %>
    <br/>
    <center>真诚感谢</center>
    <center>欢迎下次</center>
    <center><a href="javascript:window.close();">关闭窗口</a></center>
</body>
</html>
