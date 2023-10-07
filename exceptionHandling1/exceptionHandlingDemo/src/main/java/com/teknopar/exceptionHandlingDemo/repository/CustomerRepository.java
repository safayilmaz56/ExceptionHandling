package com.teknopar.exceptionHandlingDemo.repository;

import com.teknopar.exceptionHandlingDemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
