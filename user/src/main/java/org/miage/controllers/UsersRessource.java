package org.miage.controllers;

import org.miage.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRessource extends JpaRepository<User, Object> {
    Optional<User> findByUsername(String username);

    Boolean existsByEmail(String email);
}
