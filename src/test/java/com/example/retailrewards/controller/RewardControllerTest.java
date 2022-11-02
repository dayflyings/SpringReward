package com.example.retailrewards.controller;

import com.example.retailrewards.service.RewardService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RewardControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mvc;

    @Mock
    private RewardService rewardService;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(new RewardController(rewardService)).build();
        Mockito.when(rewardService.calculatePointByUserId(1L)).thenReturn(250);
    }

    @Test
    public void getRewardsTest() throws Exception {
        ResultActions res = mvc.perform(MockMvcRequestBuilders.get("/rewards/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());

    }
}