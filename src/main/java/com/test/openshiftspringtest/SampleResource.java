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
    		map.put("mongodb.host", System.getenv("MONGODB_SERVICE_HOST"));
    		map.put("mongodb.port", System.getenv("MONGODB_SERVICE_PORT"));
    		map.put("mongodb.username", System.getenv("OPENSHIFT_MONGODB_DB_USERNAME"));
    		map.put("mongodb.password", System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD"));
    		
    		System.out.println("******* Map: "+map);
    		
        return map;
    }
}