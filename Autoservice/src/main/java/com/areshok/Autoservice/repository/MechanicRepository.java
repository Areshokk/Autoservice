package com.areshok.Autoservice.repository;

import com.areshok.Autoservice.model.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic,Integer> {
}
