package com.wiss.m223.repository;

import com.wiss.m223.model.Notizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotizenRepository extends JpaRepository<Notizen, Long> {

}
