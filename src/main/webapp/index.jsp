<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<head>
    <title>Trang chủ - PolyOE</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

    <div class="container" style="max-width: 600px;">
        <h1 style="color: #ff6600; text-align: center;">Bài Lab3&4 Java 4 - PolyOE</h1>
        <p style="text-align: center; font-size: 1.1em;">Chọn một chức năng để xem:</p>

        <ul class="nav-list">
            <li>
                <a href="<c:url value='/profile' />">
                    Bài 3-Lab3: Trang Video yêu thích
                </a>
                <span>(Hiển thị video anh "Nguyễn Văn Tèo" đã thích)</span>
            </li>
            
            <li>
                <a href="<c:url value='/favorite-report' />">
                    Bài 4-Lab3: Thống kê Video
                </a>
                <span>(Hiển thị danh sách tất cả video đã được yêu thích)</span>
            </li>
		    <li>
		        <a href="<c:url value='/share-report' />">
		            Bài 1-Lab4: Thống kê Chia sẻ dùng JPQL
		        </a>
		        <span>(Hiển thị tổng hợp số lượt chia sẻ, ngày đầu, ngày cuối)</span>
		    </li>

	        <li>
	        <a href="<c:url value='/login' />">
	            Bài 2-Lab4: Đăng nhập
	        </a>
	        <span>(Đăng nhập bằng ID hoặc Email)</span>
	    	<li><a href="video-search">Bài 3-Lab4: Tìm kiếm Video</a></li>
   

    </div> 
    </body>
</html>