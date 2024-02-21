package com.kbtg.bootcamp.posttest.dao;


import com.kbtg.bootcamp.posttest.entity.UserTicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTicketRepository extends JpaRepository<UserTicketEntity, Long>, JpaSpecificationExecutor<UserTicketEntity> {

}