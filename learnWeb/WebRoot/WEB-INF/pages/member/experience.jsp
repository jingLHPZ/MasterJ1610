<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>体验金_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/experience.css" />
		<link rel="stylesheet" href="${ctx}/css1000/experience1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/experience750.css" />
		<link rel="stylesheet" href="${ctx}/css720/experience720.css" />
		<script type="text/javascript" src="${ctx}/js/method.jsp" ></script>
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
				<h3 class="exper_title">我的体验金</h3>
				<!--体验金信息-->
				<div class="exper_tyj">
					<p class="extyj_ti">体验金余额：<b>&yen;<fmt:parseNumber integerOnly="true" value="${mmd.experienceGold}" /></b></p>
				<%-- 	<p>体验金总额：<label>&yen;
					<c:if test="${empty allexperiencegold}">0.0</c:if>
					<fmt:formatNumber value="${allexperiencegold}" pattern="#,##0.00#"/>
					</label></p> --%>
					<p>待收利息：<label>&yen;<fmt:formatNumber value="${waitinterest}" pattern="#,##0.00#"/></label></p>
					<p>投资中金额：<label>&yen;${investgold}<%-- <fmt:formatNumber value="${investgold}" pattern="#,##0.00#"/></label> --%></p>
					<p>已获利息：<label>&yen;<fmt:formatNumber value="${hasbeeninterest}" pattern="#,##0.00#"/></label></p>
				</div>
				<!--表格-->
				<form name="formlist">
				<div id="allist">
				<table cellpadding="0" cellspacing="0" border="0" class="exper_tab">
					<tr>
						<th>操作</th>
						<th>体验金</th>
						<th>时间</th>
					</tr>
					<c:choose>
						<c:when test="${empty page.result}">
						<tr> <td colspan="3"><div id="tabList_no"></div></td></tr>
						</c:when>
						<c:otherwise>
						<c:forEach items="${page.result}" var="experience">
						<tr>
						<td>${experience.info}</td>
						<td>
						<c:if test="${experience.type==1}"><span>+ ${experience.affectexperiencegold}</span></c:if>
						<c:if test="${experience.type==2}"><label>- ${experience.affectexperiencegold}</lable></c:if>
						</td>
						<td><fmt:formatDate value="${experience.createtime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
						</tr>
						</c:forEach>
						</c:otherwise>
						</c:choose>
				</table>
				
				<!-- 分页 -->
				<c:choose>
					<c:when test="${not empty page.result}">
						<div class="bonda_pg">
							<div class="page_fy">
								<li:pagination methodName="fqueryPage" pageBean="${page}" sytleName="page_fy"/>
							</div>
					    </div>
					</c:when>
				</c:choose>
				</div>
				</form>
				<!--说明-->
				<div class="exper_sm">
					<h4>体验金是什么？</h4>
					<p>
						体验金是学呗通过活动等形式送给用户在学呗网投资的虚拟货币，用户通过体验金来进行模拟投标，学呗将通过体验金获得的收益金额送给用户。
					</p>
					<h4>体验金使用规则</h4>
					<p>
						1、体验金不显示在可用余额中，不可提现；<br/>
						2、仅限投资体验标，到期后仅可提取利息；<br/>
						3、投资的项目到期后，体验金本金由学呗网收回；<br/>
						4、在收到体验标利息的45天内（自然日），若未提现或未投资非体验标产品，则该笔投资利息将自动收回；<br/>
						5、体验金使用规则最终解释权归学呗网所有。

					</p>
				</div>
			</div>
		</div>
		<%@ include file="/static/footer.jsp" %>
	</body>
	<script type="text/javascript">
	function fqueryPage(pageNo,totalCount,pageSize){
		var map = $("#formlist").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount + "&pageSize=" + pageSize;
		$.ajax({
			type: "POST",
			url: "${ctx}/experience/queryPageExperience.htm",
			data: map,
			success: function(result) {
				$('#allist').html(result);
			}
		});
	}
	
	
	</script>
</html>