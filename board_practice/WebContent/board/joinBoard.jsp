<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function join() {
		//alert(frm.elements.length);
		//alert(frm.elements[1].value);
		// 입력사항 체크
		for (var i = 0; i < frm.elements.length; i++) {
			if (!frm.elements[i].value) {
				alert("입력하신 정보를 다시 확인하세요!!!");
				frm.elements[i].focus();
				return;
			}//if
		}//for End

		frm.action = "post-join.do";
		frm.submit();
	} //join()

	function memberList() {
		frm.action = "bList.do";
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<table cellpadding="0" cellspacing="0" border="1">
			<form name="frm" method="post">
				<tr>
					<td colspan="2" align="center"><h3>봉쥬르 게시판</h3></td>
				</tr>
			<td>제목</td>
			<td><input type="text" name="title" placeholder="제목" /></td>
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="writer" placeholder="글쓴이"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content" placeholder="내용" size="50"/></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" placeholder="이메일"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button"
					value="등록" onclick="join()" /> <input type="button" value="게시판 목록"
					onclick="bList()" /></td>
			</tr>
			</form>
		</table>

	</div>
</body>
</html>