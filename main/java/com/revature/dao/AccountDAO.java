package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.dto.AddOrEditAccountDTO;
import com.revature.model.Account;

public interface AccountDAO {
	public abstract List<Account> getAllAccounts() throws SQLException;
	
	public abstract Account getAccountById(int id) throws SQLException;
	
	public abstract Account addAccount(AddOrEditAccountDTO account) throws SQLException;
	
	public abstract Account editAccount(int accountId, AddOrEditAccountDTO account) throws SQLException;
}
