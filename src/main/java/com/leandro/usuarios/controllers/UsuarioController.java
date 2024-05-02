package com.leandro.usuarios.controllers;

import com.leandro.usuarios.models.Usuario;
import com.leandro.usuarios.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAll(){
        List<Usuario> usuarioList = usuarioService.getAll();
        return usuarioList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> fiindById(@PathVariable Long id){
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        if(usuarioOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(usuarioOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?>  save(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Usuario usuario, @PathVariable Long id){
        Optional<Usuario> optionalUsuario = usuarioService.update(id, usuario);
        if(optionalUsuario.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(optionalUsuario.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Usuario> optionalUsuario = usuarioService.delete(id);
        if(optionalUsuario.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalUsuario.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
