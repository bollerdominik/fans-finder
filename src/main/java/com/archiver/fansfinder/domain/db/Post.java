package com.archiver.fansfinder.domain.db;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private long originalPostId;

    @ManyToOne
    @JoinColumn
    private User user;

    private double price;

    private boolean paid;

    @Column(length = 10000)
    private String text;

    private LocalDateTime postedAt;

    @Enumerated(EnumType.STRING)
    private PostType postType;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created;

    private Long fromOriginalUserId;

    private boolean hidden;
}
