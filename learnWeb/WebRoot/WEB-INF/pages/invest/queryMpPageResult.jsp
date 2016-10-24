<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/commonTags.jsp"%>
<script src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>
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
							<c:if test="${mp.way==1}">民生支付-网关支付</c:if>
							<c:if test="${mp.way==2}">民生支付-快捷支付</c:if>
							<c:if test="${mp.way==3}">线下充值</c:if>
							<c:if test="${mp.way==4}">通联支付-网关支付</c:if>
							<c:if test="${mp.way==5}">通联支付-快捷支付</c:if>
						</td>
						<td><fmt:formatNumber value="${mp.rechargeMoney}" pattern="#,##0.00#"/></td>
						<td><span>
							<c:if test="${mp.status==1}">充值中</c:if>
							<c:if test="${mp.status==2}"><span>充值成功</span></c:if>
							<c:if test="${mp.status==3}">充值失败</c:if>
						</span></td>
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