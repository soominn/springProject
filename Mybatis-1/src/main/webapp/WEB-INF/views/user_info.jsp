<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
사용자를 조회하는 ModelAndView 테스트 페이지입니다.
<br>
<br>
아이디 : ${user_data.user_id}<br>
회사구분 : ${user_data.company_partition_code}<br>
부서코드 : ${user_data.dept_code}<br>