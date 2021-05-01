package com.foxsavvystudios.portfolio.core.user;

import com.foxsavvystudios.portfolio.core.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
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
    public User getUserById(@PathVariable Long userId) throws EntityNotFoundException {
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(User.class, userId));
    }

    @PutMapping("/{userId}")
    public User editUser(@RequestBody User newUser, @PathVariable Long userId) throws EntityNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(User.class, userId));
        newUser.setUserId(user.getUserId());
        return userRepository.save(newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) throws EntityNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(User.class, userId));
        userRepository.delete(user);
    }
}
