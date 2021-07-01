<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<link rel="stylesheet" href="/resources/css/community/boardView.css" type="text/css">
</head>
<body>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

	<%@include file ="/WEB-INF/views/common/AdminHeader.jsp" %>
	
	<section id="container">
		<div id="container_box">
			<h1 style="text-align: center;">게시글 조회</h1>
			<hr id="header_line">
			<div id="form_view">
				<form role="form" method="post" autocomplete="off">
					<input type="hidden" name="n" value="${view.boardNum}" />
				</form>
				
				<div class="board">
					<table id="tbl_community">
						<tr class="tbl_community_title">
							<td style="width: 30px; text-align: center; border-right: 1px solid #ffb5bc;"><label>제목</label></td>
							<td style="width: 500px; text-align: left; border-right: 1px solid #ffb5bc; padding-left: 10px;">${view.boardTitle}</td>
							<td style="width: 30px; text-align: center; border-right: 1px solid #ffb5bc;"><label>작성자</label></td>
							<td style="text-align: center;">${view.userName }</td>
						</tr>
						<tr class="tbl_community_title">
							<td style="text-align: center; width: 800px;" colspan="4"><label>내용</label></td>
						</tr>
						<tr>
							<td colspan="4" style="padding: 20px;">
								${view.boardContent }
		 						<div class="boardImg">
		  							<img src="${view.boardImg}">
		 						</div>
		 					</td>
		 				</tr>	
					</table>	
				</div>
			</div>
		</div>
	</section>
	
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>

</body>
<script>

	var formObj = $("form[role='form']");

	$("#btn_modify").click(function(){
 		formObj.attr("action", "/admin/goodsModify");
 		formObj.attr("method", "get")
 		formObj.submit();
	});

	$("#btn_delete").click(function(){
		
		var con = confirm("상품을 삭제하시겠습니까?");
		
		if(con) {
			formObj.attr("action", "/admin/goodsDelete");
			formObj.submit();
		}
	});
	
</script>
</html>