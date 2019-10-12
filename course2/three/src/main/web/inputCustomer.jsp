<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
</head>
<body>
<form action="/register.do">
    <div>
        <label for="account">用户名</label>
        <input id="account" type="text" name="account">
    </div>
    <div>
        <label for="pwd">密码</label>
        <input id="pwd" type="password" name="pwd">
    </div>
    <div>
        <label for="name">姓名</label>
        <input id="name" type="text" name="name">
    </div>
    <div>
        <label for="idCard">身份证</label>
        <input id="idCard" type="text" name="idCard">
    </div>
    <div>
        <label for="email">email</label>
        <input id="email" type="text" name="email">
    </div>
    <div>
        <label for="phone">手机号</label>
        <input id="phone" type="text" name="phone">
    </div>
    <div>
        <button type="submit">提交</button>
    </div>
</form>
</body>
</html>
