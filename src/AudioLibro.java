
public class AudioLibro extends RecursoMultimedia {

	private double duracionTotal;
	private String idioma;
	


	public AudioLibro(int idRecurso, String titulo, String autor, int añoPublicacion, String genero, String estado,
			double calificacion, double duracionTotal, String idioma) {
		super(idRecurso, titulo, autor, añoPublicacion, genero, estado, calificacion);
		this.duracionTotal = duracionTotal;
		this.idioma = idioma;
	}



	@Override
	public String toString() {
		return "AudioLibro [ID= " + idRecurso + " Titulo= " + titulo + " Autor= " + autor + " Genero= " + genero + " duracionTotal= " + duracionTotal + " idioma= " + idioma + "]";
	}
	

	
}
