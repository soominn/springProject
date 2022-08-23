package com.copycoding.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.copycoding.demo.service.LoginService;
import com.copycoding.demo.vo.EnterpriseMemberVo;

@Controller
public class TestController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/member/")
	public @ResponseBody List<EnterpriseMemberVo> selectListEnterpriseMember(@ModelAttribute("searchVO") EnterpriseMemberVo enterpriseMemberVo, ModelMap model) throws Exception {
		List<EnterpriseMemberVo> eList = loginService.selectListEnterpriseMember(enterpriseMemberVo);
		return eList;
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/testMv")
	public ModelAndView root() {
		ModelAndView mv = new ModelAndView();
		
		List<String> listTest = new ArrayList<String>();
		
		listTest.add("test1");
		listTest.add("test2");
		listTest.add("test3");
		
		mv.addObject("listTest", listTest);
		mv.addObject("objectTest", "테스트입니다.");
		mv.setViewName("testMv");
		return mv;
	}
}
