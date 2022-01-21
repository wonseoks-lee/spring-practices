package com.poscoict.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	// get방식일때는 joinform보여주고 post방식으로 오면 join하는
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}

	// hello03하면 자동으로 슬래쉬가 붙기때문에 슬래쉬를 붙혀둔 것
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVo vo) {
		System.out.println(vo);
		return "redirect:/";
	}
	/*
	 * 만일, n이라는 이름의 파라미터가 없는 경우
	 * 400 bad request 에러가 발생한다.
	 */
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) { // request parameter가 n으로 넘어오면 name변수에 셋팅해줘
		System.out.println(name);
		return "UserController.update()";
	}
	
	// 추천 
	// required true로 하면 위의 코드랑 같음. 그러나 디폴트 벨류를 설정해줌으로서 null 로 요청와도 400안뜸 
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(
			@RequestParam(value="n", required=true, defaultValue="") String name,
			@RequestParam(value="a", required=true, defaultValue="0") Integer age
			) { // request parameter가 n으로 넘어오면 name변수에 셋팅해줘
		System.out.println("------"+name+"------");
		System.out.println("-----"+age+"-----");
		return "UserController.update()";
	}
}
