package com.bank.controller;

import com.bank.entity.AccountHolder;
import com.bank.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;
    @PostMapping("/save")
    public AccountHolder saveAccount(@RequestBody AccountHolder holder)
    {
      return  this.service.saveAccount(holder);
    }


    @GetMapping("/acc")
    public ResponseEntity<Double> getBalance(@AuthenticationPrincipal OAuth2User principal)
    {
        if(principal != null)
        {
            String name = principal.getAttribute("name");
            log.info("Fetching data for the user");
            return ResponseEntity.status(HttpStatus.OK).body(service.getBalance(name));
        }

        else
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }


    }
}
