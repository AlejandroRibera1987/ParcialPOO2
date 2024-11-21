import java.time.LocalDate;
import java.util.ArrayList;
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
	protected TipoUsuario tipoUsuario;
	
	public Usuarios(int idUsuario, String nombre, String email, int limitePrestamosSimultaneos, int prestamosActivos, TipoUsuario tipoUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.email = email;
		this.historialPrestamos = new ArrayList<>();
		this.favoritos = new ArrayList<>();
		this.limitePrestamosSimultaneos = limitePrestamosSimultaneos;
		this.prestamosActivos = prestamosActivos;
		this.tipoUsuario = tipoUsuario;
	}
	
	
	public Usuarios(int idUsuario, String nombre, String email, int prestamosActivos, TipoUsuario tipoUsuario) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.email = email;
		this.prestamosActivos = prestamosActivos;
		this.tipoUsuario = tipoUsuario;
	    this.historialPrestamos = new ArrayList<>(); 
	    this.favoritos = new ArrayList<>(); 
	    this.limitePrestamosSimultaneos = 5;
	}
	
	public Usuarios(int idUsuario, String nombre, String email) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.email = email;
	}
	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
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
		return tipoUsuario.getRenovacionesPermitidas();
	}
	
	public boolean getLimitePrestamosSimultaneos() {
		return prestamosActivos < tipoUsuario.getLimitePrestamosSimultaneos();
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean puedeRealizarPrestamos() {
		return prestamosActivos < tipoUsuario.getLimitePrestamosSimultaneos();
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
			System.out.println("\n-----------Menu Usuario--------------");
			System.out.println("---------Bienvenido " + usuario.getNombre() + "------------");
			System.out.println("1- Listar recursos");
			System.out.println("2- Realizar prestamo");
			System.out.println("3- Ver prestamos");
			System.out.println("4- Realizar Devolucion");
			System.out.println("5- Ver renovaciones permitidas");
			System.out.println("6- Ver prestamos activos y renovaciones restantes");
			System.out.println("8- Renovar prestamo");
			System.out.println("9- Reservar recurso");
			System.out.println("10- Ver reservas");
			System.out.println("11- Salir");
			
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
					break;
				}
				
				
				if (!recurso.getEstado().obtenerEstado().equals("disponible")) {
					System.err.println("El recurso no esta disponible");
					break;
				}
				
				Prestamos nuevoPrestamo = new Prestamos();
				boolean prestamoCorrecto = nuevoPrestamo.realizarPrestamo(usuario, recurso, biblioteca);
				
				if (prestamoCorrecto) {
					usuario.historialPrestamos.add(nuevoPrestamo);
				}
				
				break;
			case 3:
				
				prestamo.mostrarPrestamosActivos(usuario);
								
				break;
			case 4:
				System.out.println("ingreso ID del recurso que desea devolver");
				int idRecursoDevolucion = scanner.nextInt();
				
				RecursoMultimedia recursoADevolver = biblioteca.buscarRecurso(idRecursoDevolucion);
				
				if (recursoADevolver == null) {
					System.err.println("Recurso no encontrado");
					break;
				}
				
				if (!recursoADevolver.getEstado().obtenerEstado().equals("prestado")) {
					System.err.println("El recurso no esta Prestado");
					break;
				}
				
				Prestamos prestamoADevolver = null;
				
				for (Prestamos prestamos : usuario.getHistorialPrestamos()) {
					if(prestamos.getRecurso() != null && prestamos.getRecurso().getId() == idRecursoDevolucion && prestamos.getEstado().obtenerEstado().equals("activo")) {
						prestamoADevolver = prestamos;
						break;
					}
				}
				
				if (prestamoADevolver == null) {
					System.err.println("El prestamo no esta activo");
				}
					
					prestamoADevolver.devolverPrestamo(usuario, biblioteca);
					
					break;
			case 5:
				System.out.println("Limite para Prestar " + usuario.tipoUsuario.getLimitePrestamosSimultaneos());
				System.out.println("Limite de renovaciones " + usuario.tipoUsuario.getRenovacionesPermitidas());							
				break;
			case 6:
				System.out.println("Prestamos activos " + usuario.getPrestamosActivos());
				System.out.println("Renovaciones que te quedan " + usuario.getRenovacionesPermitidas());
				break;
			case 8:
				System.out.println("Ingrese el ID del recurso que quiere renovar");
				int idRecursoARenovar = scanner.nextInt();
				
				Prestamos renovacion = prestamo.prestamoActivoUsuario(usuario, idRecursoARenovar);
							
				if (renovacion == null) {
					System.err.println("No se encuentra activo el prestamo");
				}else {
					LocalDate nuevaFecha = null;
					for (Prestamos prestamo1 : biblioteca.getPrestamos()) {
						//System.out.println(prestamo1.getFechaFin());
						nuevaFecha = prestamo1.getFechaFin().plusDays(3);					
					}
					//System.out.println(nuevaFecha);
					prestamo.renovarPrestamo(nuevaFecha, biblioteca, usuario);
				}
				

				break;
			case 9:
				System.out.println("Ingrese el ID del recurso que desea reservar");
				int idRecursoAReservar = scanner.nextInt();
				
				prestamo.hacerReservas(usuario, idRecursoAReservar, biblioteca);
		
				break;
			case 10:
				System.out.println("Menu para ver reservas");
				break;
			case 11:
				System.out.println("Saliendo......");
				salir = true;
				break;
			default:
				break;
			}
		}
		
	}
	
	
}
