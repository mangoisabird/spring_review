<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top.jsp" %>

<div class = "card">
	<div class = "card-header">
		Get 방식 데이터 얻기
	</div>
	<div class = "card-body">
		<p>param1: ${ch03Dto.param1}</p>
		<p>param2: ${ch03Dto.param2}</p>
		<p>param3: ${ch03Dto.param3}</p>
		<P>param4: ${ch03Dto.param4}</P>
		<p>param5: ${ch03Dto.param5}</p>
	</div>
</div>


<%@ include file="/WEB-INF/views/common/bottom.jsp" %>
