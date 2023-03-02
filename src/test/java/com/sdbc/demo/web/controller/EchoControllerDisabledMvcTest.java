package com.sdbc.demo.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static com.sdbc.demo.web.controller.EchoController.ECHO_ENDPOINT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EchoController.class)
@TestPropertySource(properties = {"echo.enabled=false"})
public class EchoControllerDisabledMvcTest {

    private static final String MESSAGE = "Hello, World";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getShouldReturnError() throws Exception {
        this.mockMvc
                .perform(get(ECHO_ENDPOINT)
                        .param("message", MESSAGE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
