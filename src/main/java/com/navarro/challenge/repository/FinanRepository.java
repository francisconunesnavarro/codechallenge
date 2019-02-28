package com.navarro.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.navarro.challenge.domain.Finan;

@Repository
public interface FinanRepository extends JpaRepository<Finan, Integer> {

	@Transactional(readOnly = true)
	List<Finan> findAll();
}
