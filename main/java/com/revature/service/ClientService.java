package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.ClientDAO;
import com.revature.dao.ClientDAOImpl;
import com.revature.dto.AddOrEditClientDTO;
import com.revature.exception.DatabaseException;
import com.revature.exception.ClientNotFoundException;
import com.revature.model.Client;

public class ClientService {
	private ClientDAO clientDao;
	
	public ClientService() {
		this.clientDao = new ClientDAOImpl();
	}
	
	public List<Client> getAllClients() throws DatabaseException {
		try {
			List<Client> clients = clientDao.getAllClients();
			
			return clients;
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong with our DAO operations");
		}	
	}
	
	public Client getClientById(int id) throws DatabaseException, ClientNotFoundException {
		try {
			Client client = clientDao.getClientById(id);
			
			if (client == null) {
				throw new ClientNotFoundException("Client with id " + id + " was not found");
			}
			
			return client;
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong with our DAO operations");
		}
	}
	
	public Client addClient(AddOrEditClientDTO client) throws DatabaseException {
		try {
			Client addedClient = clientDao.addClient(client);
			
			return addedClient;
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong with our DAO operations");
		}
	}
	
	public Client editClient(int clientId, AddOrEditClientDTO client) throws DatabaseException, ClientNotFoundException {
		try {
			if (clientDao.getClientById(clientId) == null) {
				throw new ClientNotFoundException("Client with id " + clientId + " was not found");
			}
			
			Client editedClient = clientDao.editClient(clientId, client);
			
			return editedClient;
		} catch (SQLException e) {
			throw new DatabaseException("Something went wrong with our DAO operations");
		}
	}
}
