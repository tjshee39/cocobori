<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<link rel="stylesheet" href="/resources/css/store/storeAside.css" type="text/css">
</head>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<body>

	<aside>
		<section>
			<div>	
				<ul id="aside">
				<h3>카테고리</h3>
					<li><a href="/store/list?c=100&l=1">사료</a>
						<ul class="low">
							<li><a href="/store/list?c=101&l=2">퍼피</a>
							<li><a href="/store/list?c=102&l=2">어덜트</a>
							<li><a href="/store/list?c=103&l=2">시니어</a>
							<li><a href="/store/list?c=104&l=2">건식</a>
							<li><a href="/store/list?c=105&l=2">습식</a>
						</ul>
					</li>
					
					<li><a href="/store/list?c=200&l=1">간식</a>
						<ul class="low">
							<li><a href="/store/list?c=201&l=2">껌</a>
							<li><a href="/store/list?c=202&l=2">수제간식</a>
							<li><a href="/store/list?c=203&l=2">캔</a>
							<li><a href="/store/list?c=204&l=2">육포</a>
						</ul>
					</li>
					
					<li><a href="/store/list?c=300&l=1">케어</a>
						<ul class="low">
							<li><a href="/store/list?c=301&l=2">위생</a>
							<li><a href="/store/list?c=302&l=2">목욕</a>
							<li><a href="/store/list?c=303&l=2">배변</a>
							<li><a href="/store/list?c=304&l=2">약</a>
						</ul>
					</li>
					
					<li><a href="/store/list?c=400&l=1">외출</a>
						<ul class="low">
							<li><a href="/store/list?c=401&l=2">가방</a>
							<li><a href="/store/list?c=402&l=2">목줄</a>
							<li><a href="/store/list?c=403&l=2">입마개</a>
						</ul>
					</li>
					
					<li><a href="/store/list?c=500&l=1">의류</a>
						<ul class="low">
							<li><a href="/store/list?c=501&l=2">악세서리</a>
							<li><a href="/store/list?c=502&l=2">옷</a>
							<li><a href="/store/list?c=503&l=2">신발</a>
						</ul>
					</li>
				</ul>
			</div>
		</section>
	</aside>
	
</body>
</html>