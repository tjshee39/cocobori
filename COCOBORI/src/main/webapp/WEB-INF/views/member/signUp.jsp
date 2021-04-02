<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리 | 회원가입</title>
<link rel="stylesheet" href="/resources/css/member/signUp.css" type="text/css">
</head>
<body>
	<%@include file ="/WEB-INF/views/common/header.jsp" %>
	
	<section id="container">
		<div id="container_box">
			<h1 style="text-align: center;">회원정보 입력</h1>
			<hr>
			<br>
			<section id="content">
				<form role="form" method="post" autocomplete="off">
				
					<table id="tbl_signUp">
						<div class="input_area">
							<tr>
								<td class="tbl_signUp_item"><label for="userID">아이디</label></td>
								<td><input type="email" id="userID" name="userID" placeholder="qwer@naver.com" required="required" 
								style="width: 300px; height: 40px; border-radius: 7px; border-width: 1px;"/></td>
							</tr>
						</div>
						
						<div class="input_area">
							<tr>
								<td class="tbl_signUp_item"><label for="userPW">패스워드</label></td>
								<td><input type="password" id="userPW" name="userPW" required="required" 
								style="width: 300px; height: 40px; border-radius: 7px; border-width: 1px;" /></td>
							</tr>
						</div>
						
						<div class="input_area">
							<tr>
								<td class="tbl_signUp_item"><label for="userName">이름</label></td>
								<td><input type="text" id="userName" name="userName" required="required" 
								style="width: 300px; height: 40px; border-radius: 7px; border-width: 1px;" /></td>
							</tr>
						</div>
						
						<div class="input_area">
							<tr>
								<td class="tbl_signUp_item"><label for="userPhone">연락처</label></td>
								<td><input type="text" id="userPhone" name="userPhone" required="required" 
								style="width: 300px; height: 40px; border-radius: 7px; border-width: 1px;" /></td>
							</tr>
						</div>
						
						<div>
							<tr style="width:100%;">
								<td colspan="2" id="btn_signup"><button type="submit" id="btn_signup" name="btn_signup">회원가입</button></td>
							</tr>
						</div>
					</table>
				
				</form>
			</section>
		</div>
	</section>
	
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>