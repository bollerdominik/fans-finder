package com.archiver.fansfinder.domain.db.repository;


import com.archiver.fansfinder.domain.db.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from users u order by u.userData.favoritedCount desc")
    Page<User> findAllOrderByUserData_FavoritedCount(Pageable page);


}
