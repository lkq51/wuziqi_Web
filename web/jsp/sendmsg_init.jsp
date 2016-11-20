<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: lkq
  Date: 2016/11/18
  Time: 16:02
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
    </script>
</head>
<body bgcolor="#CCCC99">
    <form action="sendmsg.jsp" method="post" onsubmit="setCookie()" id="form1">
        <table border="0" cellpadding="0" cellspacing="3">
            <tr>
                <td><%=session.getValue("username")%></td>
                <td align="left" colspan="2">
                    <input name="message" style="HEIGHT: 21px;WIDTH:367px">
                </td>
            </tr>
            <tr>
                <td align="center">对象</td>
                <td align="left">
                    <select name="toTalk">
                        <option value="all">全体</option>
                        <%
                            Vector tempuser=(Vector)getServletConfig().getServletContext().getAttribute("chatUser");
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
