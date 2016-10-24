<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>账户记录详情_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/record.css"/>
		<link rel="stylesheet" href="${ctx}/css1000/record1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/record750.css" />
		<link rel="stylesheet" href="${ctx}/css720/record720.css" />
		<script src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>
	<style type="text/css">
		#confirm {
		display: none;
		}
	</style>		
	</head>
	<body>
	<%@ include file="/static/top.jsp" %>
		<div class="content_body">
			<!--左边查单栏-->
			<div class="left_menu">
			<%@ include file="/static/left_menu.jsp" %>
			</div>
			<!--右边主体-->
			<div class="right_main">
				<!-- 充值、提现 -->
				<div class="record_cz">
					<p>
						已充值总额<b class="b_1">
						<c:choose>
							<c:when test="${empty paymoney||paymoney== '0.00' ||paymoeny== '0.0'}">
							0.00
							</c:when>
							<c:otherwise>
							<fmt:formatNumber value="${paymoney}" pattern="#,##0.00#"/>
							</c:otherwise>
						</c:choose>
						元
						</b>
						已提现总额<b class="b_2">
						<c:choose>
							<c:when test="${empty withdrawmoney||withdrawmoney== '0.00' ||withdrawmoney== '0.0'}">
							0.00
							</c:when>
							<c:otherwise><fmt:formatNumber value="${withdrawmoney}" pattern="#,##0.00#"/></c:otherwise>
						</c:choose>
						元</b>
					</p>
					<a href="${ctx}/payment/fselectmoney.htm" class="cz_href"></a>
					<a href="${ctx}/withdraw/ftixian.htm" class="tx_href"></a>
				</div>
				<!-- 模块标题 -->
				<div class="cz_title">
					<a href="javascript://"  class="cz_ti_h" id="recharge">充值金额</a><!-- <%-- ${ctx}/payment/fchongzhirecord.htm --%> -->
					<a href="javascript://" id="withdraw">提现金额</a>
				</div>
				<!-- 充值金额 -->
				<form name="fqueryMpPageForm" id="fqueryMpPageForm">
					<div class="czje_bod" id="resulMpDiv">
					<div class="screen_cont">
						起止日期&nbsp;&nbsp;&nbsp;
						<div class="screen_time">
						<input class="form-control" type="text" onclick="WdatePicker({startDate:'1980-05-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'startTime1\')}'})" readonly="readonly" id="startTime1" name="startTime1" value="${maps['payStartTime']}">
						</div>
						&nbsp;-&nbsp;
						<div class="screen_time">
							<input class="form-control" type="text" onclick="WdatePicker({startDate:'1980-05-01',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'endTime1\')}'})" readonly="readonly" id="endTime1" name="endTime1" value="${maps['payEndTime']}">
						</div>
						<a class="screen_btn"  onclick="queryFormPay()" >确定</a>
					</div>
					<div class="media_table_cont">
						<!-- 表格 -->
						<table cellpadding="0" cellspacing="0" border="0" class="cz_tab" style="font-size: 14px;">
							<tr>
								<th width="35%">时间</th>
								<th>交易类型</th>
								<th>充值渠道</th>
								<th>金额(元)</th>
								<th>状态</th>
							</tr>
							<c:choose>
								<c:when test="${empty mpPage.result}">
								<tr><td colspan="5"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${mpPage.result}" var="mp">
										<tr>
											<td><fmt:formatDate value="${mp.createTime}" pattern='yyyy-MM-dd HH:mm:ss'/></td>
											<td>
											<c:if test="${mp.type==1}">线上充值</c:if>
											<c:if test="${mp.type==2}">线下充值</c:if>
											</td>
											<td>
											<c:forEach items="${payWayEnum}" var="payWayEnum">
												<c:if test="${payWayEnum.code == mp.way}">${payWayEnum.description_zh}</c:if>
											</c:forEach>
											</td>
											<td><fmt:formatNumber value="${mp.rechargeMoney}" pattern="#,##0.00#"/></td>
											<td>
											<c:forEach items="${payStatusEnum}" var="payStatusEnum">
												<c:if test="${payStatusEnum.code == mp.status}">${payStatusEnum.description_zh}</c:if>
											</c:forEach>
											</td>
							            </tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
						<!--分页-->
						<c:choose>
							<c:when test="${not empty mpPage.result}">
								<div class="czje_pg">
								    	<!--分页-->
									<div class="page_fy">
										<li:pagination methodName="fqueryMpPage" pageBean="${mpPage}" sytleName="page_fy"/>
									</div>
								</div>
							</c:when>
						</c:choose>
				  </div>
				</form>
				<!-- 提现金额 -->
				<form name="fqueryMvPageForm" id="fqueryMvPageForm">
					<div class="czje_bod txje_bod" id="resulMvDiv">
					<!--查看筛选-->
					<div class="screen_cont">
						起止日期&nbsp;&nbsp;&nbsp;
						<div class="screen_time">
							<input class="form-control" type="text" onclick="WdatePicker({startDate:'1980-05-01',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'startTime2\')}'})" readonly="readonly" id="startTime2" name="startTime2" value="${maps['withdrawStartTime']}">
						</div>
						&nbsp;-&nbsp;
						<div class="screen_time">
							<input class="form-control" type="text" onclick="WdatePicker({startDate:'1980-05-01',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'endTime2\')}'})" readonly="readonly" id="endTime2" name="endTime2" value="${maps['withdrawEndTime']}">
						</div>
						<a class="screen_btn"  onclick="queryForm()" >确定</a>
					</div>
					<div class="media_table_cont">
						<!-- 表格 -->
						<table cellpadding="0" cellspacing="0" border="0" class="cz_tab">
							<tr>
								<th width="13%">时间</th>
								<th width="18%">银行</th>
								<th width="20%">银行账号</th>
								<th width="17%">提现金额(元)</th>
								<th width="9%">手续费</th>
								<th width="12%">状态</th>
								<th width="10%">操作</th>
							</tr>
							<c:choose>
								<c:when test="${empty mvPage.result}">
									<tr><td colspan="6"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${mvPage.result}" var="mw">
										<tr>
											<td><fmt:formatDate value="${mw.createTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
											<td>${mw.cardBank}</td>
											<td>${mw.bankCardNo}</td>
											<td id="tdWithdrawMoney"><fmt:formatNumber value="${mw.withdrawMoney}" pattern="#,##0.00#"/></td>
											<td>
											<c:choose>
											<c:when test="${empty mw.withdrawFee||mw.withdrawFee=='0.00'||mw.withdrawFee=='0.0'}">-----</c:when>
											<c:when test="${mw.withdrawFee < 10}">
									        <fmt:formatNumber value="${mw.withdrawFee}" pattern="#0.00#"/>元
									        </c:when>
											<c:otherwise>
											<fmt:formatNumber value="${mw.withdrawFee}" pattern="#,##0.00#"/>	
											</c:otherwise>
											</c:choose>
											</td>
											<td><span>
											<c:forEach items="${withdrawTypeEnum}" var="withdrawTypeEnum">
												<c:if test="${withdrawTypeEnum.code == mw.withdrawStatus}">${withdrawTypeEnum.description_zh}</c:if>
											</c:forEach>
											</span></td>
											<td>
											<c:choose>
												<c:when test="${mw.withdrawStatus == 1}"><a class="revoke" onclick="checkrevokewithdraw(${mw.withdrawMoney},${mw.id});"  href="javascript:void(0);">撤销提现</a></c:when>
												<c:otherwise>
													--
												</c:otherwise>
											</c:choose>
											<input type="hidden" id="freeWithdrawMoney" value="${mw.freeWithdrawMoney}" >
											<input type="hidden" id="systemTraceNo" value="${mw.systemTraceNo}" >
											</td>
							            </tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
						<!--分页-->
						<c:choose>
							<c:when test="${not empty mvPage.result}">
								<div class="czje_pg">
								    	<!--分页-->
									<div class="page_fy">
										<li:pagination methodName="fqueryMvPage" pageBean="${mvPage}" sytleName="page_fy"/>
									</div>
								</div>
							</c:when>
						</c:choose>
				  </div>
				</form>
				<div class="revoke_mask">
					<div class="revoke_bod">
						<h2>
							撤销提现
							<div></div>
						</h2>
						<div class="page_1">
							<h3>
								您确定撤销这笔&nbsp;<span>
								&nbsp;</span>元的提现吗？
							</h3>
							<p>（撤销成功后，该笔资金将解冻，成为账户可用余额）</p>
							<input type="button" value="确定撤销" id="determineRevoke" onclick="determineRevoke()"></input>
							<a href="javascript://" id="think">我再想想</a>
							<input type="button" value="确定" id="confirm" onclick="revokesuccess();">
						</div>
						<div class="page_2">
							<h1>撤销提现成功！</h1>
							<input type="button" value="好的" onclick="revokesuccess();"></input>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="/static/footer.jsp" %>
	</body>
	<script type="text/javascript">
	//为撤销提现的数值赋值
	function checkrevokewithdraw(val, id){
		var id= id;
		$.ajax({
			type : "post",
			url : "${ctx}/withdraw/clikcDetermineRevoke.htm?id="+id,
			dataType : "text",
			success : function(data) {
				if (data == "yes") {
					$(".revoke_bod .page_1").show();
					$(".page_1").find("span").text(val.toFixed(2));
					$("#determineRevoke").text(id);
				}else{
					$(".revoke_bod .page_1").find("h3").text("该笔提现已被受理，无法撤销");
					$(".revoke_bod .page_1").find("p").hide();
					$("#determineRevoke").hide();
					$("#think").hide();
					$("#confirm").show();
				}
			}
		})
	}
		function fqueryMpPage(pageNo,totalCount,pageSize) {
			var pars = $("#fqueryMpPageForm").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount + "&pageSize=" + pageSize;
			$.ajax({
				type: "POST",
				url: "${ctx}/payment/fqueryMpPage.htm",
				data: pars,
				success: function(result) {
					$('#resulMpDiv').html(result);
				}
			});   
		}
		function fqueryMvPage(pageNo,totalCount,pageSize){
			var pars = $("#fqueryMvPageForm").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount + "&pageSize=" + pageSize;
			$.ajax({
				type: "POST",
				url: "${ctx}/payment/fqueryMvPage.htm",
				data: pars,
				success: function(result) {
					$('#resulMvDiv').html(result);
				}
			});   
		}
		$(document).ready(function() {
			var flag = '${flag}';
			if(flag == 'withdraw') {
				$('#withdraw').addClass("cz_ti_h");
				$('#recharge').removeClass('cz_ti_h');
				$('#withdraw').click();
			}
			if(flag == 'inwithdraw'){
				$('#withdraw').addClass("cz_ti_h");
				$('#recharge').removeClass('cz_ti_h');
				$('#withdraw').click();
			}
			if(flag == 'inpay'){
				$('#recharge').addClass("cz_ti_h");
				$('#withdraw').removeClass('cz_ti_h');
				$('#recharge').click();
			}
		});
		
		
		//确定撤销
		
		function  determineRevoke(){
			var wid=$("#determineRevoke").text();
			var freeWithdrawMoney=$("#freeWithdrawMoney").val();
			var val=$(".page_1").find("span").text();
			if(freeWithdrawMoney == null ||freeWithdrawMoney ==''){
				freeWithdrawMoney = 0;
			}
			// {'wid' : wid,"freeWithdrawMoney":freeWithdrawMoney,'withdrawMoney' :withdrawMoney,'systemTraceNo' : systemTraceNo   		}
			var systemTraceNo=$("#systemTraceNo").val();
			var pars = "wid=" + wid + "&freeWithdrawMoney=" + freeWithdrawMoney + "&withdrawMoney=" + val + "&systemTraceNo=" + systemTraceNo;
			$.ajax({
				type : "post",
				url : "${ctx}/withdraw/queryDetermineRevoke.htm",
				data: pars,
				async:false,
				dataType : "text",
				success : function(data) {
					if (data == "yes") {
						$(".revoke_bod .page_1").hide();
						$(".revoke_bod .page_2").show();
					}
				}
			})
		}
		/* $(".revoke_bod .page_1 input").bind("click",function(){
			$(".revoke_bod .page_1").hide();
			$(".revoke_bod .page_2").show();
		}) */
		function revokesuccess(){
			window.location.href='${ctx}/payment/fchongzhirecord.htm?flag=withdraw';
		}
		function queryForm(){
			location.href="${ctx}/payment/fchongzhirecord.htm?flag=inwithdraw&"+$("#fqueryMvPageForm").serialize();
		}
	 	function queryFormPay(){
			location.href="${ctx}/payment/fchongzhirecord.htm?flag=inpay&"+$("#fqueryMpPageForm").serialize();
		}
	</script>
</html>
