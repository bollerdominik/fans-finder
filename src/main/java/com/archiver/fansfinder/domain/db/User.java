package com.archiver.fansfinder.domain.db;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    private String avatarFile;

    private double subscribePrice;
    private Long originalId;

    private boolean available;
    private boolean dmcaRemoved;
    private boolean performer;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created;

    private LocalDateTime lastPosted;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserData userData;
}
