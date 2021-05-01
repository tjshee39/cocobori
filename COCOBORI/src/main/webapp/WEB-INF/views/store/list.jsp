<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<link rel="stylesheet" href="/resources/css/store/list.css" type="text/css">
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
					<c:forEach items="${list }" var="list">
						<li>
							<div class="goodsThumb">
								<a href="/store/view?n=${list.gdsNum }"><img src="${list.gdsThumbImg }"></a>
							</div>
							<div class="goodsName">
								<a href="/store/view?n=${list.gdsNum }">${list.gdsName }</a>
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