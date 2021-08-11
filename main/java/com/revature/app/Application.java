package com.revature.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.Controller;
import com.revature.controller.AccountController;
import com.revature.controller.ClientController;
import com.revature.controller.TestController;
import com.revature.dto.AddOrEditClientDTO;
import com.revature.exception.DatabaseException;
import com.revature.exception.ClientNotFoundException;
import com.revature.model.Client;
import com.revature.service.ClientService;
import com.revature.util.ConnectionUtility;

import io.javalin.Javalin;

public class Application {
	private static Javalin app;
	private static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		/*
		try {
			Connection connection = ConnectionUtility.getConnection();
			
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		*/
		/*
		ClientService clientService = new ClientService();
		
		try {
			List<Client> clients = clientService.getAllClients();
			System.out.println(clients);
		} catch (DatabaseException e) {
			System.out.println("Something went wrong when interactiing with the database");
			// When it comes to HTTP response codes, this would probably be where you set the response code to 500
		}
		
		try {
			Client client = clientService.getClientById(3);
			System.out.println(client);
		} catch (DatabaseException e) {
			System.out.println("Something went wrong when interactiing with the database");
		} catch (ClientNotFoundException e) {
			System.out.println(e.getMessage());
		}
		*/
		/*
		try {
			AddOrEditShipDTO shipDto = new AddOrEditShipDTO();
			shipDto.setName("Fancy");
			shipDto.setAge(6);
			
			Ship createdShip = shipService.addShip(shipDto);
			System.out.println("Ship added: " + createdShip);
		} catch (DatabaseException e) {
			System.out.println("Something went wrong when interacting with the database");
		}
		*/
		/*
		try {
			AddOrEditClientDTO clientDto = new AddOrEditClientDTO();
			clientDto.setName("test");
			clientDto.setAge(100);
			
			Client client = clientService.editClient(1, clientDto);
			System.out.println(client);
		} catch(ClientNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (DatabaseException e) {
			System.out.println("Something went wrong when interacting with the database");
		}
		*/
		app = Javalin.create();
		
		mapControllers(new TestController(), new ClientController(), new AccountController());
		
		app.before((ctx) -> {
			logger.info(ctx.method() + " request recieved to the " + ctx.path() + " endpoint");
		});
		
		app.start(7000); // start up our Javalin server on port 7000 
	}
	
	public static void mapControllers(Controller... controllers) {
		for (Controller c : controllers) {
			c.mapEndpoints(Application.app);
		}
	}

}
