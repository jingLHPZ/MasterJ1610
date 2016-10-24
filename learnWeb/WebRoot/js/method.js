$(document).ready(function(){
	////////////////公共
	//文本框聚焦
	$("input[type=text],[type=password]").not(".szp_mmk input").focus(function(){
		$(this).css({'border':'1px solid #777','color':'#777'});
	})
	$("input[type=text],[type=password]").not(".szp_mmk input").blur(function(){
		$(this).css({'border':'1px solid #aaa','color':'#555'});
	})
	//分页高亮
	$(document).ready(function(){
		/*$(".page_fy a").eq(2).addClass('fy_gl');*/
	})
	$(".page_fy a").click(function(){
		$(this).addClass('fy_gl').siblings().removeClass('fy_gl');
	})
	
	
	////////////////top.html
	//登陆状态
	$(".login_a").click(function(){
		$(".login_q").hide();
		$(".login_h").show();
	})
	$(".close_a").click(function(){
		$(".login_q").show();
		$(".login_h").hide();
	})
	
	//导航
	$(".list_nav a:not('.nav_ul a')").click(function(){
		$(".list_nav a").removeClass('nav_bor');
		$(this).addClass('nav_bor');
	})
	$(".nav_la,.nav_ul").parent().hover(
		function(){
			$(".nav_ul").show();
			$(".nav_la").addClass('nav_bor');
		},
		function(){
			$(".nav_ul").hide();
			$(".nav_la").removeClass('nav_bor');
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
	//$(".xszx_bod:eq(1)").hide();
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
	
	
	////////////////realName.html
	$(".smr_clor").click(function(){
		$(".smrz_posi").hide();
	})
	
	
	////////////////register.html
	//注册步骤
	$(".reg_btn_next:eq(0) a").click(function(){
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
		if(!$("#user_pass2_show").is(":hidden")){
			i++
		}
		if(i==0){
			$(".reg_t1").css('background','url(img/register_1.png) top left no-repeat');
			$(".reg_ti_list").css('background','url(img/register_3_h.png) top right no-repeat');
			$(".reg_bz").hide();
			$(".reg_3").show();
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
	$(".chec_xy").toggle(
		function(){
			if($("#user_phone").val().length==0){
				$(".rb_no").show();
			}else{
				$(".rb_no").hide();
			}
			if($("#phone_ver_no").val().length==0){
				$(".rb_no").show();
			}else{
				$(".rb_no").hide();
			}
			if($("#user_pass").val().length==0){
				$(".rb_no").show();
			}else{
				$(".rb_no").hide();
			}
			if($("#user_pass2").val().length==0){
				$(".rb_no").show();
			}else{
				$(".rb_no").hide();
			}
			$(this).css('background','url(img/icon/check_d.png) top left no-repeat');
		},
		function(){
			$(".rb_no").show();
			$(this).css('background','#fff');
		}
	)
	//获取验证码
	$(".reg_btn_y").click(function(){
		$(this).hide().next(".reg_djs").show();
		show();
	});
	

	////////////////recharge.html
	//充值选择支付方式
	$(".rech_fs li").click(function(){
		$(this).addClass('re_fs_click').siblings().removeClass('re_fs_click');
	})
	//充值成功提示
	$(".rech_cz_btn").click(function(){
		$(".rech_true").show();
	})
	$(".rech_title a").click(function(){
		$(".rech_true").hide();
	})
	
	////////////////investment.html
	//标题tab切换
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
	$(".bankcard_add").click(function(){
		$(".add_bc").show();
	})
	$(".addb_close").click(function(){
		$(".add_bc").hide();
	})
	
	
	////////////////toInvest.html
	//tab菜单切换
	$(".toi_tab li").click(function(){
		var tt = $(this).index();
		$(".toin_m").hide().eq(tt).show();
		$(this).addClass('toi_title').siblings().removeClass('toi_title');
	})
	
	
	////////////////withdraw.html
	//获取验证码
	$(".wid_yzm").click(function(){
		$(this).hide().next(".wid_djs").show();
		show();
	});
	
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
		$(".znxx_tab div").addClass('at_ch_bg');
	})
	//反选
	$(".lx_xzlx a:eq(1)").click(function(){
		$(".znxx_tab div").removeClass('at_ch_bg');
	})
	//查看消息
	$(".znxx_tab a").click(function(){
		$(".sta_cen").hide().eq(1).show();
	})
	//通知设置
	$(".znxx_title a").click(function(){
		$(".sta_cen").hide().eq(2).show();
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
	$(".hb_je a").click(function(){
		$(".hb_je").hide().prev().show();
	})
	$(".hb_je li").click(function(){
		$(".hb_je div").hide();
		$(".hb_je p").show();
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
	//密码修改成功提示
	$(".per_bc_btn a").click(function(){
		$(".password_alert").show();
		setTimeout("$('.password_alert').hide()",3000);
	})
	//设置支付密码
	$(".szp_mmk ul:eq(0) input").click(function(){
		for (var s = 0; s<6; s++) {
			if ($('.szp_mmk ul:eq(0) input').eq(s).val()!='') {
				var si = s;
				while(true){
					si=si+1;
					if($('.szp_mmk ul:eq(0) input').eq(si).val()==""){
						$(".szp_mmk ul:eq(0) input").eq(si).focus();
						break;
					}
				}
			} else{
				$(".szp_mmk ul:eq(0) input").eq(s).focus();
				break;
			}
		}
	})
	$(".szp_mmk ul:eq(0) input").keyup(function(){
		$(this).parent('li').next().find('input').focus();
	})
	//设置支付密码
	$(".szp_btn_cz").click(function(){
		$(".szp_mmk ul:eq(0) input").val('');
		$(".szp_mmk ul:eq(0) input:eq(0)").focus();
	})
	$(".szp_btn_qr").click(function(){
		$(".szp_mmk ul:eq(0),.szp_btn").hide();
		$(".szp_mmk ul:eq(1)").show();
		$(".szp_mmk p").text("请再次输入确认支付密码");
		$(".szp_mmk ul:eq(1) input:eq(0)").focus();
	})
	$(".szp_clo").click(function(){
		$(".Szzf_password").hide();
	})
	
	
	////////////////borrowingData.html
	//上传身份证
	$(".bosfz_up input").change(function(){
		$(this).next('img').show();
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
	//还款弹出框
	$(".bwD_hk").click(function(){
		$(".inves_ckxq").show();
	})
	//还款确认提示
	$(".in_hkjh_tab a").click(function(){
		$(".bwD_hk_qr").show();
	})
	$(".hkqr_btn_2").click(function(){
		$(".bwD_hk_qr").hide();
	})
	
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
	
	
	
	////////////////loan.html
	//产品详细介绍
	$(".loan_zyd a").click(function(){
		$(".zyd_bod").show();
	})
	$(".zyd_clos").click(function(){
		$(".zyd_bod").hide();
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
		$(".int_dh_div").show();
		$(".int_dh_div").find('label').eq(0).text(dh_jf);
		$(".int_dh_div").find('label').eq(1).text(dh_jy);
		$(".int_dh_div").find('label').eq(2).text('红包');
		$(".int_dh_div").find('label').eq(3).text(dh_sl);
	})
	$(".tyj_dh").click(function(){
		var dh_jf = $(this).parents('.tyj_mid').find('.tyj_xh label').eq(0).text();     //获得积分
		var dh_jy = $(this).parents('.tyj_mid').find('div label:eq(0)').text();     //获得红包大小
		$(".int_dh_div").show();
		$(".int_dh_div").find('label').eq(0).text(dh_jf);
		$(".int_dh_div").find('label').eq(1).text(dh_jy);
		$(".int_dh_div").find('label').eq(2).text('体验金');
		$(".int_dh_div").find('label').eq(3).text('1');
	})
	$(".intdh_bod input").click(function(){
		$(".int_dh_div").hide();
	})
	
	////////////////calculator.html
	//计算结果
	$(".cal_btn_js").click(function(){
		$(".cal_jsjg").show();
	})
	$(".cal_close").click(function(){
		$(".cal_jsjg").hide();
	})
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
})
