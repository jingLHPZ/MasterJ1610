package com.sxt.inter;

import java.util.List;

import com.sxt.models.LdMessageTemplate;

public interface ILdMessageTemplate {
	public void add(LdMessageTemplate message);
	public List queryMessageTemplateList(Integer messageType);
	
	/**
	 * 查询模板
	 * @param template
	 * @return
	 */
	public LdMessageTemplate findMessageTemplate(LdMessageTemplate template);
	public void del(Integer messageType);
}
