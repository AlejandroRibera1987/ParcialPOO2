import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prestamos {

	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Estado estado;
	private RecursoMultimedia recurso;
	private Usuarios usuario;
	private List<Usuarios> reservas;
	
	public Prestamos(LocalDate fechaInicio, LocalDate fechaFin, int renovacionesPermitidas, 
					RecursoMultimedia recurso, Usuarios usuario) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaInicio.plusDays(5);
		this.estado = new EstadoActivo();
		this.recurso = recurso;
		this.usuario = usuario;
		this.reservas = new ArrayList<>();		
	}
	
	public Prestamos() {
	
	}
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getRenovacionesPermitidas() {
		return usuario.getTipoUsuario().getRenovacionesPermitidas();
	}
	
	public void setRenovacionesPermitidas(int renovacionesPermitidas) {
		renovacionesPermitidas = getRenovacionesPermitidas() - 1;
	}

	public Estado getEstado() {
		return estado;
	}

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
	
	public void setRecurso(RecursoMultimedia recurso) {
		this.recurso = recurso;
	}

	public List<Usuarios> getReservas() {
		return reservas;
	}

	public RecursoMultimedia getRecurso() {
		return recurso;
	}

	public Usuarios getUsuario() {
		return usuario;
	}
	

	
	public boolean realizarPrestamo(Usuarios usuario, RecursoMultimedia recurso, BibliotecaDigital biblioteca) {
		if (!usuario.puedeRealizarPrestamos()) {
			System.err.println("No es posible realizar prestamo, Limite Alcanzado");
			return false;
		}
		
		if (!recurso.getEstado().obtenerEstado().equals("disponible")) {
			System.err.println("El recurso no esta disponible");
			return false;
		}
		
		LocalDate fechaInicio = LocalDate.now();
		LocalDate fechaFin = fechaInicio.plusDays(5);
		int renovaciones = usuario.getRenovacionesPermitidas();
		Prestamos nuevoPrestamo = new Prestamos(fechaInicio, fechaFin, renovaciones, recurso, usuario);
		
		if (reservas != null && reservas.contains(usuario)) {
			reservas.remove(usuario);
		}
		
		usuario.getHistorialPrestamos().add(nuevoPrestamo);
		recurso.getEstado().cambiarEstado(recurso);
		usuario.incrementarPrestamos();
		
		biblioteca.getPrestamos().add(nuevoPrestamo);
		
		System.out.println("Se realizo con exito el Prestamo del recurso: " + recurso.getTitulo());
		
		return true;
	}
	
	public void mostrarPrestamosActivos(Usuarios usuario) {
	    if (usuario.historialPrestamos == null || usuario.historialPrestamos.isEmpty()) {
	        System.out.println("No tiene prestamos activos");
	        return;
	    }

	    System.out.println("Prestamos activos:");
	    for (Prestamos prestamo : usuario.historialPrestamos) {
	        if (prestamo.getEstado() != null && prestamo.getEstado().obtenerEstado().equals("activo")) {
	            System.out.println("ID Recurso: " + prestamo.getRecurso().getId() + 
	                               "\n - Titulo: " + prestamo.getRecurso().getTitulo() + 
	                               "\n - Estado: " + prestamo.getEstado().obtenerEstado() +
	                               "\n - Fecha de Inicio: " + prestamo.getFechaInicio() + 
	                               "\n - fecha de Finalizacion: " + prestamo.getFechaFin() +
	                               "\n-------------------------------------------");
	        }
	    }
	}
	
	public Prestamos prestamoActivoUsuario(Usuarios usuario, int idRecurso) {
		for (Prestamos prestamo : usuario.getHistorialPrestamos()) {
			if (prestamo.getRecurso().getId() == idRecurso && prestamo.getEstado().obtenerEstado().equals("activo")) {
				return prestamo;
			}
		}
		return null;
	}
	
	public boolean renovarPrestamo(LocalDate nuevaFechaFin, BibliotecaDigital biblioteca, Usuarios usuario) {
		
		LocalDate fechaInicio = null;
		
		for (Prestamos prestamo : biblioteca.getPrestamos()) {
			
			if (prestamo.getUsuario().equals(usuario)) {
				fechaInicio = prestamo.getFechaInicio();
				
				if (nuevaFechaFin.isBefore(fechaInicio)) {
					System.out.println("La fecha final no puede ser anterior a la fecha de inicio");
					return false;
				}
			    if (usuario.getRenovacionesPermitidas() > 0) {
			        prestamo.setFechaFin(nuevaFechaFin);
			        prestamo.setRenovacionesPermitidas(prestamo.getRenovacionesPermitidas() - 1);
			        System.out.println("Se realizo la renovación del prestamo con exito");
			        return true;
			    } else {
			        System.out.println("No puedes renovar mas veces");
			        return false;
			    }
				
			}
			
		}
		
		System.out.println("No se encontro un prestamo con este usuario");
		return false;
			
	}
	
	public boolean devolverPrestamo(Usuarios usuario, BibliotecaDigital biblioteca) {
		if (estado.obtenerEstado().equals("finalizado")) {
			System.out.println("El Recurso ya se devolvio");
			return false;
		}
		
		if (!recurso.getEstado().obtenerEstado().equals("prestado")) {
			System.err.println("El recurso que intenta devolver no fue prestado");
			return false;
		}
		
		estado.cambiarEstado(this);
		recurso.getEstado().cambiarEstado(recurso);;
		usuario.reducirPrestamos();
		
		System.out.println("La devolucion fue exitosa");
		
		return true;
	}
	

	public boolean estaVencido() {
		return LocalDate.now().isAfter(fechaFin);
	}
	
	public boolean hacerReservas(Usuarios usuario, int idRecurso, BibliotecaDigital biblioteca) {
		
		RecursoMultimedia recursoAReservar = biblioteca.buscarRecurso(idRecurso);
		
		if (recursoAReservar == null) {
			System.err.println("El recurso no se encontro");
			return false;
		}
		
		 this.recurso = recursoAReservar;
		
		if (recurso.getEstado().obtenerEstado().equals("disponible")) {
			System.out.println("El recurso esta disponible, se puede prestar");
		}
		
		if (recurso.getEstado().obtenerEstado().equals("reservado")) {
			
			if (reservas.contains(usuario)) {
				System.out.println("Ya tenes una reserva de este recurso");				
				return false;
			}

		}
		
		reservas = new ArrayList<>();
		
		if (recurso.getEstado().obtenerEstado().equals("prestado")) {
			System.err.println("El recurso ya esta prestado");
			reservas.add(usuario);
			System.out.println("Se realizo la reserva con exito");
			return true;
		}
		System.err.println("No se pudo realizar la reserva");
		return false;
				
	}
	
	public void mostrarReservasActivos(Usuarios usuario) {
		System.out.println("Reservas del usuario: " + usuario.getNombre());
		
		if (reservas == null || reservas.isEmpty()) {
			System.out.println("No tiene reservcas activas");
			return;
		}
		
		for (Usuarios reserva : reservas) {
			if (reserva.equals(usuario)) {
				System.out.println("Recurso reservado: " + recurso.getTitulo() +
									"\nEstado: " + recurso.getEstado().obtenerEstado());
			}
		}
	}

	public boolean agregarFavoritos(Usuarios usuario, int idRecurso, BibliotecaDigital biblioteca) {
		
		RecursoMultimedia recursoFavorito = biblioteca.buscarRecurso(idRecurso);
		
		if (recursoFavorito == null) {
			System.err.println("El recurso no se encontro");
			return false;
		}
		
		if (usuario.getFavoritos().contains(recursoFavorito)) {
			System.err.println("El recurso ya esta en la lista de favoritos");
			return false;
		}
		
		usuario.getFavoritos().add(recursoFavorito);
		System.out.println("El recurso: " + recursoFavorito.getTitulo() + " se agrego con exito");
		
		return true;
			
		
	}
	
	
	public void mostrarFavoritos(Usuarios usuario) {
		System.out.println("Favoritos de " + usuario.getNombre());
		
		for (RecursoMultimedia recurso : usuario.getFavoritos()) {
			System.out.println("ID: " + recurso.getId() +
								"\nTitulo: " + recurso.getTitulo() +
								"\nAutor: " + recurso.getAutor() +
								"\nAño de publicacion: " + recurso.getAñoPublicacion() +
								"\n-----------------------------------------------------");
		}
	}
}
