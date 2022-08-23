<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jqGrid 테스트</title>
	<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/jquery-ui.css"/>
	<link rel="stylesheet" type="text/css" media="screen" href="/resources/css/ui.jqgrid.css"/>
	
	<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="/resources/js/i18n/grid.locale-kr.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.jqGrid.min.js"></script>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#jqGrid").jqGrid({
				url: 'http://localhost:9090/users',
				mtype: "GET",
				datatype: "json",
				colModel: [
					{ label: '아이디', name: 'user_id', key: true, width: 75 },
					{ label: '이름', name: 'user_name_kr', width: 80 },
					{ label: '회사', name: 'company_partition_code', width: 150 },
					{ label: '부서코드', name: 'dept_code', width: 150 }
				],
				viewrecords: true,
				height: 250,
				rowNum: 10,
				rowList:[10,20,30],
				loadonce:true,
				pager: "#jqGridPager"
			});
		});
	</script>
	<table id="jqGrid"></table>
	<div id="jqGridPager"></div>
</body>
</html>