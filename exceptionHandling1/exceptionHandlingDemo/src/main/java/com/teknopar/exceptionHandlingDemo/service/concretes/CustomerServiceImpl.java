package com.teknopar.exceptionHandlingDemo.service.concretes;

import com.teknopar.exceptionHandlingDemo.exception.CustomerAlreadyExistsException;
import com.teknopar.exceptionHandlingDemo.exception.NoSuchCustomerExistException;
import com.teknopar.exceptionHandlingDemo.model.Customer;
import com.teknopar.exceptionHandlingDemo.repository.CustomerRepository;
import com.teknopar.exceptionHandlingDemo.service.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No Customer Present With Id: " + id)
        );
    }

    @Override
    public String addCustomer(Customer customer) {
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        if (customer1.isEmpty()) {
            this.customerRepository.save(customer);
            return "Customer added Succesfully";
        } else
            throw new CustomerAlreadyExistsException("Customer already exists");
    }

    @Override
    public String updateCustomer(Customer customer) {
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        if (customer1.isEmpty()) {
            throw new NoSuchCustomerExistException("No Such Customer Exists");
        } else {
            Customer a = customer1.get();
            a.setName(customer.getName());
            a.setAddress(customer.getAddress());
            customerRepository.save(a);
            return "Record Updated Succesfully";
        }
    }
}
