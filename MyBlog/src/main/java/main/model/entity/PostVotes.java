package main.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post_votes")
public class PostVotes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private User user;

    @OneToOne
    private Posts post;

    @Column(name = "time", nullable = false)
    private LocalDateTime voteTime;

    @Column(name = "value", nullable = false, columnDefinition = "TINYINT")
    private int voteValue;
}
