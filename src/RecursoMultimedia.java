import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecursoMultimedia {
	public int idRecurso;
	public String titulo;
	public String autor;
	public int añoPublicacion;
	public String genero;
	public String estado;
	public double calificacion;
	private List<String> reseñas;
	
	public RecursoMultimedia(int idRecurso, String titulo, String autor, int añoPublicacion, String genero,
			String estado, double calificacion) {
		super();
		this.idRecurso = idRecurso;
		this.titulo = titulo;
		this.autor = autor;
		this.añoPublicacion = añoPublicacion;
		this.genero = genero;
		this.estado = "disponible";
		this.calificacion = 0.0;
		this.reseñas = new ArrayList<>();
	}
	
	public String getGenero() {
		return genero;
	}
	
	public String getAutor() {
		return autor;
	}

	public int getAñoPublicacion() {
		return añoPublicacion;
	}

	public double getCalificacion() {
		return calificacion;
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
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAñoPublicacion(int añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void agregarResaña(String reseña, double calificacion) {
		reseñas.add(reseña);
		actualizarCalificacion(calificacion);
	}
	
	public void actualizarCalificacion(double nuevaCalificacion) {
		calificacion = (calificacion * reseñas.size() + nuevaCalificacion) / (reseñas.size() + 1);
	}

	
	
}
