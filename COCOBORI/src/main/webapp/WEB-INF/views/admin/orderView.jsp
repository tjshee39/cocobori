<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<link rel="stylesheet" href="/resources/css/admin/orderView.css" type="text/css">
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
				<div class="orderInfo">
					<c:forEach items="${orderView}" var="orderView" varStatus="status">
				  
					  	<c:if test="${status.first}">
					   		<p><span>주문자</span>${orderView.userID}</p>
					   		<p><span>수령인</span>${orderView.orderRec}</p>
					   		<p><span>주소</span>(${orderView.userAddr}) ${orderView.userAddr} ${orderView.userAddrDetail}</p>
					   		<p><span>가격</span><fmt:formatNumber pattern="###,###,###" value="${orderView.amount}" /> 원</p>
					   		<p><span>상태</span>${orderView.delivery}</p>
					   		
					   		<div class="deliveryChange">
							 		<form role="form" method="post" class="deliveryForm">	 
										<input type="hidden" name="orderID" value="${orderView.orderID}" />
									  	<input type="hidden" name="delivery" class="delivery" value="" />
									   		<button type="button" class="delivery1_btn">배송중</button>
									   		<button type="button" class="delivery2_btn">배송완료</button>
									   		
									   		<script>
									   			$(".delivery1_btn").click(function(){
									   				$(".delivery").val("배송중");
									   				run();
									   			});
											   
									   			$(".delivery2_btn").click(function(){
									   				$(".delivery").val("배송완료");
											    	run();
											    });
											   
									   			function run(){
									   				$(".deliveryForm").submit();
									   			}
									   		</script>
									   	</form>
							 	</div>
					  	</c:if>
				  
				 	</c:forEach>
				</div>
				
				<ul class="orderView">
					<c:forEach items="${orderView}" var="orderView">     
				 		<li>
				  			<div class="thumb">
				   				<img src="${orderView.gdsThumbImg}" />
				  			</div>
				  			<div class="gdsInfo">
					   			<p>
					   				<span>상품명</span>${orderView.gdsName}<br />
					    			<span>개당 가격</span><fmt:formatNumber pattern="###,###,###" value="${orderView.gdsPrice}" /> 원<br />
					    			<span>구입 수량</span>${orderView.cartStock} 개<br />
					    			<span>최종 가격</span><fmt:formatNumber pattern="###,###,###" value="${orderView.gdsPrice * orderView.cartStock}" /> 원                  
					   			</p>
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