package com.dicapisar.inputItemManager.repository;

import com.dicapisar.inputItemManager.models.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository <User, Long> {
    @Query("select u from User u where u.id =:userId")
    User getUserById(@Param("userId") Long userId);
}
