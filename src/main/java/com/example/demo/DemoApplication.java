package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
//@RestController /*rest controller creates the connection method hello(), implementing rest api, by calling the rest point
//				and the rest point is method hello() as it has getmapping annotation */

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@GetMapping
////	public List<String> hello()
////	{
////		return List.of("Kajal", "Kasat"); // output : ["Kajal","Kasat"]
////	}
//
//	public List<Student> hello()
//	{
//		return List.of(new Student(1L,
//				"MERIAN",
//				"ck@gmail.com", LocalDate.of(2020,12,01),20));
//
//	}


}
