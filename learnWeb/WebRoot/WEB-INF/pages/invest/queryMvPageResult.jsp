<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/commonTags.jsp"%>
<script src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>
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
	<table cellpadding="0" cellspacing="0" border="0" class="cz_tab" style="font-size: 14px;">
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
				<tr><td colspan="7"><div id="tabList_no"></div></td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${mvPage.result}" var="mw">
					<tr>
						<td><fmt:formatDate value="${mw.createTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
						<td>${mw.cardBank}</td>
						<td>${mw.bankCardNo}</td>
						<td><fmt:formatNumber value="${mw.withdrawMoney}" pattern="#,##0.00#"/></td>
						<td><%-- <fmt:formatNumber value="${mw.withdraw_fee}" pattern="#,##0.00#"/> --%>-----</td>
						<td><span>
							<c:forEach items="${withdrawTypeEnum}" var="withdrawTypeEnum">
								<c:if test="${withdrawTypeEnum.code == mw.withdrawStatus}">${withdrawTypeEnum.description_zh}</c:if>
							</c:forEach>
						</span></td>
						<td>
							<c:choose>
								<c:when test="${mw.withdrawStatus == 1}"><a class="revoke" onclick="checkrevokewithdraw(${mw.withdrawMoney},${mw.id})"  href="javascript:void(0);">撤销提现</a></c:when>
								<c:otherwise>
									--
								</c:otherwise>
							</c:choose>
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