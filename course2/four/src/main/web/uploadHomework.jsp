<%@ page import="model.UserBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    UserBean user = (UserBean) request.getSession().getAttribute("user");
    if (user == null) {
        response.sendRedirect("/login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上传作业</title>
</head>
<body>
    <form action="/upload.do" method="post" enctype="multipart/form-data">
        <div>
            <label for="title">作业标题</label>
            <input id="title" type="text" name="title">
        </div>
        <div>
            <label for="homework">作业</label>
            <input id="homework" type="file" name="fileName">
        </div>
        <div>
            <button type="submit">提交</button>
        </div>
</form>
</body>
</html>
