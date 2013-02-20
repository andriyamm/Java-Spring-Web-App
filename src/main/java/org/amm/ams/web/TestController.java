package org.amm.ams.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	public String test1(Map<String, Object> params, HttpServletRequest request){
		
		// get user ip
		final String userIpAddress = request.getRemoteAddr();
		// get header info
		final String userAgent = request.getHeader("user-agent");
		// get server name
		final String serverName = request.getServerName();
		
		params.put("ip", userIpAddress);
		params.put("userAgent", userAgent);
		params.put("serverName", serverName);
		
		return "list1";
	}
}
