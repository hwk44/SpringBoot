<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>글 상세</title>
</head>
<body>
	<center>
		<h1>게시글 상세</h1>
		<hr>
		<form action="updateBoard" method="post">
			<input name="seq" type="hidden" value=" ${board.seq}"/>
			<table border="1" cellpaddin="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input type="text" name="title"
						value="${board.title }" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left">${board.writer }</td>
				</tr>
					<tr>
					<td bgcolor="orange">내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10">
					${board.content }</textarea></td>
				</tr>
				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left">${board.createDate }</td>
				</tr>
				<tr>
					<td bgcolor="orange">조회수</td>
					<td align="left">${board.cnt }</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="글 수정" /></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertBoardView">글등록</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteBoard?seq=${board.seq }">글삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList">글목록</a>&nbsp;&nbsp;&nbsp;
		
	</center>

</body>
</html>