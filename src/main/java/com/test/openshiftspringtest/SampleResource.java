package com.test.openshiftspringtest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.openshiftspringtest.mongo.Employee;
import com.test.openshiftspringtest.mongo.EmployeeRepository;
import com.test.openshiftspringtest.mysql.Student;
import com.test.openshiftspringtest.mysql.StudentRepository;

@RestController
public class SampleResource {
	
	@Autowired
	private EmployeeRepository empMongoRepo;
	
	@Autowired
	private StudentRepository stuMySqlRepo;

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
    		
    		map.put("mysql.host", System.getenv("MARIADB_SERVICE_HOST"));
    		map.put("mysql.port", System.getenv("MARIADB_SERVICE_PORT"));
    		map.put("mysql.database", System.getenv("MARIADB_DATABASE"));
    		map.put("mysql.username", System.getenv("MARIADB_USERNAME"));
    		map.put("mysql.password", System.getenv("MARIADB_PASSWORD"));
    		
    		System.out.println("******* Map: "+map);
    		
        return map;
    }
    
    @RequestMapping("/save/mongo")
    public String saveEmployee() {
    		Employee emp = new Employee();
    		emp.setId(UUID.randomUUID().toString());
    		emp.setName("Vamsi");
    		emp.setAddress("San Jose");
    		empMongoRepo.save(emp);
    		System.out.println("Success ...");
    		
        return "Saved Successfully to Mongo";
    }
    
    @RequestMapping("/save/mysql")
    public String saveStudent() {
    		Student st = new Student();
    		st.setName("Vamsi "+new Random().nextInt(100));
    		st.setAddress("San Jose");
    		stuMySqlRepo.save(st);
    		System.out.println("Success ...");
    		
        return "Saved Successfully to MySQL";
    }
}