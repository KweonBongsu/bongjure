<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body,td{
		color:#777777; font-family:"돋움체";		
	}
</style>
</head>
<body>
<div align="center">
<c:set var="list" value="${requestScope.bList}"/>
	<table cellpadding="0" cellspacing="0" border="1" width="900">
  		<tr>
  			<td colspan="7" bgcolor="ffaaee" align="center">
  				<h3>게시판</h2>
  			</td>
  		</tr>
  		<tr>
  		    <td><b>순서</b></td>
  			<td><b>제목</b></td>
  			<td><b>글쓴이</b></td>
  			<td><b>내용</b></td>
  			<td><b>이메일</b></td>
  			<td><b>조회수</b>
  			<td><b>수정/삭제</b></td>
  			<td><b>상세보기</b></td>  			
  		</tr>
<c:if test="${empty list}">
	  	<tr>
	  		<td colspan="6" align="center">게시판이 없습니다.!!!!</td>
	  	</tr>
</c:if>
<c:forEach var="board" items="${list}">	  	
  		<tr>
  		    <td>${board.seq}</td>
  		    <td>${board.title}</td>
  			<td>${board.writer}</td>
  			<td>${board.content}</td>
  			<td>${board.email}</td>
  			<td>${board.hit}</td>
  			<td>
  				<a href="bUpdateForm.do?email=${board.email}">수정</a>/
  				<a href="bRemove.do?email=${board.email}">삭제</a> 
  			</td>
  			<td>
  	         <a href="bView.do?idx=${board.idx}">상세보기</a>
  			</td>  			
  		</tr>
</c:forEach>  		
	</table>
	
	<hr/>
	<a href="join-form.do">글쓰기</a>
</div>
</body>
</html>