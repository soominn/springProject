package com.copycoding.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.copycoding.demo.dao.UsersDao;
import com.copycoding.demo.vo.UsersVo;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersDao usersDao;
	
	@Override
	public List<UsersVo> selectListUsers(UsersVo vo, String page, String rows) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("page", page);
		map.put("rows", rows);
		return usersDao.selectListUsers(map);
	}
	
	@Override
	public UsersVo searchUser(String user_id) throws Exception {
		return usersDao.searchUser(user_id);
	}
	
	@Override
	public int getCount() throws Exception {
		return usersDao.getCount();
	}
}
