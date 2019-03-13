package com.fan1111;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fan1111.mapper")
public class BrickApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrickApplication.class, args);
	}
}
