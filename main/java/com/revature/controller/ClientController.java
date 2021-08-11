package com.revature.controller;

import java.util.List;

import com.revature.model.Client;
import com.revature.service.ClientService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ClientController implements Controller {
	private ClientService clientService;
	
	public ClientController() {
		this.clientService = new ClientService();
	}
	
	private Handler getAllClients = (ctx) -> {
		List<Client> clients = clientService.getAllClients();
		
		ctx.json(clients);
	};

	@Override
	public void mapEndpoints(Javalin app) {
		app.get("/clients", getAllClients);
	}

}
