package org.amm.ams.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {

	@RequestMapping("hi")
	public String test(){
		return "test";
	}
	
	@RequestMapping("ho")
	public String test1(){
		return "list1";
	}
}
