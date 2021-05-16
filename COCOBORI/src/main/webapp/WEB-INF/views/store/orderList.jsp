<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<link rel="stylesheet" href="/resources/css/store/orderList.css" type="text/css">
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
			
				<ul class = "orderList">
					<c:forEach items="${orderList }" var="orderList">
						<li>
							<div>
								<p><span>주문번호</span><a href="/store/orderView?n=${orderList.orderID}" id="orderID">${orderList.orderID}</a></p>
   								<p><span>수령인</span>${orderList.orderRec}</p>
   								<p><span>주소</span>(${orderList.userAddrZip}) ${orderList.userAddr} ${orderList.userAddrDetail}</p>
   								<p><span>가격</span><fmt:formatNumber pattern="###,###,###" value="${orderList.amount}" /> 원</p>
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