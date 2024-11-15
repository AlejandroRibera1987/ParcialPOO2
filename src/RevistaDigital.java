
public class RevistaDigital extends RecursoMultimedia {
	
	private int numeroEdicion;
	private int periodicidad;
	private int ISSN;
	private int articulos;
	
	
	public RevistaDigital(int idRecurso, String titulo, int añoPublicacion, String genero, String estado,
			double calificacion, int numeroEdicion, int periodicidad, int iSSN, int articulos) {
		super(idRecurso, titulo, añoPublicacion, genero, estado, calificacion);
		this.numeroEdicion = numeroEdicion;
		this.periodicidad = periodicidad;
		ISSN = iSSN;
		this.articulos = articulos;
	}


	public int getNumeroEdicion() {
		return numeroEdicion;
	}


	public int getPeriodicidad() {
		return periodicidad;
	}


	public int getISSN() {
		return ISSN;
	}


	public int getArticulos() {
		return articulos;
	}
	
	

	
	

	
}
