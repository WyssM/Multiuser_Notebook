package com.wiss.m223.repository;

import com.wiss.m223.model.Notizbuch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotizbuchRepository extends JpaRepository<Notizbuch, Long> {

}
