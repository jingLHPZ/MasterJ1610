//倒计时
var interval = 1000; 
function showCountDown(dom) { 
	var endDate=new Date(dom.val());
	var now = new Date(); 
	var leftTime = endDate.getTime()-now.getTime(); 
	if(leftTime < 0){
		$("#"+dom.attr("class")).text("立即投资");
		return;
	}
	var leftsecond = parseInt(leftTime/1000); 
	var day = Math.floor(leftsecond/(60*60*24));
	var hour = Math.floor((leftsecond-day*24*60*60)/3600); 
	var minute = Math.floor((leftsecond-day*24*60*60-hour*3600)/60); 
	var second = Math.floor(leftsecond-day*24*60*60-hour*3600-minute*60); 
	hour = day > 0 ? hour + day * 24 : hour;
	hour = hour < 10 ? "0" + hour : hour;
	minute = minute < 10 ? "0" + minute : minute;
	second = second < 10 ? "0" + second : second;
	$("#"+dom.attr("class")).text("倒计时：" + hour + ":" + minute + ":" + second);
	$("#"+dom.attr("class")).val("倒计时：" + hour + ":" + minute + ":" + second);
	if(hour == "00" && minute == "00" && second == "00"){
		$("#"+dom.attr("class")).parent().text("立即投资");
		$(dom).parent().removeClass("open_mask");
	}
} 
window.setInterval(function(){
	$("[class^=product]").each(function(){
	   showCountDown($(this));
	});
}, interval); 