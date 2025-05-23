package com.insurance.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class DemoApplication {

	public static void main(String[] args) {
		log.info("애플리케이션 시작");
		SpringApplication.run(DemoApplication.class, args);
		log.info("애플리케이션 실행 완료");
	}

}
