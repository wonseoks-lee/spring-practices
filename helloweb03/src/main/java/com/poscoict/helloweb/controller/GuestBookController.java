package com.poscoict.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/* 
 * @RequestMapping: 클래스(타입) 단독 매핑
 * 
 * 
 */
@Controller
@RequestMapping("/guestbook/*") //guestbook의 모든 경로, 별로 비추천 
public class GuestBookController {
	
	@ResponseBody // 문구 자체를 뽑는다 
	@RequestMapping
	public String list() {
		return "GuestbookController.list()";
	}
	
	@ResponseBody // 문구 자체를 뽑는다 
	@RequestMapping
	public String delete() {
		return "GuestbookController.delete()";
	}
}
