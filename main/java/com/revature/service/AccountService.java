package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.dto.AddOrEditAccountDTO;
import com.revature.exception.DatabaseException;
import com.revature.exception.AccountNotFoundException;
import com.revature.model.Account;

public class AccountService {
	private AccountDAO accountDao;
	
	public AccountService() {
		this.accountDao = new AccountDAOImpl();
	}
	
	public List<Account> getAllAccounts() throws DatabaseException {
		try {
			List<Account> accounts = accountDao.getAllAccounts();
			
			return accounts;
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong with our DAO operations");
		}	
	}
	
	public Account getAccountById(int id) throws DatabaseException, AccountNotFoundException {
		try {
			Account account = accountDao.getAccountById(id);
			
			if (account == null) {
				throw new AccountNotFoundException("Account with id " + id + " was not found");
			}
			
			return account;
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong with our DAO operations");
		}
	}
	
	public Account addAccount(AddOrEditAccountDTO account) throws DatabaseException {
		try {
			Account addedAccount = accountDao.addAccount(account);
			
			return addedAccount;
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong with our DAO operations");
		}
	}
	
	public Account editAccount(int accountId, AddOrEditAccountDTO account) throws DatabaseException, AccountNotFoundException {
		try {
			if (accountDao.getAccountById(accountId) == null) {
				throw new AccountNotFoundException("Account with id " + accountId + " was not found");
			}
			
			Account editedAccount = accountDao.editAccount(accountId, account);
			
			return editedAccount;
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong with our DAO operations");
		}
	}
}
