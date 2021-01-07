package com.example.theDoubleTrouble.repository;

import com.example.theDoubleTrouble.entity.Rechnung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechnungRepository extends JpaRepository<Rechnung, Integer> {
}
