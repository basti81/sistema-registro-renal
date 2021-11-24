package com.sirere.sistema_registro_renal.services;

import com.sirere.sistema_registro_renal.entity.Usuario;
import com.sirere.sistema_registro_renal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> lista(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getById(Long id_usuario){
        return usuarioRepository.findById(id_usuario);
    }

    public Optional<Usuario> getByUsername(String userName){
        return usuarioRepository.findByUsername(userName);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public boolean existsById(Long id_usuario){
        return usuarioRepository.existsById(id_usuario);
    }

    public boolean existsbyUsername(String userName){
        return  usuarioRepository.existsByUsername(userName);
    }



}
