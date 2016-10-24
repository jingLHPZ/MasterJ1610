<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit" /> 
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
	<%@ include file="/static/newtaglibs.jsp"%>
	<title>一伍一拾_学呗互联网金融</title>
	<link rel="stylesheet" href="${ctx}/css/raise.css" />
	
	<%@ include file="/static/top.jsp" %>
</head>
<body>
	<div class="raise_tab">
		<a class="raise_href" style="display:block" href="${ctx}/img/pdf/otherType.pdf">查看服务协议模板</a>
		<a class="right_btn" style="display:block" href="${ctx}/img/pdf/ywys.pdf">分类产品模板</a>
	</div>
	<%@ include file="/static/footer.jsp" %>
	<script type="text/javaScript">
	    $(function(){
			BASE.removeCss();
		})
	</script>
	</body>
</html>
