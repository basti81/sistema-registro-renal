package com.sirere.sistema_registro_renal.controllers;

import com.sirere.sistema_registro_renal.entity.Rol;
import com.sirere.sistema_registro_renal.entity.Usuario;
import com.sirere.sistema_registro_renal.enums.RolNombre;
import com.sirere.sistema_registro_renal.services.RolService;
import com.sirere.sistema_registro_renal.services.UsuarioService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

    @PostMapping("/registrar")
    public ModelAndView registrar(String username, String password) {
        ModelAndView mv = new ModelAndView();
        if (StringUtils.isBlank(username)) {
            mv.setViewName("/registro");
            mv.addObject("error", "el nombre no puede estar vacío");
            return mv;
        }
        if (StringUtils.isBlank(password)) {
            mv.setViewName("/registro");
            mv.addObject("error", "la contraseña no puede estar vacía");
            return mv;
        }
        if (!usuarioService.existsbyUsername(username)) {
            mv.setViewName("/registro");
            mv.addObject("error", "ese nombre de usuario ya existe");
            return mv;
        }
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(passwordEncoder.encode(password));
        Rol rolUser = rolService.getByRolNombre(RolNombre.ADMINISTRADOR).get();
        Set<Rol> roles = new HashSet<>();
        roles.add(rolUser);
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        mv.setViewName("/login");
        mv.addObject("registroOK", "Cuenta creada, " + usuario.getUsername() + ", ya puedes iniciar sesión");
        return mv;
    }
}
