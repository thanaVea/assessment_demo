package com.kbtg.bootcamp.posttest;


import com.kbtg.bootcamp.posttest.controller.ProductController;
import com.kbtg.bootcamp.posttest.controller.UserController;
import com.kbtg.bootcamp.posttest.dto.ProductResponseDTO;
import com.kbtg.bootcamp.posttest.dto.UserResponseDto;
import com.kbtg.bootcamp.posttest.service.ProductService;
import com.kbtg.bootcamp.posttest.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.List;
import com.kbtg.bootcamp.posttest.controller.AdminsController;
import com.kbtg.bootcamp.posttest.controller.ProductController;
import com.kbtg.bootcamp.posttest.dto.AdminRequestDto;
import com.kbtg.bootcamp.posttest.dto.AdminResponseDto;
import com.kbtg.bootcamp.posttest.dto.ProductResponseDTO;
import com.kbtg.bootcamp.posttest.entity.LotteryEntity;
import com.kbtg.bootcamp.posttest.service.AdminsService;
import com.kbtg.bootcamp.posttest.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    MockMvc mockMvc;
    @Mock
    UserService userService;

    @BeforeEach
    void setUp() {
        UserController userController = new UserController(userService);
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .alwaysDo(print())
                .build();
    }

    @Test
    @DisplayName("")
    void viewAllMyTicketsProcess() throws Exception {

    }

    @Test
    @DisplayName("Buy Lottery Ticket Process Success Created Add Lottery")
    void buyLotteryTicketProcess() throws Exception {
        UserResponseDto responseDto = new UserResponseDto("1");
        when(userService.buyLotteryTicketProcess("1", "1")).thenReturn(responseDto);

        mockMvc.perform(post("/users/1/lotteries/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is("1")));
    }

}
