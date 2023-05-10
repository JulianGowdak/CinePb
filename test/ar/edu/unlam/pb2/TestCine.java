package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class TestCine {

	@Test
    public void testAgregarSala2D() {
        Cine cine = new Cine("Cinepolis");

        SalaCine sala1 = new SalaCine2d(1, 100);
        cine.agregarSala(sala1);

        SalaCine sala2 = new SalaCine2d(2, 50);
        cine.agregarSala(sala2);

        assertEquals(2, cine.getSalas().size());
        assertTrue(cine.getSalas().contains(sala1));
        assertTrue(cine.getSalas().contains(sala2));
    }
	
	@Test
    public void testNoSePuedeAgregarSalasConElMismoNumero() {
        Cine cine = new Cine("Cinepolis");

        SalaCine sala1 = new SalaCine2d(1, 100);
        cine.agregarSala(sala1);

        SalaCine sala2 = new SalaCine2d(1, 50);
        cine.agregarSala(sala2);

        assertEquals(1, cine.getSalas().size());
      
    }
	
	 @Test
	    public void testAgregarClienteASala2d() {
	        Cine cine = new Cine("Cinepolis");

	        SalaCine sala1 = new SalaCine2d(1, 100);
	        cine.agregarSala(sala1);
	        
	        Cliente pedro=new Cliente(111111111L, 22,"pedro","apellido");
	       
	        Boolean seAgrego=sala1.agregarCliente(pedro);
			assertTrue(seAgrego);
	        
	    }
	 
	 @Test
	    public void testAgregarClienteASala3d() {
	        Cine cine = new Cine("Cinepolis");

	        SalaCine sala1 = new SalaCine3d(1, 100);
	        cine.agregarSala(sala1);
	        
	        Cliente pedro=new Cliente(111111111L, 22,"pedro","apellido");
	       
	        Boolean seAgrego=sala1.agregarCliente(pedro);
			assertTrue(seAgrego);
	        
	    }
	 
	 @Test
	 public void testBuscarSalasPorCapacidad() {
	     
	     SalaCine sala1 = new SalaCine2d(1, 100);
	     SalaCine sala2 = new SalaCine3d(2, 200);
	     SalaCine sala3 = new SalaCine2d(3, 300);

	     
	     HashSet<SalaCine> listaSalas = new HashSet<>();
	     listaSalas.add(sala1);
	     listaSalas.add(sala2);
	     listaSalas.add(sala3);

	     
	     Cine cine = new Cine("Cineplex", listaSalas);

	     
	     HashSet<SalaCine> resultado = cine.buscarSalasPorCapacidad(200);

	     
	     assertTrue(resultado.contains(sala2));
	     assertTrue(resultado.contains(sala3));

	     
	     assertFalse(resultado.contains(sala1));

	     
	     assertEquals(2, resultado.size());
	 }
	 
	 @Test
	 public void testBuscarPeliculasPorGeneroEnSala2D() {
	     
	     SalaCine sala1 = new SalaCine2d(1, 100);
	     
	     Pelicula pelicula1 = new Pelicula("El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"),"2d");
	     Pelicula pelicula2 = new Pelicula("El Padrino", "Terror", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"),"2d");
	     Pelicula pelicula3 = new Pelicula("El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"),"2d");
	     
	     sala1.agregarPelicula(pelicula1);
	     sala1.agregarPelicula(pelicula2);
	     sala1.agregarPelicula(pelicula3);

	     
	     HashSet<SalaCine> listaSalas = new HashSet<>();
	     listaSalas.add(sala1);
	     
	     
	     Cine cine = new Cine("Cineplex", listaSalas);
	     
	     
	     ArrayList<Pelicula> resultado = cine.buscarPeliculasPorGenero("Drama");
	     
	    
	     assertEquals(2, resultado.size());
	     
	 }
}
