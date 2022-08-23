package com.copycoding.demo.service;

import java.util.List;

import com.copycoding.demo.vo.UsersVo;

public interface UsersService {
	List<UsersVo> selectListUsers(UsersVo vo, String page, String rows);
	UsersVo searchUser(String user_id) throws Exception;
	int getCount() throws Exception;
}
