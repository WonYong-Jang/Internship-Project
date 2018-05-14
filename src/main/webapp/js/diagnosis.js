/**
 * 진단하기 버튼을 눌렀을때 해당 환자의 진단 클래스를 가져와서 진단명을 테이블로 보여줌
 * url:"${pageContext.request.contextPath}/checkSymptom", ==> defaultPage에서 연결할때
 */
$(document).ready(function() {
	$("#chkSymptom").click(function() {
				
		$.ajax({
			method:"GET",
					
			url:"checkSymptom",
					
			success:function(data) {
						
				var show ="";
				$.each(data.diagnosisArr ,function(index,item){
	                  show += "<tr><td>"+item+"</td></tr>";
				});
				$("#diagnosisTable > tbody").empty();
				$("#diagnosisTable").append(show); 
			}
		});
	});
});

/**
 * 
	환자 검색란에 검색을 했을 때 디비에서 검색해서 자동완성으로 보여주고 선택했을때는 환자가 설문에서 받은 증상들을
	자동으로 보여줌
 */
$(document).ready(function() {
	$("#searchPatient").autocomplete({
		source : function(request, response) {
			$.ajax({
				type:"GET",
				url: "searchPatientInfo",
				dataType :"json",
				data: { pName : request.term}, //request.term => text박스내에 입력된 값
				success: function(resultData) {
					response(
						$.map(resultData, function(item){
							return{
								label: item.pName +" /"+item.pNumber, //화면에 보여지는 텍스트
								value: item.pName // 실제 TEXT태그에 들어갈 값 => 똑같이 표기
							}
						})
					);
				}
			});
		},
	//조회를 위한 최소 글자수
	minLength: 1,
	select: function(event, ui) { //만약 검색리스트에서 선택하였을때 선택한 데이터에 의한 이벤트 발생
		var temp = ui.item.label;
		var getPatientNum = temp.split('/');
		callbackPatient(getPatientNum[1]); // 환자 번호로 검색하기 위함
	}
});
});
function callbackPatient(getPatientNum){ // 환자 번호로 증상들을 불러오는 함수
	var sendPatientNum = getPatientNum;
	$.ajax({
		type:"GET",
		dataType: "json",
		url: "getPatientSymptoms",
		data : {"pNumber" : sendPatientNum},
		success:function(resultData){
			
			var symptomList ="";
			var patientInfo ="";
			patientInfo += "<h5 style='background-color:#EBEBEB; border: solid 5px #EBEBEB'>"+
							resultData.visitDate +"| "+resultData.pName+"("+resultData.pNumber+") 500211-20*****(F. 67세 0개월 24일) | [국민공단] | 010-5199-**** | 경기도 남양주시 화도읍 명품하우스</h5>";
			
			$.each(resultData.symptomArr ,function(index,item){
				symptomList += "<tr><td>"+item.symptom+"</td><td><button onclick='deleteLine(this);' style='float: right;'>삭제</button></td></tr>";
			});
			$("#showPsymptoms > tbody").empty();
			$("#showPsymptoms").append(symptomList);
			$("#patientInfoView").empty();
			$("#patientInfoView").append(patientInfo);
		}
	});
}
//증상 삭제
function deleteLine(obj) {
    var tr = $(obj).parent().parent();
    var symptom =  tr.children().text().slice(0,-2);
  
    $.ajax({
    	type:"POST",
		dataType: "json",
		url: "deleteSelectedSymptom",
		data : {"symptom" : symptom},
		success:function(result)
		{
			//var patientNum = result;
			//callbackPatient(patientNum);
			//라인 삭제
		    tr.remove();
		   
		}
    });
}

//Default Page 검색란에 입력하고 엔터눌렀을때 똑같이 검색되는 기능
$("#searchPatient").keypress(function(event){
    if ( event.which == 13 ) {
        $("#searchButton").click();
        return false;
    }
});



//증상 추가
$(document).ready(function() {
	$("#addSymptom").click(function() {
		
		var inputData = $("#inputSymptom").val();
		$.ajax({
			method:"POST",	
			url:"addPatientSymptom",
			dataType: "json",
			data : {"symptom":inputData},
			success:function(resultData) {
				var diagnosis = JSON.stringify(resultData);
				console.log(resultData);
				
				var show ="";
				show += "<tr><td>"+resultData.symptom+"</td><td><button onclick='deleteLine(this);' style='float: right;'>삭제</button></td></tr>";
				$("#showPsymptoms").append(show);
				$("#inputSymptom").val("");
			}
		});
	});
});
$("#inputSymptom").keypress(function(event){
    if ( event.which == 13 ) {
        $("#addSymptom").click();
        return false;
    }
});
//증상 검색
$(document).ready(function() {
	$("#inputSymptom").autocomplete({
		source : function(request, response) {
			$.ajax({
				type:"GET",
				url: "searchSymptom",
				dataType :"json",
				data: { symptom : request.term}, //request.term => text박스내에 입력된 값
				success: function(resultData) {
					response(
						$.map(resultData, function(item){
							return{
								label: item.symptom +" /"+item.sRegion, //화면에 보여지는 텍스트
								value: item.symptom // 실제 TEXT태그에 들어갈 값 => 똑같이 표기
							}
						})
					);
				}
			});
		},
	//조회를 위한 최소 글자수
	minLength: 1,
	select: function(event, ui) { //만약 검색리스트에서 선택하였을때 선택한 데이터에 의한 이벤트 발생
	}
});
});
