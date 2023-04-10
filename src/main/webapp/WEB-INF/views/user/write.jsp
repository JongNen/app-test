<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
<link rel="stylesheet" href="/resource/css/style.css?${millis }" />
</head>
<body>
	<div class="root">
		<h2 style="margin: 15px 0px;">글 작성</h2>
		
		<form action="/user/write-task" method="post" class="moim-form"
			autocomplete="off">
			<div class="block">
				<label>글 제목
				</label>
				<div class="block">
					<input type="text" name="title" style="flex: 1" />
				</div>
			</div>
				
			<div class="block">
				<label>글 내용</label>
				<div class="block" style="min-height: 120px">
					<textarea style="resize: none; flex: 1" name="content"></textarea>
				</div>
			</div>
			<c:if test = "${empty logonUser}">
			
				<label>닉네임</label>
				<div class="block">
					<input type="text" name="userId" style="flex: 1" />
				</div>
			
				<label>비밀번호</label>
				<div class="block-a">
					<input type="text" name="userPass" style="flex: 1" />
				</div>
			</c:if>
			
			
			<div class="block">
				<button type="submit">글 작성하기</button>
			</div>
			<a href = "/user/list">리스트로 돌아가기</a>
		</form>
	</div>
</body>
</html>