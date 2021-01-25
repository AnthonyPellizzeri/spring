package org.miage.controllers;

import org.miage.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRessource extends JpaRepository<User, Object> {
}
