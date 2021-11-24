package com.sirere.sistema_registro_renal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SistemaRegistroRenalApplication implements CommandLineRunner{

	/*@Autowired
	private PersonalRepository personalRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(SistemaRegistroRenalApplication.class, args);
	}


	public void run(String... args) throws Exception {
	}

	/*private void guardar(){
		Personal personal = new Personal();
		//se llena el objeto personal
		personalRepository.save(personal);
		System.out.println("registro insertado");
	}

/*	private void buscarPorId(int id_usuario){
		Optional<Personal> optional = personalRepository.findById(id_usuario);
		if(optional.isPresent()){
			System.out.println("Personal encontrado");
		}else{
			System.out.println("Personal no encontrado");
		}
	}

	private void modificar(int id_usuario){
		Optional<Personal> optional = personalRepository.findById(id_usuario);
		if(optional.isPresent()){
			Personal personal = optional.get();
			//llenar personal
			personalRepository.save(personal);
			System.out.println(optional.get());
		}else{
			System.out.println("Personal no encontrado");
		}
	}*/

	/*private void eliminar(int id_usuario){
		personalRepository.deleteById(id_usuario);
	}

	private void conteo(){
		long count = personalRepository.count();
		System.out.println("total personal = " + count);
	}

	private void eliminarTodo(){
		personalRepository.deleteAll();
	}

	private void entronarPorIds(){
		List<Integer> ids = new LinkedList<Integer>();
		Iterable<Personal> personals = personalRepository.findAllById(ids);
		for (Personal per: personals) {
			System.out.println(per);
		}
	}

	private void mostrarTodo(){

	}

	private void existeId(int id_usuario){
		boolean existe = personalRepository.existsById(id_usuario);
		System.out.println(existe);
	}
*/
}
