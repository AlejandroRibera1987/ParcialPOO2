
public class RecursoMultimedia {
	public int idRecurso;
	public String titulo;
	public String autor;
	public int añoPublicacion;
	public String genero;
	public Estado estado;
	public double calificacion;
	
	public RecursoMultimedia(int idRecurso, String titulo, String autor, int añoPublicacion, String genero,
			String estado, double calificacion) {
		super();
		this.idRecurso = idRecurso;
		this.titulo = titulo;
		this.autor = autor;
		this.añoPublicacion = añoPublicacion;
		this.genero = genero;
		this.estado = new EstadoDisponible();
		this.calificacion = 0.0;
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
	
	public Estado getEstado () {
		return estado;
	}
	
	public void setEstado(Estado estado) {
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



	
	
}
