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
    public Map<String, Object> test() {
    		Map<String, Object> map = new HashMap<String, Object>();
    		map.put("message", "Hello World");
    		map.put("date", new Date().toString());
    		
    		Map<String, String> mongomap = new HashMap<String, String>();
    		mongomap.put("mongodb.host", System.getenv("MONGODB_SERVICE_HOST"));
    		mongomap.put("mongodb.port", System.getenv("MONGODB_SERVICE_PORT"));
    		mongomap.put("mongodb.username", System.getenv("MONGODB_USERNAME"));
    		mongomap.put("mongodb.password", System.getenv("MONGODB_PASSWORD"));
    		mongomap.put("mongodb.database", System.getenv("MONGODB_DATABASE"));
    		map.put("mongo", mongomap);
    		
    		Map<String, String> mysqlmap = new HashMap<String, String>();
    		mysqlmap.put("mysql.host", System.getenv("MARIADB_SERVICE_HOST"));
    		mysqlmap.put("mysql.port", System.getenv("MARIADB_SERVICE_PORT"));
    		mysqlmap.put("mysql.database", System.getenv("MARIADB_DATABASE"));
    		mysqlmap.put("mysql.username", System.getenv("MARIADB_USERNAME"));
    		mysqlmap.put("mysql.password", System.getenv("MARIADB_PASSWORD"));
    		map.put("mysql", mysqlmap);
    		
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