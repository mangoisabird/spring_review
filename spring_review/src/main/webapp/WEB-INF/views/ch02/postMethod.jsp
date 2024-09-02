<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@include file="/WEB-INF/views/common/top.jsp" %>

<body>
	<div class="card">
		<div class="card-header">
			POST 방식
		</div>
		<div class="card-body">
			<form method="post" action="postFormTag">
				<div class="mb-3">
					<label for="bno" class="form-label">게시물 번호</label>
					<input type="number" class="form-control" id="bno" name="bno" value=5>
				</div>
				<div class="mb-3">
				  <label for="bkind" class="form-label">게시물 종류</label>
				  <input type="text" class="form-control" id="bkind" name="bkind" value="free">
				</div>
				<!-- 제출 버튼 만드는 방법1 -->
				<input type="submit" value="제출" class="btn btn-info btn-sm">
				<br/>
				<!-- 제출 버튼 만드는 방법2 -->
				<input class="mt-2" type="image" src="${pageContext.request.contextPath}/resources/image/img_submit.gif">
				<br/>
				<!-- 제출 버튼 만드는 방법3 -->
				<button class="mt-2 btn btn-info btm-sm" type="submit">제출</button>
				<input>
				<br/>				
			</form>
		
			<hr/>
			
			<div class="mt-2">
				
				<button onclick="requestPost1()" class="btn btn-info btn-sm mb-2"></button>
				<button onclick="requestPost2()" class="btn btn-info btn-sm mb-2"></button>
				<div id="ajaxResult" class="border mt-2">
				</div>
			</div>
		
			<script>
				function requestPost1(){
					$.ajax({
						url: "postAjax1",
						method: "post",
						success: function(data){
							$("#ajaxResult").html(data);
						}
					})
				}
			
				function requestPost2(){
					$.ajax({
						url: "postAjax2",
						method: "post",
						data: {bno:5, bkind:"free"},
						success: function(data){
							console.log(data);
							var content = "";
							content += "<div class='card'>";
							content += "	<div class='card-header'>AJAX의 JSON 응답</div>";
							content += "	<div class='card-body'>";
							
							data.data.forEach((item)=>{
								content += "<img height='100' src='${pageContext.request.contextPath}/resources/image/photos/" + item + "' class='me-2'>";
							});
							
							content += "	</div>";
							content += "</div>";
							
							$("ajaxResult").html(content);
						}
					})
				}
			</script>
		</div>
		
		
	</div>
			
</body>

<%@include file="/WEB-INF/views/common/bottom.jsp" %>
	
