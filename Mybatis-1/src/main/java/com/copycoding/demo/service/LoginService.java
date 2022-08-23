package com.copycoding.demo.service;

import java.util.List;

import com.copycoding.demo.vo.EnterpriseMemberVo;

public interface LoginService {
	List<EnterpriseMemberVo> selectListEnterpriseMember(EnterpriseMemberVo vo);
}
