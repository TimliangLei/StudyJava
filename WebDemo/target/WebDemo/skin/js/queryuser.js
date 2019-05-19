var oTable;
$(document).ready(function(){
    //初始化表格
    initTable();
    $("#addusers").on("click",function(){
        window.location.href=context+"/jsp/demo/addUser.jsp";
    });
    $("#search").on("click",function(){
        var tmp = $("#searchVal").val();
        query(tmp);

    });

    //回车查询事件
    $("#searchVal").keydown(function(event) {
        if (event.keyCode == 13) {
            var srcName = $("#searchVal").val();
            query(srcName);
        }
    });
});

function initTable(){
    oTable = $("#userList").dtable({
        //显示“正在加载”的图标
        "processing":true,
        "ajax":context + "/demo/user/query",
        "serverSide":true,
        "bPaginate": false,
        "ordering":false,
        "columns":[
            {"data":"userId"},
            {"data":"userName"},
            {"data":"nickname"},
            {"data":"isAdmin"},
            {"data":"id"},
        ],
        "columnDefs":[
            {
                "targets":3,
                "data":"isAdmin",
                "render":function(data,type,full){
                    if(data !="" || data != null){
                        if(data == "Y"){
                            data = "是";
                        }
                        if (data == "N"){
                            data = "否";
                        }
                    }
                    return data;
                }
            },
            {
                "targets":4,
                "data":"id",
                "render":function(data,type,full){
                    return '<div><a id="edit" onclick="forUpdate('+"'"+ full.id+ "'"+')" href="#">编辑</a>'+'<span>&nbsp;&nbsp</span>'
                        +'<a id="del" onclick="del('+"'"+ full.id+ "'"+')" href="#">删除</a></div>'
                }
            }
        ]
    });
    return oTable;
}

//查询
function query(userId){
    if ((userId == "" || userId == null)) {
        oTable.ajax.url(context + "/demo/user/query").load();
    } else {
        var url=context + "/demo/user/search?userID=" + userId;
        oTable.ajax.url(url).load();
    }
}

//删除用户信息
function del(id){
    $.ajax({
        url:context+"/service/demo/user/del?id="+id,
        type:"get",
        async:false,
        success:function(){
            oTable.ajax.url(context + "/demo/user/query").load();
        },
        error:function(data){
            alert(data);
        }
    });
}
//编写用户信息
function forUpdate(id){
    window.location.href=context+"/demo/user/edits?id="+id;
}



