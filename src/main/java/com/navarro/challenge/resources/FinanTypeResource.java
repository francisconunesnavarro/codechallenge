package com.navarro.challenge.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.navarro.challenge.domain.FinanType;
import com.navarro.challenge.dto.FinanTypeDTO;
import com.navarro.challenge.services.FinanTypeService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RestController
@RequestMapping(value = "/finantype")
public class FinanTypeResource {

	@Autowired
	private FinanTypeService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<FinanTypeDTO>> findAll() {
		List<FinanType> list = service.findAll();
		List<FinanTypeDTO> listDTO = list.stream().map(obj -> new FinanTypeDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FinanType> find(@PathVariable Integer id) {
		FinanType obj = service.find(id);

		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody FinanTypeDTO objDto) {
		FinanType obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody FinanTypeDTO objDto, @PathVariable Integer id) {
		FinanType obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);

		return ResponseEntity.noContent().build();
	}

}
