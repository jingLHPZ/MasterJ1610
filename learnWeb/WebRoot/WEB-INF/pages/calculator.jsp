<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transition
al//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp" %>
		<title>计算器_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/calculator.css" />
		<link rel="stylesheet" href="${ctx}/css1000/calculator1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/calculator750.css" />
		<link rel="stylesheet" href="${ctx}/css720/calculator720.css" />
		<script type="text/javascript" src="${ctx}/js/self-method.js" ></script>
	</head>
	<body>
		<jsp:include page="/static/top.jsp" flush="true" />
		<div class="toin_body">
			<!--面包屑-->
			<div class="left_title">
				您的位置:<a href="${ctx}/">首页</a><span>>&nbsp;计算器</span>
			</div>
			<!--计算器-->
			<div class="calcul_bod">
				<h2 class="cal_tit">投资利息计算器</h2>
				<ul class="cal_list">
					<li>
						<p>投资金额</p>
						<div>
							<input type="text" id="money" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" maxlength="9"/><label>元</label>
						</div>
					</li>
					<li>
						<p>投资期限</p>
						<div>
							<input type="text" id="duration" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" maxlength="3"/>
							<select class="cal_tzqx" id="durationType" onchange="changeDurationType(1);">
								<option value="day">日</option>
								<option value="month">月</option>
							</select>
						</div>
					</li>
					<li>
						<p>年化利率</p>
						<div>
							<input type="text" id="rate" maxlength="6"/><label>%</label>
						</div>
					</li>
					<li>
						<p>还款方式</p>
						<select class="cal_hkfs" id="repayMode" onchange="changeDurationType(2);">
							<option value="5" selected="selected">每月付息，到期还本</option>
							<option value="6">每季度付息，到期还本</option>
							<option value="7">每半年付息，到期还本</option>
							<option value="2">到期还本付息</option>
						</select>
					</li>
				</ul>
				<input type="button" name="" value="开始计算" class="cal_btn_js" onclick="getRepayment();" />
				<!--计算结果-->
				<div class="cal_jsjg">
					<h3>计算结果</h3>
					<a href="javascript:void()" class="cal_close"></a>
					<p class="cal_tznum">投资金额：<label id="investMoney">0.0</label>元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;到期本息总额：<label id="totalMoney">0.0</label>元</p>
					<p class="cal_jg_ti">计算结果</p>
					<table cellspacing="0" cellpadding="0" border="0" class="cal_tab_th">
						<tr>
							<th width="150">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;期数</th>
							<th width="230">每月还款金额</th>
							<th width="230">每月还款本金</th>
							<th width="230">每月还款利息</th>
							<th>剩余还款金额&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
						</tr>
					</table>
					<table cellspacing="0" cellpadding="0" border="0" class="cal_tab_td">
					</table>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="static/footer.js"></script>
	
	<script type="text/javascript">
		$.ajaxSetup({ async: false });
	
		function getRepayment() {
			var moneyReg = /^(([1-9]\d{0,9})|0)(\.\d{1,2})?$/;
			var rateReg = /^(([1-9]\d{0,2})|0)(\.\d{1,2})?$/;
			var durationReg = /^\d+$/;
			
			var money = $("#money").val();
			var duration = $("#duration").val();
			var durationType = $("#durationType").val();
			var rate = $("#rate").val();
			var repayMode = $("#repayMode").val();
			
			if (money == null || money == '') {
				alert("投资金额不能为空！"); return ;
			} else if (!moneyReg.test(money)) {
				alert("投资金额输入有误！"); return ;
			} else if (duration == null || duration == '') {
				alert("投资期限不能为空！"); return ;
			} else if (!durationReg.test(duration)) {
				alert("投资期限输入有误！"); return ;
			} else if (rate == null || rate == '') {
				alert("年化利率不能为空！"); return ;
			} else if (!rateReg.test(rate)) {
				alert("年化利率输入有误！"); return ;
			}
			
			var result = "";
			$.post("${ctx}/calculator/findRepaymentList.htm", 
					{
						"money":money, "duration":duration, "durationType":durationType, 
						"rate":rate, "repayType":repayMode
					}, 
					function (data) {
						result = JSON.parse(data);
					}
			);
			
			var html = "";
			for (var i = 0; i < result.length; i++) {
				if (i != result.length -1) {
					html += '<tr><td width="130">'+ result[i]["sortOrder"] +'</td><td width="230">'+ result[i]["repaymentMoney"]
						+ '</td><td width="230">'+ result[i]["capital"] +'</td><td width="230">'+ result[i]["interest"]
						+ '</td><td>'+ result[i]["remainMoney"] +'</td></tr>';
				} else {
					$("#totalMoney").text(result[i]["totalMoney"]);
				}
			}
			$("#investMoney").text(money);
			$(".cal_tab_td").empty().append(html);
		}
		
		function changeDurationType(type) {
			var durationType = $("#durationType").val();
			var repayMode = $("#repayMode").val();
			
			if (type == 1 && durationType == 'month') {
				$("#repayMode").val(2);
			}
			
			if (type == 2 && repayMode != 2) {
				$("#durationType").val("day");
			}
		}
	</script>
</html>