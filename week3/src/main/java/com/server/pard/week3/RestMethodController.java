package com.server.pard.week3;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class RestMethodController {

    @GetMapping("")
    public String getUsers() {
        return " Get Method controller";
    }

    @PostMapping("")
    public String postUsers() {
        return "Add users to DB";
    }

    @GetMapping("/{userId}")
    public String getUsersById(@PathVariable Long userId) {
        return userId + "# user id updated";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        return userId + "# user id deleted";
    }
}


//http://192.168.1.100:8080/users
