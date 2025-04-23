package com.dmw.blogentity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Data
@Table(name = "COMMENTS")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer commentId;
    private String name;
    private String email;
    @Lob
    private String blogComments;

    @CreationTimestamp // Automatically sets the timestamp when the entity is created
    @Column( nullable = false) // Prevent updates to the created_at column
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBlogComments() {
        return blogComments;
    }

    public void setBlogComments(String blogComments) {
        this.blogComments = blogComments;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
