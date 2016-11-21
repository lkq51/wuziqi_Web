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
<%--当用户第一次说话后设置cooki并将本帧定位到sendmsg.jsp--%>
<form action="sendmsg.jsp" method="post" onsubmit="setCookie()" id="form1">
    <table border="0" cellspacing="3" cellpadding="0">
        <tr>
            <td><%=session.getValue("username")%></td>
            <td align="left" colspan="2">
                <input name="message" style="HEIGHT:21px;WIDTH:367px">
            </td>
        </tr>
        <tr>
            <td align="center">对象</td>
            <td align="left">
                <%--在下拉列表中显示所有用户名供用户选择--%>
                <select name="toTalk">
                    <option value="all">全体聊</option>
                    <%
                        Vector tempuser=(Vector)getServletConfig().getServletContext().getAttribute("chatUser");
                        for (int i=0;i<tempuser.size();i++){
                            out.println("<option>");
                            out.println(tempuser.elementAt(tempuser.size()-i-1).toString());
                            out.println("</option>");
                        }
                    %>
                </select>
                    <input type="submit" value="talking" name="submit">
            </td>
            <td>
                <a href="leavechat.jsp" target="_top">离开</a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
