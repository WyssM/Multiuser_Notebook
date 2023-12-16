package com.wiss.m223.repository;

import com.wiss.m223.model.Kategorien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategorienRepository extends JpaRepository<Kategorien, Long> {

}
