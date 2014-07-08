<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>

	<html>
		<head>
			<meta charset="UTF-8">
			<title>Report</title>
			<link rel = "stylesheet" href = "style.css"/>	
		</head>
		
		<body>
		<div id="user-info">
			ようこそ ${employee.name} さん <a href="">Logout</a>
		</div>
		
		<form action="rpbyctg.do" method="post" class="search-box">
			カテゴリ別:  <h:dropdown ds="${ds}" tbl="category" key="categoryId" value="categoryName" />
			<a href ="RpByTm.jsp">時間別</a>
			<input type="submit" value="Report" />
		</form>
			
	
	<table border="0" cellspacing="1" cellpadding="0">
		<tr>
			<td valign="bottom"><img src="graph.gif" width="20" height="75"></td>
			<td valign="bottom"><img src="graph.gif" width="20" height="54"></td>
			<td valign="bottom"><img src="graph.gif" width="20" height="41"></td>
		</tr><tr>
			<td><font size="1">今月</font></td>
			<td><font size="1">先月</font></td>
			<td><font size="1">先々月</font></td>
		</tr>
	</table>
			
		</body>
	</html>