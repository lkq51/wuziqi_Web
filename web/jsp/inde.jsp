<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.zip.DataFormatException" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lkq
  Date: 2016/11/18
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("username")==null){
        response.sendRedirect("../member/login.jsp?url="+request.getRequestURI());
    }else {
        String username;
        Vector temp=new Vector();
        username=(String)session.getAttribute("username");
        temp=(Vector)getServletConfig().getServletContext().getAttribute("chatUser");
        temp.addElement(username);
        getServletConfig().getServletContext().setAttribute("chatUser",temp);
        //添加欢迎信息到信息向量里
        Vector tempmsg=(Vector)getServletConfig().getServletContext().getAttribute("chatMsg");
        tempmsg.addElement("<font size='2' color='red'>"+username+"进入聊天室["
                            +request.getRemoteAddr()+"],大家欢迎！</font><br/>");
        getServletConfig().getServletContext().setAttribute("chatMsg",tempmsg);
        //用一个哈希表来记录用户在聊天室的时间
        Hashtable userLife=(Hashtable)getServletConfig().getServletContext().getAttribute("userLife");
        //用一个哈希表来记录在聊用户的IP地址
        Hashtable userIP=(Hashtable)getServletConfig().getServletContext().getAttribute("userIP");
        //记录用户登录时间
        Date userTime=new Date();
        userLife.put(username,new Long(userTime.getTime()));
        //记录用户IP地址
        userIP.put(username,request.getRemoteAddr());
        getServletConfig().getServletContext().setAttribute("userLife",userLife);
        getServletConfig().getServletContext().setAttribute("userIP",userIP);
    }
%>
<html>
<head>
    <title>聊天室</title>
</head>
<frameset cols="70%,*" border="0" framespacing="0" frameborder="NO">
    <frameset rows="83%,*">
        <frame name="" src="showmsg.jsp" marginwidth="10" marginheight="10" scrolling="auto" frameborder="0">
        <frame name="" src="sendmsg_init.jsp" marginwidth="10" marginheight="10" scrolling="no" frameborder="0">
    </frameset>
    <frame name="" src="listuser.jsp" marginwidth="10" marginheight="10" scrolling="no" frameborder="0">
</frameset>
<noframes></noframes>
<body>
</body>
</html>
