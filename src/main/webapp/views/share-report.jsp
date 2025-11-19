<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<html>
<head>
    <title>Thống kê Chia sẻ</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

    <div class="container">
        <h2>Thống kê thông tin chia sẻ</h2>
        
        <table class="report-table">
            <thead>
                <tr>
                    <th>Tiêu đề video</th>
                    <th>Số lượt chia sẻ</th>
                    <th>Ngày chia sẻ đầu tiên</th>
                    <th>Ngày chia sẻ cuối cùng</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${reportList}">
                    <tr>
                        <td>${item.videoTitle}</td>
                        <td>${item.shareCount}</td>
                        <td><fmt:formatDate value="${item.firstDate}" pattern="dd/MM/yyyy" /></td>
                        <td><fmt:formatDate value="${item.lastDate}" pattern="dd/MM/yyyy" /></td>
                    </tr>
                </c:forEach>
                
                <c:if test="${empty reportList}">
                    <tr>
                        <td colspan="4" style="text-align: center;">Chưa có video nào được chia sẻ.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
        
        <p style="margin-top: 20px;">
            <a href="${pageContext.request.contextPath}/index.jsp">Quay về trang chủ</a>
        </p>
    </div> </body>
</html>