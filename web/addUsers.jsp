<%--
  Created by IntelliJ IDEA.
  User: STRIDE
  Date: 2020/12/11
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户爱好</title>
</head>
<body>
    <form action="test/addUsers2">
        用户姓名：<input type="text" name="username"/><br/>
        爱好：<br/>
        体育<input type="checkbox" value="sport" name="userlike"/>
        音乐<input type="checkbox" value="music" name="userlike"/>
        艺术<input type="checkbox" value="art" name="userlike"/><br/>
        <input type="submit" value="OK"/>
    </form>
</body>
</html>
