<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<link rel="stylesheet" href="/resources/css/store/view.css" type="text/css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

<script>
	function replyList() {
		
		var gdsNum = ${view.gdsNum};
		$.getJSON("/store/view/replyList" + "?n=" + gdsNum, function(data) {
			var str = "";
			
			$(data).each(function() {
				
				console.log(data);
				
				var repDate = new Date(this.repDate);
				repDate = repDate.toLocaleDateString("ko-US")
				
				str += "<li data-repNum='" + this.gdsNum + "'>"
			 		+ "<div class='userInfo'>"
		     		+ "<span class='userName'>" + this.userName + "</span>"
		     		+ "<span class='date'>" + repDate + "</span>"
		     		+ "</div>"
		     		+ "<div class='replyContent'>" + this.repCon + "</div>"
		     		
		     		+ "<c:if test='${member != null}'>"
		     		
		     		+ "<div class='replyFooter'>"
		     		+ "<button type='button' class='modify' data-repNum='" + this.repNum + "'>수정</button>&nbsp;"
		     		+ "<button type='button' class='delete' data-repNum='" + this.repNum + "'>삭제</button>"
		     		+ "</div>"
		     		
		     		+ "</c:if>"
		     		
		     		+ "</li>";
			});
			
			$("section.replyList ol").html(str);
		});
	}
</script>

</head>
<body>

	<%@include file ="/WEB-INF/views/common/header.jsp" %>
	<br>
	<%@include file ="/WEB-INF/views/common/storeAside.jsp" %>
	
	<section id="container">
		<div id="container_box">
			
			<section id="content">
				<form role="form" method="post">
 					<input type="hidden" name="gdsNum" value="${view.gdsNum}" />
				</form>

				<div class="goods">
					<table id="tbl_goods">
						<tr>
							<td>
		 						<div class="goodsImg">
		  							<img src="${view.gdsImg}">
		 						</div>
		 					</td>
		 					<td>
								<div class="goodsInfo">
  									<p class="cateName">${view.cateName}</p>
  									<p class="gdsName">${view.gdsName}</p>
  									<p class="gdsPrice">
   										<fmt:formatNumber pattern="###,###,###" value="${view.gdsPrice}" /> 원
  									</p>
  									<p class="gdsStock">
   										<span>잔여 수량 </span><fmt:formatNumber pattern="###,###,###" value="${view.gdsStock}" /> EA
  									</p>
  									<p class="cartStock">
   										<span>구매 수량 </span>
   										<button type="button" class="minus">-</button>
   										<input type="number" class = "numBox" cmin="1" max="${view.gdsStock}" value="1" />
   										<button type="button" class="plus">+</button>   									
   										
   										<script>
   											$(".plus").click(function() {
   												var num = $(".numBox").val();
   												var plusNum = Number(num) + 1;
   												
   												if(plusNum >= ${view.gdsStock}) {
   													$(".numBox").val(num);
   												} else {
   													$(".numBox").val(plusNum);
   												}
   											});
   											
   											$(".minus").click(function() {
   												var num = $(".numBox").val();
   												var minusNum = Number(num) - 1;
   												
   												if(minusNum <= 0) {
   													$(".numBox").val(num);
   												} else {
   													$(".numBox").val(minusNum);
   												}
   											});
   										</script>  
  									</p>
  									<p class="addToCart">
   										<button type="button" id="btnCart">
   											<div id="btnCartImg">
   												<img src="/resources/images/store_cart.png" id="btnCartImgSize">
   											</div>
   										</button>
   										
   										<script>
   											$("#btnCart").click(function() {
   												var gdsNum = $("#gdsNum").val();
   												var cartStock = $(".numBox").val();
   												
   												var data = {
   														gdsNum: gdsNum,
   														cartStock: cartStock
   												};
   												
   												$.ajax({
   													url: "/store/view/addCart",
   													type: "post",
   													data: data,
   													success: function(result) {
   														if(result == 1) {
   															alert("장바구니에 추가하였습니다.")
   	   														$(".numBox").val("1");
   														} else {
   															alert("로그인 후 이용 가능합니다.")
   															$(".numBox").val("1");
   														}
   													},
   													error: function() {
   														alert("장바구니에 담지 못하였습니다.")
   													}
   												});
   											});
   										</script>
  									</p>
 								</div>
 							</td>
 						</tr>
 						<tr>
 							<td colspan="2">
 								<div class="gdsDes">${view.gdsDes}</div>
 								<hr id="header_line">
 							</td>
 						</tr>
 						<tr>
 							<td colspan="2">
 								<div id="reply">
 								<h3>상품 후기</h3>
 									<c:if test="${member == null }">
 										<p>후기를 남기시려면 <a href="/member/logIn" id="toLogIn">로그인 </a>해주세요</p>
 									</c:if>
 									
 									<c:if test="${member != null }">
	 									<section class="replyForm">
	  										<form role="form" method="post" autocomplete="off">
	  										<input type="hidden" name="gdsNum" id="gdsNum" value="${view.gdsNum }">
	   											<div class="input_area">
	   												<textarea name="repCon" id="repCon"></textarea>
	   											</div>
	   											<div class="input_area">
	   												<button type="button" id="btnReply">등록</button>
	   												
	   												<script>
	   											 		$("#btnReply").click(function(){
	   											  
		   											  		var formObj = $(".replyForm form[role='form']");
		   											  		var gdsNum = $("#gdsNum").val();
		   											  		var repCon = $("#repCon").val()
		   											  
				   											var data = {
		   											  			gdsNum : gdsNum,
				   											    repCon : repCon
				   											    };
				   											  
		   											  		$.ajax({
		   											  			url : "/store/view/registReply",
		   											  			type : "post",
		   											  			data : data,
		   											  			success : function(){
				   											    replyList();
				   											    $("#repCon").val("");
				   											   	}
		   											  		});
		   											  	});
	   												</script>
	   											</div>
	  										</form>
	 									</section>
	 								</c:if>
	 									
	 								<section class="replyList">
	  									<ol>
	  										<!-- 
	  										<c:forEach items="${reply }" var="reply">
		   										<li>
		   											<div class="userInfo">
		   												<span class="userName">${reply.userName }</span>
		   												<span class="date"><fmt:formatDate value="${reply.repDate }" pattern="yyyy-MM-dd" /></span>
		   											</div>
		   											<div class="replyContent">${reply.repCon }</div>
		   										</li>
	   										</c:forEach>
	  										 -->
	   									</ol>
	   									
	   									<script>
	   										replyList();
	   									</script>
	   									
	   									<script>
		   									$(document).on("click", ".modify", function(){
		   										$(".replyModal").fadeIn(200);
		   										
		   										var repNum = $(this).attr("data-repNum");
		   									 	var repCon = $(this).parent().parent().children(".replyContent").text();
		   									 
		   									 	$(".modal_repCon").val(repCon);
		   									 	$(".modal_modify_btn").attr("data-repNum", repNum);
		   									});
		   								
	   										$(document).on("click", ".delete", function(){
	   											var data = {repNum : $(this).attr("data-repNum")};

		   										$.ajax({
		   											url : "/store/view/deleteReply",
		   								   			type : "post",
		   								   			data : data,
		   								   			success : function(result){
		   								   				if(result == 1) {
		   								   					var deleteConfirm = confirm("정말로 삭제하시겠습니까?");
		   								   					if(deleteConfirm) {
		   								   						replyList();
		   								   					}
		   								   				} else {
		   								   					alert("삭제 권한이 없습니다.")
		   								   				}
		   								   			},
		   								   			error: function() {
		   								   				alert("로그인 후 이용 가능합니다.")
		   								   			}
		   										});
	   										});
	   									</script>
	
										
 									</section>
								</div>
							</td>
 					</table>
				</div>
		
		</div>
	</section>
	
	<div class="replyModal">
		<div class="modalContent">
			<div>
   				<textarea class="modal_repCon" name="modal_repCon"></textarea>
  			</div>
  			<div>
   				<button type="button" class="modal_modify_btn">수정</button>
   				<button type="button" class="modal_cancel">취소</button>
  			</div>
  		</div>

 		<div class="modalBackground"></div>
 
	</div>
	
	<script>
		$(".modal_cancel").click(function(){
			$(".replyModal").fadeOut(200);
		});
	</script>
	
	<script>
		$(".modal_modify_btn").click(function(){
			var modifyConfirm = confirm("정말로 수정하시겠습니까?");
		   									 
			if(modifyConfirm) {
				var data = {
						repNum : $(this).attr("data-repNum"),
						repCon : $(".modal_repCon").val()
				}; 
				
				$.ajax({
					url: "/store/view/modifyReply",
					type: "post",
					data: data,
					success: function(result){
		   									    
						if(result == 1) {
							replyList();
							$(".replyModal").fadeOut(200);
						} else {
							alert("수정 권한이 없습니다.");       
						}
					},
					error : function(){
						alert("로그인 후 이용 가능합니다.")
					}
				});
			}
		});

	</script>
	
	
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>