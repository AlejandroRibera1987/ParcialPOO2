
public class UsuarioPremium extends Usuarios {



	
	public UsuarioPremium(int idUsuario, String nombre, String email, int prestamosActivos, TipoUsuario tipoUsuario) {
		super(idUsuario, nombre, email, prestamosActivos, tipoUsuario);
	}
	

	@Override
	public String toString() {
		return "Usuario Premium [idUsuario= " + idUsuario + " Nombre= " + nombre + " Email= " + email + " ]";
	}
	
	
}
