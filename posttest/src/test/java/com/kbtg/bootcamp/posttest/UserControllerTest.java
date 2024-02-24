package com.kbtg.bootcamp.posttest;


import com.kbtg.bootcamp.posttest.controller.UserController;
import com.kbtg.bootcamp.posttest.dto.ProductResponseDTO;
import com.kbtg.bootcamp.posttest.dto.UserResponseDto;
import com.kbtg.bootcamp.posttest.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    @DisplayName("Buy Lottery Ticket Process Success Created Add Lottery.")
    void buyLotteryTicketProcess() throws Exception {
        UserResponseDto responseDto = new UserResponseDto("1");
        when(userService.buyLotteryTicketProcess("1", "1")).thenReturn(responseDto);

        mockMvc.perform(post("/users/1/lotteries/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is("1")));
    }

    @Test
    @DisplayName("View all my tickets returns correct ticket list and total price.")
    void viewAllMyTicketsProcess() throws Exception {
        List<String> expectedTickets = List.of("112233");
        String expectedTotalPrice = "80.00";
        ProductResponseDTO responseDTO = new ProductResponseDTO(expectedTickets, expectedTotalPrice);
        when(userService.getAllMyTicketsProcess("1")).thenReturn(responseDTO);

        mockMvc.perform(get("/users/1/lotteries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tickets", hasSize(1)))
                .andExpect(jsonPath("$.tickets[0]", is("112233")))
                .andExpect(jsonPath("$.totalPrice", is("80.00")));
    }

    @Test
    @DisplayName("Delete a lottery ticket and return the ticket number.")
    void deleteMyLottery() throws Exception {
        List<String> expectedTickets = Collections.singletonList("012340");
        ProductResponseDTO responseDTO = new ProductResponseDTO(expectedTickets, null);

        when(userService.deleteLotteryTicketProcess("1", "1")).thenReturn(responseDTO);

        mockMvc.perform(delete("/users/1/lotteries/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tickets[0]", is("012340")));
    }

}
