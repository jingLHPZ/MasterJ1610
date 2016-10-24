package com.sxt.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.sxt.models.SiProduct;
import com.sxt.service.Base64Encrypt;
import com.sxt.service.product.SiProductService;
import com.sxt.util.SHAUtil;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
@TransactionConfiguration(defaultRollback = false)
public class TestSiProductImpl extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
    private SiProductService siProductService;
    
    public TestSiProductImpl(){
        System.out.println("初始化测试类....");
    }
    @Before
    public void setUp() throws Exception{
        System.out.println("测试开始....");
    }
    
    @After
    public void tearDown() throws Exception{
        System.out.println("测试结束!!");
    }
    @Autowired
	private Base64Encrypt base64Encrypt;
    
    @Test
    public void testQueryUserList(){
        try {
        	SiProduct product = siProductService.fQueryProById("100000125");
            System.out.println(product.getProductName());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void tear() throws Exception{
    	String 	user_pass = SHAUtil.encryptSHA1(base64Encrypt.encrypt("1234"));
        System.out.println("ssss"+user_pass);
    }
    
    
}
