package com.sxt.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.util.CalculatorUtil;

/**
 * 计算器controller
 * @author 
 * @date：2015年11月12日 下午8:48:54
 * 
 */
@Controller
@RequestMapping("calculator")
public class CalculatorController {

	/**
	 * 查询计算器还款list
	 * 
	 * @param money
	 * 				投资金额
	 * @param durationType
	 * 				投资期限类型
	 * @param duration
	 * 				投资期限
	 * @param rate
	 * 				年利率
	 * @param repayType
	 * 				还款方式
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findRepaymentList.htm")
	public String findRepaymentList(BigDecimal money, String durationType, Integer duration, 
			BigDecimal rate, Integer repayType, HttpServletResponse response) {
		List<Map<String, String>> list = CalculatorUtil.
				calculator(repayType, duration, money, rate.divide(BigDecimal.valueOf(100)), durationType);
		return JSONArray.fromObject(list).toString();
	}
	
	/**
	 * 跳转到投资计算器
	 * @return
	 */
	@RequestMapping("toCalculator.htm")
	public String toCalculator() {
		return "calculator";
	}
}
