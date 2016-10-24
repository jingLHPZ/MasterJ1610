package com.sxt.page.util;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;


/**
 * 
 * PaginationTag
 * pillar liu
 * 2015-10-09 下午5:47:36
 * @version 1.0.0
 */
public class PaginationTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;
	
	private Page pageBean;
	private String methodName; //调用script方法名
	private String sytleName; //样式

	public int doStartTag() {
		if ("sytle1".equals(sytleName))
			printSytleStr1();
		else 
			getPageHtmlStr();
		
		return (BodyTagSupport.EVAL_BODY_BUFFERED);
	}
	
	
	private void printSytleStr1() {
		StringBuffer buffer = new StringBuffer();
		

		buffer.append("<table class=\"p_table ui-widget-content\">");
		buffer.append("<tr>");
		buffer.append("<td class=\"p_top\"></td>");
		buffer.append("<td style=\"width: 24px;\"><span" + (pageBean.getPageNo() == 1 ? " class=\"p_first\"" : " class=\"ui-icon ui-icon-seek-first finger\" onclick=\"" + methodName + "(1)\"") + "></span></td>");
		buffer.append("<td style=\"width: 24px;\"><span" + (pageBean.getPageNo() == 1 ? " class=\"p_previous\"" : " class=\"ui-icon ui-icon-seek-prev finger\" onclick=\"" + methodName + "(" + (pageBean.getPageNo() - 1) + ")" + "\"") + "></span></td>");
		buffer.append("<td style=\"width: 10px;\"><hr width=\"0\" size=\"16\" /></td>");
		buffer.append("<td class=\"p_input\">第 <input type=\"text\" value=\"" + pageBean.getPageNo() 
				+ "\" onkeydown=\"javascript:var e = event || window.event; if (e.keyCode == 13) { if (this.value > " 
				+ pageBean.getTotalPages() + " || this.value < 1) { alert('没有该页的索引!'); return; }" + methodName 
				+ "(this.value)}\" />&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;共 " + pageBean.getTotalPages() + "&nbsp;&nbsp;页</td>");
		buffer.append("<td style=\"width: 10px;\"><hr width=\"0\" size=\"16\" /></td>");
		buffer.append("<td style=\"width: 24px;\"><span " + (pageBean.getPageNo() == pageBean.getTotalPages() || pageBean.getTotalCount() == 0 ? " class=\"p_nonext\"" : " class=\"ui-icon ui-icon-seek-next finger\" onclick=\"" + methodName + "(" + (pageBean.getPageNo() + 1) + ")" + "\"") + "></span></td>");
		buffer.append("<td style=\"width: 24px;\"><span" + (pageBean.getPageNo() == pageBean.getTotalPages() || pageBean.getTotalCount() == 0 ? " class=\"p_last\"" : " class=\"ui-icon ui-icon-seek-end finger\" onclick=\"" + methodName + "(" + pageBean.getTotalPages() + ")\"") + "></span></td>");
		buffer.append("<td></td>");
		buffer.append("<td class=\"p_footer\">显示 " + ((pageBean.getPageNo() - 1) * pageBean.getPageSize() + 1) 
						+ " - " + (pageBean.getPageNo() == pageBean.getTotalPages() ? pageBean.getTotalCount() : pageBean.getPageNo() * pageBean.getPageSize()) 
						+ "&nbsp;&nbsp;条记录&nbsp;&nbsp;&nbsp;共&nbsp;&nbsp;" + pageBean.getTotalCount() + "&nbsp;&nbsp;条记录</td>");
		buffer.append("</tr>");
		buffer.append("</table>");
		print(buffer.toString());
	}
	
	
	private void getPageHtmlStr(){
		
		StringBuffer strHtml = new StringBuffer();
		int prevPage = pageBean != null ? pageBean.getPageNo() - 1 : 0; //上一页
		int nextPage = pageBean != null ? pageBean.getPageNo() + 1 : 0; //下一页
		int pageNo = pageBean != null ? pageBean.getPageNo() : 1; //当前页
		int totalPages = pageBean != null ? pageBean.getTotalPages() : 1; //总页数
		int totalCount = pageBean != null ? pageBean.getTotalCount() : 0; //总记录数
		int showTimes = Calendar.SECOND;
		int endPage = 0;
		
		strHtml.append("<script type=\"text/javascript\">");
		
		strHtml.append("function formatInputPage(e){"); 
		strHtml.append("var ie = navigator.appName==\"Microsoft Internet Explorer\"?true:false;");	
		strHtml.append("if(!ie) var key = e.which;");	
		strHtml.append("else var key = event.keyCode;");	
		strHtml.append("if (key == 8 || key == 46 || (key >= 48 && key <= 57)) return true;");	
		strHtml.append("return false;} ");
		
		strHtml.append("function checkPages(page){");
		strHtml.append("if (page < 1) page = 1;");	
		strHtml.append("if (page > "+ totalPages +") page = "+ totalPages +";");
		strHtml.append("return page;} ");
		
		strHtml.append("</script>");
		
		/*strHtml.append("<div id=\"pages_" + showTimes + "\" class=\"pages\"></div>");*/
		strHtml.append("<div class=\"" + sytleName +"\">");
	/*	strHtml.append("<span>总计：" + totalCount + "</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		strHtml.append("<span>当前页/总页数：" + pageNo + "/" + totalPages + "</span>");*/
		
		if (prevPage < 1) {
			strHtml.append("<a href=\"#\">首页</a>");
			strHtml.append("<a href=\"#\">上一页</span>");
		} else {
			strHtml.append("<a href=\"javascript:" + methodName + "(1," + totalCount + ");\">首页</a>");
			strHtml.append("<a href=\"javascript:" + methodName + "(" + prevPage + "," + totalCount + ");\">上一页</a>");
		}
		if (pageNo != 1) strHtml.append("<a href=\"javascript:" + methodName + "(1," + totalCount + ");\">1</a>");
		if (pageNo >= 5) strHtml.append("<span>...</span>");
		if (totalPages > pageNo + 2) {
			endPage = pageNo + 2;
		} else {
			endPage = totalPages;
		}
		for (int i = pageNo - 2; i <= endPage; i++) {
			if (i > 0) {
				if (i == pageNo) {
					strHtml.append("<a style=\"background: #ef4810; border: none; color:#ffffff;\">" + i + "</a>");
				} else {
					if (i != 1 && i != totalPages) {
						strHtml.append("<a href=\"javascript:" + methodName + "(" + i + "," + totalCount + ");\">" + i + "</a>");
					}
				}
			}
		}
		if (pageNo + 3 < totalPages) strHtml.append("<span>...</span>");
		if (pageNo != totalPages) strHtml.append("<a href=\"javascript:" + methodName + "(" + totalPages + "," + totalCount + ");\">" + totalPages + "</a>");
		if (nextPage > totalPages) {
			strHtml.append("<a href=\"#\">下一页</a>");
			strHtml.append("<a href=\"#\">尾页</a>");
		} else {
			strHtml.append("<a href=\"javascript:" + methodName + "(" + nextPage + "," + totalCount + ");\">下一页</a>");
			strHtml.append("<a href=\"javascript:" + methodName + "(" + totalPages + "," + totalCount + ");\">尾页</a>");
		}
		
		strHtml.append("</div>");
		print(strHtml.toString());
		
	}
	
	private void print(String str) {
		JspWriter out = pageContext.getOut();
		try {
			out.print(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*设置属性*/
	public Page getPageBean() {
		return pageBean;
	}

	public void setPageBean(Page pageBean) {
		this.pageBean = pageBean;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getSytleName() {
		return sytleName;
	}

	public void setSytleName(String sytleName) {
		this.sytleName = sytleName;
	}
}
