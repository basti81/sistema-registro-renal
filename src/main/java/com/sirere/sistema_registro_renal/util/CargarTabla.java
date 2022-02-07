package com.sirere.sistema_registro_renal.util;

import com.sirere.sistema_registro_renal.entity.Especialidad;
import com.sirere.sistema_registro_renal.entity.Rol;
import com.sirere.sistema_registro_renal.enums.EspecilidadEnum;
import com.sirere.sistema_registro_renal.enums.RolEnum;
import com.sirere.sistema_registro_renal.services.EspecialidadService;
import com.sirere.sistema_registro_renal.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CargarTabla implements CommandLineRunner {

    @Autowired
    private RolService rolService;

    @Autowired
    private EspecialidadService especialidadService;



    @Override
    public void run(String... args) throws Exception {
//        cargaRoles();
//        cargaEspecialidad();
    }

    private void cargaRoles(){
        List<Rol> rols = new ArrayList<>();
        rols.add(new Rol(RolEnum.ADMINISTRADOR));
        rols.add(new Rol(RolEnum.CLIENTE));
        rols.add(new Rol(RolEnum.DOCTOR));
        rols.add(new Rol(RolEnum.ENFERMERIA));
        rols.add(new Rol(RolEnum.GES));
        rols.add(new Rol(RolEnum.LABORATORISTA));
        rols.add(new Rol(RolEnum.ESTADISTICAS));
        rols.add(new Rol(RolEnum.TENS));

        for(Rol rol: rols){
            rolService.save(rol);
        }
    }

    private void cargaEspecialidad(){
        List<Especialidad> especialidads = new ArrayList<>();
        especialidads.add(new Especialidad(EspecilidadEnum.NINGUNA));
        especialidads.add(new Especialidad(EspecilidadEnum.GENERAL));
        especialidads.add(new Especialidad(EspecilidadEnum.NEFROLOGIA));

        for (Especialidad especialidad : especialidads){
            especialidadService.save(especialidad);
        }
    }
}
