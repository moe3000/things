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
    <title>操作页</title>
</head>
<body>
    <div>
        <span><a href="/uploadHomework.jsp">上传作业</a></span>
        <span><a href="/homework.html">查看所有作业</a></span>
        <span><a href="/myHomework.html">我的作业</a></span>
    </div>
</body>
</html>
