
<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h1>hello,${sessionScope.user.username}</h1>
        <div>
            <p>${CURDmsg}</p>
            <a href="${pageContext.request.contextPath}/user/welcome">回到页面</a>
        </div>

        <div>
            <form action="${pageContext.request.contextPath}/param1/upload.do" enctype="multipart/form-data" method="post">
                上传头像:<input type="file" name="image"><br>
                       <input type="submit" value="上传">
            </form>
        </div>
    </body>
</html>