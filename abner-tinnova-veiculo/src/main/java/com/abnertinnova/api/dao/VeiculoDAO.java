package com.abnertinnova.api.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.abnertinnova.api.model.Veiculo;

public interface VeiculoDAO extends CrudRepository <Veiculo, Long> {
	
	List<Veiculo> findByAno(Integer ano);
	List<Veiculo> findByVendido(boolean vendido);
	List<Veiculo> findByMarcaIgnoreCaseContaining(String marca);
	List<Veiculo> findByCreatedBefore(Date data);

}
