import java.util.ArrayList;
import java.util.List;

public class Usuarios {
	
	private String nombre;
	private String email;
	private List<Prestamos> historialPrestamos;
	private List<RecursoMultimedia> favoritos;
	private int limitePrestamosSimultaneos;
	
	public Usuarios(String nombre, String email, int limitePrestamosSimultaneos) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.historialPrestamos = new ArrayList<>();
		this.favoritos = new ArrayList<>();
		this.limitePrestamosSimultaneos = limitePrestamosSimultaneos;
	}
	
	
	public void agregarFavorito(RecursoMultimedia recurso) {
		favoritos.add(recurso);
	}
	
	public boolean puedeRealizarPrestamo() {
		return historialPrestamos.size() < limitePrestamosSimultaneos;
	}
	
	
}
