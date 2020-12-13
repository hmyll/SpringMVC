<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index5</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button").click(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/myAjax5.do",
                    success:function (data) {
                        alert(data.name+","+data.age);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <button>发送Ajax按钮</button>
</body>
</html>
