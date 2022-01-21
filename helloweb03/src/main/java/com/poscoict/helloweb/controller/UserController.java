package com.poscoict.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 
 * @ReuqestMapping: 클래스(타입) + 메소드(핸들러)
 * 
 */

//디스패처서블릿이 controller에 핸들러에 있는 파라미터들을 최대한 맞춰주려고 노력한다 

@Controller
@RequestMapping("/user")
public class UserController {
	
	// get방식으로 join으로 들어오면 join 을 실행하고 join.jsp로 forwarding 
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	//hello03하면 자동으로 슬래쉬가 붙기때문에 슬래쉬를 붙혀둔 것 
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo vo) {
		System.out.println(vo);
		return "redirect:/";
	}
}
