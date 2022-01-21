package com.poscoict.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poscoict.guestbook.repository.GuestbookRepository;
import com.poscoict.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	@Autowired
	private GuestbookRepository guestbookRepository;

	@RequestMapping("")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}

	@RequestMapping("add")
	public String login(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(
			@RequestParam(value = "no", required = true, defaultValue = "") Integer no,
			Model model) {
		model.addAttribute("no", no);
		return "/WEB-INF/views/deleteform.jsp";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(
			@RequestParam(value = "no", required = true, defaultValue = "0") String no,
			@RequestParam(value = "password", required = true, defaultValue = "") String password) {
		guestbookRepository.delete(no, password);
		return "redirect:/";
	}
}
