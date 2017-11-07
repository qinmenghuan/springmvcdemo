package com.example.demo;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }


    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Greetingp user, 	UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user);

//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//
//        userService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, "hello"));
    }


    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public ResponseEntity<Void> login() {
        System.out.println("Creating User " );
        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PostMapping("/greetingpost")
    public String greetingSubmit(@ModelAttribute Greetingp greeting) {
        return "result";
    }

}
