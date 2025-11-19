package poly.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "Favorite", uniqueConstraints = {
    // Đảm bảo cặp (UserId, VideoId) là duy nhất
    @UniqueConstraint(columnNames = {"UserId", "VideoId"})
})
public class Favorite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    // Ánh xạ Many-To-One đến User
    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    // Ánh xạ Many-To-One đến Video
    @ManyToOne
    @JoinColumn(name = "VideoId")
    private Video video;

    @Column(name = "LikeDate")
    @Temporal(TemporalType.DATE)
    private Date likeDate;

    // Constructors
    public Favorite() {
    }

    public Favorite(User user, Video video, Date likeDate) {
        this.user = user;
        this.video = video;
        this.likeDate = likeDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }
}