import java.util.ArrayList;
import java.util.List;

public class Usuarios {
	private int idUsuario;
	private String nombre;
	private String email;
	private List<Prestamos> historialPrestamo;
	private List<RecursoMultimedia> favoritos;
	
	public Usuarios(int idUsuario, String nombre, String email) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.email = email;
		this.historialPrestamo = new ArrayList<>();
		this.favoritos = new ArrayList<>();
	}
	
	
	
	
}
