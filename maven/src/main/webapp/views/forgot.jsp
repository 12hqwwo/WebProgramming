<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow rounded">
                <div class="card-body">
                    <h2 class="text-center mb-4">Quên mật khẩu</h2>

                    <c:if test="${alert != null}">
                        <div class="alert alert-danger">${alert}</div>
                    </c:if>
                    <c:if test="${msg != null}">
                        <div class="alert alert-success">${msg}</div>
                    </c:if>

                    <form action="${pageContext.request.contextPath}/forgot" method="post">
                        <div class="mb-3">
                            <label class="form-label">Nhập gmail của bạn</label>
                            <input type="email" name="email" class="form-control" required>
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Xác nhận</button>
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
