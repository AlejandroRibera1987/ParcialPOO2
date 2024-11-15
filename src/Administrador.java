
public class Administrador extends Usuarios {

	public Administrador(int idUsuario, String nombre, String email) {
		super(idUsuario, nombre, email, Integer.MAX_VALUE);
	}
	
	public void gestionarRecursos(String accion, BibliotecaDigital biblioteca, RecursoMultimedia recurso) {
		switch (accion.toLowerCase()) {
		case "agregar":
			biblioteca.agregarRecurso(recurso);
			System.out.println("Se Agrego Correctamente");
			break;
		
		case "eliminar":
			if (biblioteca.eliminarRecurso(recurso.getId())) {
				System.out.println("Se elimino correctamente");
			}else {
				System.err.println("Recurso no Encontrado");
			}
			break;

		default:
			System.err.println("Opcion Incorrecta, agregar o eliminar");
			break;
		}
	}
	
	public void generarReportes(BibliotecaDigital biblioteca) {
			
			boolean hayPrestamosActivos = false;
			
			System.out.println("Reporte de Prestamos");
			
			for (Prestamos prestamo : biblioteca.getPrestamos()) {
				if(prestamo.getEstado().equalsIgnoreCase("activo")) {
					hayPrestamosActivos = true;
					System.out.println("Recurso: " + prestamo.getRecurso().getTitulo());
					System.out.println("Nombre de Usuario: " + prestamo.getUsuario().getNombre());
					System.out.println("Fecha de Inicio: " + prestamo.getFechaInicio());
					System.out.println("Fecha Finalizacion: " + prestamo.getFechaFin());
					System.out.println("------------------------------");
				}
			}
			
	        if (!hayPrestamosActivos) {
	            System.out.println("No hay prestamos Activos");
	        }
			
	}
	
}
