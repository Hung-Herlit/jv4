<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<head>
    <title>Tìm kiếm Video</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h2>Tìm kiếm Video</h2>

        <form action="video-search" method="GET" style="margin-bottom: 20px;">
            <label>Từ khóa: </label>
            <input type="text" name="keyword" value="${keyword}" placeholder="Nhập tên video..." style="padding: 8px; width: 300px;">
            <button type="submit" class="btn-login" style="width: auto; display: inline-block;">Tìm</button>
        </form>

        <h3>Kết quả:</h3>
        <table class="report-table">
            <thead>
                <tr>
                    <th>Tiêu đề video</th>
                    <th>Số lượt thích</th>
                    <th>Còn hiệu lực</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="v" items="${videos}">
                    <tr>
                        <td>${v.title}</td>
                        <td>
                            ${v.favorites.size()}
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${v.active}">Hoạt động</c:when>
                                <c:otherwise>Đã khóa</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="${pageContext.request.contextPath}/index.jsp">Về trang chủ</a>
    </div>
</body>
</html>