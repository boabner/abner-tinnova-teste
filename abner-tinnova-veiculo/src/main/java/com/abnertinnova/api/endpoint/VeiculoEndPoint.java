package com.abnertinnova.api.endpoint;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abnertinnova.api.dao.VeiculoDAO;
import com.abnertinnova.api.error.ResourceNotFoundException;
import com.abnertinnova.api.model.Veiculo;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
@RequestMapping("veiculos")
public class VeiculoEndPoint {
	
	private final VeiculoDAO veiculoDAO;	
	@Autowired
	public VeiculoEndPoint(VeiculoDAO veiculoDAO) {
		this.veiculoDAO = veiculoDAO;
	}
	
	@GetMapping
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<>(veiculoDAO.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/find/{ano}")
	public List<Veiculo> getVeiculoByAno(@PathVariable("ano") Integer ano) {
		List<Veiculo> veiculos = veiculoDAO.findByAno(ano);
		return veiculos;
	}	
	
	@GetMapping(path = "/vendidos")
	public List<Veiculo> getVeiculoVendido() {
		List<Veiculo> veiculos = veiculoDAO.findByVendido(false);
		return veiculos;
	}
	
	
	@GetMapping(path = "/find/marca/{marca}")
	public List<Veiculo> getVeiculosByMarca(@PathVariable("marca") String marca) {
		List<Veiculo> veiculos = veiculoDAO.findByMarcaIgnoreCaseContaining(marca);
		return veiculos;
	}
	
	@GetMapping(path = "/find/semana")
	public List<Veiculo> getVeiculosBySemana() {
		Calendar cal = Calendar.getInstance();
		cal.setTime (new Date(System.currentTimeMillis()));
		int daysToDecrement = -7;
		cal.add(Calendar.DATE, daysToDecrement);
		Date date = cal.getTime();
		System.out.println(date);
		List<Veiculo> veiculos = veiculoDAO.findByCreatedBefore(date);
		return veiculos;
	}


	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getVeiculoById(@PathVariable("id") Long id) {
		verifyIfVeiculoExists(id);
		Veiculo veiculo = veiculoDAO.findById(id).get();
		return new ResponseEntity<>(veiculo, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Veiculo veiculo) {  
		veiculo.setUpdated(new Date(System.currentTimeMillis()));
		veiculoDAO.save(veiculo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfVeiculoExists(id);
		veiculoDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Veiculo veiculo) {
		veiculo.setCreated(new Date(System.currentTimeMillis()));
		return new ResponseEntity<>(veiculoDAO.save(veiculo), HttpStatus.CREATED);
	}
	
	private void verifyIfVeiculoExists(Long id) {
		if(!veiculoDAO.findById(id).isPresent())
			throw new ResourceNotFoundException("Student not found for id " + id);	
	}
	
}