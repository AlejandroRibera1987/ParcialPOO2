
public class UsuarioPremium extends Usuarios {



	
	public UsuarioPremium(int idUsuario, String nombre, String email, int prestamosActivos, TipoUsuario tipoUsuario) {
		super(idUsuario, nombre, email, prestamosActivos, tipoUsuario);
	}
	

	public boolean puedeRealizarPrestamo() {
		return true;
	}
	
	public int getRenovacionesPermitidas() {
		return Integer.MAX_VALUE;
	}
	
	@Override
	public String toString() {
		return "Usuario Premium [idUsuario= " + idUsuario + " Nombre= " + nombre + " Email= " + email + " ]";
	}
	
	
}
