package com.archiver.fansfinder.domain.mapper;


import com.archiver.fansfinder.domain.db.PostType;
import com.archiver.fansfinder.domain.db.User;
import com.archiver.fansfinder.payload.UserListResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Mapper
public interface PayloadMapper {

    @Mapping(target = "postsPerDay", expression = "java( getPostsPerDay(user) )")
    @Mapping(target = "postsCount", source = "userData.postsCount")
    @Mapping(target = "file", source = "avatarFile")
    UserListResponse.UserListDetail mapUserListResponse(User user);

    default double getPostsPerDay(User user) {
        final int DAYS_IN_THE_PAST = 30;

        long count = user.getPosts().stream()
                .filter(post -> post.getPostType() == PostType.POST)
                .filter(post -> post.getCreated().isAfter(LocalDateTime.now().minus(DAYS_IN_THE_PAST, ChronoUnit.DAYS)))
                .count();

        return ((double) count / DAYS_IN_THE_PAST);
    }
}
