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
	
	<style type="text/css">
		div.left {
			width: 50%;
			float: left;
			box-sizing: border-box;
		}
		
		div.right {
			width: 50%;
			float: right;
			box-sizing: border-box;
		}
	</style>
</head>
<body>
	<h2>사용자 조회</h2>
	<div>
		이름 : <input id="search_name" type="text" name="search_name" value="">
		<button id="searchBtn">조회</button>
	</div>
	<br>
	<div>
		<div class="left">
			<table id="jqGrid"></table>
			<div id="jqGridPager"></div>
		</div>
		<div class="right">
			<form id="userInfoForm" name="userInfoForm">
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" id="td_user_id" name="user_id" value=""></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" id="td_user_name_kr" name="user_name_kr" value=""></td>
					</tr>
					<tr>
						<td>부서</td>
						<td><input type="text" id="td_dept_code" name="dept_code" value=""></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" id="td_e_mail" name="e_mail" value=""></td>
					</tr>
				</table>
				<div><button id="updateBtn">수정</button></div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	var lastsel = $("#jqGrid").getGridParam("selrow");

	$(document).ready(function() {
		$("#jqGrid").jqGrid({
			url: '/users',
			editurl: "/userInfoUpdate",
			mtype: "GET",
			datatype: "json",
			colName: ["user_id", "user_name_kr", "company_partition_code", "dept_code", "e_mail"],
			colModel: [
				{ label: '아이디', name: 'user_id', key: true, editable: false, width: 75 },
				{ label: '이름', name: 'user_name_kr', width: 80, editable: true },
				{ label: '회사', name: 'company_partition_code', width: 150, editable: true },
				{ label: '부서코드', name: 'dept_code', width: 150, editable: true },
				{ label: '이메일', name: 'e_mail', width: 150, editable: true }
			],
			viewrecords: true,
			height: 250,
			rowNum: 10,
			rowList: [10, 20, 30],
			pager: "#jqGridPager",
			/* onSelectRow: function(ids) {
				var sel = $("#jqGrid").getGridParam("selrow");
				jQuery.ajax({
					type: "GET",
					url: "/userInfo/" + sel,
					dataType: "JSON",
					success: function(data) {
						$("#td_user_name_kr").val(data.user_name_kr);
						$("#td_user_id").val(data.user_id);
						$("#td_dept_code").val(data.dept_code);
						$("#td_e_mail").val(data.e_mail);
					},
					complete: function(data) {
						
					},
					error: function(xhr, status, error) {
						console.log(error);
						alert("에러발생");
					}
				})
			}, */
			ondblClickRow: function(rowid) {
				if(rowid && rowid != lastsel) {
					jQuery('#jqGrid').jqGrid('saveRow', lastsel);
					jQuery('#jqGrid').jqGrid('editRow', rowid, true);
					lastsel = rowid;
				}
			},
			onSelectRow: function(rowid) {
				if(rowid && rowid != lastsel) {
					jQuery('#jqGrid').jqGrid('saveRow', lastsel);
					lastsel = null;
				}
			}
		});
		jQuery("#jqGrid").jqGrid('navGrid', "#jqGridPager", {edit: true, add: false, del: false});
		
		$("#searchBtn").click(function() {
			var jsonObj = {};
			jsonObj.user_name_kr = $("#search_name").val();
			
			jQuery("#jqGrid").setGridParam({
				page: 1,
				"postData":jsonObj
			}).trigger("reloadGrid");
		});
		
		$("#updateBtn").click(function() {
			var formData =  $("#userInfoForm").serialize();
			
			$.ajax({
				cache: false,
				url: "/userInfoUpdate",
				type: "POST",
				data: formData,
				success: function(data) {
					alert(data);
				},
				error: function(xhr, status) {
					alert(xhr + " : " + status);
				}
			});
		});
	});
</script>
</html>