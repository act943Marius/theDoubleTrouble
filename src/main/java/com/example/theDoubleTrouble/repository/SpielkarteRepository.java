package com.example.theDoubleTrouble.repository;

import com.example.theDoubleTrouble.entity.Spielkarte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
    @Repository
    public interface SpielkarteRepository extends JpaRepository<Spielkarte,Integer> {
}
