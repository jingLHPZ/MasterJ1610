package com.sxt.inter;

import java.util.List;

import com.sxt.models.NewHandProduct;

public interface INewHandProduct {
	public List<NewHandProduct> fQueryProduct();
	public NewHandProduct fqueryProductById(String productId);
	public void fUpdateStateByProid(String productId);
	public String[] fQueryProductIds();
	
	public String queryNewHandProduct(String proid);
}
