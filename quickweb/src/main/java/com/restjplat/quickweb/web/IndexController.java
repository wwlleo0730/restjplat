package com.restjplat.quickweb.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Lists;

@Controller
public class IndexController {

	//根路径跳转
	@RequestMapping(value = {"/f","/",""})
	public String indexJump(HttpServletRequest request) {
		return "index";
	}
	
	@RequestMapping(value="/rightweb")
	public String rightPage(){
		return "rightweb";
	}
	
	@RequestMapping(value="/errorweb")
	public String errorPage(){
		List<String> list = Lists.newArrayList();
		list.add("1");
		list.add("2");
		//主动构建一个空指针的runtime错误
		list.get(3);
		return "errorweb";
	}

}
