<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="updateres.do" method="post">
		<input type="hidden" name="myno" value="${boardDto.myno}">
		<table border="1">
		<tr>
			<td>제목</td>
			<td><input type="text" name="mytitle" value="${boardDto.mytitle}"></td> 
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="mycontent" value="${boardDto.mycontent}"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정하기">
				<input type="button" value="돌아가기" onclick="location.href='detail.do?myno=${boardDto.myno}'">
			</td>
		</tr>
	</table>
	</form>

</body>
</html>