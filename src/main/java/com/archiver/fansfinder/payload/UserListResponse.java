package com.archiver.fansfinder.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserListResponse implements Serializable {

    private long totalCount;
    private List<UserListDetail> user;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserListDetail implements Serializable {
        private String name;

        private String file;

        private long postsCount;

        private double postsPerDay;

        private double subscribePrice;
    }
}
