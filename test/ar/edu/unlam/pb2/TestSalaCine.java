package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import org.junit.Test;

public class TestSalaCine {

	@Test
	public void testCrearSala2d() {
	    SalaCine2d sala = new SalaCine2d(1, 100);
	    assertEquals((Integer)1, sala.getNumero());
	    assertEquals((Integer)100, sala.getCapacidad());
	    
	}
	
	@Test
	public void testCrearSala3d() {
	    SalaCine3d sala = new SalaCine3d(1, 100);
	    assertEquals((Integer)1, sala.getNumero());
	    assertEquals((Integer)100, sala.getCapacidad());
	    
	}
	
	@Test
	public void testQueVerifiqueElFuncionamientoDeAgregarFuncionDelMetodoSala2D() {
	
		Integer idFuncion1=1;
		LocalDate fecha1=LocalDate.of(2023, 06, 9);
		LocalTime horaInicio1=LocalTime.of(15, 30);
		TipoDeIdioma idioma=TipoDeIdioma.INGLES;
		TipoDeVisualizacion visualizacion=TipoDeVisualizacion.VISUALIZACION_2D;	
		
		SalaCine2d sala1 = new SalaCine2d(1, 100);
	    Pelicula pelicula = new Pelicula(1,"El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));
	    FuncionDeCine nuevaFuncion=new FuncionDeCine(idFuncion1, fecha1, horaInicio1, idioma, pelicula, visualizacion);
	    
	    Boolean seAgrego=sala1.ingresarFuncionASalasDeCine(nuevaFuncion);
	    
	    assertTrue(seAgrego);
	}
	
	@Test
	public void testQueVerifiqueElFuncionamientoDeAgregarFuncionDelMetodoSala3D() {
	
		Integer idFuncion1=1;
		LocalDate fecha1=LocalDate.of(2023, 06, 9);
		LocalTime horaInicio1=LocalTime.of(15, 30);
		TipoDeIdioma idioma=TipoDeIdioma.ESPAÑOL;
		TipoDeVisualizacion visualizacion=TipoDeVisualizacion.VISUALIZACION_3D;	
		
		SalaCine3d sala1 = new SalaCine3d(1, 100);
	    Pelicula pelicula = new Pelicula(1,"El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"));
	    FuncionDeCine nuevaFuncion=new FuncionDeCine(idFuncion1, fecha1, horaInicio1, idioma, pelicula, visualizacion);
	    
	    Boolean seAgrego=sala1.ingresarFuncionASalasDeCine(nuevaFuncion);
	    
	    assertTrue(seAgrego);
	}
	
	@Test
    public void testQueNoPuedaAgregarClientesCuandoNoHayLugar() {

        SalaCine2d sala1 = new SalaCine2d(1, 2);
        
        Cliente pedro=new Cliente(111111111L, 22,"pedro","apellido");
        Cliente jose=new Cliente(211111111L, 32,"joseo","apellido");
        Cliente juan=new Cliente(22222222L, 23,"juan","apellido");
        

        sala1.agregarCliente(pedro);
        sala1.agregarCliente(jose);
        sala1.agregarCliente(juan);
        
        assertEquals(2, sala1.getListaDeClientes().size());
    }
	

}
