<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>邀请奖励_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/links.css" />
		<link rel="stylesheet" href="${ctx}/css1000/links1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/links750.css" />
		<link rel="stylesheet" href="${ctx}/css720/links720.css" />
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
				<!--邀请链接-->
				<div class="links_font" style="background:url(${QRcodeIp}) top right no-repeat; background-size:200px;">
					<h3>友情邀请</h3>
					<p>
						复制你的邀请链接发送给好友（微信微博QQ等）<br />
						好友通过你的邀请链接进行注册，将自动成为你名下的邀请好友！<br /><br />
						你的邀请链接：<a href="${QRcodeTargetUrl}"  target="target" >${QRcodeTargetUrl}</a>
					</p>
					<label onclick="copyLinkUrl(document.all.targetUrl)">复制链接</label>
				</div>
				<!--邀请记录-->
				<div class="links_tab">
					<h3>邀请记录</h3>
					<!--表格-->
					<form name="formlist">
					<div id="alllist" style="height:auto;overflow:hidden; float:left;width: 100%">
					<div class="media_table_cont">
					<table cellpadding="0" cellspacing="0" border="0">
						<tr>
							<th width="50%">用户账号</th>
							<!-- <th width="100">姓名</th> -->
							<th width="50%">创建时间</th>
							<!-- <th width="150">用户类型</th>
							<th>奖励</th> -->
						</tr>
						<c:choose>
						<c:when test="${empty proPage.result}">
						<tr> <td colspan="2"><div id="tabList_no"></div></td></tr>
						</c:when>
						<c:otherwise>
						<c:forEach items="${proPage.result}" var="inviterecord">
						<tr>
						<td>${inviterecord.mobilephone2}</td>
						<td><fmt:formatDate value="${inviterecord.createtime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/><br /></td>
				    	</tr>
					    </c:forEach>
						</c:otherwise>
					</c:choose>
					</table>
					</div>
					<!--分页-->
					<c:choose>
					  <c:when test="${empty proPage.result}"></c:when>
					  <c:otherwise>
							<div class="links_pg">
								<div class="page_fy">
									<li:pagination methodName="fqueryPage" pageBean="${proPage}" sytleName="page_fy"/>
								</div>
							 </div>
					 </c:otherwise>
					</c:choose>
					 </div>
					</form>
				</div>
			</div>
		</div>
		<%@ include file="/static/footer.jsp" %>
		<textarea style="position: relative;z-index:-9999;" cols="${fn:length(QRcodeTargetUrl)}" rows="1" id="targetUrl">${QRcodeTargetUrl}</textarea>
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

		function copyLinkUrl(obj){ 
			obj.select(); // 选择对象
			document.execCommand("Copy"); // 执行浏览器复制命令
			alert("已复制好，可贴粘。");
		} 
	</script>
</html>
