<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; UTF-8">
    <title>学生信息提交</title>
</head>
<body>
    <form action="/submitStudentInfo.do">
        <div>
            <label for="stuid">学号</label>
            <input id="stuid" type="text" name="stuid">
        </div>
        <div>
            <label for="name">姓名</label>
            <input id="name" type="text" name="name">
        </div>
        <div>
            <label for="major">专业</label>
            <input id="major" type="text" name="major">
        </div>
        <div>
            <button type="submit">提交</button>
        </div>
    </form>
</body>
</html>
