package com.copycoding.demo.service;

import java.util.List;
import java.util.Map;

import com.copycoding.demo.vo.UsersVo;

public interface UsersService {
	List<UsersVo> selectListUsers(UsersVo vo, String page, String rows);
	UsersVo searchUser(String user_id) throws Exception;
	int getCount(UsersVo vo) throws Exception;
	
	void userInfoUpdate(Map<String, Object> reqMap) throws Exception;
}
