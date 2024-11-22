
public class LibroElectronico extends RecursoMultimedia {
	
	private int numeroPaginas;
	private String formato;
	private double tamañoArchivo;
	private int ISBN;

	

	public LibroElectronico(int idRecurso, String titulo, String autor, int añoPublicacion, String genero,
			String estado, double calificacion, int numeroPaginas, String formato, double tamañoArchivo, int iSBN) {
		super(idRecurso, titulo, autor, añoPublicacion, genero, estado, calificacion);
		this.numeroPaginas = numeroPaginas;
		this.formato = formato;
		this.tamañoArchivo = tamañoArchivo;
		ISBN = iSBN;
	}



	@Override
	public String toString() {
		return "LibroElectronico\n [ID= " + idRecurso + " Titulo= " + titulo + " Autor= " + autor + " Genero= " + genero + " numeroPaginas= " + numeroPaginas + " formato= " + formato + " tamañoArchivo= "
				+ tamañoArchivo + " ISBN= " + ISBN + " ]";
	}
	
	
	
	
}
