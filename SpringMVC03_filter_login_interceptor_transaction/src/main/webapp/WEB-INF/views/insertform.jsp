<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="insertres.do" method="post">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="mytitle"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="30" name="mycontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글 작성">
					<input type="button" value="취소" onclick="location.href='list.do'">
				</td>
			</tr>
		</table>
		
	</form>

</body>
</html>