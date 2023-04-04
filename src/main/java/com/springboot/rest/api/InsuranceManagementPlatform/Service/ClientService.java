package com.springboot.rest.api.InsuranceManagementPlatform.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.springboot.rest.api.InsuranceManagementPlatform.Entity.ClientEntity;

@Component
public interface ClientService {

	public ResponseEntity<List<ClientEntity>> getClients();
	
	public ResponseEntity<ClientEntity> getClient(Long id);
	
	public ResponseEntity<ClientEntity> addClient(ClientEntity client);
	
	public ResponseEntity<HttpStatus> updateClient(Long id,ClientEntity client);
	
	public ResponseEntity<HttpStatus> deleteClient(Long id);
}
