import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Usuarios {
	
	protected int idUsuario;
	protected String nombre;
	protected String email;
	protected List<Prestamos> historialPrestamos;
	protected List<RecursoMultimedia> favoritos;
	protected int limitePrestamosSimultaneos;
	protected int prestamosActivos;
	
	public Usuarios(int idUsuario, String nombre, String email, int limitePrestamosSimultaneos, int prestamosActivos) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.email = email;
		this.historialPrestamos = new ArrayList<>();
		this.favoritos = new ArrayList<>();
		this.limitePrestamosSimultaneos = 5;
		this.prestamosActivos = 0;
	}
	
	public Usuarios(int idUsuario, String nombre, String email) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.email = email;
	}
	
	
	public int getPrestamosActivos() {
		return prestamosActivos;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public List<Prestamos> getHistorialPrestamos() {
		return historialPrestamos;
	}

	public List<RecursoMultimedia> getFavoritos() {
		return favoritos;
	}
	
	public int getRenovacionesPermitidas() {
		return 3;
	}
	
	public int getLimitePrestamosSimultaneos() {
		return limitePrestamosSimultaneos;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean puedeRealizarPrestamos() {
		return prestamosActivos < limitePrestamosSimultaneos;
	}
	
	public void incrementarPrestamos() {
		prestamosActivos ++;
	}
	
	public void reducirPrestamos() {
		if (prestamosActivos > 0) {
			prestamosActivos --;
		}
	}
	
	public void agregarFavorito(RecursoMultimedia recurso) {
		favoritos.add(recurso);
	}
	

	@Override
	public String toString() {
		return "Usuario Regular [idUsuario= " + idUsuario + " Nombre= " + nombre + " Email= " + email + " ]";
	}

	
	
	public static void menuUsuario(Prestamos prestamo, BibliotecaDigital biblioteca, Usuarios usuario, Scanner scanner) {
		boolean salir = false;
		
		
		
		while(!salir) {
			System.out.println("\n-------------Menu Usuario------------");
			System.out.println("1- Listar recursos");
			System.out.println("2- Realizar prestamo");
			System.out.println("3- Realizar devoluciones");
			System.out.println("4- Realizar renovaciones");
			System.out.println("5- control de reservas");
			System.out.println("6- Salir");
			
			int opcion = scanner.nextInt();
			
			switch (opcion) {
			case 1:
            	System.out.println("\n-----------Lista de Recursos Cargados------------");
                if (biblioteca.getCatalogo().isEmpty()) {
					System.out.println("No hay Recursos cargados");
				}else {
					for (RecursoMultimedia recurso : biblioteca.getCatalogo()) {
						System.out.println(recurso.toString());
					}
				}
				break;
			case 2:
				System.out.println("Ingrese el ID del recurso que quiere");
				int idRecurso = scanner.nextInt();
				
				RecursoMultimedia recurso = biblioteca.buscarRecurso(idRecurso);
				
				if (recurso == null) {
					System.err.println("Recurso no encontrado");
					return;
				}
				
				if (!usuario.puedeRealizarPrestamos()) {
					System.err.println("No puede realizar un retiro");
					return;
				}
				
				if (!recurso.getEstado().equalsIgnoreCase("disponible")) {
					System.err.println("El recurso no esta disponible");
					return;
				}
				
				Prestamos nuevoPrestamo = new Prestamos();
				boolean prestamoCorrecto = nuevoPrestamo.realizarPrestamo(usuario, recurso, biblioteca);
				
				if (prestamoCorrecto) {
					usuario.historialPrestamos.add(nuevoPrestamo);
					usuario.incrementarPrestamos();
				}
				
				break;
			case 6:
				System.out.println("Saliendo......");
				salir = true;
				break;
			default:
				break;
			}
		}
		
	}
	
	
}
