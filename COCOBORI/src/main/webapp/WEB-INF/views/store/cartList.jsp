<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<link rel="stylesheet" href="/resources/css/store/cartList.css" type="text/css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body>

	<%@include file ="/WEB-INF/views/common/header.jsp" %>
	<br>
	<div id="aside">
	<%@include file ="/WEB-INF/views/common/storeAside.jsp" %>
	</div>
	
	<section id="container">
		<div id="container_box">
			
			<section id="content">
				<ul>
 					<li>
	  					<div class="allCheck">
	   						<input type="checkbox" name="allCheck" id="allCheck" /><label for="allCheck">모두 선택</label>
	   						
	   						<script>
		  						$("#allCheck").click(function() {
		  							var chk = $("#allCheck").prop("checked");
		  							if(chk) {
		  								$(".chBox").prop("checked", true);
		  							} else {
		  								$(".chBox").prop("checked", false);
		  							}
		  						});
	  						</script> 
	  					</div>
	  					
	  					
	  
	  					<div class="delBtn">
	   						<button type="button" class="selectDelete_btn">선택 삭제</button> 
		  					
		  					<script>
		  						$(".selectDelete_btn").click(function() {
		  							var confirm_val = confirm("정말 삭제하시겠습니까?");
		  							
		  							if(confirm_val) {
		  								var checkArr = new Array();
		  								
		  								$("input[class='chBox']:checked").each(function() {
		  									checkArr.push($(this).attr("data-cartNum"));
		  								});
		  								
		  								$.ajax({
		  									url: "/store/deleteCart",
		  									type: "post",
		  									data: { chbox: checkArr },
		  									success: function(result) {
		  										if(result == 1) {
		  											location.href = "/store/cartList";	
		  										} else {
		  											alert("삭제 실패");
		  										}
		  										
		  									}
		  								});
		  							}
		  						});
		  					</script>
	  					</div>
	  					
   					</li>

 					<c:forEach items="${cartList}" var="cartList">
 					<li>
  						<div class="checkBox">
   							<input type="checkbox" name="chBox" class="chBox" data-cartNum="${cartList.cartNum}" />
   							
   							<script>
	  							$(".chBox").click(function() {
	  								$("#allCheck").prop("checked", false);
	  							});
  							</script>
  						</div>
 
						<div class="thumb">
   							<img src="${cartList.gdsThumbImg}" />
  						</div>
  						<div class="gdsInfo">
   							<p>
    							<span>상품명</span>${cartList.gdsName}<br />
    							<span>개당 가격</span><fmt:formatNumber pattern="###,###,###" value="${cartList.gdsPrice}" /> 원<br />
    							<span>구입 수량</span>${cartList.cartStock} 개<br />
    							<span>최종 가격</span><fmt:formatNumber pattern="###,###,###" value="${cartList.gdsPrice * cartList.cartStock}" /> 원
   							</p>
   
   							<div class="delete">
    							<button type="button" class="delete_${cartList.cartNum }_btn" data-cartNum="${cartList.cartNum}">삭제</button>
    							
    							<script>
	   								$(".delete_${cartList.cartNum}_btn").click(function() {
	   									var confirm_val = confirm("정말 삭제하시겠습니까?");
	   									
	   									if(confirm_val) {
	   										var checkArr = new Array();
	   										
	   										checkArr.push($(this).attr("data-cartNum"));
	   										
	   										$.ajax({
	   											url: "/store/deleteCart",
	   											type: "post",
	   											data: { chbox: checkArr },
	   											success: function(result) {
	   												if(result == 1) {
	   													location.href="/store/cartList";
	   												} else {
	   													alert("삭제 실패");
	   												}
	   											}
	   										});
	   									}
	   								});
   								</script>
   							</div>
   							
  						</div>   
 					</li>
 					</c:forEach>
				</ul>
			</section>
		
		</div>
	</section>
	
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>