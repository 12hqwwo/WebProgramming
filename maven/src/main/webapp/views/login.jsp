<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<jsp:include page="/views/topbar.jsp" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
	<form action="trangchu" method="post">
    <h2>Đăng nhập</h2>
    <c:if test="${alert !=null}">
        <h3 class="alert alertdanger">${alert}</h3>
    </c:if>
    <section>
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" placeholder="Tài khoản" name="username"
                       class="form-control" required>
            </div>
        </label>
    </section>
    <section>
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                <input type="password" placeholder="Mật khẩu" name="password"
                       class="form-control" required>
            </div>
        </label>
    </section>
    <button type="submit">Đăng nhập</button>
</form>

</body>
</html>