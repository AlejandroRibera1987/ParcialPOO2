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
		this.estado = estado;
		this.calificacion = calificacion;
		this.reseñas = new ArrayList<>();
	}
	
	public void agregarResaña(String reseña) {
		reseñas.add(reseña);
	}

	
	
	
}
