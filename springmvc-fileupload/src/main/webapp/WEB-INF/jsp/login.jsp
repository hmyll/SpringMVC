<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 12/18/2020
  Time: 03:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    ${msg}
    <form action="${pageContext.request.contextPath}/login.do"
          method="post" enctype="multipart/form-data">
        姓名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
