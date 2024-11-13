import java.util.ArrayList;
import java.util.List;

public class BibliotecaDigital {

	private List<RecursoMultimedia> catalogo;
	private List<Usuarios> usuarios;
	private List<Prestamos> prestamos;
	
	public BibliotecaDigital() {
		this.catalogo = new ArrayList<>();
		this.usuarios = new ArrayList<>();
		this.prestamos = new ArrayList<>();
	}
	
	public void agregarRecurso(RecursoMultimedia recurso) {
		catalogo.add(recurso);
	}
	
	public void registrarUsuario(Usuarios usuario) {
		usuarios.add(usuario);
	}
	
	
	
}
