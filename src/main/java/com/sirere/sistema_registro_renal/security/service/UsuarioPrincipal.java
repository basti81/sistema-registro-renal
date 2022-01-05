//package com.sirere.sistema_registro_renal.security.service;
//
//import com.sirere.sistema_registro_renal.entity.Usuario;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class UsuarioPrincipal implements UserDetails {
//
//    private Long id_usuario;
//    private String rut;
//    private String nombre;
//    private String apellido;
//    private String userName;
//    private String password;
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public UsuarioPrincipal(Long id_usuario, String rut, String nombre, String apellido, String userName, String password, Collection<? extends GrantedAuthority> authorities) {
//        this.id_usuario = id_usuario;
//        this.rut = rut;
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.userName = userName;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//    public static UsuarioPrincipal build(Usuario usuario){
//        List<GrantedAuthority> authorities =
//                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
//        return new UsuarioPrincipal(usuario.getId_usuario(), usuario.getRut(),usuario.getNombre(),usuario.getApellido(),usuario.getUsername(), usuario.getPassword(),authorities);
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return userName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public Long getId_usuario(){
//        return id_usuario;
//    }
//}
