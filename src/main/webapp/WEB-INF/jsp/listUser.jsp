<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>用户id</td>
        <td>名称</td>
        <td>密码</td>
        <td>年龄</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="st">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.password}</td>
            <td>${user.age}</td>
            <td><a id="${user.id}" class="button" href="editUser?id=${user.id}&userName=${user.userName}&password=${user.password}&age=${user.age}">编辑</a></td>
            <td><a>编辑</a></td>
        </tr>
    </c:forEach>
</table>
<div style="text-align:center">
        <a href="?start=0">首  页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        <a href="?start=${page.start+page.count}">下一页</a>
        <a href="?start=${page.last}">末  页</a>
</div>