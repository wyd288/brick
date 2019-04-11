package com.fan1111;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 * @author wangyds
 * @date 2019/04/11
 */
@SpringBootApplication
@MapperScan("com.fan1111.mapper")
public class BrickApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrickApplication.class, args);
	}
}
