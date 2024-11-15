
public class UsuarioPremium extends Usuarios {

	public UsuarioPremium(int idUsuario, String nombre, String email) {
		super(idUsuario, nombre, email, Integer.MAX_VALUE);
	}

	
	public boolean puedeRealizarPrestamo() {
		return true;
	}
	
}
