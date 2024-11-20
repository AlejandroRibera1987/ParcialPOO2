
public class EstadoPrestado implements Estado {

	public void cambiarEstado(Prestamos prestamo) {
		System.out.println("Se aplica al recurso");		
	}

	public void cambiarEstado(RecursoMultimedia recurso) {
		recurso.setEstado(new EstadoDisponible());
		System.out.println("El recurso esta Disponible");
	}

	public String obtenerEstado() {
		return "prestado";
	}

}
