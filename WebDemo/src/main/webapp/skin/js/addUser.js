$(document).ready(function(){
    if(flags=="edit"){
        $("#user_name").attr("readonly",true);
        $(":radio[value='"+user_isAdmin+"']").attr("checked",true);
        $(":radio[value='"+user_gender+"']").attr("checked",true);
        $(":radio[value='"+user_education+"']").attr("checked",true);
    }
    $("#saveBtn").on("click",function(){
        if($("#user_id").val()==null || $("#user_id").val()==""){
            alert("用户id不能为空");
            return false;
        }else if($("#user_name").val()==null || $("#user_name").val()==""){
            alert("用户名字不能为空");
            return false;
        }else if($("#user_password").val()==null || $("#user_password").val()==""){
            alert("用户密码不能为空");
            return false;
        }
        if(flags=="edit"){
            var url = context + "/demo/user/update";
            saveForm.action = url;
            saveForm.method = "POST";
            saveForm.submit();
        }else{
            var url = context + "/demo/user/save";
            saveForm.action = url;
            saveForm.method = "POST";
            saveForm.submit();
        }
    });
    $("#returnBtn").on("click",function(){
        window.location.href=context+"/jsp/demo/queryuser.jsp";
    });
    $("#user_name").blur(function(){
        $.ajax({
            url:context+"/demo/user/getUserByName?name="+$("#user_name").val(),
            type:"POST",
            success:function(data){
                if(data.userInfo!=null && userId=="null"){
                    $("#saveBtn").attr("disabled", true);
                    alert("用户已存在，请修改用户名");
                }else{
                    $("#saveBtn").attr("disabled", false);
                }
            }
        });
    });
});
