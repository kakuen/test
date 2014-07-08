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
		
		<form action="rpbytm.do" method="post" class="search-box">
			時間別:<br>
			<td><input type="date" value="2011-09-08-17-45" name ="time"/></td>
			<a href ="RpByCtg.jsp">カテゴリ別</a>
			<input type="submit" value="Report" />
		</form>
		
		<img src="http://chart.apis.google.com/chart?cht=p3&amp;
			chd=t:35,30,25,10&amp;
			chs=400x150&amp;
			chl=Tokyo|Osaka|Nagoya|Hakata&amp;
			chco=CC0000|CCCC00|00CC00|0000CC"
 			width="400" height="150" alt="円グラフのサンプル"
 			>
			
		</body>
	</html>