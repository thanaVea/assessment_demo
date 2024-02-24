package com.kbtg.bootcamp.posttest.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "lottery", schema = "public")
public class LotteryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lottery_id_seq")
    @SequenceGenerator(name = "lottery_id_seq", sequenceName = "lottery_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ticket_number", length = 6)
    private String ticketNumber;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "user_id")
    private Long userId;

    public LotteryEntity() {

    }

    public LotteryEntity(String ticketNumber, BigDecimal price, Integer amount) {
        this.ticketNumber = ticketNumber;
        this.price = price;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}