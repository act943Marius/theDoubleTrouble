package com.example.theDoubleTrouble.repository;

import com.example.theDoubleTrouble.entity.Statistik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatistikRepository extends JpaRepository<Statistik, Integer> {
}
