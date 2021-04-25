package com.foxsavvystudios.portfolio.core.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserRepository userRepository;

    public UserController(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) throws UserNotFoundException {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

    @PutMapping("/{userId}")
    public User editUser(@RequestBody User newUser, @PathVariable Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        newUser.setUserId(user.getUserId());
        return userRepository.save(newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        userRepository.delete(user);
    }
}
