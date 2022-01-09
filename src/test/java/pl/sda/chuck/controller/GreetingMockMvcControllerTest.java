package pl.sda.chuck.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingMockMvcControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("/hello method validation from GreetingController - positive")
    void hello() throws Exception {
        //when
        String response = mockMvc
                .perform(MockMvcRequestBuilders.get("/hello"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        //then
        assertEquals("world", response);
    }

    @Test
    @DisplayName("/hello/json method validation from GreetingController - positive")
    void helloJson() throws Exception {
        //when
        String response = mockMvc
                .perform(MockMvcRequestBuilders.get("/hello/json"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();
        //then
        assertEquals("{\"value\":\"world\"}", response);
    }
}