package com.navarro.challenge.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navarro.challenge.domain.FinanType;
import com.navarro.challenge.repository.FinanTypeRepository;

@Service
public class DBService {

	@Autowired
	private FinanTypeRepository finanTypeRepository;

	public void instantiateTestDataBase() throws ParseException {
		FinanType finanTypeAux = finanTypeRepository.findByType("I");
		if (finanTypeAux == null) {
			FinanType finanType = new FinanType(null, "I", "Interno", 4.0);
			finanTypeRepository.saveAll(Arrays.asList(finanType));
		}
		
		finanTypeAux = finanTypeRepository.findByType("E");
		if (finanTypeAux == null) {
			FinanType finanType = new FinanType(null, "E", "Externo", 6.5);
			finanTypeRepository.saveAll(Arrays.asList(finanType));
		}
	}
}
