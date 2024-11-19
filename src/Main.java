import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		BibliotecaDigital biblioteca = new BibliotecaDigital();
		Prestamos prestamo = new Prestamos();
		Scanner scanner = new Scanner(System.in);
		Administrador admin = new Administrador(1, "Alejandro", "Alejandr@gmail.com");
		Usuarios usuario = new Usuarios();
	
		
		boolean salir = false;
		
		while (!salir) {
			System.out.println("\n-------Sistema Biblioteca Digital----------");
			System.out.println("--------------Menu Principal------------");
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
				
				Usuarios.menuUsuario(prestamo, biblioteca, usuario, scanner);

				
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
