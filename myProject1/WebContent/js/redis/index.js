function addData(type){
	
	if(type=="String"){
		//$("#execute").attr("href","javascript:commit('String','"+$("#redisKey").val()+"','"+$("#redisValue").val()+"')");
		console.log("心态炸了！");
		$("#redisExecute").attr("onclick","commit('String')");
		$("#RedisModal").modal();
	}
	
	
	if(type=="Hash"){
		$("#redisExecute").attr("onclick","commit('Hash')");
		$("#RedisModal").modal();
	}
	
	
	if(type=="List"){
		$("#redisExecute").attr("onclick","commit('List')");
		$("#RedisModal").modal();
	}
	
	
	if(type=="Set"){
		$("#RedisModal").modal();
	}
	
	
	if(type=="Zset"){
		
	}
	
}


function  commit(type){
	var key = $("#redisKey").val();
	var value = $("#redisValue").val();
	
	$.ajax({
		url:"redisAdd",
		type:"POST",
		data:{type:type,key:key,value:value,t:Math.random()},
		success:function(res){
			if(res == "String" || res == "List")
				$("#"+type+"Table").append("<tr><td>1</td><td>"+value+"</td></tr>");
			else
				if(res == "Hash")
					$("#"+type+"Table").append("<tr><td>对象</td><td>"+key+"</td><td>"+value+"</td></tr>");
			
			
			
			$("#rModal").click();
		}
		
		
	});
	
}