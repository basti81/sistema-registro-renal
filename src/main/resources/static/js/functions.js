
 //EXTRAE UNA FILA DEL TABLA DOCTORES Y LA ENVIA A UNA TEXT
 $(".btn_addDoctor").on("click", function() {
//     var id_usuario =$(this).closest('tr').children()[0].textContent;
     var id_personal =$(this).closest('tr').children()[1].textContent;
//     var rut = $(this).closest('tr').children()[2].textContent;
     var nombre = $(this).closest('tr').children()[3].textContent;
//     var rol = $(this).closest('tr').children()[4].textContent;
//    alert(id_usuario," ",id_personal," ",rut," ",nombre," ",rol);
//     alert("ID USUARIO = " + id_usuario);
//      alert("ID PERSONAL = " + id_personal);
//      alert("NOMBRE = "+nombre);
//
//      alert("Rol = "+rol);
     $("#txt_id_personal").val(id_personal);
     $("#txt_name_doctor").val(nombre);
 });

  function today(){
        to_examen_list.max = new Date().toISOString().split("T")[0];
        from_examen_list.max = new Date().toISOString().split("T")[0];
    }