package com.archiver.fansfinder.domain.db;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

    @Id
    @Column(name = "id")
    private long id;

    @UpdateTimestamp
    @Column(updatable = false)
    private LocalDateTime updated;

    @Column(nullable = false)
    private boolean notFound = false;

    @OneToOne
    @MapsId
    private User user;

    private String name;

    private String location;

    @Column(length = 10000)
    private String rawAbout;

    private String wishlist;

    private long favoritesCount;

    private long favoritedCount;

    private LocalDateTime joinDate;

    private LocalDateTime lastSeen;

    private long postsCount;

    private long archivedPostsCount;

    private long photosCount;

    private long videosCount;

    private long audiosCount;
}
