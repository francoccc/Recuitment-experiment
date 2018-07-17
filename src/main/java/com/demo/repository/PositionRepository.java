package com.demo.repository;

import com.demo.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position,Long> {
    @Query("select t from Position t where t.salary >= :s_min and t.salary <= :s_max")
    List<Position> findBySalary(@Param("s_min") int s_min, @Param("s_max") int s_max) ;

    @Query("select t from Position t where t.name like '%:name%'")
    List<Position> findByNameLike(@Param("name")String name);

    @Query("select t from Position t where t.id = :id")
    Position findById(@Param("id")long id);

    @Query("select t from Position t")
    List<Position> findAll();
}
