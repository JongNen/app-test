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
		<h2 style="margin: 15px 0px;">글 수정</h2>
		
		<form action="/user/modify-task" method="post" class="moim-form"
			autocomplete="off">
			<input type="hidden" name="id" value="${post.id}" />
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
				<div>
					<button type="submit">글 수정하기</button>
				</div>
	
			
			<a href = "/user/list">리스트로 돌아가기</a>
		</form>
	</div>
</body>
</html>