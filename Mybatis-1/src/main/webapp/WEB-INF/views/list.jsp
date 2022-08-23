<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
사용자를 조회하는 ModelAndView 테스트 페이지입니다.
<br>
<br>
<table border="1">
	<tr>
		<th>아이디</th>
		<th>회사구분</th>
		<th>부서코드</th>
	</tr>
	<c:forEach var="l" items="${list}">
		<tr>
			<td>${l.user_id}</td>
			<td>${l.company_partition_code}</td>
			<td>${l.dept_code}</td>
		</tr>
	</c:forEach>
</table>