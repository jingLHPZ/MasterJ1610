<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>行业新闻_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/about.css" />
		<link rel="stylesheet" href="${ctx}/css1000/a_journalism1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/a_journalism750.css" />
		<link rel="stylesheet" href="${ctx}/css720/a_journalism720.css" />
		<script type="text/javascript">
			$(document).ready(function(){
				$(".toin_left_menu li:eq(5)").addClass('abo_me_click').siblings().removeClass('abo_me_click');
				//导航
				$(document).ready(function(){
					$(".list_nav li a").removeClass('nav_bor');
					$(".list_nav>li:eq(5)").find('a').addClass('nav_bor');
					$(".page_fy a").eq(2).removeClass('fy_gl');
				})
			})
			function newsinfo(newsid){
				window.location.href='${ctx}/newsinformation/fqueryinfocontent.htm?newsid='+newsid;
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
					<a href="${ctx}/selfaboutus/a_CompanyProfile.jsp">关于我们</a><span class="active">>&nbsp;行业新闻</span>
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
				<ul class="journ_list">
					<c:choose>
						<c:when test="${empty newsinformationlist}">暂时还没有最新行业新闻！</c:when>
						<c:otherwise>
							<c:forEach items="${newsinformationlist}" var="newsinfo">
							<li onclick="newsinfo(${newsinfo.newsid})">
							<div>
								<h3>${newsinfo.newstitle }</h3>
								<label><fmt:formatDate value="${newsinfo.createdate}" type="both" pattern='yyyy-MM-dd'/></label><p style="display: none;">搜狐报道</p>
							</div>
						    </li>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					
				</ul>
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
		/* var map = $("#formlist").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount;
		$.ajax({
			type: "POST",
			url: "${ctx}/newsinformation/queryNewInfoOther.htm",
			data: map,
			success: function(result) {
				$('#allist').html(result);
			}
		}); */
		
		window.location.href="${ctx}/newsinformation/fqueryallinformation"+pageNo+".htm";
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
