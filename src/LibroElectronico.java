
public class LibroElectronico extends RecursoMultimedia {
	
	private int numeroPaginas;
	private String formato;
	private double tamañoArchivo;
	private int ISBN;
	
	public LibroElectronico(int idRecurso, String titulo, int añoPublicacion, String genero, String estado,
			double calificacion, int numeroPaginas, String formato, double tamañoArchivo, int iSBN) {
		super(idRecurso, titulo, añoPublicacion, genero, estado, calificacion);
		this.numeroPaginas = numeroPaginas;
		this.formato = formato;
		this.tamañoArchivo = tamañoArchivo;
		ISBN = iSBN;
	}
	
	
	
	
}
