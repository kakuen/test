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
		
		<form action="report.do" method="post" class="search-box">
			時間帯: <input type="text" name="time" /> 
			カテゴリ: <h:dropdown ds="${ds}" tbl="category" key="categoryId" value="categoryName" />
			<input type="submit" value="Show" />
		</form>
		
		<img src="http://chart.apis.google.com/chart?cht=p3&amp;
			chd=t:35,30,25,10&amp;
			chs=400x150&amp;
			chl=Tokyo|Osaka|Nagoya|Hakata&amp;
			chco=CC0000|CCCC00|00CC00|0000CC"
 			width="400" height="150" alt="円グラフのサンプル"
 			>
		
	
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