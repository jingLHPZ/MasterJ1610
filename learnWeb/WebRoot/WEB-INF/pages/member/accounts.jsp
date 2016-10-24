<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>我的账户首页_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/accounts.css" />
		<link rel="stylesheet" href="${ctx}/css1000/accounts1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/accounts750.css" />
		<link rel="stylesheet" href="${ctx}/css720/accounts720.css" />
		<script type="text/javascript" src="${ctx}/js/accounts.js" ></script>
	</head>
	<body>
	<%@ include file="/static/top.jsp" %>
		<div class="content_body">
			<!--左边查单栏-->
			<div class="left_menu">
				<%@ include file="/static/left_menu.jsp" %>
			</div>
			<!--右边主体-->
			<div class="right_main">
				<!--用户信息-->
				<div class="accou_xi">
					<div class="accou_x1">
						<div class="ljzq_txt">
							<p>累计赚取</p>
							<label class="kt_1">&yen;</label>
							<label class="kt_2">
							<c:choose>
							 <c:when test="${empty mem.incomeMoney}">0.00元</c:when>
							<c:otherwise>
							<fmt:formatNumber value="${mem.incomeMoney}" pattern="#,##0.00#"/>元
							</c:otherwise>
							</c:choose>
							</label>
						</div>
						<div class="ljzq_txt">
							<p>可用余额</p>
							<label class="kt_1">&yen;</label>
							<label class="kt_2">
							<c:choose>
							<c:when test="${sessionScope.localUser.moneys == '0.00'||empty sessionScope.localUser.moneys||sessionScope.localUser.moneys == '0.0'}">
							0.00元
							</c:when>
							<c:otherwise>
							<fmt:formatNumber value="${sessionScope.localUser.moneys}" pattern="#,##0.00#"/>元
							</c:otherwise>
							</c:choose>
							</label>
						</div>
					</div>
					<div class="accou_x2">
						<a href="${ctx}/payment/fselectmoney.htm" class="conz"></a><!-- <a href="" class="woyjk"></a> -->
						<a href="${ctx}/withdraw/ftixian.htm" class="tixa"></a>
					</div>
					<div class="accou_x3">
						<!-- <label>注册号：97572483547</label> -->
						<c:if test="${sessionScope.localUser.isRealName == 1}">
							<a href="${ctx}/borrowinvest/questionnaire.htm" target="_blank" class="pgwj_href">合格投资者风险调查问卷</a>
						</c:if>
						<%-- <a href="${ctx}/aboutus/queryPayZn.htm" target="_blank">如何支付？</a> --%>
					</div>
				</div>
				<!--资产损益表-->
				<div class="accou_zc">
					<h3 class="acc_title">资产损益表</h3>
					<ul>
						<li class="tit_font1">资产总额</li>
						<li class="dark"><p>可用资金：</p><label>
						<c:choose>
							<c:when test="${sessionScope.localUser.moneys == '0.00'||empty sessionScope.localUser.moneys||sessionScope.localUser.moneys == '0.0'}">
							0.00元
							</c:when>
							<c:otherwise>
							<fmt:formatNumber value="${sessionScope.localUser.moneys}" pattern="#,##0.00#"/>元
							</c:otherwise>
					</c:choose>
					</label></li>
						<li class="dark"><p>冻结资金：</p><label>
						<c:choose>
						<c:when test="${mem.moneyFreeze == '0.00' ||empty mem.moneyFreeze||mem.moneyFreeze == '0.0'}">0.00元</c:when>
						<c:otherwise>
						<fmt:formatNumber value="${mem.moneyFreeze}" pattern="#,##0.00#"/>元
						</c:otherwise>
						</c:choose>
						</label></li>
						<li class="detail_li"><p class="txt_ind">提现冻结：</p>
						<label>
						<fmt:formatNumber value="${countWithdrawFreezeMoney}" pattern="#,##0.00#"/>元
						</label></li>
						<li class="detail_li"><p class="txt_ind">投资冻结：</p>
						<label>
						<fmt:formatNumber value="${investFreezeMoney}" pattern="#,##0.00#"/>元
						</label></li>
						<li class="dark"><p>待收总额：</p><label>
						<c:choose>
						<c:when test="${finvestormap.collectMoney == '0.00' ||empty finvestormap.collectMoney||finvestormap.collectMoney == '0.0'}">0.00元</c:when>
						<c:otherwise>
						<fmt:formatNumber value="${finvestormap.collectMoney}" pattern="#,##0.00#"/>元
						</c:otherwise>
						</c:choose>
						</label></li>
						<li class="detail_li"><p class="txt_ind">待收本金：</p><label>
						<c:choose>
						<c:when test="${finvestormap.amount1 == '0.00' ||empty finvestormap.amount1||finvestormap.amount1 == '0.0'}">0.00元</c:when>
						<c:otherwise>
						<fmt:formatNumber value="${finvestormap.amount1}" pattern="#,##0.00#"/>元
						</c:otherwise>
						</c:choose>
						</label></li>
						<li class="detail_li"><p class="txt_ind">待收利息：</p><label>
						<c:choose>
						<c:when test="${finvestormap.amount2 == '0.00' ||empty finvestormap.amount2||finvestormap.amount2 == '0.0'}">0.00元</c:when>
						<c:when test="${finvestormap.amount2 < 10}">
						<fmt:formatNumber value="${finvestormap.amount2}" pattern="#0.00#"/>元
						</c:when>
						<c:otherwise>
						<fmt:formatNumber value="${finvestormap.amount2}" pattern="#,##0.00#"/>元
						</c:otherwise>
						</c:choose>
						</label></li>
					    <%-- <li class="detail_li"><p class="txt_ind">活期宝总额：</p><label><fmt:formatNumber value="${finvestormap.cashMoney}" pattern="#,##0.00"/>元</label></li> --%>
						<li></li> 
						<li></li>
					</ul>
					<div class="payment">
						<div class="left">
							<h2>回款日历</h2>
							<p>
								<select class="years">
									<c:forEach var="year"  begin="${minPaymentYear}" end="${maxPaymentYear}">
										<option value="${year}">${year}</option>
									</c:forEach>
								</select>
								<span>年</span>
								<select class="months">
									<c:forEach var="month"  begin="1" end="12">
										<option value="${month}">${month}</option>
									</c:forEach>
								</select>
								<span>月</span>
							</p>
							<p>
								<a class="syy" href="javaScript://">
									<i class="fa fa-caret-left" aria-hidden="true"></i>
									上一月
								</a>
								<a class="xyy" href="javaScript://">
									下一月
									<i class="fa fa-caret-right" aria-hidden="true"></i>
								</a>
							</p>
							<div class="helper"></div>
							<p></p>
							<div class="cont">
								<h5>下期回款日</h5>
								<p>
									<c:choose>
										<c:when test="${not empty nextPaymentTime}"><span><fmt:formatDate value="${nextPaymentTime}" type="both" pattern='yyyy-MM-dd'/></span><a href="javascript://">详情</a></c:when>
										<c:otherwise><span>无</span></c:otherwise>
									</c:choose>
								</p>
							</div>
						</div>
						<div class="calendar"></div>
					</div>
				</div>
				<!--我的投资-->
				<div class="accou_tz">
					<!-- <h3 class="acc_title">我的投资</h3> -->
					<div class="tz_bod">
						<div class="tz_b1">
						可用余额
						<c:choose>
							<c:when test="${sessionScope.localUser.moneys == '0.00'||empty sessionScope.localUser.moneys||sessionScope.localUser.moneys == '0.0'}">
							0.00元
							</c:when>
							<c:otherwise>
							<fmt:formatNumber value="${sessionScope.localUser.moneys}" pattern="#,##0.00#"/>元
							</c:otherwise>
					     </c:choose>
						</div>
						<div class="tz_b2">
						待收总额
						<c:choose>
						<c:when test="${finvestormap.collectMoney == '0.00' ||empty finvestormap.collectMoney||finvestormap.collectMoney == '0.0'}">0.00元</c:when>
						<c:otherwise>
						<fmt:formatNumber value="${finvestormap.collectMoney}" pattern="#,##0.00#"/>元
						</c:otherwise>
						</c:choose>
						</div>
						<div class="tz_b3">
						冻结资金
						<c:choose>
						<c:when test="${mem.moneyFreeze== '0.00' ||empty mem.moneyFreeze||mem.moneyFreeze== '0.0'}">0.00元</c:when>
						<c:otherwise>
						<fmt:formatNumber value="${mem.moneyFreeze}" pattern="#,##0.00#"/>元
						</c:otherwise>
						</c:choose>
						</div>
						<div class="tz_b4">资产总额<p>
						<c:choose>
						<c:when test="${(sessionScope.localUser.moneys+mem.moneyFreeze+finvestormap.collectMoney) == '0.00'||(sessionScope.localUser.moneys+mem.moneyFreeze+finvestormap.collectMoney) == '0.0'||empty (sessionScope.localUser.moneys+mem.moneyFreeze+finvestormap.collectMoney)}">0.00元</c:when>
						<c:otherwise>
						<fmt:formatNumber value="${sessionScope.localUser.moneys+mem.moneyFreeze+finvestormap.collectMoney}" pattern="#,##0.00#"/>元
						</c:otherwise>
						</c:choose>
						</div>
					</div>
				</div>
				<!--我的借款-->
				<%-- <div class="accou_jk">
					<h3 class="acc_title">我的借款</h3>
					<a href="${ctx}/loan/queryAllBorrow.htm" class="acc_more">更多></a>
					<div class="media_table_cont">
					<table cellpadding="0" cellspacing="0" class="acc_table">
						<tr>
							<th>借款标题</th>
							<th>借款金额</th>
							<th>申请时间</th>
							<th>还款状态</th>
						</tr>
						<c:choose>
							<c:when test="${empty memberborrowlist}">
							<tr>
								<td>--</td>
								<td>--</td>
								<td>--</td>
								<td>--</td>
							</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${memberborrowlist}" var="list">
							  <tr>
								<td>${list.borrowTitle}</td>
								<td><fmt:formatNumber value="${list.borrowMoney}" pattern="#,##0.00#"/></td>
								<td><fmt:formatDate value="${list.createTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
								<td>
								<c:if test="${list.borrowStatus==0}">申请中</c:if>
								<c:if test="${list.borrowStatus==1}">办理中</c:if>
								<c:if test="${list.borrowStatus==2}">失败</c:if>
								<c:if test="${list.borrowStatus==3}">成功</c:if>
								</td>
						      </tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</table>
					</div>
				</div> --%>
				<!--我的体验金-->
				<div class="accou_jk">
					<h3 class="acc_title">我的体验金</h3>
					<div class="media_table_cont">
					<table cellpadding="0" cellspacing="0" class="acc_table">
						<tr>
							<th>剩余体验金</th>
							<th>体验中的金额</th>
							<th>待收利息</th>
							<th>已收利息</th>
						</tr>
						<tr>
							<td>&yen;
								<c:choose>
								<c:when test="${mmd.experienceGold=='0.00'||empty mmd.experienceGold||mmd.experienceGold== '0.0'}">0.00元</c:when>
								<c:otherwise> 
								<fmt:formatNumber value="${mmd.experienceGold}" pattern="#,##0.00#"/>元
								</c:otherwise>
								</c:choose>
							</td>
							<td>&yen;
							<c:choose>
								<c:when test="${investgold== '0.00'||empty investgold||investgold == '0.0'}">0.00元</c:when>
								<c:otherwise> 
								<fmt:formatNumber value="${investgold}" pattern="#,##0.00#"/>元
								</c:otherwise>
								</c:choose>
							</td>
							<td>&yen;
								<c:choose>
								<c:when test="${waitinterest == '0.00' ||empty waitinterest||waitinterest == '0.0'}">0.00元</c:when>
								<c:when test="${waitinterest < 10}">
						        <fmt:formatNumber value="${waitinterest}" pattern="#0.00#"/>元
						        </c:when>
						        <c:otherwise>
								<fmt:formatNumber value="${waitinterest}" pattern="#,##0.00#"/>元
								</c:otherwise>
								</c:choose>
							</td>
							<td>&yen;
								<c:choose>
								<c:when test="${empty hasbeeninterest||hasbeeninterest == '0.0'||hasbeeninterest == '0.00'}">
								0.00元
								</c:when>
								<c:when test="${hasbeeninterest < 10}">
						        <fmt:formatNumber value="${hasbeeninterest}" pattern="#0.00#"/>元
						        </c:when>
								<c:otherwise>
								<fmt:formatNumber value="${hasbeeninterest}" pattern="#,##0.00#"/>
								</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</table>
					</div>
				</div>
			</div>
		</div>
		
		<%@ include file="/static/footer.jsp" %>
		
		<div class="template" style="display: none;">
	    <!--月 id格式：“2015-03” -->
	    <div id="" class="month">
	        <div class="title xd-theme-color">
	            <span class="year-num"></span>年
	            <span class="month-num"></span>月
	        </div>
	        <ul class="week-list">
	            <li class="week xd-font-color2">日</li>
	            <li class="week">一</li>
	            <li class="week">二</li>
	            <li class="week">三</li>
	            <li class="week">四</li>
	            <li class="week">五</li>
	            <li class="week xd-font-color2">六</li>
	            <li class="helper"></li>
	        </ul>
	        <ul class="month-list">
	
	        </ul>
	    </div>        
	    <!--空框-->
	    <li class="item empty"></li>
	    <!--日-->
	    <li class="item day-cont">
	        <div status="false" class="day">1</div>
	    </li>
	    <!--辅助元素-->
	    <li class="helper"></li>
	    <!--弹窗-->
	    <div class="layer">
	    	<div class="arrowup"></div>
			<table border="0" cellspacing="0" cellpadding="0">
				<thead>
	    			<tr>
	    				<th width="35%" class="left">回款金额</th>
	    				<th width="35%" class="center">所属项目</th>
	    				<th width="30%" class="right">状态</th>
	    			</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		</div>
		<table>
			<tr class="data">
				<td class="left"></td>
				<td class="center"></td>
				<td class="right"></td>
			</tr>
		</table>
	</div>
</body>
	
<script type="text/javascript">
	$(function(){
		
		PFUN.calendarInit(function(year,month){
			//addPayment(6); 
		});
	});
	
	PFUN.calendarInit = function(func){
	    var myDate = new Date();
	    var year = myDate.getFullYear();
	    var month = myDate.getMonth() + 1;
	    var day = myDate.getDay();
	    var theLastMonth = month - 1;
	    var nextMonth = month + 1;
	    addMonth(year,month);
	    document.querySelector(".years").value = year;
	    document.querySelector(".months").value = month;
	    if(func){func(year,month);}
	    
	    //选年
	    $(".years").change(function(){
	    	month = $(".months").val();
	    	year = $(".years").val();
	    	addMonth(year,month);
	    	if(func){func(year,month);}
	    })
	    
	    //选月
	    $(".months").change(function(){
	    	month = $(".months").val();
	    	year = $(".years").val();
	    	addMonth(year,month);
	    	if(func){func(year,month);}
	    })
	    
	    //下个月
	    $(".syy").bind("click",function(){
			month--;
	        if(month == 0){
	            year--;
	            month = 12;
	        }
	        document.querySelector(".years").value = year;
	    	document.querySelector(".months").value = month;
	        addMonth(year,month);
	        if(func){func(year,month);}
	    });
	    
	    //上个月
	    $(".xyy").bind("click",function(){
			month++;
	        if(month == 13){
	            year++;
	            month = 1;
	        }
	        document.querySelector(".years").value = year;
	    	document.querySelector(".months").value = month;
	        addMonth(year,month);
	        if(func){func(year,month);}
	    });
	    
		//手机端配置    
	    if($("body").width() < 749){
	        $(".calendar .item .day").bind("click",function(e){
	        	$(".calendar .item .day .layer").hide();
	        	$(this).find(".layer").show();
	        	e.stopPropagation();
	        })
	        $(".calendar").bind("click",function(){
	        	$(this).find(".layer").hide();
	        })
	    }
	    
		//添加月份
		function addMonth(year,month){
	        var firstDay = year+"-"+month+"-"+"1";
	        var monthNode = document.querySelector(".template .month");
	        var dayNode = document.querySelector(".template .day-cont");
	        var emptyNode = document.querySelector(".template .empty");
	        var helperNode = document.querySelector(".template .helper");
	        var newMonthNode = monthNode.cloneNode(true);
	        var newHelperNode = helperNode.cloneNode(true);
	        var monthId = year + "-" + ((month<10)?("0"+month):month);
	        newMonthNode.setAttribute("id",monthId);
	        newMonthNode.querySelector(".month-num").textContent = month;
	        newMonthNode.querySelector(".year-num").textContent = year;
	        for( var i = 1 ; i <= getWeekDay(firstDay) ; i++ ){
	            var newEmptyNode = emptyNode.cloneNode(true);
	            newMonthNode.querySelector(".month-list").appendChild(newEmptyNode);
	        }
	        for( var i = 1 ; i <= monthDays(year,month) ; i++ ){
	            var newDayNode = dayNode.cloneNode(true);
	            newDayNode.querySelector(".day").textContent = i;
	            newMonthNode.querySelector(".month-list").appendChild(newDayNode);
	        }
	        newMonthNode.querySelector(".month-list").appendChild(newHelperNode);
	        document.querySelector(".calendar").innerHTML = "";
	        document.querySelector(".calendar").appendChild(newMonthNode);

			$.ajax({
				 type:'post',
			     cache: false,
		         url:'${ctx}/borrowinvest/queryPaymentTime.htm',
		         data:{"monthId" : monthId},
		         dataType : "json",
		         success:function(data){
		        	 addPayment(data);
		         }
			});
	    }
	    
		function addPayment(datas){
	    	 if(datas.tag=='0'){
				 window.location.href="${ctx}/login/login.htm?view=true";
	         }else{
	        	 for(var i = 0; i<datas.result.length; i++){
	        		 if(typeof(datas.result[i].productName) == "undefined"){
	        			 datas.result[i].productName = datas.result[i].productId;
	        		 }
	        		 var num = datas.result[i].sortOrder;
	        		 var money = datas.result[i].capital;
	        		 var productName = datas.result[i].productName;
	        		 var status = datas.result[i].status;
	        		 if($(".month-list .day").eq(num-1).find('.layer').length == 0){
	         			 var layerClone = $(".template .layer").clone(true);
	        		 }
	     			 var dataDom = $(".template .data");
	 				 var contDom = layerClone.find("tbody");
	     			 $(".day").eq(num-1).addClass("calendar_on");
	     			 var cloneDataDom = dataDom.clone(true);
	     			 cloneDataDom.find('.left').text("¥"+money);
	     			 cloneDataDom.find('.center').text(productName);
	     			 cloneDataDom.find('.right').text("已回款");
	     			 if(status == 1){
	     				 cloneDataDom.find('.right').addClass("red");
	     				 cloneDataDom.find('.right').text("待回款");
	     			 }
	     			 if(status == 4){
	     				 cloneDataDom.find('.right').text("收益过期失效");
	     			 }
	     			 contDom.append(cloneDataDom);
	     			
	     			//配置弹窗位置
	     			 if($("body").width() < 749){
	     				if(parseInt($(".day").eq(num-1)[0].offsetLeft) < 160){
	     					layerClone.css({left:"-"+parseInt($(".day").eq(num-1)[0].offsetLeft-4)+"px",marginLeft:"0"});
	     					layerClone.find(".arrowup").css({left:parseInt($(".day").eq(num-1)[0].offsetLeft+4)+"px",marginLeft:"0"});
	     				}
	     			 }
	     			 if(parseInt($(".month-list").width()-$(".day").eq(num-1)[0].offsetLeft-14) < 160){
	     				layerClone.css({left:"auto",right:'-'+parseInt($(".month-list").width()-$(".day").eq(num-1)[0].offsetLeft-30)+"px",marginLeft:"0"});
	     				layerClone.find(".arrowup").css({left:"auto",right:parseInt($(".month-list").width()-$(".day").eq(num-1)[0].offsetLeft-20)+"px",marginLeft:"0"});
	     			 }
	     			 
	     			 if($(".month-list .day").eq(num-1).find('.layer').length == 0){
	     				$(".day").eq(num-1).append(layerClone);
	     			 }
	        	 }
	         }
		}
		
	    function getWeekDay(fullDay){
	        var argc= new Array();      
	        argc=fullDay.split('-'); 
	        var ssdate=new Date(argc[0],parseInt(argc[1]-1),argc[2]);
	        return ssdate.getDay();
	    }
	
	    function monthDays(Year,Month){
	        Month--;
	        var d = new Date(Year,Month,1);
	        d.setDate(d.getDate()+32-d.getDate());
	        return (32-d.getDate());
	    }
	    
	}	
</script>
</html>
