package org.miage.controllers;

import org.miage.Entity.database.cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRessource extends JpaRepository<cours, Object> {
}
