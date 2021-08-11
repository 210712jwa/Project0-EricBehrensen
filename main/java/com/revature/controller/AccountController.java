package com.revature.controller;

import java.util.List;

import com.revature.model.Account;
import com.revature.service.AccountService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AccountController implements Controller {
	private AccountService accountService;
	
	public AccountController() {
		this.accountService = new AccountService();
	}
	
	private Handler getAllAccounts = (ctx) -> {
		List<Account> accounts = accountService.getAllAccounts();
		
		ctx.json(accounts);
	};

	@Override
	public void mapEndpoints(Javalin app) {
		app.get("/account", getAllAccounts);
	}

}
