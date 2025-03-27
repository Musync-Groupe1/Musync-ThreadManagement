package com.univrouen.socialmedia.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Posts")
public class Post {
    @Id
    private Integer postId;

    private String content;

    @ManyToOne
    @JoinColumn(
            name="author_id"
    )
    private User user;

    @OneToMany(
            mappedBy = "post"
    )
    private List<Comment> comments;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;


}
