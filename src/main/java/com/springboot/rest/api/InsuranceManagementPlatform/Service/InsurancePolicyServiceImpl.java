package com.springboot.rest.api.InsuranceManagementPlatform.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.springboot.rest.api.InsuranceManagementPlatform.Entity.ClientEntity;
import com.springboot.rest.api.InsuranceManagementPlatform.Entity.InsurancePolicyEntity;
import com.springboot.rest.api.InsuranceManagementPlatform.Repository.PolicyRepo;

public class InsurancePolicyServiceImpl implements InsurancePolicyService {

	@Autowired
	PolicyRepo policyRepo;
	
	@Autowired
	InsurancePolicyEntity policyEntity;
	
	@Override
	public ResponseEntity<List<InsurancePolicyEntity>> getPolicies() {
		try {
			List<InsurancePolicyEntity> policyList = policyRepo.findAll();
			if (policyList.isEmpty() || policyList.size()==0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(policyList,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<InsurancePolicyEntity> getPolicy(Long id) {

		Optional<InsurancePolicyEntity> getPolicy = policyRepo.findById(id);
		if (getPolicy.isPresent()) {
			InsurancePolicyEntity policyEntity = getPolicy.get();
			return new ResponseEntity<>(policyEntity,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<InsurancePolicyEntity> addPolicy(InsurancePolicyEntity policy) {

		try {
			InsurancePolicyEntity savedPolicy = policyRepo.save(policy);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedPolicy);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<HttpStatus> updatePolicy(Long id, InsurancePolicyEntity policy) {

		try {
			List<InsurancePolicyEntity> list = policyRepo.findAll();

			for (InsurancePolicyEntity entity : list) {
				if (entity.getId() == id) {
					entity.setType(policy.getType());
					entity.setPolicyNumber(policy.getPolicyNumber());

					policyRepo.save(entity);
				}
			}

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<HttpStatus> deletePolicy(Long id) {

		try {
			Optional<InsurancePolicyEntity> clientOptional = policyRepo.findById(id);

			if (clientOptional.isPresent()) {
				InsurancePolicyEntity client = clientOptional.get();
				policyRepo.delete(client);
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	

}
