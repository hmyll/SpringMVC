<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<%--<img src="image/hlw.jpg" alt="pic">--%>
    <form action="${pageContext.request.contextPath}/test/forth.do" method="post">
        <input type="submit" value="提交">
    </form>
</body>
</html>
