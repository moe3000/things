<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
</head>
<body>
<form action="/four/login.do">
    <div>
        <label for="account">用户名</label>
        <input id="account" type="text" name="account">
    </div>
    <div>
        <label for="pwd">密码</label>
        <input id="pwd" type="password" name="pwd">
    </div>
    <div>
        <button type="submit">提交</button>
    </div>
</form>
</body>
</html>
