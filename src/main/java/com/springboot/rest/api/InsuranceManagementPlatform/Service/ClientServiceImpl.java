package com.springboot.rest.api.InsuranceManagementPlatform.Service;

import java.util.List;
import java.util.Optional;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmTypeDefinitionType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmTypeSpecificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.rest.api.InsuranceManagementPlatform.Entity.ClientEntity;
import com.springboot.rest.api.InsuranceManagementPlatform.Repository.ClientRepo;
import com.springboot.rest.api.InsuranceManagementPlatform.Repository.PolicyRepo;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	ClientRepo clientRepo;
	
	@Autowired
	ClientEntity entity;
	
	@Override
	public ResponseEntity<List<ClientEntity>> getClients() {
		try {
			List<ClientEntity> clientList = clientRepo.findAll();
			if (clientList.isEmpty() || clientList.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(clientList, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@Override
	public ResponseEntity<ClientEntity> getClient(Long id) {
		
		Optional<ClientEntity> getClient = clientRepo.findById(id);
		
		if (getClient.isPresent()) {
			ClientEntity client = getClient.get();
			return new ResponseEntity<>(client, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<ClientEntity> addClient(ClientEntity client) {
		try {
			ClientEntity savedClient = clientRepo.save(client);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<HttpStatus> updateClient(Long id, ClientEntity client) {
		try {
			List<ClientEntity> list = clientRepo.findAll();

			for (ClientEntity entity : list) {
				if (entity.getId() == id) {
					entity.setAddress(client.getAddress());
					entity.setPhone(client.getPhone());

					clientRepo.save(entity);
				}
			}

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<HttpStatus> deleteClient(Long id) {

		try {
			Optional<ClientEntity> clientOptional = clientRepo.findById(id);

			if (clientOptional.isPresent()) {
				ClientEntity client = clientOptional.get();
				clientRepo.delete(client);
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
