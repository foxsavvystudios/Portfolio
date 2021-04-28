package com.foxsavvystudios.portfolio.core.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findAllByRole(User.Role role);

}
