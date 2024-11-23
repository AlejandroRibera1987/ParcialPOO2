
public class RevistaDigital extends RecursoMultimedia {
	
	private int numeroEdicion;
	private int periodicidad;
	private int ISSN;
	private int articulos;

	public RevistaDigital(int idRecurso, String titulo, String autor, int añoPublicacion, String genero, String estado,
			double calificacion, int numeroEdicion, int periodicidad, int iSSN, int articulos) {
		super(idRecurso, titulo, autor, añoPublicacion, genero, estado, calificacion);
		this.numeroEdicion = numeroEdicion;
		this.periodicidad = periodicidad;
		ISSN = iSSN;
		this.articulos = articulos;
	}


	@Override
	public String toString() {
		return "RevistaDigital [ID= " + idRecurso + " Titulo= " + titulo + " Autor= " + autor + " Genero= " + genero + " numeroEdicion= " + numeroEdicion + ", periodicidad= " + periodicidad + ", ISSN= " + ISSN
				+ ", articulos= " + articulos + "]";
	}
	
	
	
	
	

	
}
