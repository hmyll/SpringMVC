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
${name}<br>
${age}<br>
${student}<br>
${param.name}<br>
${param.age}<br>
</body>
</html>
