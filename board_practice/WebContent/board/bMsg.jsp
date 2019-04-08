<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="msg" value="${requestScope['bMsg']}"/>
<c:set var="url" value="${requestScope['bUrl']}"/> 

<c:if test="${msg ne null && url ne null}">
<script>
	alert("${msg}");
	location.href="${url}";
</script>
</c:if>

