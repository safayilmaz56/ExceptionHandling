package com.teknopar.exceptionHandlingDemo.service.abstracts;

import com.teknopar.exceptionHandlingDemo.model.Customer;

public interface CustomerService {
    Customer getCustomer(Long id);
    String addCustomer(Customer customer);
    String updateCustomer(Customer customer);

}
