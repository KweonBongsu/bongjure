<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="board" value="${requestScope.board}"/>
<c:if test="${board eq null}">
	<c:redirect url="bList.do"/> 
</c:if>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td, body { 
		font-family:"돋움체";
		}
</style>
<script type="text/javascript">
	
	function update(){
		//alert(frm.elements.length);
		//alert(frm.elements[1].value);
		// 입력사항 체크
		for(var i=0;i<frm.elements.length;i++){
			if(!frm.elements[i].value){
				alert("입력하신 정보를 다시 확인하세요!!!");
				frm.elements[i].focus();
				return;
			}//if
		}//for End
		
		frm.action ="postbUpdate.do";
		frm.submit();
	} //join()
	
	function boardList(){
		frm.action = "bList.do";
		frm.submit();
	}
	
</script>
</head>
<body>
<div align="center">
<table cellpadding="0" cellspacing="0" border="1" width="500">
<form name = "frm" method="post">
<tr>
<td colspan="2" align="center" bgcolor="#aaff33"><h3>게시판 정보 수정</h3></td>
</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="title" value="${board.title}"/></td>
	</tr>
	<tr>
		<td>글쓴이</td>
		<td><input type="password" name="writer" value="${board.writer}"/></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input type="text" name="content" value="${board.content}"/></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="email" value="${board.email}"/></td>
	</tr>
	<tr>		
		<td colspan="2" align="center">
		<input type="button" value="글쓰기수정" onclick="update()"/>
		<input type="button" value="목록" onclick="boardList()"/>
		</td>
	</tr>	
</form>	
</table>

</div>
</body>
</html>