
$(function(){
	if($("#alertMessage").val() != null && $("#alertMessage").val() != undefined && $("#alertMessage").val() != ""){
		$("#execute").hide();
		$("#modal").modal();
		
		$("#modalTitle").text("邮箱发送");
		$("#modalContext").text("发送成功！");
	}
})

function alertMessage(){
	if($("#alertMessage").val() != null && $("#alertMessage").val() != undefined){
		$("#execute").hide();
		$("#modal").modal();
		
		$("#modalTitle").text("邮箱发送");
		$("#modalContext").text("发送成功！");
	}
	
}