<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<link rel="stylesheet" href="/resources/css/admin/register.css" type="text/css">
<script>

	//컨트롤러에서 데이터 받기
	var jsonData = JSON.parse('${category}');
	console.log(jsonData);
	
	var cate1Arr = new Array();
	var cate1Obj = new Object();
		
	//1차 분류 셀렉트 박스에 삽입할 데이터 준비
	for(var i=0; i<jsonData.length; i++) {
		if(jsonData[i].level == "1") {
			cate1Obj = new Object();
			cate1Obj.cateCode = jsonData[i].cateCode;
			cate1Obj.cateName = jsonData[i].cateName;
			cate1Arr.push(cate1Obj);
		}
	}
	
	//1차 분류 셀렉트 박스에 데이터 삽입
	var cate1Select = $("select.category1")
	
	for(var i=0; i<cate1Arr.length; i++) {
		cate1Select.append("<option value='" + cate1Arr[i].cateCode + "'>"
				+ cate1Arr[i].cateName + "</option>");
	}
		
	//1차 분류 선택했을 때
	$(document).on("change", "select.category1", function() {
		var cate2Arr = new Array();
		var cate2Obj = new Object();
		
		//2차 분류 셀렉트 박스에 삽입할 데이터 준비
		
		for(var i=0; i<jsonData.length; i++) {
			if(jsonData[i].level == "2") {
				cate2Obj = new Object();
				cate2Obj.cateCode = jsonData[i].cateCode;
				cate2Obj.cateName = jsonData[i].cateName;
				cate2Obj.cateCodeRef = jsonData[i].cateCodeRef;
				
				cate2Arr.push(cate2Obj);
			}
		}
		
		var cate2Select = $("select.category2");
		
		/* level이 2인 목록 모두 출력됨
		for(var i=0; i<cate2Arr.length; i++) {
			cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
					+ cate2Arr[i].cateName + "</option>");
		}
		*/
			
		cate2Select.children().remove();
			
		$("option:selected", this).each(function() {
			var selectVal = $(this).val();
			cate2Select.append("<option value='" + selectVal + "'>전체</option>");
				
			for(var i=0; i<cate2Arr.length; i++) {
				if(selectVal == cate2Arr[i].cateCodeRef) {
					cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
							+ cate2Arr[i].cateName + "</option>");
				}
			}
		});
	});
	
</script>
</head>
<body>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

	<%@include file ="/WEB-INF/views/common/AdminHeader.jsp" %>
	
	<section id="container">
		<div id="container_box">
			<h1 style="text-align: center;">상품 등록</h1>
			<hr id="header_line">
			<div id="form_register">
				<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">
				
					<div class="inputArea">
						<label>1차 분류</label>
						<select class="category1">
							<option value="">전체</option>
						</select>
						<label>2차 분류</label>
					 	<select class="category2" name="cateCode">
					  		<option value="">전체</option>
					 	</select>
					</div>
	
					<div class="inputArea">
						<label for="gdsName">상품명</label>
					 	<input type="text" id="gdsName" name="gdsName" />
					</div>
	
					<div class="inputArea">
						<label for="gdsPrice">상품가격</label>
					 	<input type="text" id="gdsPrice" name="gdsPrice" />
					</div>
					
					<div class="inputArea">
						<label for="gdsStock">상품수량</label>
					 	<input type="text" id="gdsStock" name="gdsStock" />
					</div>
					
					<div class="inputArea">
						<label for="gdsDes">상품소개</label>
					 	<textarea rows="5" cols="50" id="gdsDes" name="gdsDes"></textarea>
					</div>
					
					<div class="inputArea">
						<label for="gdsImg">이미지</label>
						<input type="file" id="gdsImg" name="file" />
						<div class="select_img"><img src="" /></div>
						
						<script>
							//어떤 이미지 선택했는지 보여줌
							$("#gdsImg").change(function(){ 
								if(this.files && this.files[0]) {
									var reader = new FileReader;
									reader.onload = function(data) {
										$(".select_img img").attr("src", data.target.result).width(500);        
										}
									reader.readAsDataURL(this.files[0]);
								}
							});
 	
						</script>
						
					</div>
					
					
					<div class="inputArea">
						<button type="submit" id="btn_register" class="btn btn-primary">등록</button>
					</div>
					
				</form>
			</div>
		</div>
	</section>
	
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>

</body>
<script>

	//컨트롤러에서 데이터 받기
	var jsonData = JSON.parse('${category}');
	console.log(jsonData);
	
	var cate1Arr = new Array();
	var cate1Obj = new Object();
		
	//1차 분류 셀렉트 박스에 삽입할 데이터 준비
	for(var i=0; i<jsonData.length; i++) {
		if(jsonData[i].level == "1") {
			cate1Obj = new Object();
			cate1Obj.cateCode = jsonData[i].cateCode;
			cate1Obj.cateName = jsonData[i].cateName;
			cate1Arr.push(cate1Obj);
		}
	}
	
	//1차 분류 셀렉트 박스에 데이터 삽입
	var cate1Select = $("select.category1")
	
	for(var i=0; i<cate1Arr.length; i++) {
		cate1Select.append("<option value='" + cate1Arr[i].cateCode + "'>"
				+ cate1Arr[i].cateName + "</option>");
	}
		
	//1차 분류 선택했을 때
	$(document).on("change", "select.category1", function() {
		var cate2Arr = new Array();
		var cate2Obj = new Object();
		
		//2차 분류 셀렉트 박스에 삽입할 데이터 준비
		
		for(var i=0; i<jsonData.length; i++) {
			if(jsonData[i].level == "2") {
				cate2Obj = new Object();
				cate2Obj.cateCode = jsonData[i].cateCode;
				cate2Obj.cateName = jsonData[i].cateName;
				cate2Obj.cateCodeRef = jsonData[i].cateCodeRef;
				
				cate2Arr.push(cate2Obj);
			}
		}
		
		var cate2Select = $("select.category2");
		
		/* level이 2인 목록 모두 출력됨
		for(var i=0; i<cate2Arr.length; i++) {
			cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
					+ cate2Arr[i].cateName + "</option>");
		}
		*/
			
		cate2Select.children().remove();
			
		$("option:selected", this).each(function() {
			var selectVal = $(this).val();
			cate2Select.append("<option value=''>전체</option>");
				
			for(var i=0; i<cate2Arr.length; i++) {
				if(selectVal == cate2Arr[i].cateCodeRef) {
					cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
							+ cate2Arr[i].cateName + "</option>");
				}
			}
		});
	});

</script>
</html>