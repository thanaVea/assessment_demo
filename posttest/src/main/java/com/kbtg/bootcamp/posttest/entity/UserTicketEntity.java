package com.kbtg.bootcamp.posttest.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "user_ticket", schema = "public")
public class UserTicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_ticket_user_id_seq")
    @SequenceGenerator(name = "user_ticket_user_id_seq", sequenceName = "user_ticket_user_id_seq", allocationSize = 1)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

}
