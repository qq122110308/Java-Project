$(function(){
	
	$.ajax({
		url:"showCity",
		type:"POST",
		data:{t:Math.random()},
		success:function(res){
			//这里不用再转码了
			for(var i = 0; i < res.length; i++){
				//console.log(res[i].cityid);
				$("#city").append("<option code="+res[i].citycode+" val="+res[i].cityid+">"+res[i].city+"</option>")
			}
			
		}
	});
	
	
	$("#findWeather").click(function(){
		var cityid = $("#city").val();
		//找到city 和 citycode
		var city = "";
		var citycode = "";
		$("#city option").each(function(){
			if($(this).val() == cityid){
				city = $(this).text();
				citycode = $(this).attr("code");
			}
		})
		
		
		$.ajax({
			url:"weatherSelect",
			type:"POST",
			data:{cityid:cityid,city:city,citycode:citycode,t:Math.random()},
			success:function(res){
				//console.log(res);
				$("#showMessage").html(res.city+"\r\n"+res.date+"\r\n"+res.weather+"\r\n"+
						res.week+"\r\n"+res.winddirect+"\r\n"+res.windpower+"\r\n"+res.windspeed+"\r\n")
				}
		});
		
	})
	
	
})