<%--
  Created by IntelliJ IDEA.
  User: khai trinh
  Date: 02/03/2021
  Time: 4:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Email Validate</h1>
<h3 style="color:red">${message}</h3>
<form action="/email/validate" method="post">
    Email : <input type="text" name="email" placeholder="abc123@email.com">
    <input type="submit" value="validate">
</form>
</body>
</html>
