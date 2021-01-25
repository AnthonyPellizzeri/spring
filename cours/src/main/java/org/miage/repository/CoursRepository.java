package org.miage.repository;

import java.util.Optional;

import org.miage.Entity.cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<cours, Long> {
}
