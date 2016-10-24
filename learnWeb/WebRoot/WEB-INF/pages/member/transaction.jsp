<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>资金明细_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/accounts.css" />
		<link rel="stylesheet" href="${ctx}/css/investment.css" />
		<link rel="stylesheet" href="${ctx}/css/transaction.css" />
		<link rel="stylesheet" href="${ctx}/css1000/transaction1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/transaction750.css" />
		<link rel="stylesheet" href="${ctx}/css720/transaction720.css" />
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
				<!--用户信息-->
				<div class="accou_xi">
					<div class="accou_x1">
						<div class="ljzq_txt">
							<p>累计赚取</p>
							<label class="kt_1">&yen;</label>
							<label class="kt_2">
							<c:choose>
							 <c:when test="${empty mem.incomeMoney}">0.00元</c:when>
							<c:otherwise>
							<fmt:formatNumber value="${mem.incomeMoney}" pattern="#,#0.00#"/>元
							</c:otherwise>
							</c:choose>
							</label>
						</div>
						<div class="ljzq_txt">
							<p>可用余额</p>
							<label class="kt_1">&yen;</label>
							<label class="kt_2">
							<c:choose>
							<c:when test="${sessionScope.localUser.moneys == '0.00'||empty sessionScope.localUser.moneys||sessionScope.localUser.moneys == '0.0'}">
							0.00元
							</c:when>
							<c:otherwise>
							<fmt:formatNumber value="${sessionScope.localUser.moneys}" pattern="#,##0.00#"/>元
							</c:otherwise>
							</c:choose>
							</label>
						</div>
					</div>
					<div class="accou_x2">
						<a href="${ctx}/payment/fselectmoney.htm" class="conz"></a>
						<!-- <a href="javascript://" class="woyjk"></a> -->
						<a href="${ctx}/withdraw/ftixian.htm" class="tixa"></a>
					</div>
					<div class="accou_x3">
						<!-- <label>注册号：97572483547</label> -->
						<%-- <a href="${ctx}/aboutus/queryPayZn.htm">如何支付？</a> --%>
					</div>
				</div>
				<!--交易类型-->
				<div class="in_lis_t tra_title">
					<div class="tra_select">
						<label>交易类型</label>
						<select name="type" id="type"  size="1" >
							<option value="0" selected="selected">全部</option>
								<c:forEach items="${list}" var="list">
								<option value="${list.code}">${list.description_zh}</option>
								</c:forEach>
						</select>
					</div>
					<ul id="ulli">
						<li class="<c:if test='${map.timeType == 0}'>ils_c</c:if>"  onclick='trans(0);' id="0">全部</li>
						<li class="<c:if test='${map.timeType == 1}'>ils_c</c:if>"  onclick='trans(1);' id="1">今天</li>
						<li class="<c:if test='${map.timeType == 2}'>ils_c</c:if>"  id="2" onclick="trans(2);">一周</li>
						<li class="<c:if test='${map.timeType == 3}'>ils_c</c:if>"  id="3" onclick="trans(3);">一个月</li>
						<li class="<c:if test='${map.timeType == 4}'>ils_c</c:if>" id="4" onclick="trans(4);">一年</li>					
					</ul>
				</div>
				<!--查询表格-->
				<form name="formlist">
				<div id="alllist" style="height:auto;overflow:hidden; float:left;width: 100%" >
				<div class="media_table_cont">
				<table cellpadding="0" cellspacing="0" border="0" class="tran_table">
					<tr>
						<th width="19%">时间</th>
						<th width="20%">交易类型</th>
						<th width="15%">操作金额(元)</th>
						<th width="15%">可用金额</th>
						<th>说明</th>
					</tr>
					<!--
                    	作者：xgh_web@126.com
                    	时间：2015-09-10
                    	描述：操作金额为正数的时候给span添加class=“font_red”
                    		操作金额为负数的时候给span添加class=“font_ger”
                    -->
					<c:choose>
						<c:when test="${empty proPage.result}">
						<tr> <td colspan="5"><div id="tabList_no"></div></td></tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${proPage.result}" var="list">
								<tr>
									<td><div><fmt:formatDate value="${list.createTime}" type="both" pattern='yyyy-MM-dd'/><br /><span><fmt:formatDate value="${list.createTime}" type="both" pattern='HH:mm:ss'/></span></div></td>
									<td>
									
								 <c:forEach items="${codedesclist}" var="itemBean">
								 <c:if test="${itemBean.code == list.type}">${itemBean.description_zh}</c:if>
								</c:forEach>
								    </td>
									<td>
										
										 <c:if test="${fn:startsWith(list.showAffectMoney,'+')}">
										 <span class="font_red"><fmt:formatNumber value="${list.showAffectMoney}" pattern="+,##0.00"/></span>
										 </c:if>
										 <c:if test="${fn:startsWith(list.showAffectMoney,'-')}"><span class="font_ger"><fmt:formatNumber value="${list.showAffectMoney}" pattern="#,##0.00"/></span>
										 </c:if>
										 <c:if test="${fn:startsWith(list.showAffectMoney,'*')}"><span><fmt:formatNumber value="${list.affectMoney}" pattern="#,##0.00"/></span></c:if>
									</td>
									<td><fmt:formatNumber value="${list.availableMoney}" pattern="#,##0.00"/></td>
									<td title="${list.info}" class="remarks">${list.info}</td>
										<!--<td><span>0.00</span></td>-->
							   </tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>
				</div>
				<!-- 分页 -->
				<c:choose>
					<c:when test="${not empty proPage.result}">
						<div class="tran_pg">
							<div class="page_fy">
								<li:pagination methodName="fqueryPage" pageBean="${proPage}" sytleName="page_fy"/>
							</div>
					    </div>
					</c:when>
				</c:choose>
				 
				</div>
				</form>
			</div>
		</div>
			<%@ include file="/static/footer.jsp" %>
	</body>
	<script type="text/javascript">
		 $(function(){
		})
	    	/* var time=$("li:[class='ils_c']").attr("id");*/ 
	    	var s;
			function trans(s){
				var val=$("#type").val();
				var map="types="+val+"&timeType="+s;
				var totalCount = ${proPage.totalCount};
				fqueryPage(0,totalCount,s,val);
		    }
			$("#type").change(function(){
				var val=$("#type").val();
				var totalCount = ${proPage.totalCount};
				fqueryPage(0,totalCount,s,val);
			})
			function fqueryPage(pageNo,totalCount,s,val,pageSize){
				if(typeof(s)=='undefined'){
					s='';
					if($("li[class='ils_c']").length > 0){
						s= $("li[class='ils_c']").attr("id");
					}
				}
				if(typeof(val)=='undefined'){
					val='';
					var va=$("#type").val();
					if(va!=null){
						val=va;
					}
				}
				var map = $("#formlist").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount + "&pageSize=" + pageSize+"&types="+val+"&timeType="+s;
				$.ajax({
					type: "POST",
					url: "${ctx}/membermoney/fchecktrancerecord.htm",
					data: map,
					success: function(result) {
						$('#alllist').html(result);
					}
				});
			}
	</script>
</html>
