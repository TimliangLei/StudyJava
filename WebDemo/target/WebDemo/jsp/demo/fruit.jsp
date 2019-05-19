<%--
  Created by IntelliJ IDEA.
  User: leitianliang
  Date: 2019/4/29
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>水果超市</title>
</head>
<body>
<table>
    <tr><td>产品编码：</td><td>${fruit.code}</td></tr>
    <tr><td>产品名称：</td><td>${fruit.name}</td></tr>
    <tr><td>产品产地：</td><td>${fruit.origin}</td></tr>
    <tr><td>产品日期：</td><td>${fruit.datetime}</td></tr>
    <tr><td>产品说明：</td><td>${fruit.note}</td></tr>

</table>
</body>
</html>
