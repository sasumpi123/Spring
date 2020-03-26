<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="hidden" name="myno" value="${boardDto.myno}">
	<table border="1">
		<tr>
			<td>제목</td>
			<td>${boardDto.mytitle}</td> 
		</tr>
		<tr>
			<td>작성자</td>
			<td>${boardDto.myname}</td> 
		</tr>
		<tr>
			<td>내용</td>
			<td>${boardDto.mycontent}</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${boardDto.mydate}</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" onclick="location.href='update.do?myno=${boardDto.myno}'">
				<input type="button" value="삭제" onclick="location.href='delete.do?myno=${boardDto.myno}'">
				<input type="button" value="목록으로" onclick="location.href='list.do'">
			</td>
		</tr>
	</table>

</body>
</html>