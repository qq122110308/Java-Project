/**
 * @author ruanyang
 * 2017年11月1日
 */

$(function(){
	
})

//跳转到用户添加页面
function addData(){
	window.location.href="goadd";
}

//跳转到用户修改界面
function updateData(){
	//判断哪个被选中，取出value
	var userid=0;
	
	userid=$("input:radio:checked").val();
	
	console.log(userid);
	if(userid==0||userid==undefined){
		alert("请选择一条数据");
	}
	else{
		window.location.href="goupdate?userid="+userid;
	}
}

//Check 密码是否正确
function checkAdd(){
	
	//解决用户角色的添加问题
	var roles="";
	$(".checkboxRole").each(function(){
		if($(this).is(":checked")){
			roles += roles == ""? $(this).attr("value"):","+$(this).attr("value");
		}
	})
	$("#roles").val(roles);
	console.log(roles);
	
	//前台验证
	//密码的验证判断，存着避免以后要用到
	if($("#password").val()==$("#password2").val()){
		$("#userAdd").submit();
	}
	else{
		//提示密码输入错误
	}
	
}


//提交修改界面
function checkUpdate(){
	//先组合用户角色roles
	var roles="";
	$(".checkboxRole").each(function(){
		if($(this).is(":checked")){
			roles += roles == ""? $(this).attr("value"):","+$(this).attr("value");
		}
	})
	$("#roles").val(roles);
	console.log(roles);
	
	
	//
	$("#userAdd").submit();
}

//删除用户
function deleteData(){
	//判断哪个被选中，取出value
	var userid=0;
	
	userid=$("input:radio:checked").val();
	
	console.log(userid);
	if(userid==0||userid==undefined){
		alert("请选择一条数据");
	}
	else{
		$("#modal").modal();
		//装饰modal
		$("#modalTitle").text("删除用户");
		$("#execute").attr("href","javascript:window.location.href='deleteUser?userid="+userid+"'");
		
		
		//window.location.href="deleteUser?userid="+userid;
	}
}

