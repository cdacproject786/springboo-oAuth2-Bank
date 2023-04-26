package com.bank.service;

import com.bank.entity.AccountHolder;
import com.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {


    @Autowired
    private AccountRepository accountRepository;

    public AccountHolder saveAccount(AccountHolder holder)
    {
        return this.accountRepository.save(holder);
    }


    public Double getBalance(String name)
    {
        try {
            AccountHolder holder = this.accountRepository.findByName(name);
            return holder.getBalance();
        }

        catch (Exception e)
        {
            return 0.0;
        }


    }
}
