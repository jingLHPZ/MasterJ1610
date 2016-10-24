<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>网站公告_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/about.css" />
		<link rel="stylesheet" href="${ctx}/css1000/a_notice1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/a_notice750.css" />
		<link rel="stylesheet" href="${ctx}/css720/a_notice720.css" />
		<script type="text/javascript">
			$(document).ready(function(){
				$(".toin_left_menu li:eq(4)").addClass('abo_me_click').siblings().removeClass('abo_me_click');
				//导航
				$(document).ready(function(){
					$(".list_nav li a").removeClass('nav_bor');
					$(".list_nav>li:eq(5)").find('a').addClass('nav_bor');
					$(".page_fy a").eq(2).removeClass('fy_gl');
				})
			})
			function newsinfo(newsid){
				window.location.href='${ctx}/newsnotice/fquerynotice.htm?newsid='+newsid;
			}
		</script>
	</head>
	<body>
	<%@ include file="/static/top.jsp" %>
		<div id="ab_body">
			<!--面包屑-->
			<div class="bg tp_crumb">
				<div class="container">
					<a href="${ctx}/system/fquerysumway.htm">首页</a>&gt;
					<a href="${ctx}/selfaboutus/a_CompanyProfile.jsp">关于我们</a><span class="active">>&nbsp;网站公告</span>
				</div>
			</div>
			<!--左边查单栏-->
			<div class="left_menu">
				<%@ include file="/static/about_menu.jsp" %>
			</div>
			<!--右边主体-->
			<form name="formlist">
				<div id="allist" >
			<div class="about_right_m">
				<!--列表-->
				<ul class="notice_list">
				<c:choose>
						<c:when test="${empty newsnoticelist}">暂时还没有最新媒体报道</c:when>
						<c:otherwise>
							<c:forEach items="${newsnoticelist}" var="list">
							<li onclick="newsinfo(${list.newsid})">
							  <div> <!-- a_notice_xq.jsp -->
							<h3><div limit='28' style="display:inline">${list.newstitle}</div></h3>
							<label><fmt:formatDate value="${list.createdate}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></label>
						      </div>
							</li>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</ul>
				<!--分页-->
				<c:choose>
					<c:when test="${not empty proPage.result}">
						<div style="float: left;text-align: center;width: 100%;margin: 20px 0;" class="tran_pg">
							<div class="page_fy">
								<li:pagination methodName="fqueryPage" pageBean="${proPage}" sytleName="page_fy"/>
							</div>
					    </div>
					</c:when>
				</c:choose>
					<!--分页-->
			</div>
			</div>
			</form>
		</div>
		<%@ include file="/static/footer.jsp"  %>
	</body>
	<script type="text/javascript">
	function fqueryPage(pageNo,totalCount){
		$(document).scrollTop(0);
		window.location.href="${ctx}/newsnotice/fqueryallnotice"+pageNo+".htm";
	}
	</script>
	<script type="text/javascript">
   jQuery.fn.limit=function(){ 
	var self = $('div[limit]'); 
	self.each(function(){ 
	var objString = $(this).text(); 
	var objLength = $(this).text().length; 
	var num = $(this).attr('limit'); 
	if(objLength > num){ 
	/* $(this).attr('title',objString);  */
	objString = $(this).text(objString.substring(0,num) + '...'); 
	} 
	}) 
	} 
	$(function(){ 
	$(document.body).limit(); 
	}) 
</script>
</html>
