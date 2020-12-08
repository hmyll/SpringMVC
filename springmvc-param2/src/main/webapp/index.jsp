<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
    <form action="${pageContext.request.contextPath}/fifth.do" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>
        校名：<input type="text" name="school.sname"><br>
        地址：<input type="text" name="school.address"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
