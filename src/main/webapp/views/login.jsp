<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<head>
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    
    <style>
        .login-form { max-width: 500px; margin: 40px auto 0 auto; }
        .form-group { margin-bottom: 20px; }
        .form-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #555;
        }
        .form-group input {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1em;
        }
        .btn-login {
            width: 100%;
            padding: 15px;
            background-color: #ff6600; /* Màu cam FPT */
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 1.1em;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .btn-login:hover { background-color: #e65c00; }
        
        /* Box hiển thị lỗi */
        .error-message {
            background-color: #ffebeB;
            border: 1px solid #ffcdd2;
            color: #c62828;
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 5px;
            text-align: center;
        }
    </style>
</head>
<body>

    <div class="container login-form">
        <h1 style="color: #ff6600; text-align: center;">Đăng nhập PolyOE</h1>
        
        <form action="<c:url value='/login'/>" method="POST">
            
            <c:if test="${not empty errorMessage}">
                <div class="error-message">${errorMessage}</div>
            </c:if>
            
            <div class="form-group">
                <label for="usernameOrEmail">Username (ID) hoặc Email:</label>
                <input type="text" id="usernameOrEmail" name="usernameOrEmail" required>
            </div>
            
            <div class="form-group">
                <label for="password">Mật khẩu:</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <button type="submit" class="btn-login">Đăng nhập</button>
        </form>

        <p style="text-align: center; margin-top: 20px;">
            <a href="${pageContext.request.contextPath}/index.jsp">Quay về trang chủ</a>
        </p>
    </div>

</body>
</html>