package com.flatiron.spring.flatironspring;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reverse")
public class ReverseController {

        @PostMapping // localhost:8080/reverse
        public String reverseString(@RequestBody String input) {
            StringBuilder reverse = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                reverse.append(input.charAt(input.length() - 1 - i));
            }
            return reverse.toString();
          }
}
