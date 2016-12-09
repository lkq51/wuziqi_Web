<%--
  Created by IntelliJ IDEA.
  User: lkq
  Date: 2016/10/12
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员</title>
</head>
<body>
    <h1>Select a file to upload</h1>
    <form action="upload" enctype="multipart/form-data" method="post">
        Author:<input type="text" name="author"/><br/>
        Select file to upload <input type="file" name="filename"/><br/>
        <input type="submit" value="upload"/>
    </form>
    <a href="chat.jsp">Chat</a>
</body>
</html>
