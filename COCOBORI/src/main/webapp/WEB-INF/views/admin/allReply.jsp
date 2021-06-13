<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<link rel="stylesheet" href="/resources/css/admin/allReply.css" type="text/css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body>

	<%@include file ="/WEB-INF/views/common/AdminHeader.jsp" %>
	<br>
	
	<section id="container">
		<div id="container_box">
			
			<section id="content">
				<ul>
  					<c:forEach items="${reply}" var="reply">
  						<li>
   							<div class="replyInfo">
    							<p>
     								<span>작성자</span>${reply.userName} (${reply.userID})
    							</p>
    							<p>
     								<span>작성된 상품</span> <a href="/store/view?n=${reply.gdsNum}" style="color: #ff0080;">바로가기</a>
    							</p>
   							</div>
   							<div class="replyContent">
    							${reply.repCon}
   							</div>
   							<div class="replyControll">
   								<form role="form" method="post">
   									<input type="hidden" name="repNum" value="${reply.repNum }" />
									<button type="submit" class="delete_${reply.repNum}_btn">삭제</button>
   								</form>
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