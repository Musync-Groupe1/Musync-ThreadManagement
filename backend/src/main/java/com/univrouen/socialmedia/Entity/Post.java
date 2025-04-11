package com.univrouen.socialmedia.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    private String content;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(
            name="author_id"
    )
    private User user;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "post"
    )
    private List<Comment> comments;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(
            name = "poll_id"
    )
    private Poll poll;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;


}
