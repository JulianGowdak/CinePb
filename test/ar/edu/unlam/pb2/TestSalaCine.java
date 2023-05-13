package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestSalaCine {

	@Test
	public void testCrearSala2d() {
	    SalaCine2d sala = new SalaCine2d(1, 100);
	    assertEquals((Integer)1, sala.getNumero());
	    assertEquals((Integer)100, sala.getCapacidad());
	    assertEquals("2d",sala.getVisualizacion());
	}
	
	@Test
	public void testCrearSala3d() {
	    SalaCine3d sala = new SalaCine3d(1, 100);
	    assertEquals((Integer)1, sala.getNumero());
	    assertEquals((Integer)100, sala.getCapacidad());
	    assertEquals("3d",sala.getVisualizacion());
	}
	
	 @Test
	    public void testAgregarPeliculasASala2D() {

	        Pelicula pelicula1 = new Pelicula("El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"),"2d");
		    Pelicula pelicula2 = new Pelicula("Matrix", "Ciencia Ficción", 136, "Lana Wachowski y Lilly Wachowski", Arrays.asList("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss"),"2d");
	      
	        SalaCine sala1 = new SalaCine2d(1, 100);
	        
	        sala1.agregarPelicula(pelicula1);
	        sala1.agregarPelicula(pelicula2);
	        
	        assertEquals(2, sala1.getPeliculas().size());
	        
	    }
	 
	 @Test
	    public void testAgregarPeliculasASala3D() {

	        Pelicula pelicula1 = new Pelicula("El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"),"3d");
		    Pelicula pelicula2 = new Pelicula("Matrix", "Ciencia Ficción", 136, "Lana Wachowski y Lilly Wachowski", Arrays.asList("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss"),"3d");
	      
	        SalaCine sala1 = new SalaCine3d(1, 100);
	        
	        sala1.agregarPelicula(pelicula1);
	        sala1.agregarPelicula(pelicula2);
	        
	        assertEquals(2, sala1.getPeliculas().size());
	        
	    }
	 
	
	@Test
	public void testAgregarPelicula() {
	    SalaCine sala = new SalaCine2d(1, 100);
	    Pelicula pelicula = new Pelicula("El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"),"2d");
	    assertTrue(sala.agregarPelicula(pelicula));
	}
	
	@Test
	public void testQuitarPelicula() {
	    SalaCine sala = new SalaCine2d(1, 100);
	    Pelicula pelicula = new Pelicula("El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"),"2d");
	    sala.agregarPelicula(pelicula);
	    assertTrue(sala.quitarPelicula(pelicula));
	    assertTrue(sala.getPeliculas().isEmpty());
	}
	
	@Test
	public void testQuitarPeliculaNoExistente() {
	    SalaCine sala = new SalaCine2d(1, 100);
	    Pelicula pelicula1 = new Pelicula("El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"),"2d");
	    Pelicula pelicula2 = new Pelicula("Matrix", "Ciencia Ficción", 136, "Lana Wachowski y Lilly Wachowski", Arrays.asList("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss"),"2d");
	    sala.agregarPelicula(pelicula1);
	    assertFalse(sala.quitarPelicula(pelicula2));
	    assertEquals(1, sala.getPeliculas().size());
	}
	

	@Test
	public void testQuePermiteAgregarUnClienteALaSala3d() {
	    Cliente pedro=new Cliente(111111111L, 22,"pedro","apellido");
		SalaCine3d sala = new SalaCine3d(1, 100);
		Boolean seAgrego=sala.agregarCliente(pedro);
		assertTrue(seAgrego);
	   	}
	
	@Test
	public void testQuePermiteQuitarUnClienteDeLaSala3d() {
	    Cliente pedro=new Cliente(111111111L, 22,"pedro","apellido");
		SalaCine3d sala = new SalaCine3d(1, 100);
		sala.agregarCliente(pedro);
		Boolean seAgrego=sala.quitarCliente(pedro);
		assertTrue(seAgrego);
	   	}
	
	@Test
    public void testQueNoPuedaAgregarClientesCuandoNoHayLugar() {

        SalaCine sala1 = new SalaCine2d(1, 2);
        
        Cliente pedro=new Cliente(111111111L, 22,"pedro","apellido");
        Cliente jose=new Cliente(211111111L, 32,"joseo","apellido");
        Cliente juan=new Cliente(22222222L, 23,"juan","apellido");
        

        sala1.agregarCliente(pedro);
        sala1.agregarCliente(jose);
        sala1.agregarCliente(juan);
        
        assertEquals(2, sala1.getListaDeClientes().size());
    }
	

}
