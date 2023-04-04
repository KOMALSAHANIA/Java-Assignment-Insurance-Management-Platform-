package com.springboot.rest.api.InsuranceManagementPlatform.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.api.InsuranceManagementPlatform.Entity.ClaimEntity;
import com.springboot.rest.api.InsuranceManagementPlatform.Entity.ClientEntity;
import com.springboot.rest.api.InsuranceManagementPlatform.Entity.InsurancePolicyEntity;
import com.springboot.rest.api.InsuranceManagementPlatform.Service.ClaimService;
import com.springboot.rest.api.InsuranceManagementPlatform.Service.ClientService;
import com.springboot.rest.api.InsuranceManagementPlatform.Service.InsurancePolicyService;

@RestController
public class InsuranceMgmtController {

	@Autowired
	ClientService clientService;
	
	@Autowired
	InsurancePolicyEntity insurancePolicy;
	
	@Autowired
	InsurancePolicyService insuranceService;
	
	@Autowired
	ClaimService claimService;
	
//	For Client APIs
	
	@GetMapping("/api/clients")
	public ResponseEntity<List<ClientEntity>> getAllClients(){
		return clientService.getClients();
	}
	
	@GetMapping("/api/clients/{id}")
	public ResponseEntity<ClientEntity> getClientById(@PathVariable Long id) {
		return clientService.getClient(id);
	}
	
	@PostMapping("/api/clients")
	public ResponseEntity<ClientEntity> addRecord(@RequestBody ClientEntity client){
		return clientService.addClient(client);
	}
	
	@PutMapping("/api/clients/{id}")
	public ResponseEntity<HttpStatus> updateRecord(@PathVariable Long id, @RequestBody ClientEntity client) {
		return clientService.updateClient(id,client);
	}
	
	@DeleteMapping("/api/clients/{id}")
	public ResponseEntity<HttpStatus> deleteRecord(@PathVariable Long id){
		return clientService.deleteClient(id);
	}
	
//	For Insurance APIS
	
	@GetMapping("/api/policies")
	public ResponseEntity<List<InsurancePolicyEntity>> getAllPolicies(){
		return insuranceService.getPolicies();
	}
	
	@GetMapping("/api/policies/{id}")
	public ResponseEntity<InsurancePolicyEntity> getPolicyById(@PathVariable Long id){
		return insuranceService.getPolicy(id);
	}
	
	@PostMapping("/api/policies")
	public ResponseEntity<InsurancePolicyEntity> addRecord(@RequestBody InsurancePolicyEntity policy){
		return insuranceService.addPolicy(policy);
	} 
	
	@PutMapping("api/policies/{id}")
	public ResponseEntity<HttpStatus> updatePolicyRecord(@PathVariable Long id, @RequestBody InsurancePolicyEntity policy){
		return insuranceService.updatePolicy(id,policy);
	}
	
	@DeleteMapping("api/policies/{id}")
		public ResponseEntity<HttpStatus> deletePolicyRecord(@PathVariable Long id){
			return insuranceService.deletePolicy(id);
		}
	
//	For Claim APIs
	
	@GetMapping("/api/claims")
	public ResponseEntity<List<ClaimEntity>> getAllClaims(){
		return claimService.getClaims();
	}
	
	@GetMapping("/api/claims/{id}")
	public ResponseEntity<ClaimEntity> getClaimById(@PathVariable Long id){
		return claimService.getClaim(id);
	}
	
	
	@PostMapping("/api/claims")
	public ResponseEntity<ClaimEntity> addRecord(@RequestBody ClaimEntity claim){
		return claimService.addClaim(claim);
	}
	
	@PutMapping("/api/claims/{id}")
	public ResponseEntity<HttpStatus> updateClaimRecord(@PathVariable Long id, @RequestBody ClaimEntity claim){
		return claimService.updateClaim(id,claim);
	}
	
	@DeleteMapping("/api/claims/{id}")
	public ResponseEntity<HttpStatus> deleteClaimRecord(@PathVariable Long id){
		return claimService.deleteClaim(id);
	}
}

