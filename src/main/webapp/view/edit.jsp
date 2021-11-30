<%--
  Created by IntelliJ IDEA.
  User: UyLe
  Date: 11/30/2021
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="number" name="id" value="${edit.getId()}">
    <input type="text" name="name" value="${edit.getName()}">
    <input type="number" name="math" value="${edit.getMath()}">
    <input type="number" name="physics" value="${edit.getPhysics()}">
    <input type="number" name="chemistry" value="${edit.getChemistry()}">
    <button>sửa</button>
</form>
</body>
</html>

