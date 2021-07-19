<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="/resources/css/main/materialize.min.css" media="screen,projection" />
<link rel="stylesheet" href="/resources/css/main/main.css" type="text/css">
</head>
<body>

	<%@include file ="/WEB-INF/views/common/header.jsp" %>

	<section id="container">
		<div id="container_box">
			<!-- <div id="imgSlide">
				이미지 슬라이드
			</div> -->
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<div class="slider">
				<ul class="slides">
					<li>
						<img src="http://m.pet-kingdom.co.kr/_d1/img/middleslidebanner/03.jpg"> <!-- random image -->
						<div class="caption center-align">
							<h3>쳐 내려가라</h3>
							<h5 class="light grey-text text-lighten-3">
								cocobori
							</h5>
						</div>
					</li>
					<li>
						<img src="https://img.freepik.com/free-photo/front-view-of-beautiful-dog-with-copy-space_23-2148786499.jpg?size=626&ext=jpg&ga=GA1.2.1149860058.1620518400"> <!-- random image -->
						<div class="caption left-align">
							<h3>Left Aligned Caption</h3>
							<h5 class="light grey-text text-lighten-3">
								Here's our small slogan.
							</h5>
						</div>
					</li>
					<li>
						<img src="http://vrthumb.clipartkorea.co.kr/2020/09/10/cb0460045693.jpg"> <!-- random image -->
						<div class="caption right-align">
							<h3>Right Aligned Caption</h3>
							<h5 class="light grey-text text-lighten-3">
								Here's our small slogan.</h5>
						</div>
					</li>
					<li>
						<img src="https://barketplace.uk/wp-content/uploads/2020/11/front-view-adorable-mixed-breed-puppy-looking-left-with-copy-space-scaled.jpg"> <!-- random image -->
						<div class="caption center-align">
							<h3>This is our big Tagline!</h3>
							<h5 class="light grey-text text-lighten-3">
								Here's our small slogan.
							</h5>
						</div>
					</li>
				</ul>
			</div>
			
			<!--JavaScript at end of body for optimized loading-->
      		<script type="text/javascript" src="/resources/js/materialize.min.js"></script>
			<script>
				$(document).ready(function() {
					$('.slider').slider();
				});
			</script>

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