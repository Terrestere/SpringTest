package com.mirs.springtest.controller;

import com.mirs.springtest.model.User;
import com.mirs.springtest.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestParam(required = false) String email,
                           @RequestParam(required = false) String name) {
        userService.updateUser(id, email, name);
    }
}
