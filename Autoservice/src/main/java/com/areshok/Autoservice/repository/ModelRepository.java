package com.areshok.Autoservice.repository;

import com.areshok.Autoservice.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
}
