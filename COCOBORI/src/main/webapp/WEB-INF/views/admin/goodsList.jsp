<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<link rel="stylesheet" href="/resources/css/admin/goodsList.css" type="text/css">
</head>
<body>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

	<%@include file ="/WEB-INF/views/common/AdminHeader.jsp" %>
	
	<section id="container">
		<div id="container_box">
			<h1 style="text-align: center;">상품 목록</h1>
			<table id="tbl_goodsList">
				<thead>
					<tr style="text-align: left;">
						<th width="80px">번호</th>
						<th width="200px">상품명</th>
						<th width="100px">분류</th>
						<th width="100px">가격</th>
						<th width="100px">수량</th>
						<th width="200px">등록날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="list">
					<tr>
						<td>${list.gdsNum }</td>
						<td><a href="/admin/goodsView?n=${list.gdsNum}">${list.gdsName }</a></td>
						<td>${list.cateCode }</td>
						<td><fmt:formatNumber value="${list.gdsPrice }" pattern="###,###,###" /></td>
						<td>${list.gdsStock }</td>
						<td><fmt:formatDate value="${list.gdsDate }" pattern="yyyy-MM-dd" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>			
		</div>
	</section>
	
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>