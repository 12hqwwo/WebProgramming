<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chào mừng</title>
</head>
<body>
    <h2>Xin chào, ${username}!</h2>
    <p>Bạn đã đăng nhập thành công.</p>

    <!-- Nút đăng xuất -->
    <a href="${pageContext.request.contextPath}/logoutcontroller">Đăng xuất</a>
</body>
</html>
