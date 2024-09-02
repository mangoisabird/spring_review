<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- include 지시자의 역할: 외부의 파일의 내용을 가져와서 삽입시켜줌 --%>

<%@ include file="/WEB-INF/views/common/top.jsp" %>
	
<div class="card">
	<div class="card-header">
		파일 업로드
	</div>

	<div class="card-body">
		<form method="post" enctype="multipart/form-data" action="singleFileUpload">
			<div class="form-group">
				<label for="title">File Title</label>
				<input type="text" class="form-control" id="title" name="title" placeholder="제목">
			</div>
			<div class="mt-2 form-group">
				<label for="desc">File Description</label>
				<input type="text" class="form-control" id="desc" name ="desc" placeholder="설명">
			</div>
			
		</form>
		
		<hr/>
		
		<form>
		</form>
	</div>
</div> 

<%-- include 액션의 역할: 외부의 JSP를 실행하고 그 결과를 삽입시켜줌 --%>
<jsp:include page="/WEB-INF/views/common/bottom.jsp"/>         