package com.navarro.challenge.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.navarro.challenge.domain.Finan;
import com.navarro.challenge.domain.FinanType;
import com.navarro.challenge.dto.FinanDTO;
import com.navarro.challenge.services.FinanService;
import com.navarro.challenge.services.FinanTypeService;
import com.navarro.challenge.services.exceptions.DataIntegrityException;

@Controller
@RestController
@RequestMapping(value = "/finan")
public class FinanResource {

	@Autowired
	private FinanService service;
	@Autowired
	private FinanTypeService finanTypeService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<FinanDTO>> findAll() {
		List<Finan> list = service.findAll();
		List<FinanDTO> listDTO = list.stream().map(obj -> new FinanDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Finan> find(@PathVariable Integer id) {
		Finan obj = service.find(id);

		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody FinanDTO objDto) {
		Finan obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody FinanDTO objDto, @PathVariable Integer id) {
		Finan obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);

		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/calc", method = RequestMethod.GET)
	public ResponseEntity<Double> calcAmount(@RequestParam(value = "finantype_id", defaultValue = "") Integer finantype_id,
			@RequestParam(value = "value", defaultValue = "") Double value,
			@RequestParam(value = "amount", defaultValue = "") Integer amount) {
		
		Double quota = null;
		FinanType finanTyppe = finanTypeService.find(finantype_id);

		if (finanTyppe != null && finanTyppe.getFactor() > 0 && amount != null && amount > 0 && value != null && value > 0.0) {
			Double factor = finanTyppe.getFactor();
			quota = value * (1 + (factor/100)) / amount;
		} else {
			throw new DataIntegrityException("Não é possível calcular o valor da mensalidade");
		}
		
		return ResponseEntity.ok().body(quota);
	}

}
