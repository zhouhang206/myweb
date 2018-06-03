<%@ page  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>员工信息表</title>
<style type="text/css">
	.title{border-bottom:1px solid #aaa}
	.tab{width:90%;border-left:1px solid #ccc;border-top:1px solid #ccc;}
	.tab td{border-right:1px solid #ccc;border-bottom:1px solid #ccc;}
</style>
</head>
<body>
	<h2 class="title">员工信息表</h2>
	<table class="tab"  align="center" cellspacing="0">
	<tr>
		<td>序号</td>
		<td>姓名</td>
		<td>性别</td>
		<td>生日</td>
		<td>电话</td>
		<td>岗位</td>
		<td>住址</td>
		<td>注销</td>
	</tr>
	<c:forEach items="${emps}" var="p" varStatus="i">
	<c:if test="${i.index%2==0}">
	<tr style="background:#ccc">
	</c:if>
	<c:if test="${i.index%2!=0}">
	<tr style="background:yellow">
	</c:if>
		<td>${i.index+1 }</td>
		<td>${p.name }</td>
		<td>${p.sex }</td>
		<td>${p.birthday }</td>
		<td>${p.phone }</td>
		<td>${p.job }</td>
		<td>${p.addr }</td>
		<td><a href="empdel.do?id=${p.id}">删除</a></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>