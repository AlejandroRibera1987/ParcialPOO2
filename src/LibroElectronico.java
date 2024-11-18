
public class LibroElectronico extends RecursoMultimedia {
	
	private int numeroPaginas;
	private String formato;
	private double tamañoArchivo;
	private int ISBN;
	
	public LibroElectronico(int idRecurso, String titulo, int añoPublicacion, String genero, String estado,
			double calificacion, int numeroPaginas, String formato, double tamañoArchivo, int ISBN) {
		super(idRecurso, titulo, formato, añoPublicacion, genero, estado, calificacion);
		this.numeroPaginas = numeroPaginas;
		this.formato = formato;
		this.tamañoArchivo = tamañoArchivo;
		this.ISBN = ISBN;
	}

	@Override
	public String toString() {
		return "LibroElectronico [numeroPaginas= " + numeroPaginas + ", formato= " + formato + ", tamañoArchivo= "
				+ tamañoArchivo + ", ISBN= " + ISBN + "]";
	}
	
	
	
	
}
