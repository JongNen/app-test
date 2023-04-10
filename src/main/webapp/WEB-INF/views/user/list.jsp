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
	<div class="board" >
		
				<c:forEach items="${list }" var="post">
				
					<div class="post"
						onclick="location.href='/user/detail?id=${post.id}'">
						<h2 class="title" >
						${post.title }
						</h2>
						
					</div>
				</c:forEach>
			</div>
				<a href = "/user/write" class="link">글 작성하기</a>
		</div>	

</body>
</html>