package com.areshok.Autoservice.repository;

import com.areshok.Autoservice.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {

    @Query("SELECT u FROM Customer u WHERE u.username = :username")
    public Customer getCustomerByUsername(@Param("username") String username);
}
