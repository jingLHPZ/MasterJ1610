<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit" /> 
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
<meta name = "format-detection" content="telephone = no" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/> 
<%@ include file="/static/newtaglibs.jsp"%>
<title>邀请好友</title>
<link rel="stylesheet" href="${ctx}/css/inviteList.css" />

<link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<script type="text/javascript">
	$(document).ready(function(){
		//面包屑
		$(".left_title span").hide();
	})
</script>
</head>
<body>
<%@ include file="/static/top.jsp" %>
<div class="content_body">
	<!--右边主体-->
	<div class="right_main">
		<div class="right_cont">
			<div class="right_titie friend">
				<span>邀请好友</span>
			</div>
			<div class="invite">
				<ul class="invite_left">
					<li class="item_1">
					<a title="分享到微信">
							<img src="${ctx}/img/icon/invite_wx.png" />
							<div class="pop_ewm" style="background: #ffffff url(${QRcodeIp}) no-repeat left top/122px auto;">
								<h2>手机扫一扫</h2>
								<ul>
									<li>打开微信并“扫一扫左图二维码”</li>
									<li>跳转到注册页后，点击右上角按钮</li>
									<li>可发送给好友，或分享到朋友圈</li>
								</ul>
							</div>
						</a>
					</li>
					<li><a title="分享到微博" id="Wb" ><img src="${ctx}/img/icon/invite_wb.png"/></a></li>
					<li><a title="分享到QQ" id="QQ" target="_blank"><img src="${ctx}/img/icon/invite_qq.png"/></a></li>
					<li><a title="分享到QQ空间" id="QZone" version="1.0"  target="_blank"><img src="${ctx}/img/icon/invite_kj.png"/></a></li>
					<li class="item_5">
					<a title="复制链接" onclick="copyLinkUrl(document.all.targetUrl)">
							<img src="${ctx}/img/icon/invite_file.png"/>
							<div class="pop_ewm pop_file">
								点击此“复制链接”按钮，并将复制的推荐链接通过短信、QQ、微信等发送给好友。
							</div>
						</a>
					</li>
				</ul>
				<div class="invite_right">
					<p>1，通过左边方式分享链接给好友</p>
					<p>2，好友点击链接注册</p>
					<p>3，邀请成功，您获得推荐奖励</p>
				</div>
			</div>
			<div class="right_titie">
				<span>邀请列表</span>
			</div>
			<div id="alllist" >
			<div class="invite_list">
				<p class="prompt">注：“体验标”不计入投资</p>
				<table cellpadding="0" cellspacing="0" class="acc_table">
					<thead>
						<tr>
							<th  class="th_1">好友用户名</th>
							<th  class="th_2">注册时间</th>
							<th  class="th_3">是否已实名</th>
							<th  class="th_4">是否已投资</th>
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
			</div>
		</div>
		
		
		<div class="open_pop_phone">邀请好友</div>
		<div class="phone_mask">
			<div class="pop_phone">
				<ul class="invite_phone">
					<%-- <li>
						<a title="分享到微信"><img id="logimg" src="${ctx}/img/icon/invite_wx.png"/></a>
						<span>微信</span>
					</li> --%>
					<li>
						<a title="分享到微博" id="phoneWb"><img src="${ctx}/img/icon/invite_wb.png"/></a>
						<span>微博</span>
					</li>
					<li>
						<a title="分享到QQ" id="phoneQQ"><img src="${ctx}/img/icon/invite_qq.png"/></a>
						<span>QQ</span>
					</li>
					<li>
						<a title="分享到QQ空间" id="phoneQZone"><img src="${ctx}/img/icon/invite_kj.png"/></a>
						<span>QQ空间</span>
					</li>
				</ul>
				<p class="close_pop_phone">取消</p>
			</div>
		</div>
		
		
		
	</div>
	<!--左边查单栏-->
	<div class="left_menu">
		<%@ include file="/static/left_menu.jsp" %>
	</div>
	
</div>




<%@ include file="/static/footer.jsp" %>
<textarea style="position: relative;z-index:-9999;" cols="${fn:length(QRcodeTargetUrl)}" rows="1" id="targetUrl">${QRcodeTargetUrl}</textarea>
<script type="text/javascript">
//在这里定义bds_config
	$(function(){
		$(".open_pop_phone").bind("click",function(){
			$(this).hide();
			$(".phone_mask").addClass("active");
		});
		$(".close_pop_phone").bind("click",function(){
			$(".open_pop_phone").show();
			$(".phone_mask").removeClass("active");
		})
		$(".phone_mask").bind("click",function(){
			$(".open_pop_phone").show();
			$(".phone_mask").removeClass("active");
		})
		clickQZone();
		clickQQ();
		clickWb();
	})
	function copyLinkUrl(obj){ 
			obj.select(); // 选择对象
			document.execCommand("Copy"); // 执行浏览器复制命令
			alert("已复制好，可贴粘。");
	} 
	function fqueryPage(pageNo,totalCount,pageSize){
		var map ="&pageNo=" + pageNo + "&totalCount=" + totalCount + "&pageSize=" + pageSize;
		$.ajax({
			type: "POST",
			url: "${ctx}/invite/fqueryrecordtwobyuid.htm",
			data: map,
			success: function(result) {
				$('#alllist').html(result);
			}
		});
	}
	function clickQZone(){
			var p = {
			url:'${QRcodeTargetUrl}',
			showcount:'1',/*是否显示分享总数,显示：'1'，不显示：'0' */
			desc:'推荐一个不错的网站，注册就送10000元体验金，投资后收益可提现，快去注册吧！',/*默认分享理由(可选)*/
			summary:'上海市互联网金融行业协会理事单位，上市公司持股、国有银行资金存管，安全规范、风控出众的互联网金融理财平台，来学呗，就学呗！',/*分享摘要(可选)*/
			title:'注册送10000元，收益可提现',/*分享标题(可选)*/
			site:'',/*分享来源 如：腾讯网(可选)*/
			pics:'${fxtpUrl}', /*分享图片的路径(可选)*/
			style:'203',
			width:98,
			height:22
			};
			var s = [];
			for(var i in p){
			s.push(i + '=' + encodeURIComponent(p[i]||''));
			}
			$("#QZone").attr("href","http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?"+s.join('&'));
			$("#phoneQZone").attr("href","http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?"+s.join('&'));
	}
	function clickQQ(){
		var p = {
				url:'${QRcodeTargetUrl}', /*获取URL，可加上来自分享到QQ标识，方便统计*/
				desc:'推荐一个不错的网站，注册就送10000元体验金，投资后收益可提现，快去注册吧！', /*分享理由(风格应模拟用户对话),支持多分享语随机展现（使用|分隔）*/
				title:'推荐一个不错的网站，注册就送10000元体验金，投资后收益可提现，快去注册吧！', /*分享标题(可选)*/
				summary:'上海市互联网金融行业协会理事单位，上市公司持股、国有银行资金存管，安全规范、风控出众的互联网金融理财平台，来学呗，就学呗！', /*分享摘要(可选)*/
				pics:'${fxtpUrl}', /*分享图片(可选)*/
				flash: '', /*视频地址(可选)*/
				site:'', /*分享来源(可选) 如：QQ分享*/
				style:'201',
				width:32,
				height:32
				};
				var s = [];
				for(var i in p){
				s.push(i + '=' + encodeURIComponent(p[i]||''));
			}
		$("#QQ").attr("href","http://connect.qq.com/widget/shareqq/index.html?"+s.join('&'));
		$("#phoneQQ").attr("href","http://connect.qq.com/widget/shareqq/index.html?"+s.join('&'));
	}
	function clickWb(){
		$("#Wb").attr("href","javascript:void((function(s,d,e,r,l,p,t,z,c){var%20f='http://v.t.sina.com.cn/share/share.php?appkey=真实的appkey',u=z||d.location,p=['&url=',e(u),'&title=',e(t||d.title),'&source=',e(r),'&sourceUrl=',e(l),'&content=',c||'gb2312','&pic=',e(p||'')].join('');function%20a(){if(!window.open([f,p].join(''),'mb',['toolbar=0,status=0,resizable=1,width=440,height=430,left=',(s.width-440)/2,',top=',(s.height-430)/2].join('')))u.href=[f,p].join('');};if(/Firefox/.test(navigator.userAgent))setTimeout(a,0);else%20a();})(screen,document,encodeURIComponent,'','','${fxtpUrl}','推荐一个不错的网站，注册就送10000元体验金，投资后收益可提现，快去注册吧！','${QRcodeTargetUrl}','页面编码gb2312|utf-8默认gb2312'));")
		$("#phoneWb").attr("href","javascript:void((function(s,d,e,r,l,p,t,z,c){var%20f='http://v.t.sina.com.cn/share/share.php?appkey=真实的appkey',u=z||d.location,p=['&url=',e(u),'&title=',e(t||d.title),'&source=',e(r),'&sourceUrl=',e(l),'&content=',c||'gb2312','&pic=',e(p||'')].join('');function%20a(){if(!window.open([f,p].join(''),'mb',['toolbar=0,status=0,resizable=1,width=440,height=430,left=',(s.width-440)/2,',top=',(s.height-430)/2].join('')))u.href=[f,p].join('');};if(/Firefox/.test(navigator.userAgent))setTimeout(a,0);else%20a();})(screen,document,encodeURIComponent,'','','${fxtpUrl}','推荐一个不错的网站，注册就送10000元体验金，投资后收益可提现，快去注册吧！','${QRcodeTargetUrl}','页面编码gb2312|utf-8默认gb2312'));")
	}
</script>
<script src="http://qzonestyle.gtimg.cn/qzone/app/qzlike/qzopensl.js#jsdate=20111201" charset="utf-8"></script>
<script src="http://connect.qq.com/widget/loader/loader.js" widget="shareqq" charset="utf-8"></script>
</body>
</html>
