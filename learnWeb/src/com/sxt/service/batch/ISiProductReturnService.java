package com.sxt.service.batch;
/**
 * 散标手工还款
 * @author pillar liu
 *
 */
public interface ISiProductReturnService {

	/**
	 * 手动还款
	 * @param productId
	 * @param sortOrder
	 */
    void handwork(String productId,Integer sortOrder) throws Exception;
}
