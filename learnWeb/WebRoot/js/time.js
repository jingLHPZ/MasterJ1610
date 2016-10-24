var interval = 1000; 
function ShowCountDown(date,divname,toptimes,hiddtime) { 
	var endDate=new Date(date);
	var year=endDate.getFullYear();
	var month=endDate.getMonth()+1;
	var day=endDate.getDate();
	var now = new Date(); 
	var leftTime=endDate.getTime()-now.getTime(); 
	var leftsecond = parseInt(leftTime/1000); 
	var day1=Math.floor(leftsecond/(60*60*24));
	var hour=Math.floor((leftsecond-day1*24*60*60)/3600); 
	var minute=Math.floor((leftsecond-day1*24*60*60-hour*3600)/60); 
	var second=Math.floor(leftsecond-day1*24*60*60-hour*3600-minute*60); 
	var cc = document.getElementById(divname); 
	var ss = document.getElementById(toptimes);
	var aa=document.getElementById(hiddtime);
	if(day1<0||hour<0||minute<0||second<0){
		cc.innerHTML =0+"天"+0+"小时"+0+"分"+0+"秒";
		ss.innerHTML="已流标";
	    aa.value="no";
		return;                 
	}else{
		ss.innerHTML=day1+"天"+hour+"小时"+minute+"分"+second+"秒"; 
		/*cc.innerHTML=year+"年"+month+"月"+day+"日";*/
		cc.innerHTML= "";
		$(cc).hide();
		aa.value="yes";
	}
} 