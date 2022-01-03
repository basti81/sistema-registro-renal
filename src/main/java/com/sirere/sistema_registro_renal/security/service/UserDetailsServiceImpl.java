package com.sirere.sistema_registro_renal.security.service;

//import com.sirere.sistema_registro_renal.entity.Rol;
//import com.sirere.sistema_registro_renal.entity.Usuario;
//import com.sirere.sistema_registro_renal.services.UsuarioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    UsuarioService usuarioService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Usuario usuario = usuarioService.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException(username));
//        return UsuarioPrincipal.build(usuario);
//    }
//
//}
