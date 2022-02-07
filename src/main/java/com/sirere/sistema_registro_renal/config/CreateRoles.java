package com.sirere.sistema_registro_renal.config;

import com.sirere.sistema_registro_renal.entity.Rol;
import com.sirere.sistema_registro_renal.enums.RolEnum;
import com.sirere.sistema_registro_renal.services.EspecialidadService;
import com.sirere.sistema_registro_renal.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;


public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Autowired
     EspecialidadService especialidadService;

    @Override
    public void run(String... args) throws Exception {

        Rol rolAdmin = new Rol(RolEnum.ADMINISTRADOR);
        Rol rolCliente = new Rol(RolEnum.CLIENTE);
        Rol rolDoctor = new Rol(RolEnum.DOCTOR);
        Rol rolEnfermeria = new Rol(RolEnum.ENFERMERIA);
        Rol rolGes = new Rol(RolEnum.GES);
        Rol rolLaboratorista = new Rol(RolEnum.LABORATORISTA);
        Rol rolEstadisticas = new Rol(RolEnum.ESTADISTICAS);
        Rol rolTens = new Rol(RolEnum.TENS);

        rolService.save(rolAdmin);
        rolService.save(rolCliente);
        rolService.save(rolDoctor);
        rolService.save(rolEnfermeria);
        rolService.save(rolGes);
        rolService.save(rolLaboratorista);
        rolService.save(rolEstadisticas);
        rolService.save(rolTens);

//        Especialidad especilidadGeneral = new Especialidad(EspecilidadNombre.GENERAL);
//        Especialidad especilidadNefrologia = new Especialidad(EspecilidadNombre.NEFROLOGIA);
//
//        especialidadService.save(especilidadGeneral);
//        especialidadService.save(especilidadNefrologia);
    }

}
