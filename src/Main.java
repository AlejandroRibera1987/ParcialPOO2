import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		BibliotecaDigital biblioteca = new BibliotecaDigital();
		
		while(true) {
			System.out.println("------------Bienvenido a la Biblioteca Digital--------------");
			System.out.println("1- Gestionar Recursos");
			System.out.println("2- Gestionar Usuarios");
			System.out.println("3- Sistema de prestamos");
			System.out.println("4- Generar reporte");
			System.out.println("5- Salir");
			int option = scanner.nextInt();
			
			switch (option) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				System.out.println("Saliendo .....");
				return;

			default:
				System.out.println("Opcion no Valida");
				break;
			}
		}
		
		
		
	}
}
