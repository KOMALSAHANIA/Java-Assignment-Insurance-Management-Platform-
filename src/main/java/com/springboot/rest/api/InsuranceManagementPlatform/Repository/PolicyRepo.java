package com.springboot.rest.api.InsuranceManagementPlatform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.api.InsuranceManagementPlatform.Entity.InsurancePolicyEntity;

public interface PolicyRepo extends JpaRepository<InsurancePolicyEntity,Long>{

}
