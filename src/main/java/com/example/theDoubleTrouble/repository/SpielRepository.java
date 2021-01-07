package com.example.theDoubleTrouble.repository;

import com.example.theDoubleTrouble.entity.Spiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpielRepository extends JpaRepository<Spiel,Integer> {

}
