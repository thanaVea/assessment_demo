package com.kbtg.bootcamp.posttest;


import com.kbtg.bootcamp.posttest.controller.UserController;
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

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
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
