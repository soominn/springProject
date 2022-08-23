package com.copycoding.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.copycoding.demo.dao.LoginDao;
import com.copycoding.demo.vo.EnterpriseMemberVo;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginDao loginDao;
	
	@Override
	public List<EnterpriseMemberVo> selectListEnterpriseMember(EnterpriseMemberVo vo) {
		return loginDao.selectListEnterpriseMember(vo);
	}
}
