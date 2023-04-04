package com.springboot.rest.api.InsuranceManagementPlatform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.api.InsuranceManagementPlatform.Entity.ClientEntity;

public interface ClientRepo extends JpaRepository<ClientEntity, Long>{

}
