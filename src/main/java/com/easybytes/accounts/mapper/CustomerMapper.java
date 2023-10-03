package com.easybytes.accounts.mapper;

import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.entity.Customer;

public class CustomerMapper {
    //you can use mapStrust, modelMapper, but they are open-source and not recommended by spring itself
    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }

}
