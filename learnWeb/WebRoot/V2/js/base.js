var PFUN = {};//页面事件
var BASE = {};//公用方法

//扩展方法
(function extendInit($){
	if (!window.JSON) {
	  window.JSON = {
	    parse: function(sJSON) { return eval('(' + sJSON + ')'); },
	    stringify: (function () {
	      var toString = Object.prototype.toString;
	      var isArray = Array.isArray || function (a) { return toString.call(a) === '[object Array]'; };
	      var escMap = {'"': '\\"', '\\': '\\\\', '\b': '\\b', '\f': '\\f', '\n': '\\n', '\r': '\\r', '\t': '\\t'};
	      var escFunc = function (m) { return escMap[m] || '\\u' + (m.charCodeAt(0) + 0x10000).toString(16).substr(1); };
	      var escRE = /[\\"\u0000-\u001F\u2028\u2029]/g;
	      return function stringify(value) {
	        if (value == null) {
	          return 'null';
	        } else if (typeof value === 'number') {
	          return isFinite(value) ? value.toString() : 'null';
	        } else if (typeof value === 'boolean') {
	          return value.toString();
	        } else if (typeof value === 'object') {
	          if (typeof value.toJSON === 'function') {
	            return stringify(value.toJSON());
	          } else if (isArray(value)) {
	            var res = '[';
	            for (var i = 0; i < value.length; i++)
	              res += (i ? ', ' : '') + stringify(value[i]);
	            return res + ']';
	          } else if (toString.call(value) === '[object Object]') {
	            var tmp = [];
	            for (var k in value) {
	              if (value.hasOwnProperty(k))
	                tmp.push(stringify(k) + ': ' + stringify(value[k]));
	            }
	            return '{' + tmp.join(', ') + '}';
	          }
	        }
	        return '"' + value.toString().replace(escRE, escFunc) + '"';
	      };
	    })()
	  };
	}
	
	$.fn.extend({
		toggle: function( fn ) {
			var args = arguments,
				guid = fn.guid || jQuery.guid++,
				i = 0,
				toggler = function( event ) {
					var lastToggle = ( jQuery._data( this, "lastToggle" + fn.guid ) || 0 ) % i;
					jQuery._data( this, "lastToggle" + fn.guid, lastToggle + 1 );
					event.preventDefault();
					return args[ lastToggle ].apply( this, arguments ) || false;
				};
			toggler.guid = guid;
			while ( i < args.length ) {
				args[ i++ ].guid = guid;
			}
			return this.click( toggler );
		}
	});
	
	$.fn.extend({
		_toggle: jQuery.fn.toggle,
		toggle: function( fn, fn2, callback ) {
			var bool = typeof fn === "boolean";
			if ( jQuery.isFunction(fn) && jQuery.isFunction(fn2) ) {
				this._toggle.apply( this, arguments );
	
			} else if ( fn == null || bool ) {
				this.each(function() {
					var state = bool ? fn : jQuery(this).is(":hidden");
					jQuery(this)[ state ? "show" : "hide" ]();
				});
			} else {
				this.animate(genFx("toggle", 3), fn, fn2, callback);
			}
			return this;
		}
	});
	
	
	
})(jQuery);

$(function(){
	
	//每个页面都需要引用此方法
	PFUN.topInit = function(){
		
		//加载cdn字体文件
	     if (!!window.ActiveXObject || "ActiveXObject" in window){
	    	$("#css_font_awesome").remove();
		    $("head").append('<link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.css" rel="stylesheet">');
	    }
		
		
		$(window).scroll(function(){
			//顶部浮起
			if($(this).scrollTop()>130){
				$(".nav_warp").addClass("top_nav_fixed");
			}else{
				$(".nav_warp").removeClass("top_nav_fixed");
			}
			
			//回顶按钮显示隐藏
			if($(this).scrollTop()>400){
				$('.right_menu .arrowup').show();
			}else{
				$('.right_menu .arrowup').hide();
			}
		});
		//回顶操作
		$('.right_menu .arrowup').click(function(){
			$("body, html").animate({
			    scrollTop: 0
			  }, 300);
		})
		
		//手机端打开关闭菜单
		$(".top_nav .list_btn").bind("click",function(){
			$(".top_nav .top_menu").toggleClass("active");
		});
		
		//登录
		$(".top_bar .login").click(function(){
			/*$(".top_bar .user").hide();
			$(".top_bar .welcome").show();
			//banner登录状态框
			$(".banner_reg .reg").hide();
			$(".banner_reg .login").show();*/
		})
		
		//退出
		$(".top_bar .logout a").click(function(){
			$(".top_bar .welcome").hide();
			$(".top_bar .login").show();
			$(".top_bar .reg").show();
			//banner登录状态框
			$(".banner_reg .reg").show();
			$(".banner_reg .login").hide();
		})
		
	}.call(this);
	
	//导航栏自动选中
	PFUN.navSecAuto = function(){
		var name = $("title").text();
		var nav = {
			"学呗" : 0,
			"投资列表" : 1
		};
		if(nav[name] != null){
			$(".top_nav .top_menu li:eq("+nav[name]+") a").addClass("active");
		}
	};
	
	//导航栏手动选中num:第几个
	PFUN.navSecManual = function(num){
		num = num - 1;
		$(".top_nav .top_menu .active").removeClass("active");
		$(".top_nav .top_menu li:eq("+num+") a").addClass("active");
	};
	
	
	//index页
	PFUN.index = function(){
		PFUN.navSecManual.call(this,1);
		//公告轮播
		(function(){
			var cal = {};
			var lists = $(".carousel .lists");
			loop();
			
			$('.notice_t .prve').bind("click",function(){
				clearTimeout(cal.t);
				lists.clearQueue();
					lists.prepend($(".carousel .lists p:last"));
					lists.css("top","-20px");
				lists.animate({top:"0px"},300);
				loop();	
			});
			$('.notice_t .next').bind("click",function(){
				clearTimeout(cal.t);
				lists.clearQueue();
				lists.animate({top:"-20px"},300,function(){
					lists.css("top","0px");
					lists.append($(".carousel .lists p:first"));
				});
				loop();				
			});
			
			function loop(){
				cal.t = setInterval(function(){
					lists.animate({top:"-20px"},300,function(){
						lists.css("top","0px");
						lists.append($(".carousel .lists p:first"));
					});
				},3000);
			};
		})();
	}
	
	
	
});

//公用方法，可覆盖模块
BASE = {
	removeCss : function(){
		$("#css_mediaPublic").remove();
		$("#css_media").remove();
	},
	supportCss3 : function(){
		var explorer = window.navigator.userAgent.toLowerCase() ;
		if (explorer.indexOf("msie") >= 0) {
		    var ver=explorer.match(/msie ([\d.]+)/)[1];
		    ver = ver.substring(0,ver.indexOf("."));
		    if(ver<10){
			    return false;
		    }
		}
		else if (explorer.indexOf("firefox") >= 0) {
		    var ver=explorer.match(/firefox\/([\d.]+)/)[1];
		    ver = ver.substring(0,ver.indexOf("."));
		    if(ver<12){
			    return false;
		    }
		}
		else if(explorer.indexOf("chrome") >= 0){
		    var ver=explorer.match(/chrome\/([\d.]+)/)[1];
		    ver = ver.substring(0,ver.indexOf("."));
		    if(ver<40){
			    return false;
		    }
		}
		else if(explorer.indexOf("opera") >= 0){
			var ver=explorer.match(/opera.([\d.]+)/)[1];
			ver = ver.substring(0,ver.indexOf("."));
		    return false;
		}
		else if(explorer.indexOf("Safari") >= 0){
			var ver=explorer.match(/version\/([\d.]+)/)[1];
			ver = ver.substring(0,ver.indexOf("."));
		    if(ver<25){
			    return false;
		    }
		}
		return true;
	},
	getSubStringAmount : function(amount) {
		//返回万元整数,取小数点 后一位 如果是整数取整数;amount  数字;returns {String}
	    var returnAmount = amount / 10000;
	    var pointafter = amount % 10000;
	    if (returnAmount >= 1) {
	    	if(pointafter.toFixed(1) > 0){
	    		var p=parseInt(pointafter/ 1000);
	    		if(p>0){
	    			return "<span class='gotham'> "+ parseInt(returnAmount)+"."+ p+ " </span>万";
	    		}else{
	    			return "<span class='gotham'> "+ parseInt(returnAmount)+" </span>万";
	    		}
	    		
	    	}else{
	    		return "<span class='gotham'> "+ parseInt(returnAmount) + " </span>万";
	    	}
	    } else {
	        return "<span class='gotham'> "+ amount+" </span>";
	    }
	},
	formatContentByLength : function(str, len) {
		//根据长度截取先使用字符串，超长部分追加...; str 对象字符串; len 目标字节长度return 处理结果字符串
	    //length属性读出来的汉字长度为1
	    if(str.length*2 <= len) {
	        return str;
	    }
	    var strlen = 0;
	    var s = "";
	    for(var i = 0;i < str.length; i++) {
	        s = s + str.charAt(i);
	        if (str.charCodeAt(i) > 128) {
	            strlen = strlen + 2;
	            if(strlen >= len){
	                return s.substring(0,s.length-1) + "...";
	            }
	        } else {
	            strlen = strlen + 1;
	            if(strlen >= len){
	                return s.substring(0,s.length-2) + "...";
	            }
	        }
	    }
	    return s;
	},
	getSubStringAmountNumber : function(amount) {
		//返回万元整数
	    var returnAmount = amount / 10000;
	    if (returnAmount > 1) {
	        if(returnAmount > 100){
	            return returnAmount.toFixed(0) + "万"
	        }else{
	            return  returnAmount.toFixed(1) + "万"
	        }
	
	    } else {
	        return amount;
	    }
	},
    versions: function () {
    	//是否是移动端
        var u = navigator.userAgent;
        return {
            mobile: !!u.match(/AppleWebKit.*Mobile.*/)||u.indexOf('iPad')>-1||u.indexOf('iPhone')>-1, //是否为移动终端
            ios: u.indexOf('iPad')>-1||u.indexOf('iPhone')>-1, //ios终端
            android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1 //android终端或者uc浏览器
        };
    }
	
};

