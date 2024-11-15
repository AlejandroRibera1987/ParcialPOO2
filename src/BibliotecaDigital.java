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
	
	
	
	public List<RecursoMultimedia> getCatalogo() {
		return catalogo;
	}

	public List<Usuarios> getUsuarios() {
		return usuarios;
	}

	public List<Prestamos> getPrestamos() {
		return prestamos;
	}

	public void agregarRecurso(RecursoMultimedia recurso) {
		catalogo.add(recurso);
	}
	
	public void registrarUsuario(Usuarios usuario) {
		usuarios.add(usuario);
	}
	
	public void registrarPrestamo(Prestamos prestamo) {
		
		if (prestamo.getRecurso().getEstado().equalsIgnoreCase("disponible")) {
			if(prestamo.getUsuario().puedeRealizarPrestamo()) {
				prestamos.add(prestamo);
				prestamo.getRecurso().setEstado("prestado");					
			}else {
				System.out.println("El usuario ya cumple con el limite de prestamos");
			}
		}else {
			System.out.println("No esta disponible para el prestamo");
		}
	}
	
	public RecursoMultimedia buscarRecurso(int idRecurso) {
		
		for (RecursoMultimedia recurso : catalogo) {
			if (recurso.getId() == idRecurso) {
				return recurso;
			}
		}
		
		return null;
	}
	
	public Usuarios buscarusuario(int idUsuario) {
		
		for (Usuarios usuario : usuarios) {
			if (usuario.getIdUsuario() == idUsuario) {
				return usuario;
			}
		}
		return null;
	}
	
	public boolean eliminarRecurso(int idRecurso) {
		
		for (RecursoMultimedia recurso : catalogo) {
			if (recurso.getId() == idRecurso) {
				catalogo.remove(idRecurso);
				return true;
			}
		}
		return false;
	}
}
