package com.flatiron.spring.flatironspring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

//import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloControllerIntegration.class)
class HelloControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    // adding a JokeService here
    @MockBean
    private JokeService jokeService;

    // @Test
//    void shouldGreetByName() throws Exception {
//        String greetingName = "Jamie";
//        mockMvc.perform(get("/hello")
//                        .param("targetName", greetingName))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("Hello " + greetingName)));
//    }


    @Test
    void shouldGreetDefault() throws Exception {
        mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello Stephanie")));

    }

    @Test
    void shouldGreetByName() throws Exception {
        String greetingName = "Jamie";
        mockMvc.perform(get("/hello")
                        .param("targetName", greetingName))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello " + greetingName)));
//
//       void hello() throws Exception {
//        mockMvc.perform(get("/hello"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("Invalid Message")));
    }
}

