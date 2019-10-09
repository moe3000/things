<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; UTF-8">
    <title>学生信息显示</title>
</head>
<body>
    <jsp:useBean id="student" scope="session" type="com.model.Student"/>
    <div>
        学号：
        <jsp:getProperty name="student" property="stuid"/>
    </div>
    <div>
        姓名：
        <jsp:getProperty name="student" property="name"/>
    </div>
    <div>
        专业：
        <jsp:getProperty name="student" property="major"/>
    </div>
</body>
</html>
