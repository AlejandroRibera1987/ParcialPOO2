import java.util.List;
import java.util.Scanner;

public class Administrador extends Usuarios {


	
	
	 public Administrador(int idUsuario, String nombre, String email) {
		super(idUsuario, nombre, email);
		
	}

	public static void menuAdministrador(BibliotecaDigital biblioteca, Scanner sccanner) {
	        boolean salir = false;
	        Scanner scanner = new Scanner(System.in);

	        while (!salir) {
	            System.out.println("\n------------Menú de Administrador------------");
	            System.out.println("1- Agregar Recurso");
	            System.out.println("2- Modificar Recurso");
	            System.out.println("3- Eliminar Recurso");
	            System.out.println("4- Listar Recursos");
	            System.out.println("5- Listar Usuarios");
	            System.out.println("6- Registrar Usuario");
	            System.out.println("7- Modificar Usuario");
	            System.out.println("8- Cambiar Plan de Usuario");
	            System.out.println("9- Buscar recurso por Genero");
	            System.out.println("10- Buscar recurso por Autor");
	            System.out.println("11- Generar Reporte Prestamos");
	            System.out.println("12- Volver al Menú Principal");
	            System.out.print("Seleccione una opción: ");
	            
				int opcion = scanner.nextInt();
	            scanner.nextLine(); 

	            switch (opcion) {
	                case 1:
	                    System.out.println("\nSeleccione el tipo de Recurso");
	                    System.out.println("1- Audio Libro");
	                    System.out.println("2- Libro Electronico");
	                    System.out.println("3- Revista Digital");
	                    System.out.println("4- Volver");
	                    int tipo = scanner.nextInt();
	                    scanner.nextLine();
	                    
	                    if (tipo == 4) {
	                    	System.out.println("Volviendo.......");
							opcion = 1;
							break;
						}
	                    
	                    System.out.println("ID: ");
	                    int id = scanner.nextInt();
	                    scanner.nextLine();
	                    System.out.println("Autor: ");
	                    String autor = scanner.nextLine();
	                    System.out.println("Titulo: ");
	                    String titulo = scanner.nextLine();
	                    System.out.println("Año de publicacion: ");
	                    int año = scanner.nextInt();
	                    scanner.nextLine();
	                    System.out.println("Genero: ");
	                    String genero = scanner.nextLine();
	                    
	                    
	                    if (tipo == 1) {
							System.out.println("Duracion total: ");
							double duracion = scanner.nextDouble();
							scanner.nextLine();
							System.out.println("Idioma: ");
							String idioma = scanner.nextLine();
							
							biblioteca.agregarRecurso(new AudioLibro(id, titulo, autor, año, genero, "disponible", 0.0, duracion, idioma));
						}else if (tipo == 2) {
					        System.out.print("Numero de paginas: ");
					        int paginas = scanner.nextInt();
					        scanner.nextLine();
					        System.out.print("Formato: ");
					        String formato = scanner.nextLine();
					        System.out.print("Tamaño del archivo: ");
					        double tamaño = scanner.nextDouble();
					        scanner.nextLine();
					        System.out.print("ISBN: ");
					        int isbn = scanner.nextInt();
					        biblioteca.agregarRecurso(new LibroElectronico(id, titulo, autor, año, genero, "disponible", 0.0, paginas, formato, tamaño, isbn));
						}else if(tipo == 3) {
					        System.out.print("Numero de ediciin: ");
					        int edicion = scanner.nextInt();
					        System.out.print("Periodicidad: ");
					        int periodicidad = scanner.nextInt();
					        System.out.print("ISSN: ");
					        int issn = scanner.nextInt();
					        System.out.print("Cantidad de articulos: ");
					        int articulos = scanner.nextInt();
					        biblioteca.agregarRecurso(new RevistaDigital(id, titulo, autor, año, genero, "disponible", 0.0, edicion, periodicidad, issn, articulos));						
						}else{
							System.err.println("Opcion no valida");
						}
	                                       
	                    break;
	                case 2:
	                	System.out.println("Ingrese el ID del recurso que quiere modificar: ");
	                	int idModificar = scanner.nextInt();
	                	scanner.nextLine();
	                	System.out.println("Nuevo Titulo: ");
	                    String nuevoTitulo = scanner.nextLine();
	                    System.out.println("nuevo Genero: ");
	                    String nuevoGenero = scanner.nextLine();
	                    System.out.println("Nuevo año de publicacion: ");
	                    int nuevoAño = scanner.nextInt();
	                    biblioteca.modificarRecurso(idModificar, nuevoTitulo, nuevoGenero, nuevoAño);
	                    break;
	                case 3:                  
	                    System.out.println("Ingrese el ID del recurso a eliminar:");
	                    int idEliminar = scanner.nextInt();
	                    biblioteca.eliminarRecurso(idEliminar);
	                    break;
	                case 4:
	                	
	                	System.out.println("\n-----------Lista de Recursos Cargados------------");
	                    if (biblioteca.getCatalogo().isEmpty()) {
							System.out.println("No hay Recursos cargados");
						}else {
							for (RecursoMultimedia recurso : biblioteca.getCatalogo()) {
								System.out.println(recurso.toString());
							}
						}
	                   
	                    break;
	                case 5:
	                	
	                	System.out.println("\n---------------Lista de Usuarios Cargados---------------");
	                    if(biblioteca.getUsuarios().isEmpty()) {
	                    	System.out.println("No hay Usuarios cargados");
	                    }else {
	                    	for (Usuarios usuario  : biblioteca.getUsuarios()) {
								System.out.println(usuario.toString());
							}
	                    }
	                  
	                    break;
	                case 6:
	                	System.out.println("ID del usuario: ");
	                	int idUsuario = scanner.nextInt();
	                	scanner.nextLine();
	                	System.out.println("Nombre de usuario: ");
	                    String nombreUsuario = scanner.nextLine();
	                    System.out.println("Mail de usuario: ");
	                    String mailUsuario = scanner.nextLine();
	                    System.out.println("Es usuario Premium? true/false");
	                    boolean esPremium = scanner.nextBoolean();
	                    
	                    if (esPremium) {
							biblioteca.registrarUsuario(new UsuarioPremium(idUsuario, nombreUsuario, mailUsuario, 0, TipoUsuario.PREMIUM));
						}else {
							biblioteca.registrarUsuario(new Usuarios(idUsuario, nombreUsuario, mailUsuario, 0, TipoUsuario.REGULAR));
						}
	                    break;
	                case 7:
	                  
	                    System.out.println("Ingrese el Id del usuario a modificar: ");
	                    int idModificarUsuario = scanner.nextInt();
	                    scanner.nextLine();
	                    System.out.println("Nuevo nombre: ");
	                    String nuevoNombreUsuario = scanner.nextLine();
	                    System.out.println("Nuevo Mail: ");
	                    String nuevoMailUsuario = scanner.nextLine();
	                    
	                    biblioteca.modificarUsuario(idModificarUsuario, nuevoNombreUsuario, nuevoMailUsuario);
	                   
	                    break;
	                case 8:
	                  
	                    System.out.println("Ingrese el ID del Usuario: ");
	                    int idCambioUsuario = scanner.nextInt();
	                    System.out.println("Cambiar el usuario a Premium? True/False");
	                    boolean nuevoPlanPremium = scanner.nextBoolean();
	                    
	                    biblioteca.cambiarPlan(idCambioUsuario, nuevoPlanPremium);
	                    break;
	                    
	                case 9:
	                	
	                	System.out.println("Ingrese el genero a buscar: ");
	                	String buscarGenero = scanner.nextLine();
	                	
	                	List<RecursoMultimedia> recursosGenero = biblioteca.buscarPorGenero(buscarGenero);
	                	System.out.println("Resultado de la Busqueda: \n");
	                	if (!recursosGenero.isEmpty()) {
							for (RecursoMultimedia recurso : recursosGenero) {
								System.out.println(recurso);
							}
						}else {
							System.err.println("No se encontro el genero Buscado");
						}
	                	
	                	
	                	break;
	                case 10:
	                	
	                	System.out.println("Ingrese el nombre del autor: ");
	                	String buscarAutor = scanner.nextLine();
	                	
	                	List<RecursoMultimedia> recursosAutor = biblioteca.buscarPorAutor(buscarAutor);
	                	System.out.println("Resultado de la Busqueda: \n");
	                	if (!recursosAutor.isEmpty()) {
							for (RecursoMultimedia recurso : recursosAutor) {
								System.out.println(recurso);
							}
						}else {
							System.out.println("No se encontro el Autor buscado");
						}
	                	
	                	
	                	break;
	                	
	                case 11:
	                	
	        			boolean hayPrestamosActivos = false;
	        			
	        			System.out.println("-------------Reporte de Prestamos----------------");
	        			
	        			for (Prestamos prestamo : biblioteca.getPrestamos()) {
	        				if(prestamo.getEstado().obtenerEstado().equals("activo")) {
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
	                	
	                	break;
	                case 12:
	                    System.out.println("Volviendo al Menú Principal...");
	                    salir = true;
	                    break;
	                default:
	                    System.out.println("Opción no válida. Intente de nuevo.");
	            }
	        }
	    }
	
}

