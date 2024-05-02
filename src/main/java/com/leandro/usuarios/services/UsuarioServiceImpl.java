package com.leandro.usuarios.services;

import com.leandro.usuarios.dto.UsuarioRepository;
import com.leandro.usuarios.models.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;


    @Transactional(readOnly = true)
    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Transactional
    @Override
    public Optional<Usuario> update(Long id, Usuario usuario) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()){
            Usuario usuarioDb = optionalUsuario.orElseThrow();

            usuarioDb.setNombre(usuario.getNombre());
            usuarioDb.setApellido(usuario.getApellido());
            usuarioDb.setEdad(usuario.getEdad());
            usuarioDb.setEmail(usuario.getEmail());
        }
        return optionalUsuario;
    }

    @Transactional
    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    @Override
    public Optional<Usuario> delete(Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        optionalUsuario.ifPresent(usuarioRepository::delete);
        return optionalUsuario;
    }
}
