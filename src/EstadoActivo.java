
public class EstadoActivo implements Estado {


	public void cambiarEstado(Prestamos prestamo) {
		prestamo.setEstado(new EstaFinalizado());
		System.out.println("El prestamo a finalizado");		
	}


	public void cambiarEstado(RecursoMultimedia recurso) {
		recurso.setEstado(new EstadoDisponible());
		System.out.println("El recurso esta Disponible");
	}


	public String obtenerEstado() {
		return "activo";
	}
	
}
