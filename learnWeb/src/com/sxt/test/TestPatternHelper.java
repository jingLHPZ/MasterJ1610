package com.sxt.test;

import org.junit.Assert;
import org.junit.Test;

import com.sxt.base.utils.PatternHelper;

public class TestPatternHelper {
	
	@Test
	public void test(){
		Assert.assertEquals(PatternHelper.getFormatName("15900550445"),"159**0445");
		Assert.assertEquals(PatternHelper.getFormatName("小希"),"小**");
		Assert.assertEquals(PatternHelper.getFormatName(null),"**");
	}

}
