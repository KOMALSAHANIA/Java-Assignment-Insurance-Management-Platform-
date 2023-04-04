package com.springboot.rest.api.InsuranceManagementPlatform.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springboot.rest.api.InsuranceManagementPlatform.Entity.InsurancePolicyEntity;

public interface InsurancePolicyService {

	public ResponseEntity<List<InsurancePolicyEntity>> getPolicies();
	
	public ResponseEntity<InsurancePolicyEntity> getPolicy(Long id);
	
	public ResponseEntity<InsurancePolicyEntity> addPolicy(InsurancePolicyEntity policy);
	
	public ResponseEntity<HttpStatus> updatePolicy(Long id, InsurancePolicyEntity policy);
	
	public ResponseEntity<HttpStatus> deletePolicy(Long id);
}
