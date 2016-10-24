<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/commonTags.jsp"%>
<table cellpadding="0" cellspacing="0" border="0" class="znxx_tab" style="font-size:14px;font-family:微软雅黑;font-weight: bold;">
	<tr>
		<th width="10%"></th>
		<th width="22%">时间</th>
		<th>消息摘要</th>
	</tr>
	<c:choose>
		<c:when test="${empty page.result}">
			<tr><td colspan="3"><div id="tabList_no" style="border:none; margin:0;"></div></td></tr>
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
				</a></td>
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
	
	
<script type="text/javascript">$(function(){
	//单选
	$(".znxx_tab div").click(function(){
			if($(this).attr('class') == 'at_ch_bg'){
				$(this).removeClass('at_ch_bg');
			}else{
				$(this).not('#tabList_no').addClass('at_ch_bg');
			}
		})
	})
  </script>