package com.bank.repository;

import com.bank.entity.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountHolder,Integer> {

    public AccountHolder findByName(String name);
}
