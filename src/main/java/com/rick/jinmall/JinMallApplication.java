package com.rick.jinmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class JinMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(JinMallApplication.class, args);
	}

}
