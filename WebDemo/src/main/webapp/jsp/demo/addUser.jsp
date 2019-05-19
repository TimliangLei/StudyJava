<%--
  Created by IntelliJ IDEA.
  User: leitianliang
  Date: 2019/5/8
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>新增用户</title>
    <!-- 引入css文件 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/skin/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/skin/css/datatables.css">
    <!-- 引入js文件 -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/skin/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/skin/js/addUser.js"></script>

</head>
<body>
<div class="container" style="margin-top: 60px;">
    <form id="saveForm" name="saveForm" class="form-horizontal pull-left" onsubmit="return false" style="width: 600px">
        <input name="id" value="${usersInfo.id}" type="hidden"/>
        <div class="form-group">
            <label class="col-xs-3 col-md-3 control-label">用户ID:</label>
            <div class="col-xs-9 col-md-9">
                <input id="user_id" name="userId" type="text" class="form-control" value="${userInfo.userId}" placeholder="用户ID不能为空"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 col-md-3 control-label">姓名:</label>
            <div class="col-xs-9 col-md-9">
                <input id="user_name" name="userName" type="text" class="form-control" value="${usersInfo.userName }" placeholder="名字不能为空"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 col-md-3 control-label">昵称：</label>
            <div class="col-xs-9 col-md-9">
                <input id="user_nickname" name="nickname" type="text" class="form-control" value="${usersInfo.nickname }" placeholder="请填写昵称">
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 col-md-3 control-label">密码：</label>
            <div class="col-xs-9 col-md-9">
                <input id="user_password" name="password" type="password" class="form-control" value="${usersInfo.password }" placeholder="密码不能为空">
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 col-md-3 control-label">是否管理员：</label>
            <div class="col-xs-9 col-md-9">
                <div class="radio" id="user_isAdmin">
                    <label>
                        <input type="radio" name="isAdmin" value="Y">是
                    </label>
                    <label>
                        <input type="radio" name="isAdmin" value="N" checked>否
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 col-md-3 control-label">性别：</label>
            <div class="col-xs-9 col-md-9">
                <div class="radio" id="gender">
                    <label>
                        <input type="radio" name="archive.gender" id="gender1" value="M" checked>男
                    </label>
                    <label>
                        <input type="radio" name="archive.gender" id="gender2" value="F">女
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 col-md-3 control-label">生日：</label>
            <div class="col-xs-9 col-md-9">
                <input id="user_birthday" name="archive.birthday" type="text" class="form-control" value="${usersInfo.archive.birthday}" placeholder="请填写生日">
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 col-md-3 control-label">学历：</label>
            <div class="col-xs-9 col-md-9">
                <div class="radio" id="educations">
                    <label>
                        <input type="radio" name="archive.education" id="education1" value="0" checked>本科
                    </label>
                    <label>
                        <input type="radio" name="archive.education" id="education2" value="1">硕士
                    </label>
                    <label>
                        <input type="radio" name="archive.education" id="education3" value="2">博士
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 col-md-3 control-label">学校：</label>
            <div class="col-xs-9 col-md-9">
                <input name="archive.school" type="text" class="form-control" value="${usersInfo.archive.school }" placeholder="请填写学校">
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 col-md-3 control-label"></label>
            <div class="col-xs-9 col-md-9">
                <button type="button" class="btn btn-primary" id="saveBtn">保存</button>
                <button type="button" class="btn" id="returnBtn">返回</button>
            </div>
        </div>
    </form>
</div>

</body>
<script type="text/javascript">
    var context = "<%=request.getContextPath()%>";
    var userId = "<%=request.getParameter("id")%>";
    var flags = '${flags}';
    var user_isAdmin = '${usersInfo.isAdmin}';
    var user_gender = '${usersInfo.archive.gender}';
    var user_education = '${usersInfo.archive.education}';
</script>

</html>
