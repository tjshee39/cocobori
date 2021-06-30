<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<link rel="stylesheet" href="/resources/css/comunity/boardList.css" type="text/css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body>

	<%@include file ="/WEB-INF/views/common/header.jsp" %>
	<br>
	
	<section id="container">
		<div id="container_box">
			
			<section id="content">
				<table class="boardList">
					<tr><th>글 번호</th><th>제목</th><th>작성일</th><th>작성자</th></tr>
					<c:forEach items="${boardList }" var="boardList">
						<tr>
							<td><c:out value="${boardList.boardNum }" /></td>
							<td><c:out value="${boardList.boardTitle }" /></td>
							<td><fmt:formatDate value="${boardList.regDate }" pattern="yyyy-MM-dd" /></td>
							<td><c:out value="${boardList.userName }" /></td>
						</tr>
					</c:forEach>				
				</table>
				
				<c:if test="${member != null }">
					<div id="register_btn">
						<a href="/community/register"><img id="register_img" alt="글 작성" src="/resources/images/board_write.png" /></a>
					</div>
				</c:if>
			</section>
		
		</div>
	</section>
	
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>