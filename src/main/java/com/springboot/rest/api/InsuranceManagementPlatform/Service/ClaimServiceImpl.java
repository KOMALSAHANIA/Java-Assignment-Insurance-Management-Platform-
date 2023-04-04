package com.springboot.rest.api.InsuranceManagementPlatform.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.rest.api.InsuranceManagementPlatform.Entity.ClaimEntity;
import com.springboot.rest.api.InsuranceManagementPlatform.Repository.ClaimRepo;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	ClaimRepo claimRepo;

	@Override
	public ResponseEntity<List<ClaimEntity>> getClaims() {
		try {
			List<ClaimEntity> claimList = claimRepo.findAll();
			if (claimList.isEmpty() || claimList.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(claimList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ClaimEntity> getClaim(Long id) {

		Optional<ClaimEntity> getClaim = claimRepo.findById(id);

		if (getClaim.isPresent()) {
			ClaimEntity claim = getClaim.get();
			return new ResponseEntity<>(claim, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<ClaimEntity> addClaim(ClaimEntity claim) {

		try {
			ClaimEntity savedClaim = claimRepo.save(claim);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedClaim);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<HttpStatus> updateClaim(Long id, ClaimEntity claim) {
		try {
			List<ClaimEntity> list = claimRepo.findAll();

			for (ClaimEntity entity : list) {
				if (entity.getId() == id) {
					entity.setDescription(claim.getDescription());
					entity.setClaimStatus(claim.getClaimStatus());

					claimRepo.save(entity);
				}
			}

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<HttpStatus> deleteClaim(Long id) {
		try {
			Optional<ClaimEntity> claimOptional = claimRepo.findById(id);

			if (claimOptional.isPresent()) {
				ClaimEntity claim = claimOptional.get();
				claimRepo.delete(claim);
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
