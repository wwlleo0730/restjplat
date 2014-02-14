package com.restjplat.quickweb.web.restServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.restjplat.core.webserver.RestErrorCode;
import com.restjplat.core.webserver.RestServiceException;

/**
 * 必须继承BaseWebServerController
 * @author leos
 *
 */
@Controller
public class RestSimpleController extends BaseWebServerController{
	
	@ResponseBody
	@RequestMapping("/book/add")
	public Object addBook(
			@RequestParam(value="a") String a,
			@RequestParam(value="b") String b,
			@RequestParam(value="c") String c
			){
		Map<String,Object> dataMap = new HashMap<String, Object>();
		return dataMap;
	}
	
	@ResponseBody
	@RequestMapping("/good")
	public Object rgood(){
		Map<String,String> dataMap = new HashMap<String, String>();
		dataMap.put("name", "tom");
		dataMap.put("age", "23");
		dataMap.put("sex", "male");
		return dataMap;
	}
	
	
	/**
	 * 主动输出错误response
	 * @return  
	 */
	@SuppressWarnings("unused")
	@ResponseBody
	@RequestMapping(value = "/ex/ex1", method = { RequestMethod.GET })
	public Object goEx1 () {
		//某种业务出错
		if(2>1){
			List<String> list = Lists.newArrayList();
			list.add("1");
			list.add("2");
			//这里报空指针的runtime错误
			list.get(3);
			return "44";
		}else{
			return "55";
		}
	}
	
	
	/**
	 * 主动输出错误response
	 * @return  
	 */
	@SuppressWarnings("unused")
	@ResponseBody
	@RequestMapping(value = "/ex/ex2", method = { RequestMethod.GET })
	public Object goEx2 () {
		//某种业务出错
		if(2>1){
			throw new RestServiceException("出错了");
		}
		return "";
	}
	
	/**
	 * 主动输出错误response
	 * @return  
	 */
	@SuppressWarnings("unused")
	@ResponseBody
	@RequestMapping(value = "/ex/ex3", method = { RequestMethod.GET })
	public Object goEx3 () {
		//某种业务出错
		if(2>1){
			throw new RestServiceException("出错",RestErrorCode.uri_not_found.getValue());
		}
		return "";
	}


}
