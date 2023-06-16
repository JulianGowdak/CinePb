package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class TestCine {

	@Test
    public void testQuePermiteAgregarUnaSalaDeTipo2DAUnCine() {
        String nombre="Cinepolis";
        
        Integer numero=1; 
        Integer capacidad=100;
        Integer cantidadDeSalasEsperada=1;
        
		Cine cine = new Cine(nombre);

        SalaCine2d sala2D = new SalaCine2d(numero, capacidad);
        Boolean seAgrego=cine.agregarSala(sala2D);

        assertEquals(cantidadDeSalasEsperada,cine.cantidadDeSalasAgregadas());
        assertTrue(seAgrego);
       
    }
	
	@Test
    public void testNoSePuedeAgregarSalasConElMismoNumero() {
        Cine cine = new Cine("Cinepolis");

        SalaCine2d sala1 = new SalaCine2d(1, 100);
        cine.agregarSala(sala1);

        SalaCine2d sala2 = new SalaCine2d(1, 50);
        Boolean seAgrego=cine.agregarSala(sala2);

        assertEquals(1, cine.getSalas().size());
        assertFalse(seAgrego);
      
    }
	
	
	 @Test
	 public void testBuscarSalasPorCapacidad() {
		 Integer idPelicula=1;
		 Integer idPelicula1=2;

	     SalaCine2d sala1 = new SalaCine2d(1, 300);
	     SalaCine3d sala2 = new SalaCine3d(2, 200);
	     SalaCine2d sala3 = new SalaCine2d(3, 300);
   
	     HashSet<SalaCine> listaSalas = new HashSet<>();
	     listaSalas.add(sala1);
	     listaSalas.add(sala2);
	     listaSalas.add(sala3);
	     
	     Pelicula pelicula1 = new Pelicula(idPelicula,"El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));
	     Pelicula pelicula2 = new Pelicula(idPelicula1,"El Padrino", "Terror", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));
	      
	     ArrayList<Pelicula>listaPeliculas = new ArrayList<>();
	     listaPeliculas.add(pelicula1);
	     listaPeliculas.add(pelicula2);
   
	     Cine cine = new Cine("Cineplex", listaSalas,listaPeliculas);
	     
	     HashSet<SalaCine> resultado = cine.buscarSalasPorCapacidad(300);
  
	     assertTrue(resultado.contains(sala1));
	     assertTrue(resultado.contains(sala3));
	     assertFalse(resultado.contains(sala2));
	     assertEquals(2, resultado.size());
	     
	 }
	 
	 @Test
	 public void testBuscarPeliculasPorGeneroEnSala2D() {
		 Integer idPelicula=1;
		 Integer idPelicula1=2;
		 
	     SalaCine2d sala1 = new SalaCine2d(1, 100);
	     
	     Pelicula pelicula1 = new Pelicula(idPelicula,"El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));
	     Pelicula pelicula2 = new Pelicula(idPelicula1,"El Padrino", "Terror", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));
	     Pelicula pelicula3 = new Pelicula(idPelicula,"El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));
	     
	     HashSet<SalaCine> listaSalas = new HashSet<>();
	     listaSalas.add(sala1);
	     
	     ArrayList<Pelicula>listaPeliculas = new ArrayList<>();
	     listaPeliculas.add(pelicula1);
	     listaPeliculas.add(pelicula2);
	     listaPeliculas.add(pelicula3);

	     Cine cine = new Cine("Cineplex", listaSalas,listaPeliculas);
	     
	     ArrayList<Pelicula> resultado = cine.buscarPeliculasPorGenero("Drama");
	     
	     assertEquals(2, resultado.size());
	     
	 }
	 
	@Test   
	public void testQuePermiteEliminarUnaSalaDelCineCuandoLaSalaNoTengaUnCliente() {
	    String nombre="Cinepolis";
			 
		Integer numero=1; 
		Integer capacidad=100;
		        
		Cine cine = new Cine(nombre);

		SalaCine2d sala1 = new SalaCine2d(numero, capacidad);
	    cine.agregarSala(sala1);
	    Boolean seElimino=cine.eliminarUnaSala(sala1);
	    Integer cantidadDeSalasEsperada=0;
	        
	    assertTrue(seElimino);
	    assertEquals(cantidadDeSalasEsperada,cine.cantidadDeSalasAgregadas());
	      
	}
	
	@Test
    public void testQueNoPermiteEliminarUnaSalaDelCineCuandoTengaUnCliente() {
		 String nombre="Cinepolis";
		 
	     Integer numero=1; 
	     Integer capacidad=100;
	     
	     Long dni=111111111L;
	     Integer edad=31;
	     String nombreCliente="facundo";
	     String apellido="Benitez";
	        
		 Cine cine = new Cine(nombre);
	     SalaCine sala1 = new SalaCine2d(numero, capacidad);
	     cine.agregarSala(sala1);
	     Cliente facundo=new Cliente(dni, edad,nombreCliente,apellido);
	     sala1.agregarCliente(facundo);
         Boolean seElimino=cine.eliminarUnaSala(sala1); 
         Integer cantidadDeSalasEsperada=1;
        
	     assertFalse(seElimino);
         assertEquals(cantidadDeSalasEsperada,cine.cantidadDeSalasAgregadas());
      
    }
	
	@Test
    public void testQueVerificaQueNoPuedoEliminarUnaSalaDeCineQueNoExiste() {
		 String nombre="Cinepolis";
		 
	     Integer numero=1; 
	     Integer capacidad=100;
	     Integer numeroNuevaSala=4; 
	     Integer capacidadNuevaSala=200;
	        
		 Cine cine = new Cine(nombre);
	     SalaCine2d sala1 = new SalaCine2d(numero, capacidad);
	     SalaCine2d sala3 = new SalaCine2d(numeroNuevaSala, capacidadNuevaSala);
	     cine.agregarSala(sala1);
	     Boolean seElimino=cine.eliminarUnaSala(sala3); 
         Integer cantidadDeSalasEsperada=1;
        
	     assertFalse(seElimino);
         assertEquals(cantidadDeSalasEsperada,cine.cantidadDeSalasAgregadas());
      
    }
	
	@Test
    public void quePermitaAsignarUnaPeliculaAUnaFuncionDesdeUnCine() {
		String nombreCine="Cinepolis";
	     
	    Integer idFuncion=1;
		LocalDate fecha=LocalDate.of(2023, 06, 9);
	    LocalTime horaInicio1=LocalTime.of(15, 30);
		TipoDeIdioma idioma=TipoDeIdioma.ESPAÑOL;
		TipoDeVisualizacion visualizacion=TipoDeVisualizacion.VISUALIZACION_2D;
	    Integer idPelicula=1;
	     
		Cine cine = new Cine(nombreCine);
		
	    Pelicula peliculaInicial =null;    
	    Pelicula peliculaFinal = new Pelicula(idPelicula,"El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));
	       
	    FuncionDeCine nueva=cine.crearFuncionDeCine(idFuncion, fecha, horaInicio1, idioma,peliculaInicial, visualizacion);
	    cine.agregarFuncionesAlCine(nueva);
	    
	    Boolean seAsignaron=cine.asignarUnaPeliculaAUnaFuncionDeCine(idFuncion,peliculaFinal);
	      
	    assertTrue(seAsignaron);
	    assertEquals(peliculaFinal, nueva.getPeliculas());
	       
    }
	
	@Test 
    public void quePermitaAUnCineCrearUnaFuncionYUnaVezCreadaGuardeEsaFuncion() {
		String nombreCine="Cinepolis";
	     
	    Integer idFuncion=1;
		LocalDate fecha=LocalDate.of(2023, 06, 9);
		LocalTime horaInicio1=LocalTime.of(15, 30);
		TipoDeIdioma idioma=TipoDeIdioma.ESPAÑOL;
		TipoDeVisualizacion visualizacion=TipoDeVisualizacion.VISUALIZACION_2D;
	        
		Cine cine = new Cine(nombreCine);
	    Pelicula pelicula = new Pelicula(1,"El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));
	     
	    FuncionDeCine nueva=cine.crearFuncionDeCine(idFuncion, fecha, horaInicio1, idioma, pelicula, visualizacion);
	    Boolean seAgrego=cine.agregarFuncionesAlCine(nueva);
	    Integer cantidadAgregadas=1;
	    
	    assertNotNull(nueva);
	    assertEquals(cantidadAgregadas,cine.cantidadDeFuncionesAgregadas());
	    assertTrue(seAgrego);
	    assertEquals(idFuncion,nueva.getId());
	    assertEquals(fecha,nueva.getFecha());
	     
    }

	@Test 
    public void quePermitaCambiarElHorarioDeUnaFuncion() {
		String nombreCine="Cinepolis";   
	    Integer idFuncion=1;
		LocalDate fecha=LocalDate.of(2023, 06, 9);
		LocalTime horaInicio1=LocalTime.of(15, 30);
		TipoDeIdioma idioma=TipoDeIdioma.ESPAÑOL;
		TipoDeVisualizacion visualizacion=TipoDeVisualizacion.VISUALIZACION_2D;
	        
		Cine cine = new Cine(nombreCine);
	    Pelicula pelicula = new Pelicula(1,"El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));    
	    FuncionDeCine nueva=cine.crearFuncionDeCine(idFuncion, fecha, horaInicio1, idioma, pelicula, visualizacion);
	    cine.agregarFuncionesAlCine(nueva);
	     
	    LocalTime horaNueva=LocalTime.of(17, 30);
	    Boolean seCambioHora=cine.cambiarHorarioDeUnaFuncion(idFuncion, horaNueva);
	     
	    assertTrue(seCambioHora);
	    assertEquals(horaNueva,nueva.getHoraInicio());
	        
    }
	
	@Test
    public void BuscarFuncionDeCineDelDia() {
		String nombreCine="Cinepolis"; 
	    Integer idFuncion1=1;
	    Integer idFuncion2=2;
	    Integer idFuncion3=3;
		LocalDate fecha1=LocalDate.of(2023, 06, 9);
		LocalDate fecha2=LocalDate.of(2023, 06, 12);
		LocalTime horaInicio1=LocalTime.of(15, 30);
		LocalTime horaInicio2=LocalTime.of(18, 40);
		LocalTime horaInicio3=LocalTime.of(15, 30);
		TipoDeIdioma idioma=TipoDeIdioma.ESPAÑOL;
		TipoDeVisualizacion visualizacion=TipoDeVisualizacion.VISUALIZACION_2D;
	        
		Cine cine = new Cine(nombreCine);
	    Pelicula pelicula = new Pelicula(1,"El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));
	    FuncionDeCine nueva1=cine.crearFuncionDeCine(idFuncion1, fecha1, horaInicio1, idioma, pelicula, visualizacion);
	    FuncionDeCine nueva2=cine.crearFuncionDeCine(idFuncion2, fecha1, horaInicio2, idioma, pelicula, visualizacion);
	    FuncionDeCine nueva3=cine.crearFuncionDeCine(idFuncion3, fecha2, horaInicio3, idioma, pelicula, visualizacion);
	     
	    cine.agregarFuncionesAlCine(nueva1);
	    cine.agregarFuncionesAlCine(nueva2);
	    cine.agregarFuncionesAlCine(nueva3);
	     
	    HashSet<FuncionDeCine> resultado = cine.buscarfuncionesDelDia(fecha1);
	     
	    assertEquals(2, resultado.size());
	     
    }
	
	@Test
    public void quePermitaAgregarUnaFuncionDeCineAUnaSala2D() {
		 String nombreCine="Cinepolis"; 
	     Integer idFuncion=1;
		 LocalDate fecha=LocalDate.of(2023, 06, 9);
		 LocalTime horaInicio1=LocalTime.of(15, 30);
		 TipoDeIdioma idioma=TipoDeIdioma.ESPAÑOL;
		 TipoDeVisualizacion visualizacion=TipoDeVisualizacion.VISUALIZACION_2D;
		 Integer idPelicula=1;
	     Integer numero=1; 
	     Integer capacidad=100;
	     
		 Cine cine = new Cine(nombreCine);
	     Pelicula peliculaInicial =null;    
	     Pelicula peliculaFinal = new Pelicula(idPelicula,"El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));  
	     SalaCine2d sala = new SalaCine2d(numero, capacidad);
	     
	     FuncionDeCine nueva=cine.crearFuncionDeCine(idFuncion, fecha, horaInicio1, idioma,peliculaInicial, visualizacion);
	     cine.agregarFuncionesAlCine(nueva);
	     cine.asignarUnaPeliculaAUnaFuncionDeCine(idFuncion,peliculaFinal);     
	     Boolean seAgregoASala=cine.agregarFuncionDeCineAUnaSala(sala, nueva);
	     Integer CantidadDeFunciones=1;
	     
	     assertTrue(seAgregoASala); 
	     assertEquals(CantidadDeFunciones, sala.cantidadDeFuncionesAgregadas());
	     
    }
	
	@Test
    public void testquePermitaAgregarUnaFuncionDeCineAUnaSala3d() {

    	 String nombreCine="Cinepolis"; 
	     Integer idFuncion=1;
		 LocalDate fecha=LocalDate.of(2023, 06, 9);
		 LocalTime horaInicio1=LocalTime.of(15, 30);
		 TipoDeIdioma idioma=TipoDeIdioma.ESPAÑOL;
		 TipoDeVisualizacion visualizacion=TipoDeVisualizacion.VISUALIZACION_3D;
		 Integer idPelicula=1;
	     Integer numero=1; 
	     Integer capacidad=100;
	     
		 Cine cine = new Cine(nombreCine);
	     Pelicula peliculaInicial =null;    
	     Pelicula peliculaFinal = new Pelicula(idPelicula,"El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));  
	     SalaCine3d sala = new SalaCine3d(numero, capacidad);   
	     FuncionDeCine nueva=cine.crearFuncionDeCine(idFuncion, fecha, horaInicio1, idioma,peliculaInicial, visualizacion);
	     cine.agregarFuncionesAlCine(nueva);
	     cine.asignarUnaPeliculaAUnaFuncionDeCine(idFuncion,peliculaFinal);     
	    
	     Boolean seAgregoASala=cine.agregarFuncionDeCineAUnaSala(sala, nueva);
	     Integer CantidadDeFunciones=1;
			
	     assertTrue(seAgregoASala); 
	     assertEquals(CantidadDeFunciones, sala.cantidadDeFuncionesAgregadas());
	     assertEquals(visualizacion,nueva.getVisualizacion());
	         
    }
	
	@Test
	public void testQuePermiteAgregarUnClienteALaSala2d() {

    	 String nombreCine="Cinepolis"; 
	     Integer idFuncion=1;
		 LocalDate fecha=LocalDate.of(2023, 06, 9);
		 LocalTime horaInicio1=LocalTime.of(15, 30);
		 TipoDeIdioma idioma=TipoDeIdioma.ESPAÑOL;
		 TipoDeVisualizacion visualizacion=TipoDeVisualizacion.VISUALIZACION_2D;
		 Integer idPelicula=1;
	     Integer numero=1; 
	     Integer capacidad=100;
	     
		 Cine cine = new Cine(nombreCine);
	     Pelicula peliculaInicial =null;    
	     Pelicula peliculaFinal = new Pelicula(idPelicula,"El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));  
	     SalaCine2d sala = new SalaCine2d(numero, capacidad);
	     
	     FuncionDeCine nueva=cine.crearFuncionDeCine(idFuncion, fecha, horaInicio1, idioma,peliculaInicial, visualizacion);
	     cine.agregarFuncionesAlCine(nueva);
	     cine.asignarUnaPeliculaAUnaFuncionDeCine(idFuncion,peliculaFinal);     
	     cine.agregarFuncionDeCineAUnaSala(sala, nueva);
		 
	     Cliente pedro=new Cliente(111111111L, 22,"pedro","apellido");
		 Boolean seAgrego=sala.agregarCliente(pedro);
		
		 assertTrue(seAgrego);
		
		
	 }
	
	@Test
	public void testQuePermiteSacarUnClienteDeUnaSala2d() {
		String nombreCine="Cinepolis";
	    Integer idFuncion=1;
		LocalDate fecha=LocalDate.of(2023, 06, 9);
		LocalTime horaInicio1=LocalTime.of(15, 30);
		TipoDeIdioma idioma=TipoDeIdioma.ESPAÑOL;
		TipoDeVisualizacion visualizacion=TipoDeVisualizacion.VISUALIZACION_2D;
		Integer idPelicula=1;
	    Integer numero=1; 
	    Integer capacidad=100;
	     
		Cine cine = new Cine(nombreCine);
	    Pelicula peliculaInicial =null;    
	    Pelicula peliculaFinal = new Pelicula(idPelicula,"El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));  
	    SalaCine2d sala = new SalaCine2d(numero, capacidad);
	   
	    FuncionDeCine nueva=cine.crearFuncionDeCine(idFuncion, fecha, horaInicio1, idioma,peliculaInicial, visualizacion);
	    cine.agregarFuncionesAlCine(nueva);
	    cine.asignarUnaPeliculaAUnaFuncionDeCine(idFuncion,peliculaFinal);     
	    cine.agregarFuncionDeCineAUnaSala(sala, nueva);  
	    Cliente pedro=new Cliente(111111111L, 22,"pedro","apellido");
		sala.ingresarFuncionASalasDeCine(nueva);
		sala.agregarCliente(pedro);
		
		Boolean seQuito=sala.quitarClienteDeSala(pedro);
		Integer cantidadDeSalasEsperada=0;
		
		assertTrue(seQuito);
		assertEquals(cantidadDeSalasEsperada,sala.cantidadDeClientesAgregados());
	
	 }
	
	@Test 
	public void testQuePermiteAgregarUnClienteAUnaSala3dYPrestarleUnLente3D() {
	
		String nombreCine="Cinepolis"; 
	    Integer idFuncion=1;
		LocalDate fecha=LocalDate.of(2023, 06, 9);
		LocalTime horaInicio1=LocalTime.of(15, 30);
		TipoDeIdioma idioma=TipoDeIdioma.ESPAÑOL;
		TipoDeVisualizacion visualizacion=TipoDeVisualizacion.VISUALIZACION_3D;
		Integer idPelicula=1;
	    Integer numero=1; 
	    Integer capacidad=100;
	     
		Cine cine = new Cine(nombreCine);
	    Pelicula peliculaInicial =null;    
	    Pelicula peliculaFinal = new Pelicula(idPelicula,"El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));  
	    SalaCine3d sala = new SalaCine3d(numero, capacidad);
	    FuncionDeCine nueva=cine.crearFuncionDeCine(idFuncion, fecha, horaInicio1, idioma,peliculaInicial, visualizacion);
	    cine.agregarFuncionesAlCine(nueva);
	    cine.asignarUnaPeliculaAUnaFuncionDeCine(idFuncion,peliculaFinal);     
	    cine.agregarFuncionDeCineAUnaSala(sala, nueva);  
	    
	    Integer idLente=1; 
        Cliente usuario=null;
        Lente3D anteojos3D=new Lente3D(idLente,usuario);
	    Cliente pedro=new Cliente(111111111L, 22,"pedro","apellido");
	
		sala.ingresarFuncionASalasDeCine(nueva);
		sala.agregarLentes3dASala(anteojos3D);
		sala.agregarCliente(pedro);
		
		Boolean sePrestoLente=sala.prestarLente3dACliente(anteojos3D, 111111111L);
		assertTrue(sePrestoLente);
		
	 }
	
	@Test 
	public void testQuePermiteSacarAUnClienteDeUnaSala3dYDevuelvaElLente3DPrestado() {
		
		String nombreCine="Cinepolis";
	     
	    Integer idFuncion=1;
		LocalDate fecha=LocalDate.of(2023, 06, 9);
		LocalTime horaInicio1=LocalTime.of(15, 30);
		TipoDeIdioma idioma=TipoDeIdioma.ESPAÑOL;
		TipoDeVisualizacion visualizacion=TipoDeVisualizacion.VISUALIZACION_3D;
		Integer idPelicula=1;
	    Integer numero=1; 
	    Integer capacidad=100;
	     
		Cine cine = new Cine(nombreCine);
	    Pelicula peliculaInicial =null;    
	    Pelicula peliculaFinal = new Pelicula(idPelicula,"El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));  
	    SalaCine3d sala = new SalaCine3d(numero, capacidad);
	    FuncionDeCine nueva=cine.crearFuncionDeCine(idFuncion, fecha, horaInicio1, idioma,peliculaInicial, visualizacion);
	    cine.agregarFuncionesAlCine(nueva);
	    cine.asignarUnaPeliculaAUnaFuncionDeCine(idFuncion,peliculaFinal);     
	    cine.agregarFuncionDeCineAUnaSala(sala, nueva);  
	    
	    Integer idLente=1; 
        Cliente usuario=null;
        Lente3D anteojos3D=new Lente3D(idLente,usuario);
	    Cliente pedro=new Cliente(111111111L, 22,"pedro","apellido");
	
		sala.ingresarFuncionASalasDeCine(nueva);
		sala.agregarLentes3dASala(anteojos3D);
		sala.agregarCliente(pedro);
		sala.prestarLente3dACliente(anteojos3D, 111111111L);
		
		Boolean seDevolvioLente=sala.DevolverLentes3D(anteojos3D);
		Boolean seQuito=sala.quitarClienteSala3D(pedro,seDevolvioLente);
		
		assertTrue(seDevolvioLente);
		assertTrue(seQuito);
		
	 }
	
	@Test
	public void testQueNoPermiteSacarAUnClienteDeUnaSala3dSinoDevuelveElLentePrestado() {
		
		String nombreCine="Cinepolis";  
	    Integer idFuncion=1;
		LocalDate fecha=LocalDate.of(2023, 06, 9);
		LocalTime horaInicio1=LocalTime.of(15, 30);
		TipoDeIdioma idioma=TipoDeIdioma.ESPAÑOL;
		TipoDeVisualizacion visualizacion=TipoDeVisualizacion.VISUALIZACION_3D;
		Integer idPelicula=1;
	    Integer numero=1; 
	    Integer capacidad=100;
	     
		Cine cine = new Cine(nombreCine);
	    Pelicula peliculaInicial =null;    
	    Pelicula peliculaFinal = new Pelicula(idPelicula,"El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));  
	    SalaCine3d sala = new SalaCine3d(numero, capacidad);
	    FuncionDeCine nueva=cine.crearFuncionDeCine(idFuncion, fecha, horaInicio1, idioma,peliculaInicial, visualizacion);
	    cine.agregarFuncionesAlCine(nueva);
	    cine.asignarUnaPeliculaAUnaFuncionDeCine(idFuncion,peliculaFinal);     
	    cine.agregarFuncionDeCineAUnaSala(sala, nueva);  
	    
	    Integer idLente=1; 
        Cliente usuario=null;
        Lente3D anteojos3D=new Lente3D(idLente,usuario);
	    Cliente pedro=new Cliente(111111111L, 22,"pedro","apellido");
	
		sala.ingresarFuncionASalasDeCine(nueva);
		sala.agregarLentes3dASala(anteojos3D);
		sala.agregarCliente(pedro);
		sala.prestarLente3dACliente(anteojos3D, 111111111L);
	
		Boolean seDevolvio=sala.DevolverLentes3D(null);
		Boolean seQuito=sala.quitarClienteSala3D(pedro,seDevolvio);
		
		assertFalse(seQuito);
		
	 }


	
}
