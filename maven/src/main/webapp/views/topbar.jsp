<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!-- Topbar -->
<div class="d-flex justify-content-end align-items-center p-2 bg-light shadow-sm rounded">
    <c:choose>
        <c:when test="${sessionScope.account == null}">
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link text-primary fw-bold" href="${pageContext.request.contextPath }/trangchu">
                        <i class="fa fa-sign-in"></i> Đăng nhập
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-success fw-bold" href="${pageContext.request.contextPath }/register">
                        <i class="fa fa-user-plus"></i> Đăng ký
                    </a>
                </li>
            </ul>
        </c:when>
        <c:otherwise>
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link text-dark fw-bold" href="${pageContext.request.contextPath }/member/myaccount">
                        <i class="fa fa-user-circle"></i> ${sessionScope.account.fullName}
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-danger fw-bold" href="${pageContext.request.contextPath }/logout">
                        <i class="fa fa-sign-out"></i> Đăng xuất
                    </a>
                </li>
            </ul>
        </c:otherwise>
    </c:choose>
</div>
