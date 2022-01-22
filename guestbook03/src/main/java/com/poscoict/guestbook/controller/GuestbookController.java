package com.poscoict.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String login(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}

	@RequestMapping("delete/{no}")
	public String delete(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "/WEB-INF/views/deleteform.jsp";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(GuestbookVo vo) {
		guestbookRepository.delete(vo);
		return "redirect:/";
	}
}
