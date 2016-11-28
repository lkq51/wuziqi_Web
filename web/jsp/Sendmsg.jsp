<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Hashtable" %><%--
  Created by IntelliJ IDEA.
  User: lkq
  Date: 2016/11/21
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发送聊天信息</title>
    <script language="JavaScript" type="text/javascript">
        function setCookie() {
            document.cookie=form1.toTalk.selectedIndex+"#";
        }
        function setFocus() {
            form1.message.focus();
            var cookieValue=document.cookie;
            var formValue=cookieValue.split("#");
            form1.toTalk.selectedIndex=formValue[1];
            _formValue=formValue[0].split(";");
        }
    </script>
</head>
<body bgcolor="#CCCCFF" onload="setFocus()">
    <%!
        public void clearVector(){
            Vector _tempchatMsg=(Vector)getServletConfig().getServletContext().getAttribute("chatMsg");

            if (_tempchatMsg.size()>40){
                _tempchatMsg.removeAllElements();
                _tempchatMsg.addElement("<font color='orange' size='2'>"+"系统管理员清除了消息队列"+"</font><br/>");
            }
        }
    %>
    <%
        boolean boolcanupdatemsg=true;
        Vector tempchatMsg=(Vector)getServletConfig().getServletContext().getAttribute("chatMsg");
        String cUserName=(String) session.getAttribute("username");
        Date userTime=new Date();
        String
        timestamp="["+userTime.getHours()+":"+userTime.getMinutes()+":"+userTime.getSeconds()+"]";
    %>
    <%
        byte[] temp_t;
        String temp_p;
        temp_p=request.getParameter("message");
        temp_t=temp_p.getBytes("utf-8");
        String temp=new String(temp_t);
        byte[] talkTo_t;
        String talkTo_p;
        talkTo_p=request.getParameter("toTalk");
        talkTo_t=talkTo_p.getBytes("utf-8");
        String talkTo=new String(talkTo_t);
    %>
    <%
        if (temp.startsWith("<"))
        {
            temp="<font color='red' size='2'>请不要使用html标记"+timestamp+"</font><br/>";
            tempchatMsg.addElement(temp);
            boolcanupdatemsg=false;
            getServletConfig().getServletContext().setAttribute("chatMsg",tempchatMsg);
        }
        if (temp.endsWith("/>"))
        {
            temp="<font color='red' size='2'>请不要使用html标记"+timestamp+"</font><br/>";
            tempchatMsg.addElement(temp);
            boolcanupdatemsg=false;
            getServletConfig().getServletContext().setAttribute("chatMsg",tempchatMsg);
        }
        if (talkTo.equals("all"))
        {
            talkTo="每一个人";
        }
    %>
    <%
        cUserName="<font color='red' size='2'>"+cUserName+"</font>";
        talkTo="<font color='#0000FF' size='2'"+talkTo+"</font>";

        if (boolcanupdatemsg==true){
            Hashtable userLife=(Hashtable)getServletConfig().getServletContext().getAttribute("userLife");
            userLife.put((String)session.getValue("username"),new Long(userTime.getTime()));
            getServletConfig().getServletContext().setAttribute("userLife",userLife);
        }
        if (boolcanupdatemsg==true)
        {
            tempchatMsg.addElement(cUserName+"对"+talkTo+"说:"+temp);
            getServletConfig().getServletContext().setAttribute("chatMsg",tempchatMsg);
        }
    %>
    <form action="sendmsg.jsp" method="post" onsubmit="setCookie()" id="form1">
        <table border="0" cellspacing="3" cellpadding="0">
            <tr>
                <td><%=session.getValue("username")%></td>
                <td align="left" colspan="2">
                    <input name="message" style="HEIGHT:21px;WIDTH:367px">
                </td>
            </tr>
            <tr>
                <td>
                    <td align="center">对象</td>
                </td>
                <td align="left">
                    <select name="toTalk">
                        <option value="all">全体在聊</option>
                        <%
                            Vector tempuser=(Vector) getServletConfig().getServletContext().getAttribute("chatMsg");
                            for (int i=0;i<tempuser.size();i++){
                                out.println("<option>");
                                out.println(tempuser.elementAt(tempuser.size()-i-1).toString());
                                out.println("</option>");
                            }
                        %>
                    </select>
                        <input type="submit" value="说话" name="submit">
                </td>
                <td>
                    <a href="leavechat.jsp" target="_top">离开聊天室</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
