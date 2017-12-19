package com.test.openshiftspringtest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.openshiftspringtest.mongo.Employee;
import com.test.openshiftspringtest.mongo.EmployeeRepository;

@RestController
public class SampleResource {
	
	@Autowired
	private EmployeeRepository empRepo;

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
    		map.put("mongodb.username", System.getenv("MONGODB_USERNAME"));
    		map.put("mongodb.password", System.getenv("MONGODB_PASSWORD"));
    		map.put("mongodb.database", System.getenv("MONGODB_DATABASE"));
    		
    		System.out.println("******* Map: "+map);
    		
        return map;
    }
    
    @RequestMapping("/save")
    public String saveEmployee() {
    		Employee emp = new Employee();
    		emp.setId(UUID.randomUUID().toString());
    		emp.setName("Vamsi");
    		emp.setAddress("San Jose");
    		empRepo.save(emp);
    		System.out.println("Success ...");
    		
        return "Saved Successfully";
    }
}