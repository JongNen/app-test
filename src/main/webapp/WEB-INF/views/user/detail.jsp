<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resource/css/style.css?${millis }" />
<title>list</title>
</head>
<body>
	<form action = "/user/modify" method = "post">
	<table border = "1" cellspacing="0">
		<tr>
			<th width="10%">작성코드</th>
			<th width="10%">제목</th>
			<th width="10%">내용</th>
		</tr>
		<c:forEach var="r" items="${detail }">
			<tr>
				<td align="center" style="padding: 100px;">${r.id }</td>
				<td align="center" style="padding: 100px;">${r.title }</td>
				<td align="center" style="padding: 100px;">${r.content }</td>
			</tr>
		</c:forEach>
	</table>
			
	
		<input type="hidden" name="id" value="${r.id}"/>
		<button type="submit" class="join-btn">수정</button>
	
	</form>
		
	<button onclick="location.href='/user/delete'">삭제</button>
	

</body>
</html>