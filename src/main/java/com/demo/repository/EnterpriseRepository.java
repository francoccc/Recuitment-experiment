package com.demo.repository;

import com.demo.entity.Enterprise;
import com.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnterpriseRepository extends JpaRepository<Enterprise,Long> {
    @Query("select t from Enterprise t where t.username= :username and t.password= :password")
    Enterprise findByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

    @Query("select t from Enterprise  t")
    List<Enterprise> findAll();

    @Query("select t from Enterprise t where t.username= :username")
    Enterprise findByUsername(@Param("username")String username);
}
