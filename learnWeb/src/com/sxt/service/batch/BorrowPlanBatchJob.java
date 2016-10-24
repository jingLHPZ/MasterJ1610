package com.sxt.service.batch;

import org.springframework.beans.factory.annotation.Autowired;

import com.sxt.inter.IBatchService;
import com.sxt.service.product.NewHandProductService;

public class BorrowPlanBatchJob implements IBatchService{

	@Autowired
	NewHandProductService iNewHandProductService;
	
	@Override
	public void batch() {
		// TODO Auto-generated method stub
	}

}
