<%--
  Created by IntelliJ IDEA.
  User: username
  Date: 2019/8/6
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>瑞乐购</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body id="body">
<div id="wk" >
    <div id="zi">
        <p>瑞 &nbsp;乐&nbsp;&nbsp;购&nbsp;&nbsp;后&nbsp;&nbsp;台&nbsp;&nbsp;管&nbsp;&nbsp;理&nbsp;&nbsp;系&nbsp;&nbsp;统</p>
    </div>
    <div id="nk">

        <form action="/manage/user/login.do" method="post">
            <input type="text"name="username"  placeholder="账户" style="width:200px;height:40px;"><br><br>
            <input type="password" password="password"  placeholder="密码" style="width:200px;height:40px;"><br><br>
            <input type="submit"value="登陆"style="width:100px;height:35px;">
        </form>

        <div></div>
    </div>
</div>
</body>
</html>
