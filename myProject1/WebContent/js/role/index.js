/**
 * @author ruanyang
 * 2017年11月1日
 */

function addData(){
	window.location.href="goadd";
}

function updateData(){
	//判断哪个被选中，取出value
	
	var funid=0;
	
	funid=$("input:radio:checked").val();
	
	console.log(funid);
	if(funid==0||funid==undefined){
		alert("请选择一条数据");
	}
	else{
		window.location.href="goupdate?roleid="+funid;
	}
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
		$("#execute").attr("href","javascript:window.location.href='deleteRole?roleid="+userid+"'");
		
		
		//window.location.href="deleteUser?userid="+userid;
	}
}
