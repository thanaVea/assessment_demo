package com.kbtg.bootcamp.posttest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponseDTO {
    private List<String> tickets;

    private String totalPrice;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(List<String> tickets, String totalPrice) {
        this.tickets = tickets;
        this.totalPrice = totalPrice;
    }

    public List<String> getTickets() {
        return tickets;
    }

    public void setTickets(List<String> tickets) {
        this.tickets = tickets;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
