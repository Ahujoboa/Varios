package com.andrea.pruebaSpring1.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andrea.pruebaSpring1.models.UsuarioModel;

@Repository
//Es una interfaz porque implementa métodos que ya están implementados al extender de crudRepository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

	public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
}
