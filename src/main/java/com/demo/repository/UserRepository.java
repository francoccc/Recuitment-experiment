package com.demo.repository;

import com.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select t from User t where t.username= :username and t.password= :password")
    User findByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

    @Query("select t from User t where t.username= :username")
    User findByUsername(@Param("username")String username);

    @Query("select t from User t")
    List<User> findAll();

    @Query("select t from User t where t.school= :school")
    List<User> findBySchool(@Param("school")String school);
}
