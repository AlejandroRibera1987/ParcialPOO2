
public class EstadoDisponible implements Estado {

	
	public void cambiarEstado(Prestamos prestamo) {
		System.out.println("no aplica al recurso");
	}

	
	public void cambiarEstado(RecursoMultimedia recurso) {
		recurso.setEstado(new EstadoPrestado());
		System.out.println("El recurso esta prestado");
	}

	
	public String obtenerEstado() {
		return "disponible";
	}

}
