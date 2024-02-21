package com.kbtg.bootcamp.posttest.service;

import com.kbtg.bootcamp.posttest.dao.LotteryRepository;
import com.kbtg.bootcamp.posttest.dao.UserTicketRepository;
import com.kbtg.bootcamp.posttest.dto.ProductResponseDTO;
import com.kbtg.bootcamp.posttest.dto.UserResponseDto;
import com.kbtg.bootcamp.posttest.entity.LotteryEntity;
import com.kbtg.bootcamp.posttest.entity.UserTicketEntity;
import com.kbtg.bootcamp.posttest.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserTicketRepository userTicketRepository;

    @Autowired
    private LotteryRepository lotteryRepository;

    @Transactional(rollbackFor = Exception.class)
    public UserResponseDto buyLotteryTicketProcess(String userId, String ticketId) throws Exception{

        LotteryEntity lottery = this.lotteryRepository.findById(Long.valueOf(ticketId))
                .orElseThrow(() -> new NotFoundException("No such lottery ticket with id: " + ticketId));

        UserResponseDto responseDto = new UserResponseDto();
        Optional<UserTicketEntity> userTicketCheck = this.userTicketRepository.findById(Long.valueOf(userId));
        UserTicketEntity userTicket;

        if(userTicketCheck.isPresent()){
            userTicket = userTicketCheck.get();
        }else{
            userTicket = new UserTicketEntity();
            this.userTicketRepository.saveAndFlush(userTicket);

        }

        BigDecimal totalPrice;
        if(userTicket.getTotalPrice() == null){
            totalPrice = null;
        }else{
            totalPrice = userTicket.getTotalPrice();
        }
        totalPrice = totalPrice.add(lottery.getPrice());
        userTicket.setTotalPrice(totalPrice);

        //UPDATE lottery owner
        lottery.setUserId(userTicket.getUserId());
        this.lotteryRepository.saveAndFlush(lottery);
        System.out.println("lottery.getUser = " + lottery.getUserId());
        responseDto.setId(lottery.getUserId().toString());

        return responseDto;
    }

//    @Transactional(rollbackFor = Exception.class)
//    public UserResponseDto buyLotteryTicketProcess(String userId, String ticketId) throws Exception {
//        UserResponseDto responseDto = new UserResponseDto();
//
//        LotteryEntity lottery = lotteryRepository.findById(Long.valueOf(ticketId))
//                .orElseThrow(() -> new NotFoundException("No such lottery ticket with id: " + ticketId));
//
//        UserTicketEntity userTicket = userTicketRepository.findById(Long.valueOf(userId))
//                .orElseGet(() -> userTicketRepository.saveAndFlush(new UserTicketEntity()));
//
//        BigDecimal totalPrice = Optional.ofNullable(userTicket.getTotalPrice()).orElse(BigDecimal.ZERO)
//                .add(lottery.getPrice());
//        userTicket.setTotalPrice(totalPrice);
//
//        // Update lottery owner
//        lottery.setUserId(userTicket.getUserId());
//        lotteryRepository.saveAndFlush(lottery);
//
//        responseDto.setId(userTicket.getUserId().toString());
//        return responseDto;
//    }


    public ProductResponseDTO getAllMyTicketsProcess(String userId) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();

        UserTicketEntity userTicket = userTicketRepository.findById(Long.valueOf(userId))
                .orElseThrow(() -> new NotFoundException("No such User with id: " + userId));

        List<LotteryEntity> lottery = lotteryRepository.findByUserId(Long.valueOf(userId));

        List<String> tickets = lottery.stream()
                .map(LotteryEntity::getTicketNumber)
                .collect(Collectors.toList());

        responseDTO.setTickets(tickets);
        responseDTO.setTotalPrice(userTicket.getTotalPrice().toString());
        return responseDTO;
    }
}
