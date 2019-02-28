package com.navarro.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.navarro.challenge.domain.FinanType;

@Repository
public interface FinanTypeRepository extends JpaRepository<FinanType, Integer> {

	@Transactional(readOnly = true)
	List<FinanType> findAll();

	@Transactional(readOnly = true)
	FinanType findByType(String type);
}
