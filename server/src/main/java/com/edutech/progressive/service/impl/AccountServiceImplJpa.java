package com.edutech.progressive.service.impl;
 
import com.edutech.progressive.entity.Accounts;

import com.edutech.progressive.repository.AccountRepository;

import org.springframework.stereotype.Service;
 
import java.sql.SQLException;

import java.util.Comparator;

import java.util.List;
 
@Service

public class AccountServiceImplJpa {
 
    private final AccountRepository accountRepository;
 
    public AccountServiceImplJpa(AccountRepository accountRepository) {

        this.accountRepository = accountRepository;

    }
 
    public List<Accounts> getAllAccounts() throws SQLException {

        return accountRepository.findAll();

    }
 
    public List<Accounts> getAccountsByUser(int userId) throws SQLException {

        return accountRepository.findByCustomerId(userId);

    }
 
    public Accounts getAccountById(int accountId) throws SQLException {

        return accountRepository.findByAccountId(accountId);

    }
 
    public int addAccount(Accounts accounts) throws SQLException {

        Accounts saved = accountRepository.save(accounts);

        return saved.getAccountId();

    }
 
    public void updateAccount(Accounts accounts) throws SQLException {

        accountRepository.save(accounts);

    }
 
    public void deleteAccount(int accountId) throws SQLException {

        Accounts existing = accountRepository.findByAccountId(accountId);

        if (existing != null) {

            accountRepository.delete(existing);

        }

    }
 
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {

        List<Accounts> list = accountRepository.findAll();

        list.sort(Comparator.comparingDouble(Accounts::getBalance));

        return list;

    }

}

 