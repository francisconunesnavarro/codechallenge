package com.navarro.challenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.navarro.challenge.domain.FinanType;
import com.navarro.challenge.dto.FinanTypeDTO;
import com.navarro.challenge.repository.FinanTypeRepository;
import com.navarro.challenge.services.exceptions.DataIntegrityException;
import com.navarro.challenge.services.exceptions.ObjectNotFoundException;

@Service
public class FinanTypeService {

	@Autowired
	private FinanTypeRepository repo;

	public FinanType find(Integer id) {
		Optional<FinanType> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + FinanType.class.getName()));
	}

	public List<FinanType> findAll() {
		return repo.findAll();
	}
	
	public FinanType findByType(String type) {
		return repo.findByType(type);
	}

	public FinanType fromDTO(FinanTypeDTO objDto) {
		return new FinanType(objDto.getId(), objDto.getType(), objDto.getName(), objDto.getFactor());
	}

	public FinanType insert(FinanType obj) {
		obj.setId(null);

		return repo.save(obj);
	}

	public FinanType update(FinanType obj) {
		FinanType newObj = find(obj.getId());
		updateData(newObj, obj);
		
		return repo.save(newObj);
	}
	
	private void updateData(FinanType newObj, FinanType obj) {
		newObj.setType(obj.getType());
		newObj.setName(obj.getName());
		newObj.setFactor(obj.getFactor());
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir");
		}
	}

}
