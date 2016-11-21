<%--
  Created by IntelliJ IDEA.
  User: lkq
  Date: 2016/11/18
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Vector" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Hashtable" %>
<html>
<head>
    <title>初始化聊天室</title>
</head>
<body>
    <%
        //初始化聊天室信息
        Vector chatMsgVector=new Vector();
        chatMsgVector.addElement("<font color='red' size='2'>欢迎来到聊天室<br/>");
        //初始化欢迎信息
        getServletConfig().getServletContext().setAttribute("chatMsg",chatMsgVector);
        //初始化聊天室用户列表
        Vector chatUser=new Vector();
        chatUser.addElement("blueriver[管理员]");
        chatUser.addElement("wangxining[管理员]");
        chatUser.addElement("hhe[管理员]");
        getServletConfig().getServletContext().setAttribute("chatUser",chatUser);
        //初始化聊天主题
        getServletConfig().getServletContext().setAttribute("chatTopic","测试");
    %>
    <%
        Hashtable userLife=new Hashtable();
        Hashtable userIP=new Hashtable();
        Date initTime=new Date();
        String initIP="192.168.1.100";
        userLife.put("init",new Long(initTime.getTime()));
        userIP.put("init",initIP);
        getServletConfig().getServletContext().setAttribute("userLife",userLife);
        getServletConfig().getServletContext().setAttribute("userIP",userIP);
    %>
</body>
</html>
