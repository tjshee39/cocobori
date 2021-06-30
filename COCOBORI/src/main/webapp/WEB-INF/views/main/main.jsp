<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<link rel="stylesheet" href="/resources/css/main/main.css" type="text/css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body>

	<%@include file ="/WEB-INF/views/common/header.jsp" %>
	
	<section id="container">
		<div id="container_box">
			<div id="imgSlide">
				이미지 슬라이드
			</div>
			<div class="board_main">
			
			<table id="board_main">
				<tr>
					<td>게시글 썸네일</td>
					<td>게시글 썸네일</td>
					<td>게시글 썸네일</td>
					<td>게시글 썸네일</td>
					<td rowspan="2">게시글 썸네일 두칸</td>
					<td rowspan="2">게시글 썸네일 두칸</td>
				</tr>
				<tr>
					<td>게시글 썸네일</td>
					<td>게시글 썸네일</td>
					<td>게시글 썸네일</td>
					<td>게시글 썸네일</td>
				</tr>
			</table>
		
			</div>
			
			<c:if test="${member != null }">
				<div id="register_btn">
					<a href="/community/register"><img id="register_img" alt="글 작성" src="/resources/images/board_write.png" /></a>
				</div>
			</c:if>
		
		</div>
	</section>
	
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>