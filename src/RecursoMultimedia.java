import java.util.ArrayList;
import java.util.List;

public class RecursoMultimedia {
	private int idRecurso;
	private String titulo;
	private List<String> autor;
	private int añoPublicacion;
	private String genero;
	private String estado;
	private double calificacion;
	private List<String> reseñas;
	
	public RecursoMultimedia(int idRecurso, String titulo, int añoPublicacion, String genero,
			String estado, double calificacion) {
		super();
		this.idRecurso = idRecurso;
		this.titulo = titulo;
		this.autor = new ArrayList<>();
		this.añoPublicacion = añoPublicacion;
		this.genero = genero;
		this.estado = "disponible";
		this.calificacion = 0.0;
		this.reseñas = new ArrayList<>();
	}
	
	public int getId() {
		return idRecurso;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getEstado () {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void actualizarCalificacion(double nuevaCalificacion) {
		calificacion = (calificacion * reseñas.size() + nuevaCalificacion) / (reseñas.size() + 1);
	}

	public void agregarResaña(String reseña, double calificacion) {
		reseñas.add(reseña);
		actualizarCalificacion(calificacion);
	}

	
	
	
}
