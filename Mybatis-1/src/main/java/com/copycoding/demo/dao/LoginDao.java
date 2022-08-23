package com.copycoding.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.copycoding.demo.vo.EnterpriseMemberVo;

@Mapper
public interface LoginDao {
	public List<EnterpriseMemberVo> selectListEnterpriseMember(EnterpriseMemberVo enterpriseMemberVo);
}
