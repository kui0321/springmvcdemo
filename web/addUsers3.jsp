<%--
  Created by IntelliJ IDEA.
  User: STRIDE
  Date: 2020/12/11
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="test/addUsers6" method="post">
        用户姓名:<input type="text" name="username" /><br />
        爱好：<br />
        体育<input type="checkbox" value="sport" name="userlike"/>
        音乐<input type="checkbox" value="music" name="userlike"/>
        艺术<input type="checkbox" value="art" name="userlike"/><br />
        地址：<br/>
        电话号码：<input type="text" name="addressMap['one'].phonenumber"/>
        邮编：<input type="text" name="addressMap['one'].postcode"/><br/>
        电话号码：<input type="text" name="addressMap['two'].phonenumber"/>
        邮编：<input type="text" name="addressMap['two'].postcode"/><br>
        <input type="submit" value="OK"/>
    </form>
</body>
</html>
