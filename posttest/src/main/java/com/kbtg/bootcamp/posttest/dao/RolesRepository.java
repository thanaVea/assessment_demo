package com.kbtg.bootcamp.posttest.dao;

import com.kbtg.bootcamp.posttest.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, Long> , JpaSpecificationExecutor<RolesEntity> {

    @Query(value = "select * from roles where name = :name ",nativeQuery = true)
    RolesEntity findByName(@Param("name") String name);
}
