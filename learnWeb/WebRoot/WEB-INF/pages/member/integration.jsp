<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>我的积分_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/integration.css" />
		<link rel="stylesheet" href="${ctx}/css1000/integration1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/integration750.css" />
		<link rel="stylesheet" href="${ctx}/css720/integration720.css" />
		<script type="text/javascript" src="${ctx}/js/method.js" ></script>
	</head>
	<body>
		<div class="content_body">
			<%@ include file="/static/top.jsp" %>
			<!--左边查单栏-->
			<div class="left_menu">
				<%@ include file="/static/left_menu.jsp" %>
			</div>
			<!--右边主体-->
			<div class="right_main">
				<!--积分奖励规则-->
				<p class="integ_gz">
					<b>积分奖励规则</b>
					积分&nbsp;=&nbsp;投资总金额&nbsp;x&nbsp;月数
				</p>
				<!--积分记录-->
				<h3 class="integ_title">积分记录</h3>
				<form name="formlist">
					<div id="alllist">
			 <div class="media_table_cont">
				<table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<th width="28%">时间</th>
						<th width="23%">行为</th>
						<th width="16%">收入+/支出-</th>
						<th>备注</th>
					</tr>
					<c:choose>
						<c:when test="${empty proPage.result}">
						<tr> <td colspan="3"><div id="tabList_no"></div></td></tr>
						</c:when>
						<c:otherwise>
						<c:forEach items="${proPage.result}" var="scorelist">
						<tr>
						<td><fmt:formatDate value="${scorelist.createtime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/><br /></td>
						<td>${scorelist.info}</td>
						<td>
						<c:if test="${scorelist.type==1}"><label class="sr_font">+ ${scorelist.affectscore}</label></c:if><!-- 增加 -->
						<c:if test="${scorelist.type==2}"><label class="zc_font">- ${scorelist.affectscore}</label></c:if><!-- 减少 -->
						</td>
				    	</tr>
					    </c:forEach>
						</c:otherwise>
					</c:choose>
     			    </table>
     			    </div>
     			    </div>
     			    </form>
				<p class="integ_hj">积分合计：${mmd.totalScore}</p>
				     <div class="inte_pg">
					<!--分页-->
						<div class="page_fy">
							<li:pagination methodName="fqueryPage" pageBean="${proPage}" sytleName="page_fy"/>
						</div>
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
				url: "${ctx}/invite/fqueryrecordtwobyuid.htm",
				data: map,
				success: function(result) {
					$('#alllist').html(result);
				}
			});
		}
	</script>
</html>