
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--<meta charset="utf-8">  -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/bootstrap.min2.css">

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

<script type="text/javascript" src="table/jquery.tablesorter.min.js"></script>
<link rel="stylesheet" href="table/blue_style.css" type="text/css">

<!-- Bootstrap core CSS -->
<title>위담한방병원</title>
<style>
h4 {
	margin: 40px 0 10px;
}

.noresize {
	resize: none;
	background-color: #EBEBEB;
}

.label {
	width: 290px;
	height: 40px;
	margin: 9px 0 0 0;
	padding: 2px;
	background-color: #EBEBEB;
	text-align: left;
	border: 1px solid #EBEBEB;
}

.elements {
	border: 1px solid #ccccff;
	padding: 7px;
	border: 1px solid #ffffff;
	width: 280px;
}

#evalRuleTable {
	text-align: left;
	font-size: 2rem;
	margin-left: auto;
	margin-right: auto;
}

#search {
	text-align: center;
}

h5 {
	border: 10px solid #ACE26D;
	background: #ACE26D
}

.span1 {
	background-color: #EBEBEB;
}

body {
	color: black;
	background-color: #FAFAFA;
}

.verticalLine {
	border-left: thick solid #ff0000;
}
</style>
</head>
<body>
	<div class="ui_container">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="collapse navbar-collapse" id="navbarsExample09">
			<ul class="navbar-nav nav nav-tabs mr-auto" role="tablist">
				<li><a href="/mybatis" class="nav-link" role="tab"
					style="color: black;">진단</a></li>
				<li class="active"><a href="evalTablePage"
					class="nav-link active" role="tab" style="color: black;">평가</a></li>
			</ul>
			<form class="form-inline" id="evalRuleForm">
				<form class="navbar-form pull-left">
					<input class="form-control" type="text" name="patientName"
						id="search" placeholder="환자이름" aria-label="환자이름" />
					<button type="submit" class="btn btn-primary">검색</button>
					<button type="submit" class="btn btn-danger">LogOut</button>
				</form>
			</form>
		</div>
		</nav>
		<div class="tab-content">
			<div class="tab-pane active" id="tab2">
				<table width="880" cellpadding="0" cellspacing="0" border="1"
					id="evalRuleTable" class="tablesorter">
					<thead>
						<tr>
							<th style="font-size: 1.5rem">환자번호</th>
							<th style="font-size: 1.5rem">환자이름</th>
							<th style="font-size: 1.5rem">날짜</th>
							<th style="font-size: 1.5rem">점수</th>
							<th style="font-size: 1.5rem">코멘트</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${memberList}" var="member">
							<tr>
								<td>${member.patientNum}</td>
								<td>${member.patientName}</td>
								<td>${member.date}</td>
								<td>${member.score}</td>
								<td><a href="#" onclick="patientHistory('${member.patientNum}','${member.date}')">${member.comment}</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<br /> <br />

				<ul class="nav justify-content-center">
					<form class="form-inline" id="search">
						<input type="number"
							style="font-size: 25px; width: 150px; text-align: center;"
							placeholder="최소점수" min="1" max="5">
						<h1>&nbsp;~&nbsp;</h1>
						<input type="number"
							style="font-size: 25px; width: 150px; text-align: center;"
							placeholder="최대점수" min="1" max="5">
							
						<button type="button" class="btn btn-secondary">검색</button>
					</form>
				</ul>
			</div>
		</div>
	</div>

	<script type="text/javascript">
       $(document).ready(function(){
          $("#evalRuleTable").tablesorter();
       });
       
    	// 룰 평가된 게시판 목록을 클릭했을때 이전 진료 내용으로 이동
       	function patientHistory(num,date) {
    		var patientNum = num;
    		var visitDate = date;
			
    	   	$.ajax({
    	    	type:"GET",
    			dataType: "json",
    			url: "${pageContext.request.contextPath}/patientDiagnosis_view",
    			data : {"patientNum":patientNum, "visitDate":visitDate},
    			success:function(result)
    			{
    				window.location = "${pageContext.request.contextPath}/";  
    			}
    	    });
    	}
    
    </script>
	<script type="text/javascript" src="js/diagnosis.js?ver=2.2225353393"></script>
	<script type="text/javascript" src="js/evalRule.js?ver=1.223553332"></script>

</body>
</html>
