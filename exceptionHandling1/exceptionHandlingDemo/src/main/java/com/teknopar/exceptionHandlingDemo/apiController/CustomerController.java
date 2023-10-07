package com.teknopar.exceptionHandlingDemo.apiController;

import com.teknopar.exceptionHandlingDemo.exception.CustomerAlreadyExistsException;
import com.teknopar.exceptionHandlingDemo.exception.ErrorResponse;
import com.teknopar.exceptionHandlingDemo.model.Customer;
import com.teknopar.exceptionHandlingDemo.service.abstracts.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CustomerController {
    private CustomerService customerService;
    @GetMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable("id") Long id){
        return this.customerService.getCustomer(id);
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer){
        return this.customerService.addCustomer(customer);
    }

    @PutMapping("updateCustomer")
    public String updateCustomer(@RequestBody Customer customer){
        return this.customerService.updateCustomer(customer);
    }
    @ExceptionHandler(value = CustomerAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONTINUE)
    public @ResponseBody ErrorResponse handleCustomerAlreadyExistException(CustomerAlreadyExistsException ex){
        return new ErrorResponse(HttpStatus.CONTINUE.value(), ex.getMessage());
    }
}
