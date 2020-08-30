package com.archiver.fansfinder.controller;

import com.archiver.fansfinder.domain.db.User;
import com.archiver.fansfinder.domain.db.repository.UserRepository;
import com.archiver.fansfinder.domain.mapper.PayloadMapper;
import com.archiver.fansfinder.payload.UserListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    private static final int SUBMISSIONS_LIST_PAGE_SIZE = 20;

    private final PayloadMapper payloadMapper = Mappers.getMapper(PayloadMapper.class);

    @GetMapping
    private UserListResponse getAllUsers(@RequestParam(name = "page") int page) {

        Page<User> userPage = userRepository.findAllOrderByUserData_FavoritedCount(PageRequest.of(page, SUBMISSIONS_LIST_PAGE_SIZE));
        List<UserListResponse.UserListDetail> userListDetails = userPage.stream()
                .map(payloadMapper::mapUserListResponse)
                .collect(Collectors.toList());
        return new UserListResponse(userPage.getTotalElements(), userListDetails);
    }
}
