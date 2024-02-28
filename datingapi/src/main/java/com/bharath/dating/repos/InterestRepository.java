package com.bharath.dating.repos;

import com.bharath.dating.entities.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<Interest, Integer> {
}
