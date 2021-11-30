<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <title>Title</title>
</head>
<body>
<h1>Danh sách </h1>
<table>
    <tr>
        <td>id</td>
        <td>tên</td>
        <td>toán</td>
        <td>lý</td>
        <td>hóa</td>
        <td>sửa</td>
        <td>xóa</td>
    </tr>

<c:forEach items='${requestScope["students"]}' var="student">
    <tr>
        <td>${student.getId()}</td>

        <td>${student.getName()}</td>

        <td>${student.getMath()}</td>

        <td>${student.getPhysics()}</td>

        <td>${student.getChemistry()}</td>

        <td><a href="/students?action=edit&id=${student.id}">sửa</a></td>

        <td><a href="/students?action=delete&id=${student.getId()}">Xóa</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
