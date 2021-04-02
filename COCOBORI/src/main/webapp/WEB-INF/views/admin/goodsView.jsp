<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<link rel="stylesheet" href="/resources/css/admin/goodsView.css" type="text/css">
</head>
<body>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

	<%@include file ="/WEB-INF/views/common/AdminHeader.jsp" %>
	
	<section id="container">
		<div id="container_box">
			<h1 style="text-align: center;">상품 등록</h1>
			<hr id="header_line">
			<div id="form_register">
				<form role="form" method="post" autocomplete="off">
				<input type="hidden" name="n" value="${goods.gdsNum}" />
				
					<div class="inputArea"> 
						<label>1차 분류</label>
						<span class="category1"></span>        
						<label>2차 분류</label>
						<span class="category2">${goods.cateCode}</span>
					</div>
					
					<div class="inputArea">
						<label for="gdsName">상품명</label>
						<span>${goods.gdsName}</span>
					</div>
					
					<div class="inputArea">
						<label for="gdsPrice">상품가격</label>
						<span><fmt:formatNumber value="${goods.gdsPrice}" pattern="###,###,###"/></span>
					</div>
					
					<div class="inputArea">
						<label for="gdsStock">상품수량</label>
						<span>${goods.gdsStock}</span>
					</div>
					
					<div class="inputArea">
						<label for="gdsDes">상품소개</label>
						<span>${goods.gdsDes}</span>
					</div>
					
					<div class="inputArea">
						<label for="gdsImg">이미지</label>
						<p>원본 이미지</p>
						<img src="${goods.gdsImg }" class="img_origin" />
						
						<p>썸네일</p>
						<img src="${goods.gdsThumbImg }" class="img_thumb" />
					</div>		
					
					<div class="inputArea">
						<button type="button" id="btn_modify" class="btn btn-warning">수정</button>
						<button type="button" id="btn_delete" class="btn btn-danger">삭제</button>
					</div>
					
				</form>
			</div>
		</div>
	</section>
	
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>

</body>
<script>

	var formObj = $("form[role='form']");

	$("#btn_modify").click(function(){
 		formObj.attr("action", "/admin/goodsModify");
 		formObj.attr("method", "get")
 		formObj.submit();
	});

	$("#btn_delete").click(function(){
		
		var con = confirm("상품을 삭제하시겠습니까?");
		
		if(con) {
			formObj.attr("action", "/admin/goodsDelete");
			formObj.submit();
		}
	});
	
</script>
</html>