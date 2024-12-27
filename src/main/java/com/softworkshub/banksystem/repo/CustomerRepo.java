package com.softworkshub.banksystem.repo;

import com.softworkshub.banksystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
