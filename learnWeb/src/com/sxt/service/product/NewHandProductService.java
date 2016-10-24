package com.sxt.service.product;

import java.math.BigDecimal;
import java.util.List;

import com.sxt.inter.dto.LocalUserDto;
import com.sxt.models.NewHandProduct;

public interface NewHandProductService {
	
	public List<NewHandProduct> fQueryProduct();
	
	public NewHandProduct fqueryProductById(String productId);
	
	public void fUpdateStateByProid(String productId);
	
	public void payProduct(String productId, BigDecimal investmoney, String systemtradeno, LocalUserDto lud, String ip);
	
	public String[] fQueryProductIds();
	
	public String queryNewHandProduct(String proid);
}
