/**
 * 
 */

function rechargeOn() {
	var moneyStr = $("#orderAmount").val();
	var payWay = $("#payWay").val();
	var r = moneyStr.match(/^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/); 
	if (r == null){
		 $("#payForm").attr("action","paySubmit.htm");
		 $("#payForm").submit();
	 }else if(moneyStr<1){
		 $("#payForm").attr("action","paySubmit.htm");
		 $("#payForm").submit();
	 }else if(payWay==null||payWay==''){
		 $("#payForm").attr("action","paySubmit.htm");
		 $("#payForm").submit();
	 }else{
		 $("#payForm").attr("target", "_blank");
		 //$("#openReal").load("../payDialog.jsp");
		 $("#payForm").attr("action","paySubmit.htm");
		 $(".rech_true").show();
		 $("#payForm").submit();  
	 }
}

function rechargeWay(){
	$("#payWay").val("1");
}
function rechargeWay2(allinPayType){
	$("#allinPayType").val("2");
	$("#allinPayType").val(allinPayType);
}

function signMsgAjax() {
	var pickupUrl = $("input[name='pickupUrl']").val();
	var receiveUrl = $("input[name='receiveUrl']").val();
	var version = $("input[name='version']").val();
	var signType = $("input[name='signType']").val();
	var merchantId = $("input[name='merchantId']").val();
	var orderNo = $("input[name='orderNo']").val();
	var orderAmount = $("input[name='orderAmount']").val();
	var orderDatetime = $("input[name='orderDatetime']").val();
	var productName = $("input[name='productName']").val();
	var payType = $("input[name='payType']").val();
	var tradeNature = $("input[name='tradeNature']").val();
	var key = $("input[name='key']").val();
	$.ajax({
		type : "post",
		url : "${ctx}/payment/payRecord.htm",
		data : {
			pickupUrl : $("input[name='pickupUrl']").val(),
			receiveUrl : $("input[name='receiveUrl']").val(),
			version : $("input[name='version']").val(),
			language : $("input[name='language']").val(),
			signType : $("input[name='signType']").val(),
			merchantId : $("input[name='merchantId']").val(),
			orderNo : $("input[name='orderNo']").val(),
			orderAmount : $("input[name='orderAmount']").val(),
			orderCurrency : $("input[name='orderCurrency']").val(),
			orderDatetime : $("input[name='orderDatetime']").val(),
			productName : $("input[name='productName']").val(),
			payType : $("input[name='payType']").val(),
			tradeNature : $("input[name='tradeNature']").val(),
			key : $("input[name='key']").val()
		},
		dataType : "json",
		success : function(data) {
			$("#signMsg").val(data.md5);
		}
	});
}