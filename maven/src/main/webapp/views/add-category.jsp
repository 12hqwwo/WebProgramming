<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm danh mục</title>
    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-lg border-0 rounded-3">
        <div class="card-header bg-primary text-white text-center fw-bold">
            ➕ Thêm danh mục mới
        </div>
        <div class="card-body p-4">
            <form action="${pageContext.request.contextPath}/admin/category/add" method="post" enctype="multipart/form-data">
                
                <!-- Tên danh mục -->
                <div class="mb-3">
                    <label for="catename" class="form-label fw-semibold">Tên danh mục</label>
                    <input type="text" id="catename" name="catename" 
                           class="form-control" placeholder="Nhập tên danh mục..." required>
                </div>

                <!-- Icon -->
                <div class="mb-3">
                    <label for="icon" class="form-label fw-semibold">Icon (ảnh)</label>
                    <input type="file" id="icon" name="icon" 
                           class="form-control" accept="image/*">
                </div>

                <!-- Nút -->
                <div class="d-flex justify-content-between">
                    <a href="${pageContext.request.contextPath}/admin/category/list" class="btn btn-secondary">
                        ⬅ Quay lại
                    </a>
                    <button type="submit" class="btn btn-success">
                        💾 Lưu danh mục
                    </button>
                </div>

            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
