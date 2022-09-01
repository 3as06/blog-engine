package main.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.entity.enums.ModerationStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "is_active", nullable = false, columnDefinition = "TINYINT")
    private boolean isActive;

    @Column(name = "moderation_status", nullable = false, columnDefinition = "ENUM('NEW', 'ACCEPTED', 'DECLINED') default 'NEW'")
    private String moderationStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    private User moderator;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @Column(name = "time", nullable = false)
    private LocalDateTime postTime;

    @Column(nullable = false)
    private String title;

    @Column(name = "text", nullable = false, columnDefinition = "TEXT")
    private String postText;

    @Column(name = "view_count", nullable = false)
    private int viewCount;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tag2post",
        joinColumns = {@JoinColumn(name = "tag_id")},
        inverseJoinColumns = {@JoinColumn(name = "post_id")})
    private List<Tags> tags;
}
