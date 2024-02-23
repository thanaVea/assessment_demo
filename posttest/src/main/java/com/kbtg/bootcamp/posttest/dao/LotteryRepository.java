package com.kbtg.bootcamp.posttest.dao;


import com.kbtg.bootcamp.posttest.entity.LotteryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LotteryRepository extends JpaRepository<LotteryEntity, Long>, JpaSpecificationExecutor<LotteryEntity> {

    @Query(value = "select * from lottery where user_id = :userId ",nativeQuery = true)
    List<LotteryEntity> findByUserId(@Param("userId") Long userId);

    @Query(value = "select * from lottery where user_id is null ",nativeQuery = true)
    List<LotteryEntity> findAllWithOutOwner();

}