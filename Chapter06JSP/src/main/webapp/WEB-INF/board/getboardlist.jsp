<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>게시글 목록</h1>
	<table border="1">
		<tr>
			<td>seq</td>
			<td>title</td>
			<td>writer</td>
			<td>content</td>
			<td>createDate</td>
			<td>cnt</td>
		</tr>
			<c:forEach var="board" items="${boardList }">
				<tr>
					<td>${board.seq }</td>
					<td align="left"><a href="getBoard?seq=${board.seq}">${board.title }</a></td>
					<td>${board.writer }</td>
					<td>${board.content }</td>
					<%-- <td><fmt:formatDate value="${board.createDate }" 
					pattern="yyyy-MM-dd"></fmt:formatDate></td> --%>
					<td>${board.createDate }</td>
					<td>${board.cnt }</td>
				</tr>
			</c:forEach>
	</table>
<br />
<a th:href="@{/insertBoard}">글등록</a>&nbsp;&nbsp;&nbsp;
</center>
</body>
</html>