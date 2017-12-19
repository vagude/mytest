package com.test.openshiftspringtest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleResource {

    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/test")
    public Map<String, String> test() {
    		Map<String, String> map = new HashMap<String, String>();
    		map.put("message", "Hello World");
    		map.put("date", new Date().toString());
    		
    		System.out.println("******* Map: "+map);
    		
        return map;
    }
}