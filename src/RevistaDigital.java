import java.util.ArrayList;
import java.util.List;

public class RevistaDigital extends RecursoMultimedia {
	
	private int numeroEdicion;
	private int periodicidad;
	private int ISSN;
	private List<String> articulos;
	
	
	public RevistaDigital(int idRecurso, String titulo, int añoPublicacion, String genero, String estado,
			double calificacion, int numeroEdicion, int periodicidad, int iSSN) {
		super(idRecurso, titulo, añoPublicacion, genero, estado, calificacion);
		this.numeroEdicion = numeroEdicion;
		this.periodicidad = periodicidad;
		ISSN = iSSN;
		this.articulos = new ArrayList<>();
	}
	
	
	public void agregarArticulo(String articulo) {
		articulos.add(articulo);
	}
	
	

	
}
