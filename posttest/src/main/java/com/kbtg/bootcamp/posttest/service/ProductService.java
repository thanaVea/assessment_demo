package com.kbtg.bootcamp.posttest.service;

import com.kbtg.bootcamp.posttest.dao.LotteryRepository;
import com.kbtg.bootcamp.posttest.dto.ProductResponseDTO;
import com.kbtg.bootcamp.posttest.entity.LotteryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private LotteryRepository lotteryRepository;

    public ProductResponseDTO getAllProduct() {
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        List<LotteryEntity> productList = this.lotteryRepository.findAllWithOutOwner();

        List<String> tickets = productList.stream()
                .map(LotteryEntity::getTicketNumber)
                .collect(Collectors.toList());

        responseDTO.setTickets(tickets);

        return responseDTO;
    }

}
