<%--
  Created by IntelliJ IDEA.
  User: leitianliang
  Date: 2019/5/8
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>用户详细信息</title>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/skin/css/datatables.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/skin/css/bootstrap.css"/>

    <script type="text/javascript" src="<%=request.getContextPath()%>/skin/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/skin/js/datatables.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/skin/js/queryuser.js"></script>
</head>
<body class="container">
<div class="input-group pull-left" style="margin-top: 10px;">
    <div class="input-group col-xs-6 col-md-6">
        <input type="text" id="searchVal" class="form-control" style="width: 200px;" placeholder="请输入用户ID">
        <span class="input-group-btn">
                <button class="btn btn-default" type="button" id="search">搜索</button>
        </span>
    </div>
</div>
<div class="btn-group pull-right" style="margin-top: 10px; padding-bottom: 5px;">
    <button type="button" class="btn btn-primary" id="addusers">新增</button>
</div>
<div>
    <table id="userList" class="table table-bordered table-hover">
        <thead>
        <tr>
            <th width="20">用户名</th>
            <th width="20">名称</th>
            <th width="20">昵称</th>
            <th width="20">是否管理员</th>
            <th width="20">操作</th>
        </tr>
        </thead>
    </table>
</div>
</body>
<script type="text/javascript">
    var context = "<%=request.getContextPath()%>"
</script>
</html>
