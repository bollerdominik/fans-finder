package com.archiver.fansfinder.domain.db;

import lombok.Getter;

@Getter
public enum PostType {
    ARCHIVE("Archived"),
    MESSAGE("Messages"),
    POST("Posts");

    private final String folderName;

    PostType(String folderName) {
        this.folderName = folderName;
    }
}
