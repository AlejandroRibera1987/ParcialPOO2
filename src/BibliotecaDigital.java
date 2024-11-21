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
		System.out.println("Recurso agregado Correctamente");
	}
	
	public void registrarUsuario(Usuarios usuario) {
		usuarios.add(usuario);
		System.out.println("Se registro Correctamente el Usuario");
	}
	
	public RecursoMultimedia buscarRecurso(int idRecurso) {
		
		for (RecursoMultimedia recurso : catalogo) {
			if (recurso.getId() == idRecurso) {
				return recurso;
			}
		}
		
		return null;
	}
	
	public Usuarios buscarUsuario(int idUsuario) {
		
		for (Usuarios usuario : usuarios) {
			if (usuario.getIdUsuario() == idUsuario) {
				return usuario;
			}
		}
		return null;
	}
	
	public List<RecursoMultimedia> buscarPorGenero(String genero){
		List<RecursoMultimedia> resultados = new ArrayList<>();
		
		for (RecursoMultimedia recurso : catalogo) {
			if (recurso.getGenero().equalsIgnoreCase(genero)) {
				resultados.add(recurso);
			}
		}
		
		return resultados;
	}
	
	public List<RecursoMultimedia> buscarPorAutor(String autor){
	    List<RecursoMultimedia> resultados = new ArrayList<>();
	    
	    for (RecursoMultimedia recurso : catalogo) { 
	        if (recurso.getAutor().equalsIgnoreCase(autor)) {
	            resultados.add(recurso);
	        }
	    }
	    
	    return resultados;
	}
	
	
	public boolean eliminarRecurso(int idRecurso) {
		
		for (int i = 0; i < catalogo.size(); i++) {
			if (catalogo.get(i).getId() == idRecurso) {
				catalogo.remove(i);
				System.out.println("Se elimino correctamente el recurso");
				return true;
			}
		}
		System.err.println("No se encontro el recurso");
		return false;
	}
	
	public void modificarRecurso(int idRecurso, String nuevoTitulo, String nuevoGenero, int nuevoAño) {
		RecursoMultimedia recurso = buscarRecurso(idRecurso);
		if (recurso != null) {
			recurso.setTitulo(nuevoTitulo);
			recurso.setGenero(nuevoGenero);
			recurso.setAñoPublicacion(nuevoAño);
			System.out.println("Se modifico el recurso Correctamente");
		}else {
			System.err.println("No se encontro el recurso");
		}
	}
	
	public void modificarUsuario(int idUsuario, String nuevoNombre, String nuevoMail) {
		Usuarios usuario = buscarUsuario(idUsuario);
		if (usuario != null) {
			usuario.setNombre(nuevoNombre);
			usuario.setEmail(nuevoMail);
			System.out.println("Se modifico el usuario Correctamente");
		}else {
			System.err.println("No se encontro el usuario");
		}
	}

	
	public void cambiarPlan(int idUsuario, boolean esPremium) {
		Usuarios usuario = buscarUsuario(idUsuario);
		
		if (usuario != null) {
			Usuarios nuevoUsuario;
			if (esPremium) {
				nuevoUsuario = new UsuarioPremium(usuario.getIdUsuario(), usuario.getNombre(), usuario.getEmail(), usuario.getPrestamosActivos(), TipoUsuario.PREMIUM);
			}else {
				nuevoUsuario = new Usuarios(usuario.getIdUsuario(), usuario.getNombre(), usuario.getEmail(), usuario.getPrestamosActivos(), TipoUsuario.REGULAR);
			}
			
			if (nuevoUsuario.historialPrestamos == null) {
				nuevoUsuario.historialPrestamos = new ArrayList<>();
			}
			if (nuevoUsuario.historialPrestamos != null) {
				nuevoUsuario.historialPrestamos.addAll(usuario.getHistorialPrestamos());				
			}
			if (nuevoUsuario.favoritos == null) {
				nuevoUsuario.favoritos = new ArrayList<>();
			}
			if (nuevoUsuario.favoritos != null) {
				nuevoUsuario.favoritos.addAll(usuario.getFavoritos());				
			}
			
			usuarios.remove(usuario);
			usuarios.add(nuevoUsuario);
			System.out.println("El Plan se Cambio Correctamente");
		}else {
			System.err.println("No se encontro el usuario");
		}
		
	}
	


}
