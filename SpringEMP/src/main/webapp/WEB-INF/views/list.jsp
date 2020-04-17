<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>LIST</h1>
	<table border="1">
		<thead>
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
			<th>mgr</th>
			<th>hiredate</th>
			<th>sal</th>
			<th>comm</th>
			<th>deptno</th>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.empno}</td>
					<td>${dto.ename}</td>
					<td>${dto.job}</td>
					<td>${dto.mgr}</td>
					<td>${dto.hiredate}</td>
					<td>${dto.sal}</td>
					<td>${dto.comm}</td>
					<td>${dto.deptno}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>