<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<%@ include file="/static/commonTags.jsp"%>
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
