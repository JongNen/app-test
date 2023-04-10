<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resource/css/style.css?${millis }" />
<title>M.O.I.M</title>

</head>
<body>
	
	<div class="root">
		<form action="/user/login-task" method="post" >
			<h2>로그인</h2>
			<div style="margin: 0.4em">
				<input type="text" placeholder="아이디" name="id" class="join-input" value = "alss" />
			</div>
			<div style="margin: 0.4em">
				<input type="password" placeholder="비밀번호" name="pass" class="join-input" value = "1111"/>
			</div>
			
		

			<div style="margin: 0.4em">
				<button type="submit" class="join-btn">다음</button>
			</div>			
			<a href ="/index">비회원으로 접속</a>
		</form>
		
	</div>

	
	
	
</body>
</html>