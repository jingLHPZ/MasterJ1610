 var showMsgInfo = function(info){
	 if(typeof info != 'undefined'){
		 $("#msg_alert").addClass("active").text(info);
	 }
 }
 var msgResult = {
	0: {flag: false, info: "请输入金额！", call : showMsgInfo},
    1: {flag: false, info: "可用余额不足请充值！", call : showMsgInfo},
    2: {flag: false, info: "投资金额应当为"+$("#increment").val()+"元的整数倍！", call : showMsgInfo},
    4: {flag: false, info: "投资金额小于"+$("#investmin").val()+"元！", call : showMsgInfo},
    5: {flag: false, info: "投资金额大于"+$("#investmax").val()+"元！", call : showMsgInfo},
    7: {flag: false, info: "投资金额必须是整数。", call : showMsgInfo},
    9: {flag: false, info: "投资金额大于项目可投资金额。", call : showMsgInfo},
    11: {flag: false, info: "新手只有一次机会，你已投资过。", call : showMsgInfo},
    13: {flag: false, info: "体验金不足哦！", call : showMsgInfo},
    14: {flag: false, info: "投资金额必须等于可投资余额", call : showMsgInfo},
    15: {flag: false, info: "投资金额应以"+$("#increment").val()+"元的整数倍递增。", call : showMsgInfo},
    16: {flag: false, info: "您不能投资自己的产品", call : showMsgInfo}
 };