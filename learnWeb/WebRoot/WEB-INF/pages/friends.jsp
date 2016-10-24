<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>  
  <head>
		<meta charset="utf-8">
		<title>邀请好友_学呗互联网金融</title>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE10" />
  		<%@ include file="/static/newtaglibs.jsp" %>
		<link rel="stylesheet" href="${ctx}/css/public.css" />
		<script type="text/javascript" src="${ctx}/static/top.js"></script>
		<style type="text/css">
			.friends_body{width: 100%; height: auto; overflow: hidden; float: left; padding:600px 0 50px 0; text-align: center; background:#fef8ea url(${ctx}/img/activity/Friends_banner.jpg) top center no-repeat;}
			.friends_body img{ margin:10px 0 15px 0;}
		</style>
	</head>
	<body>
		<jsp:include page="/static/top.jsp" flush="true" />
		<div class="friends_body">
			<img src="${ctx}/img/activity/Friends_img1.jpg" />
			<img src="${ctx}/img/activity/Friends_img2.jpg" />
			<img src="${ctx}/img/activity/Friends_img3.jpg" />
			<img src="${ctx}/img/activity/Friends_img4.jpg" />
		</div>
		<%@ include file="/static/footer.jsp" %>
	</body>
</html>  