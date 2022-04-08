package com.andrea.pruebaSpring1.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrea.pruebaSpring1.models.UsuarioModel;
import com.andrea.pruebaSpring1.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	// Necesitamos usar el repositorio creado anteriormente, lo declaramos como una
	// variable
	// No tenemos que instanciarla ya que spring sabrá que ya existe y la instancia
	// automáticamente
	@Autowired
	UsuarioRepository usuarioRepository;

	public ArrayList<UsuarioModel> obtenerUsuarios() {
		return (ArrayList<UsuarioModel>) usuarioRepository.findAll();

	}

	public UsuarioModel guardarUsuario(UsuarioModel usuario) {
		return usuarioRepository.save(usuario);
	}

	// optional para que si existe bien y si no existe el id no causa problemas
	public Optional<UsuarioModel> obtenerPorId(Long id) {
		return usuarioRepository.findById(id);

	}

	public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad) {
		return usuarioRepository.findByPrioridad(prioridad);
	}

	public boolean eliminarUsuario(Long id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		} catch (Exception error) {
			return false;
		}
	}

}
