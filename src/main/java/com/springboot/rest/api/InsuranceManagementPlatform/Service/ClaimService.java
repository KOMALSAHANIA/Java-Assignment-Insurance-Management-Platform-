package com.springboot.rest.api.InsuranceManagementPlatform.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springboot.rest.api.InsuranceManagementPlatform.Entity.ClaimEntity;

public interface ClaimService {

	public ResponseEntity<List<ClaimEntity>> getClaims();
	
	public ResponseEntity<ClaimEntity> getClaim(Long id);
	
	public ResponseEntity<ClaimEntity> addClaim(ClaimEntity claim);
	
	public ResponseEntity<HttpStatus> updateClaim(Long id ,ClaimEntity claim);
	
	public ResponseEntity<HttpStatus> deleteClaim(Long id);
}