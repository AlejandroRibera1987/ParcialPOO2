import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		BibliotecaDigital biblioteca = new BibliotecaDigital();
		Scanner scanner = new Scanner(System.in);
		
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
				Administrador.menuAdministrador(biblioteca, scanner);
				break;
			case 2:
				System.out.println("menu Usuario");
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
