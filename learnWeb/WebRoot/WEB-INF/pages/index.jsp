<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="baidu-site-verification" content="TyEtN7VFPk" />
<meta name="renderer" content="webkit" /> 
<meta http-equiv="X-UA-Compatible" content="IE=10" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<title>学呗_上海学呗_学呗网_学呗互联网金融平台_学呗互联网金融_上海学呗互联网金融</title>
<meta name="keywords" content="学呗,上海学呗,学呗互联网金融,上海学呗互联网金融">
<meta name="description" content="上海学呗互联网金融信息服务有限公司管理团队主要来自于国泰君安、中融国际信托、陆金所和中国软件,依托成功的行业经验和领先的“四位一体的信用风险管控模式”为客户提供“安全、稳健、专业”的金融产品和服务,构建出一个高效、透明、人性化易操作的..">
<%@ include file="/static/newtaglibs.jsp"%>
<link rel="stylesheet" href="${ctx}/V2/css/index.css" />
<script type="text/javascript" src="${ctx}/V2/js/TouchSlide.1.1.js"></script>
</head>
<body>

<!-- top -->
<%@ include file="/static/top.jsp"%>
	
<div id="banner">
	<div class="banner_box">
		<div class="banner_num" >
			<ul></ul>
			<div class="banner_reg action">
				<h2>简单、可靠、赚的多！</h2>
				<c:choose>
					<c:when test="${sessionScope.localUser==null }">
						<div class="reg">
							<h3>学呗预期年化收益率</h3>
							<h5>
								最高<em>10</em>
								<span>%</span>
							</h5>
							<a class="btn_reg" href="${ctx}/register.jsp">注册</a>
							<p>
								已有账号？&nbsp;
								<a href="${ctx}/login/login.htm">登录</a>
							</p>
						</div>
					</c:when>
					<c:otherwise>
						<div class="login ">
							<h3>欢迎来到学呗平台投资！</h3>
							<h5>
								您当前的登录帐户是：
							</h5>
							<h4>${sessionScope.localUser.userName}</h4>
							<a class="btn_mine" href="${ctx}/borrowinvest/toinvest.htm">我的学呗账户</a>
							<a class="btn_sign" href="javaScript://">
								<span class="status_qd">签到</span>
								<span class="status_yqd">已签</span>
								<i>+${sessionScope.signTotal}</i>
							</a>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<a class="icon_prev" href="javascript://">
			<i class="fa fa-angle-left"></i>
		</a>
		<a class="icon_next" href="javascript://">
			<i class="fa fa-angle-right"></i>
		</a>
		<div class="banner_img">
			<ul>
				<c:forEach items="${imageList}" var="imageDto">
					<c:choose>
						<c:when test="${empty imageDto.url}">
							<li><a href="javascript:void(0)" style="background: url(${path}/${imageDto.imageName}) no-repeat 50% 50%;"></a></li>
						</c:when>
						<c:otherwise>
							<li><a href="javascript:void(0)" style="background: url(${path}/${imageDto.imageName}) no-repeat 50% 50%;" onclick="window.open('${imageDto.url}')"></a></li>
						</c:otherwise>
					</c:choose>
		  		</c:forEach>
		    </ul>
		</div>
	</div>
</div>
<script type="text/javascript">
   TouchSlide({ 
        slideCell:"#banner",
        titCell:".banner_num ul", 
        mainCell:".banner_img ul", 
        effect:"leftLoop", 
        autoPage:true,//自动分页
        autoPlay:true, //自动播放
        interTime:8000,
        prevCell:".icon_prev",
		nextCell:".icon_next"
    });
</script>

<div class="bg advantage">
	<div class="container">
		<ul>
			<li>
				<label class="falsh_light">
					<img src="${ctx}/V2/img/icon/index-ico1.png"/>
				</label>
				<div class="text">
					<h2>背景</h2>
					<p>实力股东背景雄厚</p>
					<p>上市公司倾力打造</p>
				</div>
			</li>
			<li>
				<label class="falsh_light">
					<img src="${ctx}/V2/img/icon/index-ico2.png"/>
				</label>
				<div class="text">
					<h2>保障</h2>
					<p>严格的风控模式</p>
					<p>保障客户交易安全</p>
				</div>
			</li>
			<li class="th_3">
				<label class="falsh_light">
					<img src="${ctx}/V2/img/icon/index-ico3.png"/>
				</label>
				<div class="text">
					<h2>收益</h2>
					<p>预期年化收益</p>
					<p>最高可达10%</p>
				</div>
			</li>
			<li class="notice">
				<div class="notice_t">
					最新公告
					<div class="btn_cont">
						<a class="prve" href="javascript://">
							<i class="fa fa-angle-left"></i>
						</a>
						<a class="next" href="javascript://">
							<i class="fa fa-angle-right"></i>
						</a>
					</div>
				</div>
				<div class="carousel">
					<div class="lists">
					<c:choose>
						<c:when test="${empty newsnoticelist}">暂时还没有最新公告</c:when>
						<c:otherwise>
							<c:forEach items="${newsnoticelist}" var="noticelist">
							<p><a title="${noticelist.newstitle}" href="${ctx}/newsnotice/fquerynotice.htm?newsid=${noticelist.newsid}">${noticelist.newstitle}</a></p>
							</c:forEach>
						</c:otherwise>
					</c:choose>
						<!-- <p><a title="新闻公告1新闻公告1新闻公告1新闻公告1f撒的发生的" href="javascript://">1新闻公告1新闻公告1新闻公告1新闻公告1f撒的发生的</a></p>
						<p><a title="新闻公告2新闻公告2新闻公告12" href="javascript://">2新闻公告2新闻公告2新闻公告12</a></p>
						<p><a title="新闻公告3新闻公告3新闻公告" href="javascript://">3新闻公告3新闻公告3新闻公告</a></p>
						<p><a title="新闻公告4新闻公告4新闻公告4新闻公告4新闻公告新闻公告4" href="javascript://">4新闻公告4新闻公告4新闻公告4新闻公告4新闻公告新闻公告4</a></p>
						<p><a title="新闻公告4新闻公告4新闻公告4新闻公告4新闻公告新闻公告4" href="javascript://">5新闻公告4新闻公告4新闻公告4新闻公告4新闻公告新闻公告4</a></p> -->
					</div>
				</div>
			</li>
		</ul>
	</div>
	
</div>

<!-- 新手专区 -->
<%@ include file="attempt.jsp"%>
<!--现金理财-->
<%@ include file="cash.jsp"%>
<!--专享理财-->
<%@ include file="finance.jsp"%>
<!--盈享理财-->
<%@ include file="yingxiang.jsp"%>

<!--行业相关-->
<div class="bg relevant">
	<div class="container">
		<div class="proj_name">
			<h4>行业相关</h4>
		</div>
		<div class="cont">
			<div class="box">
				<div class="news">
					<h4>
						行业新闻<a href="${ctx}/newsinformation/fqueryallinformation.htm">更多</a>
					</h4>
					<c:choose> 
						<c:when test="${empty newsinformationlist}">暂时还没有最新媒体报道</c:when>
						<c:otherwise>
							<c:forEach items="${newsinformationlist}" var="list">
								<p>
									<em></em>
									<a href="${ctx}/newsinformation/fqueryinfocontent.htm?newsid=${list.newsid}">${list.newstitle}</a>
								</p>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="stock">
					<div class="sh">
						<h4>上证指数</h4>
						<!--上涨用rise，下跌用fall-->
						<p <c:if test="${sh000001_type == 'add'}">class="rise"</c:if>
						<c:if test="${sh000001_type != 'add'}">class="fall"</c:if>>
							<em>${sh000001_total}</em>
							<i class="fa fa-sort-asc"></i>
							<i class="fa fa-sort-desc"></i>
							<span>${sh000001_amount} ( ${sh000001_rate}%）</span>
							<p class="text">(以上数据仅供参考)</p>
						</p>
					</div>
					<div class="sz">
						<h4>深证指数</h4>
						<!--上涨用rise，下跌用fall-->
						<p <c:if test="${sz399001_type == 'add'}">class="rise"</c:if>
						<c:if test="${sz399001_type != 'add'}">class="fall"</c:if>>
							<em>${sz399001_total}</em>
							<i class="fa fa-sort-asc"></i>
							<i class="fa fa-sort-desc"></i>
							<span>${sz399001_amount} ( ${sz399001_rate}%）</span>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="friends bg">
	<div class="container">
		<h1>
			合作伙伴
		</h1>
		<img src="${ctx}/V2/img/index_hzfb_01.png"/>
		<ul class="clearFix">
			<li class="item_1"><a href="http://www.wenfex.com" target='_blank'><img src="${ctx}/V2/img/partners/wjs.png"/></a></li>
			<li class="item_2"><a href="http://www.guanfu.com" target='_blank'><img src="${ctx}/V2/img/partners/gfjy.png"/></a></li>
			<li class="item_3"><a href="http://bank.pingan.com" target='_blank'><img src="${ctx}/V2/img/partners/payh.png"/></a></li>
			<li class="item_4"><a href="http://www.boc.cn" target='_blank'><img src="${ctx}/V2/img/partners/zgyh.png"/></a></li>
			<li class="item_5"><a href="http://www.cmbc.com.cn" target='_blank'><img src="${ctx}/V2/img/partners/zgmsyh.png"/></a></li>
			<li class="item_6"><a href="http://www.allinpay.com" target='_blank'><img src="${ctx}/V2/img/partners/tlzf.png"/></a></li>
		</ul>
	</div>
</div>
	<%@ include file="/static/footer.jsp"%>
	<script type="text/javascript">
		$(function(){
			PFUN.index.call(this);
			PFUN.sign();
			var signFlag='${sessionScope.localUser.signFlag}'; 
			if(signFlag==1){
				$(".btn_sign").addClass("active");
				$(".btn_sign").find("i").hide();
				$(".btn_sign.active").unbind("click");
			}
		});
		PFUN.sign = function(){
			$(".btn_sign").bind('click',function(){
				$(this).unbind("click");
				$.ajax({
					type : "post",
					url : "${ctx}/person/submitSign.htm",
					data :{},
					dataType : "text",
					success : function(data) {
						if(data=="success"){
							$(".btn_sign").addClass("active");
							$(".btn_sign").find("i").animate({left:"-32px",top:"-44px",fontSize:"14px",opacity:"0.9"},400,"swing").hide(600);
							$(".btn_sign.active").unbind("click");
						}
					}
				});
				
			})
		}
	</script>
</body>
</html>

