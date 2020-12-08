<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index1</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript">
        var student1={
            name:"张三",
            age:23
        }
        var student2={
            name:"李四",
            age:24
        }
        var students=[];
        students.push(student1);
        students.push(student2);
        $(function () {
            $("button").click(function () {
                $.ajax({
                    type:"POST",
                    url:"${pageContext.request.contextPath}/myAjax1.do",
                    contentType:"application/json",
                    data:JSON.stringify(students),
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
