<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đặt lại mật khẩu</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow rounded">
                <div class="card-body">
                    <h2 class="text-center mb-4">Đặt lại mật khẩu</h2>

                    <form action="${pageContext.request.contextPath}/reset" method="post">
                        <div class="mb-3">
                            <label class="form-label">Mật khẩu mới</label>
                            <input type="password" name="newPassword" class="form-control" required>
                        </div>
                        <button type="submit" class="btn btn-success w-100">Cập nhật mật khẩu</button>
                    </form>

                    <div class="text-center mt-3">
                        <a href="${pageContext.request.contextPath}/trangchu">Quay lại đăng nhập</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
