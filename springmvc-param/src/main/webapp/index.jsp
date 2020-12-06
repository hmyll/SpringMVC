<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
    <form action="${pageContext.request.contextPath}/sixth.do" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
