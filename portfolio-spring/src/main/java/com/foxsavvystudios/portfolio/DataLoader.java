package com.foxsavvystudios.portfolio;

import com.foxsavvystudios.portfolio.core.user.User;
import com.foxsavvystudios.portfolio.core.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DataLoader implements CommandLineRunner {

    private static final String DEFAULT_SUPERUSER_USERNAME = "ffsSuper";
    private static final String DEFAULT_SUPERUSER_PASSWORD_HASH = "qwertyuiop1234567asdfghj";
    private static final String DEFAULT_SUPERUSER_EMAIL = "foxsavvystudios@gmail.com";

    private final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);

    private UserRepository userRepository;

    public DataLoader(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!hasDefaultSuperuser()) {
            User superuser = new User(DEFAULT_SUPERUSER_USERNAME,
                    DEFAULT_SUPERUSER_PASSWORD_HASH,
                    DEFAULT_SUPERUSER_EMAIL,
                    User.Role.SUPERADMIN,
                    true);
            userRepository.save(superuser);
        }
    }

    private boolean hasDefaultSuperuser() {
        Set<String> superadminSet = userRepository.findAllByRole(User.Role.SUPERADMIN)
                .stream()
                .map(u -> u.getUsername())
                .collect(Collectors.toSet());

        return superadminSet.contains(DEFAULT_SUPERUSER_USERNAME);
    }


}
