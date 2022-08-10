package com.flatiron.spring.flatironspring;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class HelloControllerUnitTest {
    @Test
    void shouldReturnGreeting() {
        JokeService jokeService = Mockito.mock(JokeService.class);
        String dadJoke = "Did you hear about the new restaurant on the moon? The food is great, " +
                "but there’s just no atmosphere.";
        HelloControllerIntegration helloController = new HelloControllerIntegration(jokeService);
        when(jokeService.getDadJoke()).thenReturn(dadJoke);
        String name = "Jamie";
        String expected = "Hello " + name + "<br/>" +
                "Dad joke of the moment: " +
                dadJoke;
        String actual = helloController.hello(name);
        assertEquals(expected, actual);
    }




//    @Test
//    void hello() {
//        HelloController helloController = new HelloController();
//        String name = "LaToya";
//        assertEquals("Hello " + name, helloController.hello(name));
  //  }
}