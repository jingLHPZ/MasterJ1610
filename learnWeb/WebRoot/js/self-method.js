$(document).ready(function(){
	//文本框聚焦
	$("input[type=text],[type=password]").not(".szp_mmk input,.cal_list input").focus(function(){
		$(this).css({'border':'1px solid #777','color':'#777'});
	})
	$("input[type=text],[type=password]").not(".szp_mmk input,.cal_list input").blur(function(){
		$(this).css({'border':'1px solid #aaa','color':'#555'});
	})
	
	//导航
	$(".nav_la").parent().hover(
		function(){
			$(this).find('ul').show();
		},
		function(){
			$(this).find('ul').hide();
		}
	)
	
	//侧边栏
	$(".ab_d1").hover(
		function(){
			$(".cbl_bod").show().find('p').show();
		},
		function(){
			$(".cbl_bod").hide().find('p').hide();
		}
	)
	$(".ab_d4").hover(
		function(){
			$(".cbl_bod").show().find('img').show();
		},
		function(){
			$(".cbl_bod").hide().find('img').hide();
		}
	)
	
	
	////////////////index.html
	//众筹
	$(".zc_tab").click(function(){
		var zc = $(this).index();
		$(".panel").hide()
		$(".panel").eq(zc).show();
		$(".zc_tab").find('a').removeClass('active');
		$(this).find('a').addClass('active');
	})
	//新手标
	$(".xszx_tab a").click(function(){
		var xa = $(this).index();
		$(this).addClass('xszx_t_click').siblings().removeClass('xszx_t_click');
		$(".xszx_bod").not('.ind_tyb .xszx_bod,.ind_sbzq .xszx_bod').hide().eq(xa).show();
	})
	//专区
	$(".xszx_hover").hover(function(){
		$(this).find('div').animate({marginLeft:'0px'});
	},function(){
		$(this).find('div').animate({marginLeft:'-89px'});
	})
	$(".ind_sbzq .xszx_bod").eq(2).css('border','none');
	$(".ind_zrzq .xszx_bod").eq(2).css('border','none');
	
	////////////////register.html
	//注册步骤
	$(".reg_btn_next:eq(0) a").click(function(){
		$.ajax({
			type : "post",
			url : "/learnWeb/message/equalToCode.htm",
			data : {
				code : $("#phone_ver_no").val(),
				messageType:1
			},
			async:false,
			dataType : "text",
			success : function(data) {
				if(data=="success"){
					$("#phoneYzm").hide();
				}else{
					$("#phoneYzm").show();
					$("#phoneYzmNum").hide();
					flushYzm();
					$("#yzm").show();
				}
			}
		});
		var i=0;
		if(!$("#user_phone-show").is(":hidden")){
			i++;
		}
		if(!$("#user_phone-login").is(":hidden")){
			i++
		}
		if(!$("#user_pass_show").is(":hidden")){
			i++
		}
		if(!$("#phoneYzm").is(":hidden")){
			i++
		}
		if(!$("#phoneYzmNum").is(":hidden")){
			i++
		}
		if(!$("#yzm").is(":hidden")){
			i++
		}
		if(!$("#phoneErr").is(":hidden")){
			i++
		}
		if(i==0){
			$.ajax({
				type : "post",
				url : "/learnWeb/register/register.htm",
				data : $("form").serialize(),
				dataType : "text",
				success : function(data) {
					$(".reg_bz").hide();
					$(".reg_3").show();
				}
			});
		}
	})
	
	$(document).ready(function(e){
		var browserWidth = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
		if(browserWidth<=1000){
		$(".reg_btn_next:eq(0) a").click(function(){
			$(".reg_t1").css({'background':'#eee','color':'#444'});
			$(".reg_t2").css({'background':'#fe3f3b','color':'#fff'});
			$(".reg_bz").hide();
			$(".reg_2").show();
		})
		$(".reg_btn_next:eq(1) a").click(function(){
			$(".reg_t2").css({'background':'#eee','color':'#444'});
			$(".reg_t3").css({'background':'#fe3f3b','color':'#fff'});
			$(".reg_bz").hide();
			$(".reg_3").show();
		})
		}
	});
	$(".chec_xy").css('background','url(img/icon/check_d.png) top left no-repeat');
	$(".chec_xy").toggle(
		function(){
			$(".chec_xy").css('background','#fff');
			$(".rb_no").show().next().hide();
			$("#nextFlag").val(0);
		},
		function(){
			$(".chec_xy").css('background','url(img/icon/check_d.png) top left no-repeat');
			if($("input[name='user_phone']").val().length==0||
				$("input[name='kaptcha']").val().length==0||
				$("input[name='phone_ver_no']").val().length==0||
				$("input[name='user_pass']").val().length==0){
				$(".rb_no").show().next().hide();
			}else{
				$(".rb_no").hide().next().show();
			}
			$("#nextFlag").val(1);
		}
	)
	
	
	////////////////toInvest.html
	//tab菜单切换
	$(".toi_tab li").click(function(){
		var tt = $(this).index();
		/*$(".toin_m").hide().eq(tt).show(); 散标 涨中宝 同时使用时开启 modify 2016-01-19*/
		$(this).addClass('toi_title').siblings().removeClass('toi_title');
	})
	
	
	//获取验证码
	$(".reg_btn_y").click(function(){
		if($("#user_phone").val().length==0){
			$("#user_phone-show").show();
			return false;
		}
		if($("#kaptcha").val().length==0){
			$("#yzm").show();
			return false;
		}
		$(this).hide().next(".reg_djs").show();
		validateShow();
	});
	

	////////////////recharge.html
	//充值选择支付方式
	$(".rech_fs li").click(function(){
		$(this).addClass('re_fs_click').siblings().removeClass('re_fs_click');
	})
	
	
	//债权tab
	$(".zqzr_list li").click(function(){
		var zl = $(this).index();
		$(this).addClass('zqzr_ls_hov').siblings().removeClass('zqzr_ls_hov');
		$(this).parents(".zqzr_bod").find('table').eq(zl).addClass('zq_dis').siblings().removeClass('zq_dis');
	})
	
	
	////////////////bidSet.html
	//投资期限设置
	$(".bd_rd").click(function(){
		$(".bd_rd").removeClass('bd_cl').parent('.bd_li_s').find('select').attr('disabled','disabled');
		$(this).addClass('bd_cl').parent('.bd_li_s').find('select').removeAttr('disabled');
	})
	//投资类型设置
	$(".bd_fw").toggle(
		function(){
			$(this).addClass('mar_cl');
		},function(){
			$(this).removeClass('mar_cl');
		}
	)
	
	
	////////////////bankCard.html
	//添加银行卡
	/*$(".bankcard_add").click(function(){
		$(".add_bc").show();
	})*/
	$(".addb_close").click(function(){
		$(".add_bc").hide();
	})
	//删除银行卡
	$(".bankC_bod li").hover(
		function(){
			$(this).find('a').show();
		},function(){
			$(this).find('a').hide();
		}
	)
	$(".bankC_bod li div a").click(function(){
		$(".bankC_bod").hide().next('.bankC_yz').show();
	})
	$(".yz_btn2").click(function(){
		$(".bankC_bod").show().next('.bankC_yz').hide();
	})
	/*$(".yz_btn1").click(function(){
		$(".bankC_del").show();
	})*/
	$(".del_bod input").click(function(){
		$(".bankC_yz").hide().prev('.bankC_bod').show();
	})
	
	
	////////////////toInvest.html
	//左边分类菜单
	$(".toin_left_menu li:eq(0)").click(function(){
		var title = $(this).find('label').text();
		var ind = $(this).index();
		$(".tole_list").show();
		$(this).addClass('lfm_cli').siblings().removeClass('lfm_cli');
		$(".tole_px h3").text(title);
		$(".left_title span").html('>&nbsp;'+title);
	})
	$(".toin_left_menu li:not(li:eq(0))").click(function(){
		var title = $(this).find('label').text();
		var ind = $(this).index();
		var s = ('.tole_d')+ind;
		$(".tole_list").hide();
		$(s).show();
		$(this).addClass('lfm_cli').siblings().removeClass('lfm_cli');
		$(".tole_px h3").text(title);
		$(".left_title span").html('>&nbsp;'+title);
	})
	//列表排序
	$(".tole_px a").click(function(){
		$(this).addClass('tole_px_h').siblings().removeClass('tole_px_h');
	})
	
	////////////////record.html
	//充值金额、提现金额
	$(".cz_title a").click(function(){
		var c = $(this).index();
		$(".czje_bod").hide().eq(c).show();
		$(this).addClass('cz_ti_h').siblings().removeClass('cz_ti_h');
	})
	
	
	////////////////proDetails.html
	//项目简介、风险控制、投资记录
	$(".prod_ahref a").click(function(){
		var p = $(this).index();
		$(this).addClass('prod_click').siblings().removeClass('prod_click');
		$(".pxq_main").hide().eq(p).show();
	})
	
	
	////////////////publicChips.html
	//点赞
	$(".xm_list_2").click(function(){
		$(this).css('background','url(img/zan_h.png) 9px 0 no-repeat');
	})
	//评论话题
	$(".pl_bt_1").click(function(){
		$(".sr_list").find(".pl_tx_div,.pl_bt_2").hide();
		$(".sr_list").find(".pl_bt_1").show();
		$(this).hide().siblings().show();
		$(".pl_tx_div").css('border','1px solid #ecebeb');
	})
	$(".pl_bt_2").click(function(){
		$(".sr_list").find(".pl_tx_div,.pl_bt_2").hide();
		$(this).hide().siblings().hide();
		$(this).prev().show();
		$(".pl_tx_div").css('border','1px solid #ecebeb');
	})
	//选中文本框
	$(".pub_div2 textarea").click(function(){
		$(this).parent('div').css('border','1px solid #555');
	})
	//项目简介、风险控制、投资记录
	$(".prod_ahref a").click(function(){
		var pa = $(this).index();
		$('.pd_cen').hide();
		$(".pd_cen").eq(pa).show();
		
	})
	
	
	////////////////zhPassword.html
	//下一步
	$(".zhp_next").click(function(){
		$(".zhp_b1").hide().next().show();
	})
	
	
	////////////////stationnews.html
	//高亮
	$(".znxx_lx p a").click(function(){
		$(this).parent('p').find('a').css({'color':'#727272'});
		$(this).css({'color':'#2ea1e4'});
	})
	//全选
	$(".lx_xzlx a:eq(0)").click(function(){
		$(".znxx_tab div").not('#tabList_no').addClass('at_ch_bg');
	})
	//反选
	$(".lx_xzlx a:eq(1)").click(function(){
        $(".znxx_tab div").each(function () {  
			if($(this).attr('class') == 'at_ch_bg'){
				$(this).removeClass('at_ch_bg');
			}else{
				$(this).addClass('at_ch_bg');
			}
        });
	})
	//单选
	$(".znxx_tab div").click(function(){
		if($(this).attr('class') == 'at_ch_bg'){
			$(this).removeClass('at_ch_bg');
		}else{
			$(this).not('#tabList_no').addClass('at_ch_bg');
		}
	})
	//查看消息
	$(".znxx_tab a").click(function(){
		$(".sta_cen").eq(1).show();
	})
	//通知设置
	$(".znxx_title a").click(function(){
		//$(".sta_cen").hide().eq(1).show();
	})
	$(".tzsz_tab div").toggle(
		function(){
			$(this).addClass('at_ch_bg');
		},function(){
			$(this).removeClass('at_ch_bg');
		}
	)
	//返回列表
	$(".stati_lb_title a").click(function(){
		$(".sta_cen").hide().eq(0).show();
	})
	
	
	
	////////////////pay.html
	//使用红包
	$(".pay_hb2").click(function(){
		$(".hb_sy").hide().next().show();
		$(".hb_je p").hide();
	})
	$(".pay_clhb").click(function(){
		$(".hb_je").hide().prev().show();
	})
	$(".hb_je li").click(function(){
		$(".hb_je div").hide();
		$(".hb_je p,.pay_xgyh").show();
	})
	$(".pay_xgyh").click(function(){
		$(".hb_je div").show();
		$(".hb_je p,.pay_xgyh").hide();
	})
	
	////////////////personal.html
	//密码设置
	$(".pas_yzm").click(function(){
		$(this).hide().next().show();
	})
	$(".per_password p").click(function(){
		var pn = $(this).index();
		$(this).addClass('pass_tit').siblings().removeClass('pass_tit');
		$(".end_pass").hide();
		$(".end_pass").eq(pn).show();
	})
	$(".person_tab a").click(function(){
		var an = $(this).index();
		$(this).addClass('per_tab_hov').siblings().removeClass('per_tab_hov');
		$(".per_bod").hide();
		$(".per_bod").eq(an).show();
	})
	
	
	////////////////borrowingData.html
	//上传身份证
	$(".bosfz_up input").change(function(){
		$(this).next('img').show();
	})
	
	/***start***/
	////////////////loanStatistics.html
	//tab切换
	$(".loanS_title_tab a").click(function(){
		var ls = $(this).index();
		$(this).addClass('ltt_click').siblings().removeClass('ltt_click');
		$(".loanS_table").hide().eq(ls).show();
	})
	//查看详情
	$(".locS_ck").click(function(){
		$(".loanS_ckxq").show();
	})
	$(".lS_close").click(function(){
		$(".loanS_ckxq").hide();
	})
	//我要还款
	$(".lS_div div:not('.lD_yhq')").toggle(function(){
		$(this).css('background','url(img/icon/ls_g2.png) 1px 2px no-repeat')
	},function(){
		$(this).css('background','none')
	})
	
	////////////////关于我们
	//左边菜单
	$(".toin_left_menu li").click(function(){
		$(this).addClass('abo_me_click').siblings().removeClass('abo_me_click');
	})
	//创始团队奇偶行背景色
	$(".Team_gstd li:odd").css('background','#fbfafa');
	$(".partn_div:last-child").css('marginBottom','70px');
	//网站公告鼠标悬停
	$(".notice_list li,.journ_list li").hover(function(){
		$(this).find('h3').css('color','#fca703');
	},function(){
		$(this).find('h3').css('color','#727272');
	})
	//招贤纳士详情
	$(".recrui_list h3").click(function(){
		$(".recrui_list div").hide();
		$(this).next('div').show().parent('li').css('background','url(../img/icon/xians_btn.png) 830px 26px no-repeat').siblings().css('background','url(../img/icon/xiax_btn.png) 830px 26px no-repeat');
	})
	
	
	
	////////////////loan.html
	//产品详细介绍
	$(".loan_zyd a").click(function(){
		$(".zyd_bod").show();
	})
	$(".zyd_clos").click(function(){
		$(".zyd_bod").hide();
	})
	
	/***end***/
	
	//新手标
	$(".xszx_bod:eq(0)").hide();
	$(".xszx_tab a").click(function(){
		var xa = $(this).index();
		$(this).addClass('xszx_t_click').siblings().removeClass('xszx_t_click');
		$(".xszx_bod").not('.ind_tyb .xszx_bod,.ind_sbzq .xszx_bod').hide().eq(xa).show();
	})
	//专区
	$(".xszx_hover").hover(function(){
		$(this).find('div').animate({marginLeft:'0px'});
	},function(){
		$(this).find('div').animate({marginLeft:'-89px'});
	})
	$(".ind_sbzq .xszx_bod").eq(2).css('border','none');
	$(".ind_zrzq .xszx_bod").eq(2).css('border','none');
	
////////////////integration.html
	//积分明细、兑换投资红包、兑换体验金
	$(".integ_tit a").click(function(){
		var ita = $(this).index();
		$(this).addClass('int_t_h').siblings().removeClass('int_t_h');
		$(".integ_div").hide().eq(ita).show();
	})
	//积分记录时间查询
	$(".jfjl_time a").click(function(){
		$(this).addClass('jfjl_ti_h').siblings().removeClass('jfjl_ti_h');
	})
	//立即兑换确认框
	$(".hb_dh").click(function(){
		var dh_jf = $(this).next().find('label').eq(0).text();     //获得积分
		var dh_jy = $(this).parents('.hb_mid').find('label:eq(0)').text();     //获得红包大小
		var dh_sl = $(this).parents('.hb_mid').find('.hb_sl label').text();     //获得数量
		var jfUser=parseInt($("#totalScores").text());
		var jfReward=parseInt(dh_jf);
		if(jfUser>=jfReward){
			$(".int_dh_div").show();
			$(".int_dh_div").find('label').eq(0).text(dh_jf);
			$(".int_dh_div").find('label').eq(1).text(dh_jy);
			$(".int_dh_div").find('label').eq(2).text('投资红包');
			$(".int_dh_div").find('label').eq(3).text(dh_sl);
		}else{
			$(this).text("积分不足").removeClass('hb_dh').addClass("addTotal");
		}
		
	})
	$(".tyj_dh").click(function(){
		var dh_jf = $(this).parents('.tyj_mid').find('.tyj_xh label').eq(0).text();     //获得积分
		var dh_jy = $(this).parents('.tyj_mid').find('div label:eq(0)').text();     //获得红包大小
		var jfUser=parseInt($("#totalScores").text());
		var jfReward=parseInt(dh_jf);
		if(jfUser>=jfReward){
			$(".int_dh_div").show();
			$(".int_dh_div").find('label').eq(0).text(dh_jf);
			$(".int_dh_div").find('label').eq(1).text(dh_jy);
			$(".int_dh_div").find('label').eq(2).text('体验金');
			$(".int_dh_div").find('label').eq(3).text('1');
		}else{
			$(this).text("积分不足").removeClass('tyj_dh').addClass("addTotal1");
		}
	})
	/*$(".intdh_bod input").click(function(){
		$(".int_dh_div").hide();
	})*/
////////////////bondAssignment.html
	//可转让的债权、转让中、已转让tab切换
	$(".bonda_title a").click(function(){
		var bta = $(this).index();
		$(this).addClass('bonda_ti').siblings().removeClass('bonda_ti');
		$(".bonda_div").hide().eq(bta).show();
	})
	//取消转让确认框
	$(".qxzr_href .bond_zrhref").click(function(){
		var zqn = $(this).parents('tr').find('.bond_name').text();
		$(".qx_bod label").text(zqn);
		$(".qx_bonda").show();
	})
	$(".qx_btn_1").click(function(){
		$(".qx_bonda").hide();
	})
	
	////////////////borrowingData.html
	//未结算、已结算
	$(".bonda_title a").click(function(){
		var bta = $(this).index();
		$(this).addClass('bonda_ti').siblings().removeClass('bonda_ti');
		$(".borwD_bod").hide().eq(bta).show();
	})
	//还款日期查询
	$(".boli_title a").click(function(){
		$(this).addClass('bld_hover').siblings().removeClass('bld_hover');
	})

	
	////////////////assignment.html
	//转让手续费说明
	$(".assi_sxf a").mouseover(function(){
		$(this).next().show();
	})
	
	
	////////////////subscription.html
	//购买成功提示
//	$(".pay_qr").click(function(){
//		$(".subs_cg").show().prev().hide();
//	})
////////////////cardCoupons.html
	//我的现金红包、我的投资红包、我的加息券Tab切换
	$(".integ_tit a").click(function(){
		var ita = $(this).index();
		$(this).addClass('int_t_h').siblings().removeClass('int_t_h');
		$(".cadCop_bod").hide().eq(ita).show();
	})
	//使用（领取）状态
	$(".cadCop_ttab a").click(function(){
		var cta = $(this).index();
		$(this).addClass('cadC_tHov').siblings().removeClass('cadC_tHov');
		$(this).parents(".cadCop_bod").find(".cap_zt").hide().eq(cta-1).show();
	})

	
	
	$(".inve_tab_title li").click(function(){
		var il = $(this).index();
		$(this).addClass('itb_hover').siblings().removeClass('itb_hover');
		$(this).parents(".right_main").find('.inve_list').eq(il).addClass('lid_blo').siblings().removeClass('lid_blo');
	})
	//查询周期
	$(".in_lis_t li:not(li:eq(5))").click(function(){
		$(this).addClass('ils_c').siblings().removeClass('ils_c');
		$(".inv_gjss").hide();
	})
	$(".in_lis_t li:eq(4)").click(function(){
		$(".inv_gjss").show();
	})
	//查看详情
	$(".inv_ck").click(function(){
		$(".inves_ckxq").show();
	})
	$(".in_ckxq_title div").click(function(){
		$(".inves_ckxq").hide();
	})
	////////////////payZn.html
	//充值提现流程图
	$(".payZn_tit a:eq(0)").click(function(){
		$(".pZ_cz").show().next().hide();
		$(this).addClass('pZ_t_1').siblings().removeClass('pZ_t_1').find('img');
		$(this).find('img').attr('src','../img/btn/pZ_cz_hov.png');
		$(this).next().find('img').attr('src','../img/btn/pZ_tx.png');
	})
	$(".payZn_tit a:eq(1)").click(function(){
		$(".pZ_tx").show().prev().hide();
		$(this).addClass('pZ_t_1').siblings().removeClass('pZ_t_1');
		$(this).find('img').attr('src','../img/btn/pZ_tx_hov.png');
		$(this).prev().find('img').attr('src','../img/btn/pZ_cz.png');
	})
	
	////////////////calculator.html
	//计算结果
	$(".cal_btn_js").click(function(){
		$(".cal_jsjg").show();
	})
	$(".cal_close").click(function(){
		$(".cal_jsjg").hide();
	})
	////////////////help.html
	//左边菜单
	$(".help_nav li").click(function(){
		var hnl = $(this).index();
		$(this).addClass('hnav_hov').siblings().removeClass('hnav_hov');
		$(".help_div").hide();
		$(".help_div:eq("+hnl+")").show();
	})
	
	
	//了解学呗
	$(".help_ljzb h3").toggle(
		function(){
			$(this).next('div').show();
		},
		function(){
			$(this).next('div').hide();
		}
	)
	//阅读并同意协议
	$(".pay_check").hide();
	$(".check_xy div").toggle(function(){
		$(this).css('background','none').parent().nextAll().find('.pay_qr').hide().next().show();
	},function(){
		$(this).css('background','url(../img/icon/check_d.png) top left no-repeat').parent().nextAll().find('.pay_check').hide().prev().show();
	})
	
	//账户记录详情 撤销提现弹窗
	$(".revoke").bind("click",function(){
		$(".revoke_bod .page_1").show();
		$(".revoke_bod .page_2").hide();
		$(".revoke_mask").show();
	})
	$(".revoke_bod h2 div").bind("click",function(){
		$(".revoke_mask").hide();
	})
	$(".revoke_bod .page_1 a").bind("click",function(){
		$(".revoke_mask").hide();
	})
	
	$(".revoke_bod .page_2 input").bind("click",function(){
		$(".revoke_mask").hide();
	})
	
	//安全保障页--翻页
	$(".security_nav ul li").bind("click",function(){
		$(".point").removeClass("point");
		$("."+$(this).attr("page")).addClass("point");
		$(".security_nav .active").removeClass("active");
		$(this).addClass("active");
	})
	function flushYzm() {
		$("#kaptchaImage").hide().attr('src','/captcha-image.htm?'+ Math.floor(Math.random() * 100)).fadeIn();
	}
})
