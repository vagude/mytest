package com.test.openshiftspringtest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(method=RequestMethod.GET, path="/")
	public Map<String, String> helloworld() {
		System.out.println("Hello world .... Date: "+new Date());
		Map<String, String> respmap = new HashMap<String, String>();
		respmap.put("message", "Hello World");
		respmap.put("date", new Date().toString());
		System.out.println("Resp Map: "+respmap);
		return respmap;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/test")
	public Map<String, String> test() {
		System.out.println("Hello world .... Date: "+new Date());
		Map<String, String> respmap = new HashMap<String, String>();
		respmap.put("message", "Hello World");
		respmap.put("date", new Date().toString());
		System.out.println("Resp Map: "+respmap);
		return respmap;
	}
}
