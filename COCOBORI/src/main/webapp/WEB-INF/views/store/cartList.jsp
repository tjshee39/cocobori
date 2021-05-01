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
					<c:forEach items="${cartList }" var="cartList">
						<table id="tblCart">
							<tr>
								<td style rowspan="5"><img src="${cartList.gdsThumbImg }"></td>
								<td><span>상품명</span></td><td>${cartList.gdsName }</td>
							</tr>
							<tr>
								<td><span>가격</span></td><td><fmt:formatNumber pattern="###,###,###" value="${cartList.gdsPrice }" /></td>
							</tr>
							<tr>
								<td><span>구입 수량</span></td><td>${cartList.cartStock }</td>
							</tr>
							<tr>
								<td><span>최종 가격</span></td><td><fmt:formatNumber pattern="###,###,###" value="${cartList.gdsPrice * cartList.cartStock }" /></td>
							</tr>
							<tr>
								<td colspan="3">
									<div class="delete">
										<button type="button" class="btnDelete">삭제</button>
									</div>
								</td>
							</tr>
							
						</table>
						<!-- 
						<li>
							<div class="thumb">
								<img src="${cartList.gdsThumbImg }">
							</div>
							<div class="gdsInfo">
								<p>
									<span>상품명:</span>${cartList.gdsName }<br>
									<span>가격:</span>
										<fmt:formatNumber pattern="###,###,###" value="${cartList.gdsPrice }" /> <br>
									<span>구입 수량:</span>${cartList.cartStock }<br>
									<span>최종 가격:</span>
										<fmt:formatNumber pattern="###,###,###" value="${cartList.gdsPrice * cartList.cartStock }" />
								</p>
								
								<div class="delete">
									<button type="button" class="btnDelete">삭제</button>
								</div>
							</div>
						</li>
						 -->
					</c:forEach>				
				</ul>
			</section>
		
		</div>
	</section>
	
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>