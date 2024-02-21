package com.kbtg.bootcamp.posttest.dto;

public class AdminRequestDto {

    //@Pattern(regexp = "\\d{6}", message = "Ticket must be 6 digits")
    private String ticket;

    //@NotNull(message = "price must not be null")
    private Integer price;

    //@NotNull(message = "amount must not be null")
    private Integer amount;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
