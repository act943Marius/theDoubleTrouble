package com.example.theDoubleTrouble.repository;

import com.example.theDoubleTrouble.entity.Spielplan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface SpielplanRepository extends JpaRepository<Spielplan,Integer> {
}
