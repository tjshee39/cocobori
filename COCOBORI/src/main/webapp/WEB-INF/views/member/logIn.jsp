<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리 | 로그인</title>
<link rel="stylesheet" href="/resources/css/member/logIn.css"
	type="text/css">
</head>
<body>
	<%@include file ="/WEB-INF/views/common/header.jsp" %>
	
	<section id="container">
		<div id="container_box">
			<h1 style="text-align: center;">로그인</h1>
			<hr>
			<br>
			<section id="content">
				<form role="form" method="post" autocomplete="off" id="logInForm" name="logInForm">
				
					<table id="tbl_logIn">
						<div class="input_area">
							<tr>
								<td><input type="email" id="userID" name="userID" placeholder="이메일" required="required" 
								style="width: 400px; height: 40px; border-radius: 7px; border-width: 1px;"/></td>
							</tr>
						</div>
						
						<div class="input_area">
							<tr>
								<td><input type="password" id="userPW" name="userPW" placeholder="비밀번호" required="required" 
								style="width: 400px; height: 40px; border-radius: 7px; border-width: 1px;" /></td>
							</tr>
						</div>
						
						<div>
							<tr style="height: 2px"></tr>
							<tr style="width:100%;">
								<td colspan="2" id="btn_logIn">
									<button type="submit" id="btn_logIn" name="btn_logIn" >로그인</button>
								</td>
							</tr>
						</div>
						
					</table>
					<div id="member_null">
						<c:if test="${msg == false}">
							<p style="color:#f00;">아이디 혹은 비밀번호가 일치하지 않습니다.</p>
						</c:if>
					</div>
							
				</form>
			</section>
		</div>
	</section>
	
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>

