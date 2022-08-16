package com.flatiron.spring.flatironspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//        http.authorizeRequests()
//                .antMatchers("/coingecko")
//                .hasAuthority("admin");

        http.authorizeRequests()
                .antMatchers("/coingecko")
                .authenticated()
                .and()
                .formLogin()
                .and()
                .logout();

        // adding a rule to require authentication for all content via OAuth
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login();

            return http.build();


//        http.authorizeRequests()
//                .antMatchers("/coingecko")
//                .hasAuthority("admin");
//
//        http.authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .logout();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailService = new InMemoryUserDetailsManager();

        String username = "bailey";
        String password = "1234";
        UserDetails thisUser = User.withUsername(username)
                .password(passwordEncoder().encode(password))
                .authorities("read")
                .build();
        userDetailService.createUser(thisUser);


        username = "Lynn";
        password = "1";
        thisUser = User.withUsername(username)
                .password(passwordEncoder().encode(password))
                .authorities("admin")
                .build();
        userDetailService.createUser(thisUser);

        return userDetailService;
    }

    // Use a bean to determine which Password Encoder will be used.
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
