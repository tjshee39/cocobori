<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코코보리</title>
<link rel="stylesheet" href="/resources/css/community/register.css" type="text/css">
<script src="/resources/ckeditor/ckeditor.js"></script>

</head>

<body>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

	<%@include file ="/WEB-INF/views/common/AdminHeader.jsp" %>
	
	<section id="container">
		<div id="container_box">
			<h1 style="text-align: center;">게시글 등록</h1>
			<hr id="header_line">
			<div id="form_register">
				<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">
	
					<div class="inputArea">
						<label for="boardTitle">제목</label>
					 	<input type="text" id="boardTitle" name="boardTitle" style="width: 340px;" />
					 	<label for="userName">작성자</label>
					 	<input type="hidden" id="userID" name="userID" value="${member.userID }"/>
					 	<input type="text" id="userName" name="userName" value="${member.userName }" readonly style="width: 100px;">
					</div>
					
					<div class="inputArea" id="ckEditor">
						<label for="boardContent" id="input_boardContent">내용</label>
					 	<textarea rows="5" cols="50" id="boardContent" name="boardContent"></textarea>
					 	<script>
							var ckeditor_config = {
						   	resize_enaleb : false,
						   	enterMode : CKEDITOR.ENTER_BR,
						   	shiftEnterMode : CKEDITOR.ENTER_P,
						   	filebrowserUploadUrl : "/comunity/register"
						 	};
						 
						 	CKEDITOR.replace("boardContent", ckeditor_config);
						</script>
					</div>
					
					<div class="inputArea">
						<label for="boardImg">이미지</label>
						<input type="file" id="boardImg" name="file" />
						<div class="select_img"><img src="" /></div>
						
						<script>
							//어떤 이미지 선택했는지 보여줌
							$("#boardImg").change(function(){ 
								if(this.files && this.files[0]) {
									var reader = new FileReader;
									reader.onload = function(data) {
										$(".select_img img").attr("src", data.target.result).width(500);        
										}
									reader.readAsDataURL(this.files[0]);
								}
							});
 	
						</script>
						
					</div>
					
					
					<div class="inputArea">
						<button type="submit" id="btn_register" class="btn btn-primary">등록</button>
					</div>
					
				</form>
			</div>
		</div>
	</section>
	
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>

</body>

</html>