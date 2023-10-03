package com.easybytes.accounts.service.impl;


import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.entity.Customer;
import com.easybytes.accounts.exception.CustomerAlreadyExistsException;
import com.easybytes.accounts.mapper.CustomerMapper;
import com.easybytes.accounts.repo.AccountsRepo;
import com.easybytes.accounts.repo.CustomerRepo;
import com.easybytes.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AccounsServiceImpl implements IAccountsService {

    private AccountsRepo accountsRepo;
    private CustomerRepo customerRepo;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer
                = customerRepo.findByMobileNumber(customerDto.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer" +
                    " already registered with given mobile number: "+
                    customerDto.getMobileNumber());
        }
        Customer savedCustomer = customerRepo.save(customer);
    }
}
