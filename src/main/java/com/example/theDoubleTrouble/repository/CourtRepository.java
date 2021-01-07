package com.example.theDoubleTrouble.repository;

import com.example.theDoubleTrouble.entity.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtRepository extends JpaRepository<Court, Integer> {
}
