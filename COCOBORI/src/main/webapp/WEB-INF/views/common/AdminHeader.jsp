<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<link rel="stylesheet" href="/resources/css/common/AdminHeader.css" type="text/css">
</head>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<body>

	<header class="header_area"> <!-- Top Header Area Start -->
	<div class="top_header_area">
		<!-- Logo Area -->
		<div class="top_logo">
			<a href="/"><img src="/resources/images/logo_cocobori.png" /></a>
		</div>
		
		<!-- Menu Area -->
		<div class="top_menu">
			<div class="top_menu_right" style="vertical-align: middle;">
				<c:if test="${member == null }">
					<a href="/member/logIn" class="menu_right">로그인</a>&nbsp;&nbsp;|&nbsp;
					<a href="/member/signUp" class="menu_right">회원가입</a>&nbsp;&nbsp;|&nbsp;
				</c:if>
				<c:if test="${member != null }">
					<a href="/member/memberInfo" class="menu_right" style="font-weight: bold;">
						${member.userName }
					</a>님&nbsp;&nbsp;|&nbsp;
					<a href="/member/logOut" class="menu_right">로그아웃</a>&nbsp;&nbsp;|&nbsp;
				</c:if>
				<a href="/cart/cartList" class="menu_right">장바구니</a>&nbsp;&nbsp;|&nbsp;
				<a href="/mypage/memberInfo" class="menu_right">마이페이지</a>
			</div>
		</div>
		
		<hr id="header_line">
		<div class="top_second_menu">
			<ul>
				<li>
					<a href="#">커뮤니티</a>
				</li>
				<li>
					<a href="/main/storeMain">스토어</a>
				</li>
				<li>
					<a href="/admin/register">상품 등록</a>
				</li>
				<li>
					<a href="/admin/goodsList">상품 목록</a>
				</li>
				<li>
					<a href="#">회원 목록</a>
				</li>
			</ul>
		</div>
		
	</div>
	</header>
	
	<!-- 구분 선 -->
	<hr id="header_line">
	
</body>

<script type="text/javascript">

	$(function(){
		var top_second_menu = $("ul > li");    //  ul > li 이를 top_second_menu으로 칭한다. (클릭이벤트는 li에 적용 된다.)
		top_second_menu.find("a").click(function(){   // top_second_menu에 속해 있는  a 찾아 클릭 하면.
			top_second_menu.removeClass("active");     // top_second_menu 속에 (active) 클래스를 삭제 한다.
			$(this).parent().addClass("active"); // 클릭한 a에 (active)클래스를 넣는다.
		})
	})
       
</script>
</html>