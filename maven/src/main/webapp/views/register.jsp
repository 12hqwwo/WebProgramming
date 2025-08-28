<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow rounded">
                <div class="card-body">
                    <h2 class="text-center mb-4">Tạo tài khoản mới</h2>

                    <!-- Thông báo lỗi -->
                    <c:if test="${alert != null}">
                        <div class="alert alert-danger">${alert}</div>
                    </c:if>

                    <form action="${pageContext.request.contextPath}/register" method="post">
                        <div class="mb-3">
                            <label class="form-label">Tài khoản</label>
                            <input type="text" name="username" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Mật khẩu</label>
                            <input type="password" name="password" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input type="email" name="email" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Họ và tên</label>
                            <input type="text" name="fullname" class="form-control" required>
                        </div>

                        <button type="submit" class="btn btn-primary w-100">Đăng ký</button>
                    </form>

                    <div class="text-center mt-3">
                        <p>Bạn đã có tài khoản? <a href="${pageContext.request.contextPath}/trangchu">Đăng nhập</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
