package com.poscoict.aoptest.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.poscoict.aoptest.service.ProductService;
import com.poscoict.aoptest.vo.ProductVo;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		//container안에있는 bean객체를 불러오는 것
		ProductService ps = ac.getBean(ProductService.class);
		ProductVo vo = ps.find("tv");
		System.out.println(vo);
		((AbstractApplicationContext)ac).close();
	}
}
