package com.copycoding.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.copycoding.demo.vo.UsersVo;

@Mapper
public interface UsersDao {
	public List<UsersVo> selectListUsers(Map<String, Object> usersVo);
	public UsersVo searchUser(String user_id) throws Exception;
	public int getCount(Map<String, Object> userVo) throws Exception;
	
	public void userInfoUpdate(Map<String, Object> reqMap) throws Exception;
}
