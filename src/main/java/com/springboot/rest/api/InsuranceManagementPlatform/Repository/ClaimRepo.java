package com.springboot.rest.api.InsuranceManagementPlatform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.api.InsuranceManagementPlatform.Entity.ClaimEntity;

public interface ClaimRepo extends JpaRepository<ClaimEntity, Long>{

}
