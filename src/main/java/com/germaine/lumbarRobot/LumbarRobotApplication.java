package com.germaine.lumbarRobot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.germaine.lumbarRobot.mapper")
public class LumbarRobotApplication {

	public static void main(String[] args) {
		SpringApplication.run(LumbarRobotApplication.class, args);
	}
}
