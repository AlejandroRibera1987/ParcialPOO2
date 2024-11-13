import java.sql.Date;

public class Prestamos {

	private Date fechaInicio;
	private Date fechaFin;
	private int renovacionesPermitidas;
	private String estado;
	private RecursoMultimedia recurso;
	private Usuarios usuario;
	
	public Prestamos(Date fechaInicio, Date fechaFin, int renovacionesPermitidas, String estado,
			RecursoMultimedia recurso, Usuarios usuario) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.renovacionesPermitidas = renovacionesPermitidas;
		this.estado = "activo";
		this.recurso = recurso;
		this.usuario = usuario;
	}
	
	public void renovarPrestamo() {
		if(renovacionesPermitidas > 0) {
			
			
			renovacionesPermitidas --;
		}
	}
	
}
