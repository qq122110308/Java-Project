$(function(){
	if($("#alertMessage").val() != null && $("#alertMessage").val() != undefined && $("#alertMessage").val() != ""){
		$("#execute").hide();
		$("#modal").modal();
		
		$("#modalTitle").text("执行操作");
		$("#modalContext").text("操作成功！");
	}
})

function alertMessage(){
	if($("#alertMessage").val() != null && $("#alertMessage").val() != undefined){
		$("#execute").hide();
		$("#modal").modal();
		
		$("#modalTitle").text("执行操作");
		$("#modalContext").text("操作成功！");
	}
	
}


function manageAdd(){
	$.ajax({
		url:"add",
		data:{funname:$("#funname").val(),
			  funurl:$("#url").val(),
			  funicon:$("#funicon").val(),
			  funfathernode:$("#funfatherid").val()},
		type:"POST",
		success:function(res){
			console.log("执行成功！");	
		}
	});
	
}