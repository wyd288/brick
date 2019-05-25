package com.fanyi.scm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 * @author wangyds
 * @date 2019/04/11
 */
@SpringBootApplication
@MapperScan("com.fanyi.scm.mapper")
public class FyscmApplication {

	public static void main(String[] args) {
		SpringApplication.run(FyscmApplication.class, args);
	}

}
