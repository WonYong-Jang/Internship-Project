<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="js/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
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

.star-input>.input, /* .star-input>.input>label:hover, */
	/* .star-input>.input>input:focus+label, */ .star-input>.input>input:checked+label
	{
	display: inline-block;
	vertical-align: middle;
	background: url('img/grade_img.png') no-repeat;
}

.star-input {
	display: inline-block;
	white-space: nowrap;
	width: 225px;
	height: 40px;
	padding: 25px;
	line-height: 30px;
}

.star-input>.input {
	display: inline-block;
	width: 150px;
	background-size: 150px;
	height: 28px;
	white-space: nowrap;
	overflow: hidden;
	position: relative;
}

.star-input>.input>input {
	position: absolute;
	width: 1px;
	height: 1px;
	opacity: 0;
}

star-input>.input.focus {
	outline: 1px dotted #ddd;
}

.star-input>.input>label {
	width: 30px;
	height: 0;
	padding: 28px 0 0 0;
	overflow: hidden;
	float: left;
	cursor: pointer;
	position: absolute;
	top: 0;
	left: 0;
}
/* .star-input>.input>label:hover, */
/* .star-input>.input>input:focus+label, */
.star-input>.input>input:checked+label {
	background-size: 150px;
	background-position: 0 bottom;
}

.star-input>.input>label:label {
	background-image: none;
}

.star-input>.input>label[for="p1"] {
	width: 30px;
	z-index: 5;
}

.star-input>.input>label[for="p2"] {
	width: 60px;
	z-index: 4;
}

.star-input>.input>label[for="p3"] {
	width: 90px;
	z-index: 3;
}

.star-input>.input>label[for="p4"] {
	width: 120px;
	z-index: 2;
}

.star-input>.input>label[for="p5"] {
	width: 150px;
	z-index: 1;
}

.star-input>output {
	display: inline-block;
	width: 60px;
	font-size: 18px;
	text-align: right;
	vertical-align: middle;
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
</style>
</head>
<body>
	<div class="ui_container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light rounded">
		<div class="collapse navbar-collapse" id="navbarsExample09">
			<ul class="navbar-nav nav nav-tabs mr-auto" role="tablist">
				<li><a href="/mybatis" class="nav-link" role="tab">진단</a></li>
				<li class="active"><a href="evalTablePage"
					class="nav-link active" role="tab">평가</a></li>
			</ul>
			<form class="form-inline my-2 my-md-0 col-sm-4" id="evalRuleForm">
				<form class= "navbar-form pull-left">
					<input class="form-control" type="text" name="patientName" id="search" placeholder="환자이름" aria-label="환자이름"/>
					<button type="submit" class="btn">검색</button>
					<button type="submit" class="btn btn-danger">LogOut</button>
				</form>
			</form>
		</div>
		</nav>
		<div class="tab-content">
			<div class="tab-pane active" id="tab2">
				<div class="container-fluid">
					<div class="col-md-12 mx-auto">
						<div class="tab-content" role="tablist">
							<table width="700" cellpadding="0" cellspacing="0" border="1" id="evalRuleTable">
								<thead>
									<tr>
										<th>환자번호</th>
										<th>환자이름</th>
										<th>날짜</th>
										<th>점수</th>
										<th>코멘트</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${memberList}" var="member">
										<tr>
											<td>${member.patientNum}</td>
											<td>${member.patientName}</td>
											<td>${member.date}</td>
											<td>${member.score}</td>
											<td><a
												href="patientDiagnosis_view?patientNum=${member.patientNum}">${member.comment}</a>
											</td>
										</tr>
									</c:forEach>
									<tr>
										<td colspan="5"><a href="/mybatis">뒤로가기</a></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br/><br/><br/><br/>
	<hr/>
	<h2>더미 데이터 생성</h2>
	<table width="700" cellpadding="0" cellspacing="0" border="1">
		<form action="ruleEvaluate" method="post">
			<tr>
				<td>환자번호</td>
				<td><input type="text" name="patientNum" size="30"></td>
			</tr>
			<tr>
				<td>환자이름</td>
				<td><input type="text" name="patientName" size="30"></td>
			</tr>
			<tr>
				<td>점수</td>
				<td><input type="text" name="score" size="30"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="comment" row="10"></textarea></td>
			</tr>
			<tr><td colspan="2"><input type="submit" value="입력"></td></tr>
		</form>
	</table>
	
	<script type="text/javascript">
		var elements = document.getElementsByTagName("div");
		// 모든 영역 접기
		for (var i = 0; i < elements.length; i++) {
			if (elements[i].className == "elements") {
				elements[i].style.display = "none";
			} else if (elements[i].className == "label") {
				elements[i].onclick = switchDisplay;
			}
		}
		// 상태에 따라 접거나 펼치기
		function switchDisplay() {
			var parent = this.parentNode;
			var target = parent.getElementsByTagName("div")[1];
			if (target.style.display == "none") {
				target.style.display = "block";
			} else {
				target.style.display = "none";
			}
			return false;
		}
	</script>
	<script type="text/javascript" src="js/diagnosis.js?ver=1.111"></script>
	<script type="text/javascript" src="js/evalRule.js?ver=1"></script>
	<script src="js/star.js"></script>
	<script src="js/assets/js/vendor/popper.min.js"></script>
	<script src="js/js/dist/util.js"></script>
	<script src="js/js/dist/tab.js"></script>
	<script src="js/js/dist/dropdown.js"></script>
</body>
</html>