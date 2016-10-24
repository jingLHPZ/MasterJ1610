<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/commonTags.jsp"%>
          <div class="invite_list">
				<p class="prompt">注：“体验标”不计入投资</p>
				<table cellpadding="0" cellspacing="0" class="acc_table">
					<thead>
						<tr>
							<th class="th_1">好友用户名</th>
							<th class="th_2">注册时间</th>
							<th class="th_3">是否已实名</th>
							<th class="th_4">是否已投资</th>
						</tr>
					</thead>
					<tbody>
					<c:choose>
						<c:when test="${empty proPage.result}">
							<tr> 
								<td colspan="4"><div id="tabList_no"></div></td>
							</tr>
						</c:when>
						<c:otherwise>
						<c:forEach items="${proPage.result}" var="inviterecord">
							<tr>
								<td class="td_1">${inviterecord.members.userName}</td>
								<td class="td_2"><fmt:formatDate value="${inviterecord.members.regTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
								<td class="td_3">
									<c:choose>
										<c:when test="${inviterecord.members.isRealName==1}">
											是
										</c:when>
										<c:otherwise>
											否
										</c:otherwise>
									</c:choose>
								</td>
								<td class="td_4">
									<c:choose>
										<c:when test="${inviterecord.investorNum>0}">
											是
										</c:when>
										<c:otherwise>
											否
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						 </c:forEach>
						</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
			<!--分页-->
			<c:choose>
			  <c:when test="${empty proPage.result}"></c:when>
			  <c:otherwise>
					<div class="links_pg" style="float: right;"> 
						<div class="page_fy">
							<li:pagination methodName="fqueryPage" pageBean="${proPage}" sytleName="page_fy"/>
						</div>
					 </div>
			 </c:otherwise>
			</c:choose>