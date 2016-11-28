<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: lkq
  Date: 2016/11/21
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="refresh" content="10">
<head>
    <title>聊天室聊天信息列表</title>
</head>
<body bgcolor="#FFFFCC">
    <%
        String tempmsg;
        String cUserName=(String) session.getAttribute("username");
        Vector chatMsg=(Vector) getServletConfig().getServletContext().getAttribute("chatMsg");
        for (int i=0;i<chatMsg.size();i++){
            String s_UserName;
            String o_UserName;
            int firstPos;
            int lastPos;
            boolean ifwhisper=false;

            tempmsg=chatMsg.elementAt(chatMsg.size()-i-1).toString();
            if (tempmsg.startsWith("#"))
            {
                ifwhisper=true;
            }
            if (ifwhisper){
                firstPos=1;
                lastPos=tempmsg.indexOf("#",firstPos);
                s_UserName=tempmsg.substring(firstPos,lastPos);

                firstPos=lastPos+1;
                lastPos=tempmsg.indexOf("#",firstPos);
                o_UserName=tempmsg.substring(firstPos,lastPos);

                firstPos=lastPos+1;
                tempmsg=tempmsg.substring(firstPos,tempmsg.length());
                if (o_UserName.equals(cUserName)){
                    tempmsg="<img src='new.gif'"+tempmsg;
                    out.println(tempmsg);
                }
                if(s_UserName.equals(cUserName))
                {
                    tempmsg="<img src=new.gif>"+tempmsg;
                    out.println(tempmsg);
                }
            }else {
                out.println(tempmsg+"<br/>");
            }
        }
    %>
</body>
</html>
