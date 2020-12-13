<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC</title>
</head>
<body>
    welcome you:<br>
    ${message}<br>
    ${requestScope.message}
<hr>
    <%--底层执行了request.getAttribute("name")--%>
${name}<br>
${age}<br>
${student}<br>
    <%--底层执行了request.getParamater("name")--%>
${param.name}<br>
${param.age}<br>
</body>
</html>
