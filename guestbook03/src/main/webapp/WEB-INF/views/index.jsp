<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>

<body>
	<c:set var="count" value="${fn:length(list) }"/>
	<form action="${pageContext.request.contextPath }/add" method="post">
		<table border=1 width=500>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
			</tr>
		</table>
	</form>
	<br>


	<c:forEach items="${list }" var="vo" varStatus="status">
		<ul>
			<li>
				<table border="1px" cellspacing="0" cellpadding="10">
					<tr>
						<td>[${count-status.index }]</td>
						<td>${vo.name }</td>
						<td>${vo.reg_date }</td>
						<td><a
							href="${pageContext.request.contextPath}/delete?no=${vo.no}">삭제</a></td>
					</tr>
					<tr>
						<td colspan=4>${fn:replace(vo.message, newline, "<br/>")}</td>
					</tr>
				</table> <br>
			</li>
		</ul>
	</c:forEach>
</body>
</html>