package com.areshok.Autoservice.repository;

import com.areshok.Autoservice.model.Mechanic;
import com.areshok.Autoservice.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic,Integer> {
    Optional<Mechanic> findByFirstName(String firstName);
}
