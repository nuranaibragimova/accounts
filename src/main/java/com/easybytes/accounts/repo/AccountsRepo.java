package com.easybytes.accounts.repo;

import com.easybytes.accounts.entity.Accounts;
import com.easybytes.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountsRepo extends JpaRepository<Accounts, Long> {
}