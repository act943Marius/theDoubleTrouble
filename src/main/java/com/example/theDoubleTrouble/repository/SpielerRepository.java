package com.example.theDoubleTrouble.repository;

import com.example.theDoubleTrouble.entity.Spieler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpielerRepository extends JpaRepository<Spieler, Integer> {
    List<Spieler> findByVorname(String vorname);
}
