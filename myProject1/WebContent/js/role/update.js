/**
 * @author ruanyang
 * 2017年11月1日
 */
$(function(){
		
	//级联操作
	$(".fatherNode").click(function(){
		//这里只要操作下面的复选框选中 判断当前是否已选中
		if(!$(this).is(":checked")){
			//alert("取消选中");
			$(this).parent().parent().find(".manage").removeAttr("checked","checked");	
		}
		else{
			//alert("选中");
			$(this).parent().parent().find(".manage").attr("checked","checked");	
		}
	});
	
	
	//添加操作
	$("#confirm").click(function(){
		//角色功能的整合,以逗号分隔
		var manages = "";
		$(".manage").each(function(){
			if($(this).is(":checked")){
				manages += manages ==""?$(this).attr("funid"):","+$(this).attr("funid");
			}

		});
		
		$("#funids").val(manages);
		
		console.log(manages);
		$("#submit").click();
		
	});
	
})