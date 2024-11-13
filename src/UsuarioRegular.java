public class UsuarioRegular extends Usuarios {
	private int limitePrestamos;

	public UsuarioRegular(int idUsuario, String nombre, String email, int limitePrestamos) {
		super(idUsuario, nombre, email);
		this.limitePrestamos = limitePrestamos;
	}

	public int getLimitePrestamos() {
		return limitePrestamos;
	}

	public void setLimitePrestamos(int limitePrestamos) {
		this.limitePrestamos = limitePrestamos;
	}
	
	
	
}
