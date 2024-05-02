package com.leandro.usuarios.services;

import com.leandro.usuarios.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public List<Usuario> getAll();
    public Optional<Usuario> findById(Long id);
    public Optional<Usuario> update(Long id, Usuario usuario);

    public Usuario save(Usuario usuario);

    public Optional<Usuario> delete(Long id);


}
