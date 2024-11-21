import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prestamos {

	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private int renovacionesPermitidas;
	private Estado estado;
	private RecursoMultimedia recurso;
	private Usuarios usuario;
	private List<Usuarios> reservas;
	
	public Prestamos(LocalDate fechaInicio, LocalDate fechaFin, int renovacionesPermitidas, 
					RecursoMultimedia recurso, Usuarios usuario) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.renovacionesPermitidas = 5;
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

	public int getRenovacionesPermitidas() {
		return renovacionesPermitidas;
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

	public RecursoMultimedia getRecurso() {
		return recurso;
	}

	public Usuarios getUsuario() {
		return usuario;
	}
	
	public Prestamos buscarPrestamoActivo(int idRecurso) {
	    for (Prestamos prestamo : usuario.historialPrestamos) {
	        if (prestamo.getRecurso() != null && 
	            prestamo.getRecurso().getId() == idRecurso && 
	            prestamo.getEstado().obtenerEstado().equals("activo")) {
	            return prestamo;
	        }
	    }
	    return null; // No se encontró préstamo activo
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
		
		usuario.getHistorialPrestamos().add(nuevoPrestamo);
		recurso.getEstado().cambiarEstado(recurso);
		usuario.incrementarPrestamos();
		
		biblioteca.getPrestamos().add(nuevoPrestamo);
		
		System.out.println("Se realizo con exito el Prestamo del recurso: " + recurso.getTitulo());
		
		return true;
	}
	
	public void mostrarPrestamosActivos(Usuarios usuario) {
	    if (usuario.historialPrestamos == null || usuario.historialPrestamos.isEmpty()) {
	        System.out.println("No tiene préstamos activos.");
	        return;
	    }

	    System.out.println("Préstamos Activos:");
	    for (Prestamos prestamo : usuario.historialPrestamos) {
	        if (prestamo.getEstado() != null && prestamo.getEstado().obtenerEstado().equals("activo")) {
	            System.out.println("ID Recurso: " + prestamo.getRecurso().getId() + 
	                               " - Título: " + prestamo.getRecurso().getTitulo() + 
	                               " - Estado: " + prestamo.getEstado().obtenerEstado());
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
	
	public boolean renovarPrestamo(LocalDate nuevaFechaFin) {
	    if (nuevaFechaFin.isBefore(fechaInicio)) {
	        System.out.println("La fecha final no puede ser anterior a la fecha de inicio.");
	        return false;
	    }

	    if (renovacionesPermitidas > 0) {
	        fechaFin = nuevaFechaFin;
	        renovacionesPermitidas--;
	        System.out.println("Se realizó la renovación del préstamo con éxito.");
	        return true;
	    } else {
	        System.out.println("No puedes renovar más veces.");
	        return false;
	    }
			
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
	
	public void hacerReservas(Usuarios usuario) {
		if (recurso.getEstado().obtenerEstado().equals("disponible")) {
			recurso.reservar(usuario);
		}else if(recurso.getEstado().obtenerEstado().equals("reservado")) {
			reservas.add(usuario);
			System.out.println("Se realizo la reserva del Recurso con exito");
		}else {
			System.err.println("No esta disponible para la reserva");
		}
	}

	
	
}
