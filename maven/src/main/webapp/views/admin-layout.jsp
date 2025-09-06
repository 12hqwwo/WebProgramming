<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />

<style>
body {
	margin: 0;
	font-family: Arial, sans-serif;
}

.sidebar {
	width: 270px;
	background: #1e1e2f;
	color: white;
	height: 100vh;
	padding: 20px;
	position: fixed;
	top: 0;
	left: 0;
	overflow-y: auto;
}

.sidebar a {
	color: white;
	display: block;
	margin: 10px 0;
	text-decoration: none;
	font-size: 18px;
	padding: 14px 18px;
	border-radius: 8px;
	transition: all 0.3s ease;
	font-weight: 500;
}

.sidebar a i {
	margin-right: 12px;
}

.sidebar a:hover {
	padding-left: 25px;
	opacity: 0.9;
}

.sidebar a.active {
	font-weight: bold;
	border: 2px solid #fff;
}

.sidebar a.dashboard {
	background: #08519c;
}

.sidebar a.category {
	background: #3182bd;
}

.sidebar a.product {
	background: #6baed6;
}

.sidebar a.user {
	background: #9ecae1;
}

.submenu {
	margin-left: 20px;
	margin-top: 5px;
}

.submenu a {
	background: #333;
	font-size: 16px;
	padding: 10px 15px;
}

.submenu a:hover {
	background: #555;
}

.content {
	margin-left: 270px;
	padding: 0;
}

.topbar {
	background: #2196f3;
	color: white;
	padding: 15px 20px;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.main-content {
	padding: 20px;
}
</style>
</head>
<body>

	<!-- Sidebar -->
	<div class="sidebar">
		<div class="text-center mb-4">
			<!-- Form upload -->
			<form action="${pageContext.request.contextPath}/admin/upload-avatar" 
      method="post" enctype="multipart/form-data">

				<input type="file" name="imageFile" id="imageInput"
					class="form-control mb-2" accept="image/*" required />
				<button type="submit" class="btn btn-primary btn-sm">Upload</button>
			</form>

			<!-- Hiển thị ảnh Admin -->
			<img id="avatarPreview"
				src="${pageContext.request.contextPath}/image/${empty sessionScope.avatar ? 'admin.png' : sessionScope.avatar}"
				width="120" height="120"
				class="rounded-circle border border-2 border-light mt-2" />

			<p class="mt-2 fw-bold">Bạn là Admin</p>
		</div>

		<script>
    // Khi người dùng chọn file
    document.getElementById("imageInput").addEventListener("change", function (event) {
        const file = event.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function(e) {
                // Đổi ảnh preview ngay
                document.getElementById("avatarPreview").src = e.target.result;
            }
            reader.readAsDataURL(file);
        }
    });
</script>

		<a href="${pageContext.request.contextPath}/dashboard"
			class="dashboard active"> <i class="fa fa-home"></i> Dashboard
		</a> <a href="#" class="category"> <i class="fa fa-folder"></i> Quản
			lý Danh mục
		</a>
		<div class="submenu">
			<a href="${pageContext.request.contextPath}/admin/category/add">
				<i class="fa fa-plus-circle"></i> Thêm danh mục mới
			</a> <a href="${pageContext.request.contextPath}/admin/category/list">
				<i class="fa fa-list"></i> Danh sách danh mục
			</a>
		</div>

		<a href="${pageContext.request.contextPath}/admin/product/list"
			class="product"> <i class="fa fa-box"></i> Quản lý Sản phẩm
		</a> <a href="${pageContext.request.contextPath}/admin/user/list"
			class="user"> <i class="fa fa-user"></i> Quản lý Tài khoản
		</a>
	</div>

	<!-- Nội dung -->
	<div class="content">
		<div class="topbar">
			<span>Xin chào ${sessionScope.account.fullName}</span> <a
				href="${pageContext.request.contextPath}/logoutcontroller"
				class="btn btn-danger btn-sm">Đăng xuất</a>
		</div>

		<div class="main-content">
			<jsp:include page="${contentPage}" />
		</div>
	</div>
</body>
</html>
