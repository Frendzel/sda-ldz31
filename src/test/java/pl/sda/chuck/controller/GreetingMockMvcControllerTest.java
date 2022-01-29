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
    MockMvc mockMvc; //Tests only for REST/External API layer

    @Test
    @DisplayName("/hello method verification from GreetingController - positive")
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
    @DisplayName("/hello/json method verification from GreetingController - positive")
    void helloJson() throws Exception {
        //when
        String response = mockMvc
                .perform(MockMvcRequestBuilders.get("/hello/json")) //run http method over application
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful()) //check http status on response
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)) //check content type on response
                .andReturn() //return mvc result to validate response
                .getResponse()
                .getContentAsString();
        //then
        assertEquals("{\"value\":\"world\"}", response);
    }
}