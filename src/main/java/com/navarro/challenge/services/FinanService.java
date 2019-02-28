package com.navarro.challenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.navarro.challenge.domain.Finan;
import com.navarro.challenge.dto.FinanDTO;
import com.navarro.challenge.repository.FinanRepository;
import com.navarro.challenge.services.exceptions.DataIntegrityException;
import com.navarro.challenge.services.exceptions.ObjectNotFoundException;

@Service
public class FinanService {

	@Autowired
	private FinanRepository repo;

	public Finan find(Integer id) {
		Optional<Finan> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Finan.class.getName()));
	}

	public List<Finan> findAll() {
		return repo.findAll();
	}

	public Finan insert(Finan obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Finan update(Finan obj) {
		Finan newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Finan newObj, Finan obj) {
		newObj.setFinanType(obj.getFinanType());
		newObj.setAmount(obj.getAmount());
		newObj.setValue(obj.getValue());
		newObj.setQuota(obj.getQuota());
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir");
		}
	}

	public Double calcAmount(Finan obj) {
		Double value = obj.getValue();
		Integer amount = obj.getAmount();
		Double quota = null;

		if (amount != null && amount > 0 && value != null && value > 0.0) {
			Double factor = obj.getFinanType().getFactor();
			quota = value * (1 + (factor/100)) / amount;
		} else {
			throw new DataIntegrityException("Não é possível calcular o valor da mensalidade");
		}

		return quota;
	}

	public Finan fromDTO(FinanDTO objDto) {
		return new Finan(objDto.getId(), objDto.getFinanType(), objDto.getAmount(), objDto.getValue(),
				objDto.getQuota(), objDto.getName(), objDto.getContacto());
	}

}
