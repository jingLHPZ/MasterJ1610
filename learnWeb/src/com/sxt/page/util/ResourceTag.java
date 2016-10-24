package com.sxt.page.util;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * <p>
 * This is a JSP tag class which could be used to build an anchor, a button or a submit button with correct role,
 * if user couldn't access the resource, than the element would not be rendered. This tag also support internationalization 
 * with using locale attribute.
 * </p>
 * 
 * Example:
 * <p>Use as tag &lt;input type="button"&gt; Code:<br> 
 * &lt;li:button request="${req }" value="冻结" type="button" url="/merchantMemberFreezeOrUnfreeze.htm" 
 *   otherAttribute="javascript:merchantMemberFreezeOrUnfreeze('${member.memberCode}','3'); " /&gt;
 * </p>
 * <p>Use as tag &lt;a&gt; Code:<br> 
 * &lt;li:button request="${req }" value="冻结" type="a" url="/merchantMemberFreezeOrUnfreeze.htm" 
 *   otherAttribute="herf=\"/merchantMemberFreezeOrUnfreeze.htm?memberCode=${member.memberCode}\" " /&gt;
 * </p>
 * @author pillr liu
 * @since 1.0.9 <p>2015-10-9 下午3:47:41</p>
 */
public class ResourceTag extends BodyTagSupport {

	private static final long serialVersionUID = -572028891027740273L;

	private static Log log = LogFactory.getLog(ResourceTag.class);

	/**
	 * display type
	 */
	public static final String BUTTON = "button";
	public static final String ANCHOR = "a";
	public static final String SUBMIT = "submit";

	/**
	 * value of current HttpServletRequest
	 */
	private HttpServletRequest request;
	/**
	 * url of the tag
	 */
	private String url = null;

	/**
	 * value could be a key in a property file or a real displayed value 
	 */
	private String value = null;

	/**
	 * type of the resource, just support button, anchor, submit
	 */
	private String type = null;

	/**
	 * other attributes of the element, such as class, id, name etc.
	 */
	private String otherAttribute = null;

	@Override
	public int doStartTag() throws JspException {
			
			String content = "";
			
			if (type.equals(BUTTON)) {
				content = createButton(value);
			} else if (type.equals(ANCHOR)) {
				content = createAnchor(value);
			} else if (type.equals(SUBMIT)) {
				content = createSubmit(value);
			}

			content = MessageFormat.format(content,(otherAttribute == null || otherAttribute.equals("")) ? "": otherAttribute);

			JspWriter out = pageContext.getOut();

			try {
				out.print(content);
				out.flush();
			} catch (IOException e) {
				log.error(e);
			}
			

		return super.doStartTag();
	}

	private String createSubmit(String value) {
		return "<input type=\"submit\" value=\""+ value +"\" {0} />";
	}

	private String createButton(String value) {
		return "<input type=\"button\" value=\""+ value +"\" {0} />";
	}

	private String createAnchor(String value) {
		return "<a {0}>" + value + "</a>";
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setOtherAttribute(String otherAttribute) {
		this.otherAttribute = otherAttribute;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
