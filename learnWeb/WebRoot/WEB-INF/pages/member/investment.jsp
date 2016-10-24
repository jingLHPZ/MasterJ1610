<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>我的投资_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/investment.css" />
		<link rel="stylesheet" href="${ctx}/css1000/investment1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/investment750.css" />
		<link rel="stylesheet" href="${ctx}/css720/investment720.css" />
		<style type="text/css">
			form{ margin:0px; }
		</style>
	</head>
	
	<body>
		<%@ include file="/static/top.jsp" %>
		<div class="content_body">
			<!--左边查单栏-->
			<div class="left_menu">
				<%@ include file="/static/left_menu.jsp" %>
			</div>
			  <!--查看详情-->
			<div class="inves_ckxq">
			</div>
			<div class="right_main">
				<!--tab标题-->
				<div class="inve_tab_title">
					<ul>
							<%--<li id="1" class="<c:if test="${typeType == 1||typeType==0}">itb_hover</c:if>" id="ci"><label>涨中宝</label><!--<div>0</div>--></li>--%>
						<li id="2" class="<c:if test="${typeType == 2}">itb_hover</c:if>" id="si"><label>专享理财</label><!--<div>0</div>--></li>
						<li id="2" class="<c:if test="${typeType == 4}">itb_hover</c:if>" id="yx"><label>盈享理财</label><!--<div>0</div>--></li>
						<li id="3" class="<c:if test="${typeType == 3}">itb_hover</c:if>" id="ex"><label>新手专区</label><!--<div>0</div>--></li>
						<div class="last"><a href="${ctx}/repayementdetail/repaydetail.htm">查看回款明细>></a></div>
					</ul>
				</div>
				<%--/*
				<!--涨中宝-->
				<form name="CiFormlist">
				<div id="ciprolist" class="inve_list" style='<c:if test="${typeType == 1||typeType==0}">display:block;</c:if>'>
					<!--表格 涨中宝-->
					<div class="in_lis_t">
						<label>加入时间:</label>
						<ul>
							<li class="<c:if test="${timeType == 1||timeType == 0}">ils_c</c:if>" onclick='trans("1_1");' id="1_1">全部</li>
							<li class="<c:if test="${timeType == 2}">ils_c</c:if>" onclick='trans("1_2");' id="1_2">近1周</li>
							<li class="<c:if test="${timeType == 3}">ils_c</c:if>" onclick='trans("1_3");' id="1_3">近1个月</li>
							<li class="<c:if test="${timeType == 4}">ils_c</c:if>" onclick='trans("1_4");' id="1_4">近3个月</li>
							<!--<li>高级搜索</li>-->
							<li class="inv_gjss">
								<select>
									<option>2015</option>
									<option>2012</option>
									<option>2013</option>
								</select>
								<label>年</label>
								<select>
									<option>1</option>
									<option>2</option>
									<option>3</option>
								</select>
								<label>月</label>
								<!--<a href="javascript://">高级搜索</a>-->
							</li>
						</ul>
						<div class="in_lis_sele">
							项目状态:
							<select  onchange='typefun("1_5")' id="1_5">
								<option value="0" <c:if test="${type == 0}">selected</c:if> >全部</option>
								<option value="3" <c:if test="${type == 3}">selected</c:if> >竞标中</option>
								<option value="6" <c:if test="${type == 6}">selected</c:if> >回款中</option>
								<option value="8" <c:if test="${type == 8}">selected</c:if> >已结清</option>
								<option value="9" <c:if test="${type == 9}">selected</c:if> >已逾期</option>
							</select>
						</div>
					</div>
					<div class="media_table_cont">
						<table cellpadding="0" cellspacing="0" border="0">
							<tr>
								<th width="24%">名称/期次</th>
								<th width="20%">加入时间</th>
								<th width="16%">加入金额</th>
								<th width="11%">预期年化</th>
								<th width="8%">加息</th>
								<th width="8%">投资期限</th>
								<th width="13%">操作</th>
							</tr>
							<c:choose>
								<c:when test="${empty cipage.result}">
									<tr><td colspan="7"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${cipage.result}" var="ciproduct">
										<tr>
											<td align="left">
												<a href="${ctx}/ciProduct/fqueryCiProduct.htm?productId=${ciproduct.productId}" title="${ciproduct.productName}">
													<c:choose>
														<c:when test="${fn:length(ciproduct.productName) > 10}">${fn:substring(ciproduct.productName, 0, 10)}</c:when>
														<c:otherwise>${ciproduct.productName}</c:otherwise>
													</c:choose>
												</a>
											</td>
											<td><fmt:formatDate value="${ciproduct.createTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/><br /></td>
											<td><fmt:formatNumber value="${ciproduct.investorCapital}" pattern="#,##0.00#"/></td>
											<td><fmt:formatNumber type="number" value="${ciproduct.borrowInterestRate*100}" pattern="##0.00" maxFractionDigits="2"/>%</td>
											<td>
											<c:choose>
											<c:when test="${empty ciproduct.proValue||ciproduct.type!=2}">----</c:when>
											<c:otherwise>+
											<fmt:formatNumber type="number" value="${ciproduct.proValue*100}" pattern="##0.00" maxFractionDigits="1"/>%
											</c:otherwise>
											</c:choose>
											<td>
											<c:choose>
											<c:when test="${empty ciproduct.borrowMonthDuration||ciproduct.borrowMonthDuration==0}">
											    ${ciproduct.borrowDayDuration}天
											</c:when>
											<c:otherwise>
												${ciproduct.borrowMonthDuration}月
											</c:otherwise>
										    </c:choose>
											</td>
											<td><a href="javascript:queryInvestDetail(${ciproduct.productId},'${ciproduct.systemTraceNo}');" class="inv_ck">查看</a></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
					</div>		
						<!-- 分页 -->
						<c:choose>
							<c:when test="${empty cipage.result}"></c:when>
							<c:otherwise>
							 	<div class="inves_pg">
									    	<!--分页-->
										<div class="page_fy">
											<li:pagination methodName="fqueryCiproPage" pageBean="${cipage}" sytleName="page_fy"/>
										</div>
								 </div>
							</c:otherwise>
						</c:choose>
					</div>
				</form>
				*/--%>
				<!--散标-->
				<form name="SiFormlist">
				<div id="siprolist" class="inve_list" style='<c:if test="${typeType == 2}">display: block;</c:if>'>
					<div class="in_lis_t">
						<label>加入时间:</label>
						<ul>
							<li class="<c:if test="${timeType == 1||timeType == 0}" >ils_c</c:if>" onclick='trans("2_1");' id="2_1">全部</li>
							<li class="<c:if test="${timeType == 2}">ils_c</c:if>" onclick='trans("2_2");' id="2_2" >近1周</li>
							<li class="<c:if test="${timeType == 3}">ils_c</c:if>" onclick='trans("2_3");' id="2_3">近1个月</li>
							<li class="<c:if test="${timeType == 4}">ils_c</c:if>" onclick='trans("2_4");' id="2_4">近3个月</li>
							<!--<li>高级搜索</li>-->
							<li class="inv_gjss">
								<select>
									<option>2015</option>
									<option>2012</option>
									<option>2013</option>
								</select>
								<label>年</label>
								<select>
									<option>1</option>
									<option>2</option>
									<option>3</option>
								</select>
								<label>月</label>
								<!--<a href="javascript://">高级搜索</a>-->
							</li>
						</ul>
						<div class="in_lis_sele">
							项目状态:
							<select  onchange='typefun("2_5")' id="2_5">
								<option value="0" <c:if test="${type == 0}">selected</c:if> >全部</option>
								<option value="3" <c:if test="${type == 3}">selected</c:if> >竞标中</option>
								<option value="6" <c:if test="${type == 6}">selected</c:if> >回款中</option>
								<option value="8" <c:if test="${type == 8}">selected</c:if> >已结清</option>
								<option value="9" <c:if test="${type == 9}">selected</c:if> >已逾期</option>
							</select>
						</div>
					</div>
					<!--表格-->
					<div class="media_table_cont">
						<table cellpadding="0" cellspacing="0" border="0">
							<tr>
								<th width="24%">名称/期次</th>
								<th width="20%">投资时间</th>
								<th width="16%">投资金额</th>
								<th width="11%">预期年化</th>
								<th width="8%">加息</th>
								<th width="8%">投资期限</th>
								<th width="13%">操作</th>
							</tr>
							<c:choose>
								<c:when test="${empty sipage.result}">
									<tr><td colspan="7"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${sipage.result}" var="siproduct">
										<tr>
											<td align="left">
												<a href="<c:choose>
													<c:when test="${siproduct.productId==700000001 || siproduct.productId==700000002}">
														${ctx}/newHandProduct/fqueryNewHandProduct.htm?productId=700000001
													</c:when>
													<c:when test="${siproduct.productAdaptedType == 2}">
														${ctx}/siproduct/fquerybisipro.htm?proid=${siproduct.productId}
													</c:when>
													<c:when test="${siproduct.productAdaptedType == 3}">
														${ctx}/peproduct/fquerybisipro.htm?proid=${siproduct.productId}
													</c:when></c:choose>" title='${siproduct.productName}'>
													<c:choose>
														<c:when test="${fn:length(siproduct.productName) > 10}">${fn:substring(siproduct.productName, 0, 10)}...</c:when>
														<c:otherwise>${siproduct.productName}</c:otherwise>
													</c:choose>
												</a>
											</td>
											<td><fmt:formatDate value="${siproduct.createTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
											<c:choose>
												<c:when test="${siproduct.type==3}">
													<td class="prize">
														<fmt:formatNumber value="${siproduct.investorCapital}" pattern="#,##0.00#"/>元
														<div>含投资红包￥<fmt:formatNumber value="${siproduct.proValue}" pattern="#,###"/></div>
													</td>
												</c:when>
												<c:otherwise>
													<td>
														<fmt:formatNumber value="${siproduct.investorCapital}" pattern="#,##0.00#"/>元
													</td>
												</c:otherwise>
											</c:choose>
											<td><fmt:formatNumber type="number" value="${siproduct.borrowInterestRate*100}" pattern="0" maxFractionDigits="2"/>%</td>
											<td>
											<c:choose>
											<c:when test="${empty siproduct.proValue||siproduct.type!=2}">----</c:when>
											<c:otherwise>+
											<fmt:formatNumber type="number" value="${siproduct.proValue*100}" pattern="##0.00" maxFractionDigits="1"/>%
											</c:otherwise>
											</c:choose>
											</td>
											<td>
											<c:choose>
											<c:when test="${empty siproduct.borrowMonthDuration||siproduct.borrowMonthDuration==0}">
											    ${siproduct.borrowDayDuration}天
											</c:when>
											<c:otherwise>
												${siproduct.borrowMonthDuration}月
											</c:otherwise>
										    </c:choose>
											</td>
											<td><a href="javascript:queryInvestDetail(${siproduct.productId},'${siproduct.systemTraceNo}');" class="inv_ck">查看</a></td>
										    </tr>
										</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
					<!--分页-->
					<c:choose>
					<c:when test="${empty sipage.result}"></c:when>
					<c:otherwise>
					 <div class="inves_pg">
						<div class="page_fy">
							<li:pagination methodName="fquerySiproPage" pageBean="${sipage}" sytleName="page_fy"/>
						</div>
					 </div>
					 </c:otherwise>
					</c:choose>
				</div>
				</form>
				
				<!-- 盈享理财 -->
				<form name="YxFormlist">
				<div id="yxprolist" class="inve_list" style='<c:if test="${typeType == 4}">display: block;</c:if>'>
					<div class="in_lis_t">
						<label>加入时间:</label>
						<ul>
							<li class="<c:if test="${timeType == 1||timeType == 0}" >ils_c</c:if>" onclick='trans("4_1");' id="4_1">全部</li>
							<li class="<c:if test="${timeType == 2}">ils_c</c:if>" onclick='trans("4_2");' id="4_2" >近1周</li>
							<li class="<c:if test="${timeType == 3}">ils_c</c:if>" onclick='trans("4_3");' id="4_3">近1个月</li>
							<li class="<c:if test="${timeType == 4}">ils_c</c:if>" onclick='trans("4_4");' id="4_4">近3个月</li>
							<li class="inv_gjss">
								<select>
									<option>2015</option>
									<option>2012</option>
									<option>2013</option>
								</select>
								<label>年</label>
								<select>
									<option>1</option>
									<option>2</option>
									<option>3</option>
								</select>
								<label>月</label>
								<!--<a href="javascript://">高级搜索</a>-->
							</li>
						</ul>
						<div class="in_lis_sele">
							项目状态:
							<select  onchange='typefun("4_5")' id="4_5">
								<option value="0" <c:if test="${type == 0}">selected</c:if> >全部</option>
								<option value="3" <c:if test="${type == 3}">selected</c:if> >竞标中</option>
								<option value="6" <c:if test="${type == 6}">selected</c:if> >回款中</option>
								<option value="8" <c:if test="${type == 8}">selected</c:if> >已结清</option>
								<option value="9" <c:if test="${type == 9}">selected</c:if> >已逾期</option>
							</select>
						</div>
					</div>
					<!--表格-->
					<div class="media_table_cont">
						<table cellpadding="0" cellspacing="0" border="0">
							<tr>
								<th width="24%">名称/期次</th>
								<th width="18%">投资时间</th>
								<th width="14%">投资金额</th>
								<th width="11%">预期年化</th>
								<th width="8%">加息</th>
								<th width="12%">最终还款日</th>
								<th width="13%">操作</th>
							</tr>
							<c:choose>
								<c:when test="${empty yxpage.result}">
									<tr><td colspan="7"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${yxpage.result}" var="product">
										<tr>
											<td align="left">
												<a href="${ctx}/yingxiang/queryYingXiangDetail.htm?proid=${product.productId}" title="${product.productName}">
													<c:choose>
														<c:when test="${fn:length(product.productName) > 10}">${fn:substring(product.productName, 0, 10)}...</c:when>
														<c:otherwise>${product.productName}</c:otherwise>
													</c:choose>
												</a>
											</td>
											<td><fmt:formatDate value="${product.createTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
											<c:choose>
												<c:when test="${product.type==3}">
													<td class="prize">
														<fmt:formatNumber value="${product.investorCapital}" pattern="#,##0.00#"/>元
														<div>含投资红包￥<fmt:formatNumber value="${product.proValue}" pattern="#,###"/></div>
													</td>
												</c:when>
												<c:otherwise>
													<td>
														<fmt:formatNumber value="${product.investorCapital}" pattern="#,##0.00#"/>元
													</td>
												</c:otherwise>
											</c:choose>
											<td><fmt:formatNumber type="number" value="${product.borrowInterestRate*100}" pattern="0" maxFractionDigits="2"/>%</td>
											<td>
											<c:choose>
											<c:when test="${empty product.proValue||product.type!=2}">----</c:when>
											<c:otherwise>+
											<fmt:formatNumber type="number" value="${product.proValue*100}" pattern="##0.00" maxFractionDigits="2"/>%
											</c:otherwise>
											</c:choose>
											</td>
											<td>
											<%-- <c:choose>
											<c:when test="${empty product.borrowMonthDuration||product.borrowMonthDuration==0}">
											    ${product.borrowDayDuration}天
											</c:when>
											<c:otherwise>
												${product.borrowMonthDuration}月
											</c:otherwise>
										    </c:choose> --%>
										    <fmt:formatDate value="${product.lastTime}" type="both" pattern='yyyy-MM-dd'/>
											</td>
											<td><a href="javascript:queryInvestDetail(${product.productId},'${product.systemTraceNo}');" class="inv_ck">查看</a></td>
										    </tr>
										</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
					<!--分页-->
					<c:choose>
					<c:when test="${empty yxpage.result}"></c:when>
					<c:otherwise>
					 <div class="inves_pg">
						<div class="page_fy">
							<li:pagination methodName="fqueryYxproPage" pageBean="${yxpage}" sytleName="page_fy"/>
						</div>
					 </div>
					 </c:otherwise>
					</c:choose>
				</div>
				</form>
				
				
				<!--体验标-->
				<form name="ExFormlist">
				<div id="exprolist" class="inve_list zqzr_bod" style='<c:if test="${typeType == 3}">display: block;</c:if>'>
					<div class="in_lis_t">
						<label>加入时间:</label>
						<ul>
							<li class="<c:if test="${timeType == 1||timeType == 0}" >ils_c</c:if>" onclick='trans("3_1");' id="3_1">全部</li>
							<li class="<c:if test="${timeType == 2}">ils_c</c:if>" onclick='trans("3_2");' id="3_2">近1周</li>
							<li class="<c:if test="${timeType == 3}">ils_c</c:if>" onclick='trans("3_3");' id="3_3">近1个月</li>
							<li class="<c:if test="${timeType == 4}">ils_c</c:if>" onclick='trans("3_4");' id="3_4">近3个月</li>
							<!--<li>高级搜索</li>-->
							<li class="inv_gjss">
								<select>
									<option>2015</option>
									<option>2012</option>
									<option>2013</option>
								</select>
								<label>年</label>
								<select>
									<option>1</option>
									<option>2</option>
									<option>3</option>
								</select>
								<label>月</label>
								<!--<a href="javascript://">高级搜索</a>-->
							</li>
						</ul>
						<div class="in_lis_sele" style="display:none;">
							项目状态:
							<select  onchange='typefun("3_5")' id="3_5">
								<option value="0" <c:if test="${type == 0}">selected</c:if> >全部</option>
								<option value="3" <c:if test="${type == 3}">selected</c:if> >竞标中</option>
								<option value="6" <c:if test="${type == 6}">selected</c:if> >回款中</option>
								<option value="8" <c:if test="${type == 8}">selected</c:if> >已结清</option>
								<option value="9" <c:if test="${type == 9}">selected</c:if> >已逾期</option>
							</select>
						</div>
					</div>
					<!--表格-->
					<div class="media_table_cont">
						<table cellpadding="0" cellspacing="0" border="0">
							<tr>
								<th width="22%">投资时间</th>
								<th width="21%">投资体验金</th>
								<th width="16%">预期年化</th>
								<!-- <th width="11%">加息</th> -->
								<th width="11%">投资期限</th>
								<th width="18%">操作</th>
							</tr>
							<c:choose>
								<c:when test="${empty expage.result}">
									<tr><td colspan="5"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${expage.result}" var="exproduct">
										<tr>
											<td align="left"><fmt:formatDate value="${exproduct.createTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
											<td><fmt:formatNumber value="${exproduct.affectExperienceGold}" pattern="#,##0.00"/>元</td>
											<td><fmt:formatNumber type="number" value="${exproduct.borrowInterestRate*100}" pattern="0" maxFractionDigits="2"/>%</td>
											<%-- <td><c:choose>
											<c:when test="${empty exproduct.proValue||exproduct.type!=2}">----</c:when>
											<c:otherwise>+
											<fmt:formatNumber type="number" value="${exproduct.proValue*100}" pattern="##0.00" maxFractionDigits="2"/>%
											</c:otherwise>
											</c:choose></td> --%>
											<td>${exproduct.investLimit}天</td>
											<td><a href="javascript:queryInvestDetail(${exproduct.productId},'${exproduct.systemTraceNo}');" class="inv_ck" >查看</a></td>
										</tr><!-- class="inv_ck" -->
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
					<c:choose>
					<c:when test="${empty expage.result}"></c:when>
					<c:otherwise>
					<!-- 分页 -->
					<div class="inves_pg">
						<div class="page_fy">
							<li:pagination methodName="fqueryExperiencePage" pageBean="${expage}" sytleName="page_fy"/>
						</div>
					 </div>
					 </c:otherwise>
					</c:choose>
					</div>
				</form>
			</div>
		</div>
	<%@ include file="/static/footer.jsp" %>
	</body>
	<script type="text/javascript">
		$.ajaxSetup({ async: false });
	
		$(function(){
			$(".inve_tab_title li").click(function(){
				var il = $(this).index();
				$(this).addClass('itb_hover').siblings().removeClass('itb_hover');
				$(this).parents(".right_main").find('form .inve_list').each(function(index,element){
					if(index == il){
						$(this).parents(".right_main").find('form .inve_list').eq(il).addClass('lid_blo').css('display','block');
					}else{
						$(this).parents(".right_main").find('form .inve_list').eq(index).removeClass('lid_blo').css('display','none');
					}
				});
				$(this).parents(".right_main").find('.inve_tab_title').css('display','block');
			})
		});
		//时间触发函数	 
		function trans(timeType){
			var totalCount = "";
			if(timeType.substring(0,1) == 1){
				timeType=(timeType.substring(2,3));
				var selecttype = $("#1_5 option:selected").val();
				fqueryCiproPage(0,totalCount,1,timeType,selecttype);
			}else if(timeType.substring(0,1) == 2){
				timeType=(timeType.substring(2,3));
				var selecttype = $("#2_5 option:selected").val();
				fquerySiproPage(0,totalCount,2,timeType,selecttype);
			}else if(timeType.substring(0,1) == 4){
				timeType=(timeType.substring(2,3));
				var selecttype = $("#4_5 option:selected").val();
				fqueryYxproPage(0,totalCount,4,timeType,selecttype);
			}else{
				timeType=(timeType.substring(2,3));
				var selecttype = $("#3_5 option:selected").val();
				fqueryExperiencePage(0,totalCount,3,timeType,selecttype);			
			}
		}
		//select 函数
		function typefun(types){
			var totalCount = "";
			var selecttype = $("#"+types+" option:selected").val();
			var timeType = "";
			if($("li[class='ils_c']").length > 0){
				 $("li[class='ils_c']").each(function(){
				    if($(this).attr("id").substring(0,1) == (types.substring(0,1))){
				    	timeType = $(this).attr("id").substr(2,3);
				    }
				 });
			}
			if(types.substring(0,1) == 1){
				// $(".selector").find("option[val='"+selecttype+"']").attr("selected",true);
				fqueryCiproPage(0,totalCount,1,timeType,selecttype);
			}else if(types.substring(0,1) == 2){
				fquerySiproPage(0,totalCount,2,timeType,selecttype);
			}else if(types.substring(0,1)== 4){
				fqueryYxproPage(0,totalCount,4,timeType,selecttype);
			}else{
				fqueryExperiencePage(0,totalCount,3,timeType,selecttype);
			}
		}
		//涨中宝	
		function fqueryCiproPage(pageNo,totalCount,typeType,timeType,selecttype){
			if(typeof(typeType)=='undefined'){
				if($("li[class='itb_hover']").length > 0){
					var typeType= $("li[class='itb_hover']").attr("id");
					typeType=typeType.substring(0,1);
				}
			}
			if(typeof(timeType)=='undefined'){
				if($("li[class='ils_c']").length > 0){
					$("li[class='ils_c']").each(function(){
					    if($(this).attr("id").substr(0,1) == typeType){
					    	timeType = $(this).attr("id").substr(2,3);
					    }
					 });
				}
			}
			if(typeof(selecttype)=='undefined'){
				selecttype = $("#"+typeType+"_5"+" option:selected").val();
			}
			var map = $("#CiFormlist").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount+"&typeType="+typeType+"&timeType="+timeType+"&type="+selecttype;
			$.ajax({
				type: "POST",
				url: "${ctx}/borrowinvest/querycirecord.htm",
				data: map,
				success: function(result) {
					$('#ciprolist').html(result);
				   }
		    	});
         }
		//散标
		function fquerySiproPage(pageNo,totalCount,typeType,timeType,selecttype){
			if(typeof(typeType)=='undefined'){
				if($("li[class='itb_hover']").length > 0){
					var typeType= $("li[class='itb_hover']").attr("id");
					typeType=typeType.substring(0,1);
				}
			}
			if(typeof(timeType)=='undefined'){
				if($("li[class='ils_c']").length > 0){
					$("li[class='ils_c']").each(function(){
					    if($(this).attr("id").substr(0,1) == typeType){
					    	timeType = $(this).attr("id").substr(2,3);
					    }
					 });
				}
			}
			if(typeof(selecttype)=='undefined'){
				selecttype = $("#"+typeType+"_5"+" option:selected").val();
			}
			var map = $("#SiFormlist").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount +"&typeType="+typeType+"&timeType="+timeType+"&type="+selecttype;
			$.ajax({
				type: "POST",
				url: "${ctx}/borrowinvest/querysirecord.htm",
				data: map,
				success: function(result) {
					$('#siprolist').html(result);
				   }
		    	});
           }
		
		
		//盈享
		function fqueryYxproPage(pageNo,totalCount,typeType,timeType,selecttype){
			if(typeof(typeType)=='undefined'){
				if($("li[class='itb_hover']").length > 0){
					var typeType= $("li[class='itb_hover']").attr("id");
					typeType=typeType.substring(0,1);
				}
			}
			if(typeof(timeType)=='undefined'){
				if($("li[class='ils_c']").length > 0){
					$("li[class='ils_c']").each(function(){
					    if($(this).attr("id").substr(0,1) == typeType){
					    	timeType = $(this).attr("id").substr(2,3);
					    }
					 });
				}
			}
			if(typeof(selecttype)=='undefined'){
				selecttype = $("#"+typeType+"_5"+" option:selected").val();
			}
			var map = $("#YxFormlist").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount +"&typeType="+typeType+"&timeType="+timeType+"&type="+selecttype;
			$.ajax({
				type: "POST",
				url: "${ctx}/borrowinvest/queryyxrecord.htm",
				data: map,
				success: function(result) {
					$('#yxprolist').html(result);
				   }
		    	});
           }
		
		//体验标
		function fqueryExperiencePage(pageNo,totalCount,typeType,timeType,selecttype){
			if(typeof(typeType)=='undefined'){
				if($("li[class='itb_hover']").length > 0){
					var typeType= $("li[class='itb_hover']").attr("id");
					typeType=typeType.substring(0,1);
				}
			}
			if(typeof(timeType)=='undefined'){
				if($("li[class='ils_c']").length > 0){
					$("li[class='ils_c']").each(function(){
					    if($(this).attr("id").substr(0,1) == typeType){
					    	timeType = $(this).attr("id").substr(2,3);
					    }
					 });
				}
			}
			if(typeof(selecttype)=='undefined'){
				selecttype = $("#"+typeType+"_5"+" option:selected").val();
			}
				 var map = $("#ExFormlist").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount+"&typeType="+typeType+"&timeType="+timeType+"&type="+selecttype;
				 $.ajax({
					type: "POST",
					url: "${ctx}/borrowinvest/queryexrecord.htm",
					data: map,
					success: function(result) {
						$('#exprolist').html(result);
					   }
			    	 });
	         }
		
		//	查看投资明细
		function queryInvestDetail(productId,systemTraceNo) {
			$.post("${ctx}/repayementdetail/queryInvestDetail.htm", 
					{"productId":productId,"systemTraceNo":systemTraceNo}, 
					function(data) {
				$(".inves_ckxq").css("display","block");
				$(".inves_ckxq").html("");
				$(".inves_ckxq").html(data);
			});
		}
	</script>
</html>
