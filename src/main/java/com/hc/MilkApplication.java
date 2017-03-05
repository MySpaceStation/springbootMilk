package com.hc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@MapperScan("com.hc.mapper")
@SpringBootApplication
@EnableRedisHttpSession
public class MilkApplication {

	public static void main(String[] args) {
		SpringApplication.run(MilkApplication.class, args);
	}
}
