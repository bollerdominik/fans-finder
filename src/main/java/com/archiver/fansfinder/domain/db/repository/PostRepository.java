package com.archiver.fansfinder.domain.db.repository;


import com.archiver.fansfinder.domain.db.Post;
import com.archiver.fansfinder.domain.db.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface PostRepository extends CrudRepository<Post, Long> {
    Optional<Post> findByOriginalPostId(long postId);

    Page<Post> findAllByUserAndHiddenIsFalseOrderByPostedAtDesc(User user, Pageable page);

    Page<Post> findAllByUserAndPaidIsFalseAndHiddenIsFalseOrderByPostedAtDesc(User user, Pageable page);

    Page<Post> findAllByUserAndPaidIsTrueAndHiddenIsFalseOrderByPostedAtDesc(User user, Pageable page);

    List<Post> findAllByUserAndHiddenIsFalse(User user);

    Page<Post> findAllByPaidIsTrueOrderByPostedAtDesc(Pageable of);

    Page<Post> findAllByPaidIsTrueOrderByCreatedDesc(Pageable of);
}
