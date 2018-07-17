package com.demo.repository;

import com.demo.entity.Recuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecuitRepository extends JpaRepository<Recuit,Long> {
    @Query("select t from Recuit where t.pid= :pid")
    List<Recuit> findByPid(@Param("pid")long pid);

    @Query("select t from Recuit where t.uid= :uid")
    List<Recuit> findByUid(@Param("uid")long uid);

    @Query("select t from Recuit where t.id= :id")
    Recuit findById(@Param("id")long id);
}
