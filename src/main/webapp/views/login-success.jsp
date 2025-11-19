<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Đăng nhập thành công</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

    <div class="container login-form">
    
        <c:if test="${not empty sessionScope.currentUser}">
            <h1 style="text-align: center; color: #008000;">Thành công!</h1>
            
            <h3 style="text-align: center; margin-bottom: 30px;">
                Chào mừng, ${sessionScope.username}!
            </h3>
            <p style="text-align: center;">Bạn đã đăng nhập thành công.</p>
            
            <a href="<c:url value='/logout' />" class="btn-logout">
                Đăng xuất
            </a>
            
            <a href="<c:url value='/index.jsp' />" class="btn-home">
                Về trang chủ
            </a>
        </c:if>

        <c:if test="${empty sessionScope.currentUser}">
            <h1 style="text-align: center; color: #c62828;">Lỗi</h1>
            <p style="text-align: center;">
                Bạn chưa đăng nhập. Vui lòng quay lại trang đăng nhập.
            </p>
            <a href="<c:url value='/login' />" class="btn-login">
                Đi đến Đăng nhập
            </a>
        </c:if>
        
    </div>

</body>
</html>