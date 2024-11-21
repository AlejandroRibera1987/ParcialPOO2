import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		BibliotecaDigital biblioteca = new BibliotecaDigital();
		Prestamos prestamo = new Prestamos();
		Scanner scanner = new Scanner(System.in);
		Administrador admin = new Administrador(1, "Alejandro", "Alejandr@gmail.com");
		Usuarios usuarioActual = new Usuarios(2, "Pedro", "pedro@gmail", 0, TipoUsuario.REGULAR);
		biblioteca.registrarUsuario(usuarioActual);
		Usuarios usuarioActual2 = new Usuarios(3, "Juan", "juan@gmail", 0, TipoUsuario.REGULAR);
		biblioteca.registrarUsuario(usuarioActual2);
		Usuarios usuarioActual3 = new UsuarioPremium(4, "Sandro", "juan@gmail", 0, TipoUsuario.PREMIUM);
		biblioteca.registrarUsuario(usuarioActual3);
		biblioteca.agregarRecurso(new AudioLibro(10, "Prueba1", 2024, "Terror", "disponible", 10, 20, "Ingles"));
		biblioteca.agregarRecurso(new AudioLibro(20, "Sangre1", 2024, "Terror", "disponible", 10, 20, "Ingles"));
		biblioteca.agregarRecurso(new AudioLibro(30, "Prueba2", 2024, "Terror", "disponible", 10, 20, "Ingles"));
		biblioteca.agregarRecurso(new AudioLibro(40, "Sangre2", 2024, "Terror", "disponible", 10, 20, "Ingles"));
		biblioteca.agregarRecurso(new AudioLibro(50, "Prueba3", 2024, "Terror", "disponible", 10, 20, "Ingles"));
		biblioteca.agregarRecurso(new AudioLibro(60, "Sangre3", 2024, "Terror", "disponible", 10, 20, "Ingles"));
		
		boolean salir = false;
		
		while (!salir) {
			System.out.println("\n-------Sistema Biblioteca Digital----------");
			System.out.println("-------------Menu Principal--------------");
			System.out.println("1- Menu Administrador");
			System.out.println("2- menu Usuario");
			System.out.println("3- salir");
			
			int opcion = scanner.nextInt();
			scanner.nextLine();
			
			
			switch (opcion) {
			case 1:
				if (admin.getIdUsuario() == 1) {
					Administrador.menuAdministrador(biblioteca, scanner);					
				}else {
					System.err.println("No es Administrador");
				}
				break;
			case 2:
				
				System.out.println("Ingreso su ID de Usuario: ");
				int idUsuarioActual = scanner.nextInt();
				
				usuarioActual = biblioteca.buscarUsuario(idUsuarioActual);
				
				if (usuarioActual != null) {
					Usuarios.menuUsuario(prestamo, biblioteca, usuarioActual, scanner);					
				}else {
					System.err.println("El Usuario no existe o no se cargo por el administrador");
				}
				

				
				break;
			case 3:
				System.out.println("Saliendo........");
				salir = true;
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
			
			
		}
		
		
		
	}

	

}
