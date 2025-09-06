<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<h2 style="color: #151b54; font-weight: bold;">Quản lý danh mục</h2>
<p class="text-muted">Đây là nơi bạn có thể theo dõi, chỉnh sửa và quản lý các danh mục sản phẩm.</p>

<div class="card border-secondary mb-3">
  <div class="card-header bg-light fw-bold">Danh sách danh mục</div>
  <div class="card-body">
    <div class="d-flex justify-content-end mb-2">
      <input type="text" class="form-control w-25" placeholder="Tìm kiếm danh mục...">
    </div>

    <c:choose>
      <c:when test="${not empty cateList}">
        <div class="table-responsive">
          <table class="table table-bordered table-striped mb-0">
            <thead class="table-dark">
              <tr>
                <th>STT</th>
                <th>Hình ảnh</th>
                <th>Tên danh mục</th>
                <th>Hành động</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="cat" items="${cateList}" varStatus="st">
                <tr>
                  <td>${st.index + 1}</td>
                  <td>
                    <c:if test="${not empty cat.icon}">
                      <img src="${pageContext.request.contextPath}/image/${cat.icon}" width="60" alt="icon"/>
                    </c:if>
                  </td>
                  <td>${cat.catename}</td>
                  <td>
                    <a href="${pageContext.request.contextPath}/admin/category/edit?id=${cat.cateid}" class="btn btn-sm btn-warning">Sửa</a>
                    <a href="${pageContext.request.contextPath}/admin/category/delete?id=${cat.cateid}" class="btn btn-sm btn-danger">Xóa</a>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </c:when>
      <c:otherwise>
        <p class="text-danger fw-bold">⚠️ Hiện chưa có danh mục nào.</p>
      </c:otherwise>
    </c:choose>
  </div>
</div>
