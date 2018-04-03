package com.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

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

		// 通过 assertThat
		//assertThat(entity.getBody())
	}

	@Test
	public void list(){
		ResponseEntity<String> entity = testRestTemplate.getForEntity("/car_list",String.class);
		System.out.println(entity.getBody());
	}
	/**
	 *  加载上下文
	 */
	@Test
	public void contextLoads() {
	}

}
