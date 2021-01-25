package org.miage.controllers;

import org.miage.Entity.cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRessource extends JpaRepository<cours, Object> {
}
