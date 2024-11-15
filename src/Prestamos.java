import java.time.LocalDate;

public class Prestamos {

	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private int renovacionesPermitidas;
	private String estado;
	private RecursoMultimedia recurso;
	private Usuarios usuario;
	
	public Prestamos(LocalDate fechaInicio, LocalDate fechaFin, int renovacionesPermitidas, String estado,
			RecursoMultimedia recurso, Usuarios usuario) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.renovacionesPermitidas = renovacionesPermitidas;
		this.estado = "activo";
		this.recurso = recurso;
		this.usuario = usuario;
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

	public String getEstado() {
		return estado;
	}

	public RecursoMultimedia getRecurso() {
		return recurso;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void cambiarEstado(String nuevoEstado) {
		this.estado = nuevoEstado;
	}	
	
	public void renovarPrestamo(LocalDate nuevaFechaFin) {
		
		if(nuevaFechaFin.isBefore(fechaInicio)) {
			System.out.println("La fecha final no puede ser anterior a la fecha de inicio");
			return;
		}
		
		if(renovacionesPermitidas > 0) {
			this.fechaFin = nuevaFechaFin;
			renovacionesPermitidas --;
		}else{
			System.out.println("No puedes renovar mas veces");
		}
	}
	
	public boolean estaVencido() {
		return LocalDate.now().isAfter(fechaFin);
	}
	
	public void devolverRecurso() {
		if (estado.equalsIgnoreCase("activo") || estado.equalsIgnoreCase("renovado")) {
			cambiarEstado("finalizado");
			recurso.setEstado("disponible");
			
		}
	}
	
	
}
