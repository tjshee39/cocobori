<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery.innerfade.js"></script>
<link rel="stylesheet" href="/resources/css/main/main.css" type="text/css">
<script>
	$(document).ready(function() {
		// innerfade 플러그인을 적용합니다.
		$('#img_slide').innerfade({
			animationtype : 'fade',
			speed : 750,
			timeout : 2000,
			type : 'random',
			containerheight : '350px'
		});
	});
</script>
</head>
<body>

	<%@include file="/WEB-INF/views/common/header.jsp"%>

	<section id="container">
		<div id="container_box">

			<div class="board_main">

				<ul id="img_slide">
					<li><img src="/resources/images/img_slide1.jpg" /></li>
					<li><img src="/resources/images/img_slide2.jpg" /></li>
					<li><img src="/resources/images/img_slide3.jpg" /></li>
				</ul>

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
					<a href="/community/register"><img id="register_img" alt="글 작성"
						src="/resources/images/board_write.png" /></a>
				</div>
			</c:if>

		</div>
	</section>

	<%@include file="/WEB-INF/views/common/footer.jsp"%>

</body>
</html>