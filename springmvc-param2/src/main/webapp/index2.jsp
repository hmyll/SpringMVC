<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index2</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button").click(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/myAjax2.do",
                    data:{
                        name:"赵六",
                        age:26
                    },
                    success:function (data) {
                        alert(data);
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
