<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户信息</title>
</head>
<body>
    <jsp:useBean id="customer" scope="session" type="com.model.Customer"/>
    <div>
        用户名:<jsp:getProperty name="customer" property="account"/>
    </div>
    <div>
        姓名:<jsp:getProperty name="customer" property="name"/>
    </div>
    <div>
        身份证:<jsp:getProperty name="customer" property="idCard"/>
    </div>
    <div>
        email:<jsp:getProperty name="customer" property="email"/>
    </div>
    <div>
        手机号:<jsp:getProperty name="customer" property="phone"/>
    </div>
</body>
</html>
