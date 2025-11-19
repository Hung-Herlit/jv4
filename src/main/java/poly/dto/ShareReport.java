package poly.dto;

//DTO (Data Transfer Object)

import java.util.Date;

/**
 * Lớp này dùng để chứa dữ liệu tổng hợp từ JPQL.
 * Quan trọng: Phải có constructor khớp với các trường SELECT.
 */


public class ShareReport {
    private String videoTitle;
    private Long shareCount;
    private Date firstDate;
    private Date lastDate;

    // Constructor rỗng
    public ShareReport() {
    }

    // Constructor dùng cho JPQL (SELECT NEW ...)
    public ShareReport(String videoTitle, Long shareCount, Date firstDate, Date lastDate) {
        this.videoTitle = videoTitle;
        this.shareCount = shareCount;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
    }

    // Getters and Setters
    public String getVideoTitle() { return videoTitle; }
    public void setVideoTitle(String videoTitle) { this.videoTitle = videoTitle; }
    public Long getShareCount() { return shareCount; }
    public void setShareCount(Long shareCount) { this.shareCount = shareCount; }
    public Date getFirstDate() { return firstDate; }
    public void setFirstDate(Date firstDate) { this.firstDate = firstDate; }
    public Date getLastDate() { return lastDate; }
    public void setLastDate(Date lastDate) { this.lastDate = lastDate; }
}

/*Việc tạo class ShareReport trong gói DTO (Data Transfer Object) là bắt buộc và cần thiết trong trường hợp này vì 3 lý do chính sau đây:

1. Cấu trúc dữ liệu không khớp với Entity

Entity (Share.java): Đại diện cho 1 dòng trong bảng CSDL. Nó chứa thông tin chi tiết: Ai share? Share video nào? Vào ngày nào?

Báo cáo (Report): Là kết quả của việc tổng hợp (Group By). Nó chứa thông tin: Video này được share bao nhiêu lần (Count)? Ngày sớm nhất là gì (Min)? Ngày muộn nhất là gì (Max)?

Trong Entity Share (hoặc Video), bạn không có sẵn các thuộc tính như shareCount, firstDate, lastDate. Nếu bạn cố nhồi nhét các trường này vào Entity Video, bạn sẽ làm sai lệch cấu trúc bảng trong CSDL.

2. Hứng dữ liệu từ các hàm tổng hợp (Aggregate Functions)

Khi bạn viết câu lệnh SQL/JPQL có dùng các hàm toán học như: COUNT, SUM, MIN, MAX... kết quả trả về không còn là một Entity nữa.

Ví dụ câu lệnh:

SQL
SELECT s.video.title, COUNT(s), MIN(s.shareDate), MAX(s.shareDate) ...
Kết quả trả về là một danh sách các dòng, mỗi dòng gồm 4 cột rời rạc:

String (Title)

Long (Count)

Date (Min)

Date (Max)

Không có Entity nào trong dự án của bạn (User, Video, Favorite, Share) có đúng 4 trường này để chứa dữ liệu đó cả. Vì vậy, bạn phải tạo ra một "cái hộp" mới (ShareReport) để đựng vừa khít 4 món này.

3. Tránh làm việc với Object[] (Mảng đối tượng)

Nếu bạn không tạo DTO ShareReport, Hibernate vẫn trả về dữ liệu được, nhưng nó sẽ trả về một danh sách các mảng Object[].

Lúc đó code của bạn sẽ trông rất "xấu" và khó bảo trì như thế này:

Nếu KHÔNG dùng DTO:

Java
// Trong DAO
List<Object[]> list = query.getResultList();

// Trong JSP
<c:forEach var="row" items="${list}">
    Tiêu đề: ${row[0]}  Số lượng: ${row[1]} </c:forEach>
Cách này rất dễ lỗi. Nếu bạn sửa câu SQL đổi thứ tự cột, code JSP sẽ hiển thị sai ngay lập tức.

Nếu CÓ dùng DTO (Cách chúng ta làm): Hibernate sẽ tự động "đổ" dữ liệu vào constructor của class ShareReport.

Java
// Trong JSP
<c:forEach var="item" items="${list}">
    Tiêu đề: ${item.videoTitle}  Số lượng: ${item.shareCount}
</c:forEach>

Tóm lại

Chúng ta tạo ShareReport (DTO) để làm một cầu nối trung gian: Nó giúp đóng gói những dữ liệu rời rạc được tính toán từ câu lệnh SQL thành một Đối tượng Java gọn gàng, dễ sử dụng và gửi lên giao diện (JSP) để hiển thị.
 */