<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow rounded">
        <div class="card-body">
            <h2>Chào mừng <c:out value="${sessionScope.username}"/></h2>
            <p>Bạn đã đăng nhập thành công!</p>
            <a href="${pageContext.request.contextPath}/logoutcontroller" class="btn btn-danger">Đăng xuất</a>
        </div>
    </div>
</div>
</body>
</html>
