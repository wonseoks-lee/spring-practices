package com.poscoict.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	// execution(접근지시자 returnType method이름(parameterType)
	// 풀패키지로 적어줘야한다 
	@Before("execution(public com.poscoict.aoptest.vo.ProductVo com.poscoict.aoptest.service.ProductService.find(String))")
	public void beforeAdvice() {
		System.out.println("---Before Advice---");
	}
	
	// 접근지시자 생략, * 모든 리턴타입, com..service.find(type) = *..*
	@After("execution(* *..*ProductService.*(..))")
	public void afterAdvice() {
		System.out.println("---After Advice---");
	}
	
	@AfterReturning("execution(* *..*ProductService.*(..))")
	public void afterReturningAdvice() {
		System.out.println("---After Returning Advice---");
	}
	
	@AfterThrowing(value="execution(* *..*.*.*(..))", throwing="ex")
	public void afterThrowingAdvice(Throwable ex) {
		System.out.println("---After Throwing Advice---");
	}
	
	@Around("execution(* *..*ProductService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		/* before */
		System.out.println("---Around(Before) Advice---");
		
		
		
		/* 
		 * PointCut method 실행 
		 */
		//파라미터 변경 
		Object[] params = {"Camera"};
		Object result = pjp.proceed(params);
		
		/* after */
		System.out.println("---Around(After) Advice---");
		
		
		return result;
	}
}
