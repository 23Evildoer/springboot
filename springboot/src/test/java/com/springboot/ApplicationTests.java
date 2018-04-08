package com.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

// 基于 Spring boot(junit)  单元测试类
@RunWith(SpringRunner.class)
// 说明 Spring boot 测试类
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public  void  hello(){
		ResponseEntity<String> entity = testRestTemplate.getForEntity("/hello",String.class);
		System.out.println(entity.getBody());
		System.out.println(entity.getStatusCodeValue());

		// 通过 assertThat
		assertThat(entity.getBody()).isEqualTo("Hello Spring Boot");
	}

	@Test
	public void list(){
		ResponseEntity<String> entity = testRestTemplate.getForEntity("/car_list",String.class);
		System.out.println(entity.getBody());
		System.out.println(entity.getStatusCodeValue());

		//assertThat(entity.getBody()).isEqualTo("{\"code\":200,\"message\":\"查询成功\"}");
	}
	/**
	 *  加载上下文
	 */
	@Test
	public void contextLoads() {
	}

}
