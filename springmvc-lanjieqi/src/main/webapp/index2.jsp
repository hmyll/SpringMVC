<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="${pageContext.request.contextPath}/upload2.do"
      method="post" enctype="multipart/form-data">
    图片：<input type="file" name="pics"><br>
    图片：<input type="file" name="pics"><br>
    图片：<input type="file" name="pics"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
