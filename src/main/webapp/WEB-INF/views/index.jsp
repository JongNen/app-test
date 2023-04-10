<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>.</title>
</head>
<body>	
	<c:choose>
	<c:when test = "${empty logonUser }">
		<b>비회원으로 접속하셨습니다.</b>
		<br></br>
		<a href = "/user/login">로그인 하기</a>
	</c:when>
		<c:otherwise>
		
			<b>${logonUser.id }님 반갑습니다.</b> <a href="/user/logout">로그아웃</a>
			
 
		
		</c:otherwise>
	
	</c:choose>
	
	<br></br>
	<a href ="/user/write">글 작성하기</a>
	<br></br>
	<a href ="/user/list">게시판으로 이동</a>
</body>
</html>