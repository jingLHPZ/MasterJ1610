package com.sxt.test;

import org.junit.Assert;
import org.junit.Test;

import com.sxt.base.utils.PropertyLoader;

public class TestPropertyLoader {

	@Test
	public void test(){
		Assert.assertTrue(PropertyLoader.getPropertyValue("upload", "file.path").equals("D:/conpdf/"));
	}
}
