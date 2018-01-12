<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<ul style="list-style-type: none">
	<li>名称:<input id="userName" name="userName"
		value="${user.userName}" /></li>
	<li>密码:<input id="password" name="password"
		value="${user.password}" /></li>
	<li>年龄:<input id="age" name="age" value="${user.age}" /></li>
</ul>
<a id="save" href="saveUser?id=${user.id}&userName=${user.userName}&password=${user.password}&age=${user.age}">保存</a>
<a id="goback" href="javascript:history.back(-1);">返回</a>

