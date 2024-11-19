import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Usuarios {
	
	protected int idUsuario;
	protected String nombre;
	protected String email;
	private List<Prestamos> historialPrestamos;
	private List<RecursoMultimedia> favoritos;
	private int limitePrestamosSimultaneos;
	
	public Usuarios(int idUsuario, String nombre, String email, int limitePrestamosSimultaneos) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.email = email;
		this.historialPrestamos = new ArrayList<>();
		this.favoritos = new ArrayList<>();
		this.limitePrestamosSimultaneos = limitePrestamosSimultaneos;
	}
	
	
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public List<Prestamos> getHistorialPrestamos() {
		return historialPrestamos;
	}

	public List<RecursoMultimedia> getFavoritos() {
		return favoritos;
	}

	public int getLimitePrestamosSimultaneos() {
		return limitePrestamosSimultaneos;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public void agregarFavorito(RecursoMultimedia recurso) {
		favoritos.add(recurso);
	}
	
	public boolean puedeRealizarPrestamo() {
		return historialPrestamos.size() < limitePrestamosSimultaneos;
	}



	@Override
	public String toString() {
		return "Usuario Regular [idUsuario= " + idUsuario + " Nombre= " + nombre + " Email= " + email + " ]";
	}






	
	
}
