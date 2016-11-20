<%--
  Created by IntelliJ IDEA.
  User: lkq
  Date: 2016/11/18
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>初始化聊天室</title>
</head>
<body>
<%
    Vector chatMsgVector=new Vector();
    chatMsgVector.addElement("<font color='red' size='2'>欢迎来到聊天室<br/>" );
    //初始化聊天信息
    getServletConfig().getServletContext().setAttribute("chatMsg",chatMsgVector);
    //初始化聊天室应用
    Vector chatUser=new Vector();
    chatUser.addElement("blueriver[管理员]");
    chatUser.addElement("wangxining[管理员]");
    chatUser.addElement("蓝河[管理员]");
    getServletConfig().getServletContext().setAttribute("chatUser",chatUser);
    //初始化聊天主题
    getServletConfig().getServletContext().setAttribute("chatTopic","加油");
%>
<%
    Hashtable userLife=new Hashtable();
    Hashtable userIP=new Hashtable();
    Date intiTime=new Date();
    String initIP="192.168.1.100";
    userLife.put("init",new Long(intiTime.getTime()));
    userIP.put("init",initIP);

    getServletConfig().getServletContext().setAttribute("userLife",userLife);
    getServletConfig().getServletContext().setAttribute("userIP",userIP);
%>
</body>
</html>
