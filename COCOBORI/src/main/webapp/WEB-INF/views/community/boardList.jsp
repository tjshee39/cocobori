<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<link rel="stylesheet" href="/resources/css/community/boardList.css" type="text/css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body>

	<%@include file ="/WEB-INF/views/common/header.jsp" %>
	<br>
	
	<section id="container">
		<div id="container_box">
			
			<section id="content">
				<table class="boardList">
					<tr style="background: #fbe6e8; border-bottom: 1px solid #ffb5bc;">
						<th style="width: 60px; border-right: 1px solid #ffb5bc;  padding: 5px;">글 번호</th>
						<th style="width: 500px; border-right: 1px solid #ffb5bc;">제목</th>
						<th style="width: 100px; border-right: 1px solid #ffb5bc;">작성일</th>
						<th style="width: 150px;">작성자</th>
					</tr>
					<c:forEach items="${boardList }" var="boardList">
						<tr>
							<td style="text-align: center; border-right: 1px solid #ffb5bc;"><c:out value="${boardList.boardNum }" /></td>
							<td style="border-right: 1px solid #ffb5bc;"><a href="/community/boardView?n=${boardList.boardNum }" style="margin-left: 10px;"><c:out value="${boardList.boardTitle }" /></a></td>
							<td style="text-align: center; border-right: 1px solid #ffb5bc;"><fmt:formatDate value="${boardList.regDate }" pattern="yyyy-MM-dd" /></td>
							<td style="text-align: center;"><c:out value="${boardList.userName }" /></td>
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