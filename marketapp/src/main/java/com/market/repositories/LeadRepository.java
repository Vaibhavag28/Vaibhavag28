package com.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
