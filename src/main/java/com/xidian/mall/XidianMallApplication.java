package com.xidian.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author LDBX
 */
@SpringBootApplication
@MapperScan(basePackages = "com.xidian.mall.model.dao")
@EnableSwagger2
@EnableCaching
public class XidianMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(XidianMallApplication.class, args);
	}

}
