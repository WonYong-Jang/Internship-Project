<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="js/assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<!--  <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>-->
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
				<li class="active"><a href="#tab1" data-toggle="tab"
					class="nav-link active" role="tab">진단</a></li>
				<li><a href="evalTablePage" class="nav-link" role="tab">평가</a></li>
			</ul>
			<form class="form-inline">
				<form class="navbar-form pull-left">
					<input class="form-control" type="text" name="pName"
						id="searchPatient" placeholder="환자이름" aria-label="환자이름">
					<button type="button" class="btn" id="searchButton">검색</button>
					<button type="button" class="btn btn-danger">LogOut</button>
				</form>
			</form>
			<table id="searchPtable">
				<tbody>
				</tbody>
			</table>
		</div>
		</nav>
		<div class="tab-content">
			<div class="tab-pane active" id="tab1">
				<div class="container-fluid">
					<div class="col-md-12 mx-auto">
						<div class="tab-content" role="tablist">
							<div class="tab-pane active" id="home" role="tabpanel">
								<div class="row">
									<div class="col-md-4 mx-auto">
										<div class="row">
											<div class="col-md-6 mx-auto">
												<img src="img/설진.png" style="width: 80%; height: 80%"
													alt="설진">
											</div>
											<div class="col-md-6 mx-auto">
												<textarea style="width: 100%; height: 78%" class="noresize"></textarea>
												<div style="float: right;">
													<input type="submit" value="show list"> <input
														type="submit" value="확인"><br />
												</div>
											</div>
										</div>
									</div>
									<div class="col-md-8 mx-auto">
										<div class="row">
											<div class="col-md-4 mx-auto">
												<h5>
													<strong>설문결과</strong>
												</h5>
												<div style="width: 100%; height: 200px; overflow: auto">
													<table class="table table-striped" style='line-height: 90%'>
														<!-- <thead>
    													<tr>
    															<th>설문결과</th>
    													</tr>
    											</thead> -->
														<tbody>
															<tr>
																<td>소화불량</td>
															</tr>
															<tr>
																<td>명치답답</td>
															</tr>
															<tr>
																<td>명치부위 압통</td>
															</tr>
															<tr>
																<td>담적 상복부</td>
															</tr>
															<tr>
																<td>담적 하복부</td>
															</tr>
															<tr>
																<td>명치통증</td>
															</tr>
															<tr>
																<td>불안함</td>
															</tr>
															<tr>
																<td>추위 탐</td>
															</tr>
															<tr>
																<td>건망증</td>
															</tr>
														</tbody>
													</table>
												</div>
											</div>
											<div class="col-md-4 mx-auto">
												<h5>
													<strong>증상</strong>
												</h5>
												<div style="width: 100%; height: 200px; overflow: auto">
													<table class="table table-striped" style='line-height: 90%'
														id="showPsymptoms">

														<tbody>
															<tr>
																<td></td>
															</tr>
															<tr>
																<td></td>
															</tr>
															<tr>
																<td></td>
															</tr>
															<tr>
																<td></td>
															</tr>
															<tr>
																<td></td>
															</tr>
															<tr>
																<td></td>
															</tr>
															<tr>
																<td></td>
															</tr>
														</tbody>
													</table>
												</div>
												<div style="float: right;">
													<div class="input-append">
														<input class="input-medium" id="appendedInputButtons"
															type="text">
														<button type="button">Add</button>
														<button type="button">Del</button>
														<br />
														<!-- <button type="submit" class="btn btn-primary">변경사항 저장</button> -->
													</div>
													<div style="float: right;">
														<button type="button" class="btn btn-primary"
															id="chkSymptom">진단하기</button>
													</div>
												</div>
											</div>
											<div class="col-md-4 mx-auto">
												<h5>
													<strong>증상 선택 리스트</strong>
												</h5>
												<div style="width: 100%; height: 200px; overflow: auto">
													<table class="table table-striped" style='line-height: 90%'>
														<form>
															<div>
																<div id="section1" class="label">
																	<p>카테고리</p>
																</div>
																<div id="section1b" class="elements">
																	<div>
																		<div id="section1" class="label">
																			<p>머리</p>
																		</div>
																		<div id="section1b" class="elements">
																			<input type="checkbox" name="box1" /> - 왼쪽<br /> <input
																				type="checkbox" name="box1" /> - 오른쪽<br /> <input
																				type="checkbox" name="box1" /> - 앞<br /> <input
																				type="checkbox" name="box1" /> - 뒤<br /> <input
																				type="checkbox" name="box1" /> - 전체<br />
																		</div>
																	</div>
																	<div>
																		<div id="section1" class="label">
																			<p>내장기관</p>
																		</div>
																		<div id="section1b" class="elements">
																			<input type="checkbox" name="box1" /> - 간<br /> <input
																				type="checkbox" name="box1" /> - 심장<br /> <input
																				type="checkbox" name="box1" /> - 갱년기<br /> <input
																				type="checkbox" name="box1" /> - 위<br /> <input
																				type="checkbox" name="box1" /> - 장<br />
																		</div>
																	</div>
																	<div>
																		<div id="section1" class="label">
																			<p>기타</p>
																		</div>
																		<div id="section1b" class="elements">
																			<input type="checkbox" name="box1" /> - 소화불량<br />
																			<input type="checkbox" name="box1" /> - 명치답답<br />
																			<input type="checkbox" name="box1" /> - 기타1<br /> <input
																				type="checkbox" name="box1" /> - 기타2<br /> <input
																				type="checkbox" name="box1" /> - 기타3<br />
																		</div>
																	</div>
																</div>
															</div>
														</form>
													</table>
												</div>
												<div style="float: right;">
													<input type="submit" value="Add to left"><br />
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4 mx-auto">
									<div class="row">
										<div class="col-md-6 mx-auto">
											<img src="img/복진.png" style="width: 85%; height: 85%"
												alt="복진">
										</div>
										<div class="col-md-6 mx-auto">
											<textarea style="width: 100%; height: 87%" class="noresize"></textarea>
											<div style="float: right;">
												<input type="submit" value="show list"> <input
													type="submit" value="확인"><br />
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-8 mx-auto">
									<h5>
										<strong>진단</strong>
									</h5>
									<div style="width: 100%; height: 200px; overflow: auto">
										<table class="table table-striped" id="diagnosisTable"
											style='line-height: 90%'>

											<tbody>
												<tr>
													<td></td>
												</tr>
												<tr>
													<td></td>
												</tr>
												<tr>
													<td></td>
												</tr>
												<tr>
													<td></td>
												</tr>
												<tr>
													<td></td>
												</tr>
												<tr>
													<td></td>
												</tr>
												<tr>
													<td></td>
												</tr>
											</tbody>
										</table>
									</div>
									<br></br>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4 mx-auto">
									<div class="row">
										<div class="col-md-6 mx-auto">
											<img src="img/오장육부.png" style="width: 95%; height: 135%"
												alt="오장육부">
										</div>
										<div class="col-md-6 mx-auto">
											<textarea style="width: 100%; height: 120%" class="noresize"></textarea>
											<div style="float: right;">
												<input type="submit" value="show list"> <input
													type="submit" value="확인"><br />
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-8 mx-auto">
									<div style="float: left;">
										<h5>
											<strong> 처방적합성<br />
											</strong> <i class="icon-chevron-down"></i>추가사항들
										</h5>
									</div>
									<div style="float: right;">
										<p>
											<span class="star-input"> <span class="input">
													<input type="radio" name="star-input" value="1" id="p1">
													<label for="p1">1</label> <input type="radio"
													name="star-input" value="2" id="p2"> <label
													for="p2">2</label> <input type="radio" name="star-input"
													value="3" id="p3"> <label for="p3">3</label> <input
													type="radio" name="star-input" value="4" id="p4"> <label
													for="p4">4</label> <input type="radio" name="star-input"
													value="5" id="p5"> <label for="p5">5</label>
											</span> <output for="star-input"> <b>0</b>점</output>
											</span>
										</p>
									</div>
									<div style="width: 100%; height: 200px; overflow: auto">

										<textarea style="width: 100%; height: 82%" class="noresize" id="commentArea"></textarea>
										<br />
										<div style="float: right;">
											<input type="button" id="evalSaveButton" value="저장" />

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

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

	<script type="text/javascript" src="js/diagnosis.js?ver=1.3111111"></script>
	<script type="text/javascript" src="js/evalRule.js?ver=1"></script>
	<script src="js/star.js"></script>
	<!--  <script src="js/jquery-1.11.3.min.js"></script> 
	<script src="js/assets/js/vendor/jquery-slim.min.js"></script> -->
	<script src="js/assets/js/vendor/popper.min.js"></script>
	<script src="js/js/dist/util.js"></script>
	<script src="js/js/dist/tab.js"></script>
	<script src="js/js/dist/dropdown.js"></script>
</body>
</html>