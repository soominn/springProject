package com.copycoding.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.copycoding.demo.JsonObj;
import com.copycoding.demo.service.UsersService;
import com.copycoding.demo.vo.UsersVo;

@Controller
public class UsersController {
	@Autowired
	UsersService usersService;
	
//	@RequestMapping(value="/userList")
//	public ModelAndView userList(@ModelAttribute("searchVO") UsersVo usersVo, Model model) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		model.addAttribute("list", usersService.selectListUsers(usersVo));
//		mv.setViewName("list");
//		return mv;
//	}
	
	@RequestMapping("/user/{user_id}")
	private String search_user(@PathVariable String user_id, Model model) throws Exception{
		model.addAttribute("user_data", usersService.searchUser(user_id));
		return "user_info";
	}
	
	@RequestMapping("/users")
	@ResponseBody
	public JsonObj selectListUsers(@ModelAttribute("searchVO") UsersVo usersVo, @RequestParam(value="page", required=false, defaultValue="1") String page, @RequestParam(value="rows", required=false, defaultValue="") String rows) throws Exception {
		List<UsersVo> eList = usersService.selectListUsers(usersVo, page, rows);
		int totalCnt = usersService.getCount();
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> tempMap = new HashMap<String, Object>();
		// list 형식으로 된 데이터의 크기를 구함.
		int size = eList.size();
		for(int i=0; i<size; i++) {
			tempMap.put("user_id" , eList.get(i).getUser_id());
			tempMap.put("company_partition_code", eList.get(i).getCompany_partition_code());
			tempMap.put("dept_code", eList.get(i).getDept_code());
			tempMap.put("user_name_kr", eList.get(i).getUser_name_kr());
			resultList.add(tempMap);
			tempMap = new HashMap<String, Object>();
		}
		
		JsonObj jsonObj = new JsonObj();
		jsonObj.setRecords(totalCnt);
		jsonObj.setTotal(totalCnt/Integer.parseInt(rows));
		jsonObj.setPage(Integer.parseInt(page));
		jsonObj.setRows(resultList);
		return jsonObj;
	}

	@RequestMapping(value="/jqgrid_test", method=RequestMethod.GET)
	public String jqgrid_test() {
		return "jqgrid_test";
	}
}
