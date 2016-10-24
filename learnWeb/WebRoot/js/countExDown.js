//倒计时
var interval = 1000; 
window.setInterval(function(){
	$("[class^=endProduct]").each(function(){
		var dom = $(this);
		var endDate=new Date(dom.val());
		var now = new Date(); 
		var leftTime = endDate.getTime()-now.getTime(); 
		if(leftTime < 0){
			$(dom).parent().addClass("open_mask");
			$(dom).parent().find(".round_spread").attr("href","javascript://");
			if(!$(dom).parent().find(".mask_jjks_ex").length){
				$(dom).parent().append('<div class="mask_jjks_ex"></div>');
			}
			return;
		}
	});
}, interval); 

window.setInterval(function(){
	$("[class^=startProduct]").each(function(){
		var dom = $(this);
		var startDate=new Date(dom.val());
		var now = new Date(); 
		var leftTime = startDate.getTime()-now.getTime(); 
		var leftsecond = parseInt(leftTime/1000); 
		var day = Math.floor(leftsecond/(60*60*24));
		var hour = Math.floor((leftsecond-day*24*60*60)/3600); 
		var minute = Math.floor((leftsecond-day*24*60*60-hour*3600)/60); 
		var second = Math.floor(leftsecond-day*24*60*60-hour*3600-minute*60); 
		hour = day > 0 ? hour + day * 24 : hour;
		hour = hour < 10 ? "0" + hour : hour;
		minute = minute < 10 ? "0" + minute : minute;
		second = second < 10 ? "0" + second : second;
		if(hour == "00" && minute == "00" && second == "00"){
			$(dom).parent().removeClass("open_mask");
			$(dom).parent().find(".round_spread").attr("href","/experienceProduct/fqueryExperienceProduct.htm?productId="+ dom.attr("class").split("_")[1]);
		}
	});
}, interval); 