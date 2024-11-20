
public class EstaFinalizado implements Estado {


	public void cambiarEstado(Prestamos prestamo) {
		System.out.println("El prestamo finalizo");
		
	}


	public void cambiarEstado(RecursoMultimedia recurso) {
		System.out.println("No se puede cambiar el estado");		
	}

	
	public String obtenerEstado() {
		return "finalizado";
	}

}
