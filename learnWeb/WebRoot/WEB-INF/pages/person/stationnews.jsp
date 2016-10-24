<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>站内消息_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/stationnews.css" />
		<link rel="stylesheet" href="${ctx}/css1000/stationnews1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/stationnews750.css" />
		<link rel="stylesheet" href="${ctx}/css720/stationnews720.css" />
		<%@ include file="/static/top.jsp" %>
	</head>
	<body>
		<div class="content_body">
			<!--左边查单栏-->
			<div class="left_menu">
				<%@ include file="/static/left_menu.jsp" %>
			</div>
			<!--右边主体-->
		<form name="messageQueryForm">
			<div class="right_main">
				<!--通知详情-->
				<c:choose>
					<c:when test="${not empty message}">
					<div class="stati_tzxq sta_cen" style="display:block;">
						<p class="stati_lb_title">
							<a href="${ctx}/message/personMessage.htm">&lt;&nbsp;列表</a>
							<b>消息列表</b>
						</p>
						<div class="stati_xx_bod">
							<h3>系统消息</h3>
							<div class="sta_font">
							${message.messageContent}
							</div>
							<div class="sta_sx">
								<a href="${ctx}/message/N/${message.id}.htm">下一条</a>
								<a href="${ctx}/message/P/${message.id}.htm">上一条</a>
							</div>
						</div>
					</div>
					</c:when>
					<c:otherwise>
					<!--站内消息-->
					<div class="stati_znxx sta_cen">
					<p class="znxx_title">
						<b>站内消息</b>
						我们将推送给您与您的账户相关的新提醒、新服务、帮助等。
						<!-- <a href="javascript://">通知设置</a> -->
					</p>
					<div class="znxx_lx">
						<p class="lx_xzlx">
							<b>选择</b>
							<a href="javascript://">全选</a>
							<a href="javascript://">反选</a>
						</p>
						<p class="lx_xzlx">
							<b>类型</b>
							<a id="haveRead" href="javascript:messageQuery(1);">已读</a>
							<a id="toRead" href="javascript:messageQuery(1);">未读</a>
						</p>
						<p class="lx_cz">
							<b>操作</b>
							<a href="javascript:updateMessage('H');">标记已读</a>
							<a href="javascript:updateMessage('T');">标记未读</a>
							<a href="javascript:updateMessage('D');">删除</a>
						</p>
					</div>
					<div id="resultListDiv">
						<table cellpadding="0" cellspacing="0" border="0" class="znxx_tab" style="font-size:14px;font-family:微软雅黑;font-weight: bold;">
							<tr>
								<th width="10%"></th>
								<th width="22%">时间</th>
								<th>消息摘要</th>
							</tr>
							<c:choose>
								<c:when test="${empty page.result}">
									<tr><td colspan="3" style="text-align: center;padding-left: 0px;"><div id="tabList_no" style="border:none; margin:0;"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${page.result}" var="message" varStatus = "rowStatus">
									   <tr>
									        <td><div data="${message.id}"></div></td>
											<td><fmt:formatDate value="${message.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
											<td><a href="${ctx}/message/${message.id}.htm" style="<c:if test="${message.readStatus == 'H' }">color:#333</c:if>">
											<c:choose>
												<c:when test="${fn:length(message.messageContent) > 36}">${fn:substring(message.messageContent, 0, 36)}……</c:when>
												<c:otherwise>${message.messageContent}</c:otherwise>
											</c:choose>
											</a>
											</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						
						</table>
						<c:if test="${not empty page.result}">
							<!--分页-->
							<div class="stati_pg">
							    	<!--分页-->
								<li:pagination methodName="messageQuery" pageBean="${page}" sytleName="page_fy"/>
							</div>
						</c:if>
					</div>
				
				</div>
					</c:otherwise>
				</c:choose>
			</div>
		 </form>
		</div>
		
		
		<div class="smrz_posi" style="display:none;">
			<div class="smr_bloak">
				<a href="javascript:void(0);" onclick="closeDialog();" class="smr_clor"></a>
				<h3 style="margin-top: 50px;">您确认要删除么？</h3>
				<input type="button" name="" value="确认" class="smr_btn" onclick="agreeDelete();" style="margin-top:50px;margin-left:100px;"/>
			</div>
		</div>
		<!-- <div class="smrz_bod"></div> -->
	<script type="text/javascript">
		function messageQuery(pageNo,totalCount,pageSize) {
			var readStatus;
			if($("#haveRead").css("color") === "rgb(46, 161, 228)"){
				readStatus ="H";
			}else if($("#toRead").css("color") === "rgb(46, 161, 228)"){
				readStatus ="T";
			}else{
				readStatus ="";
			}
			var pars = $("#messageQueryForm").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount + "&pageSize=" + pageSize + "&readStatus=" + readStatus;
			$.ajax({
				type: "POST",
				url: "${ctx}/message/queryMessagePage.htm",
				data: pars,
				success: function(result) {
					$('#resultListDiv').html(result);
				}
			});
		}
		
		function updateMessage(readStatus){
			
			$("#haveRead").css("color","");
			$("#toRead").css("color","");
			var updateIds = "_";
	        $(".znxx_tab div").each(function () {  
				if($(this).attr('class') == 'at_ch_bg'){
					updateIds += $(this).attr('data') + "_";
				}
	        });
	        if(updateIds == "__" || updateIds =="_"){
	        	$('.znxx_lx p a').css("color", "#727272");
	        	return;
	        }
			if(readStatus == "D"){
				$(".smrz_posi").show();
			}else{
				updateMessageStatus(readStatus, updateIds);
			}
		}
		function updateMessageStatus(readStatus, updateIds){
	        updateIds = updateIds.substring(1, updateIds.length);
	        var pars = $("#messageQueryForm").serialize() +"&updateIds=" + updateIds + "&readStatus=" + readStatus;
	        $.ajax({
				type: "POST",
				url: "${ctx}/message/updateStatusMessage.htm",
				data: pars,
				success: function(result) {
					$('#resultListDiv').html(result);
					$('.znxx_lx p a').css("color", "#727272");
					window.location.reload();
				}
			});
		}
		function getMessageDetail(id){
	        var pars = $("#messageQueryForm").serialize() +"&id=" + id;
	        $.ajax({
				type: "POST",
				url: "${ctx}/message/fQueryMessage.htm",
				data: pars,
				success: function(result) {
					$('#resultListDiv').html(result);
				}
			});
		}
		function closeDialog(){
			$(".smrz_posi").hide();
			$('.znxx_lx p a').css("color", "#727272");
		}
		function agreeDelete(){
			$(".smrz_posi").hide();
			$("#haveRead").css("color","");
			$("#toRead").css("color","");
			var updateIds = "_";
	        $(".znxx_tab div").each(function () {  
				if($(this).attr('class') == 'at_ch_bg'){
					updateIds += $(this).attr('data') + "_";
				}
	        });
	        if(updateIds == "__" || updateIds =="_"){
	        	return;
	        }
			updateMessageStatus('D', updateIds);
		}
   </script>
		<%@ include file="/static/footer.jsp" %>
	</body>
</html>
