package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestPelicula {

	 @Test
	 public void testGetTitulo() {
	        Pelicula pelicula = new Pelicula("El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"),"2d");
	        String titulo = pelicula.getTitulo();
	        assertEquals("El Padrino", titulo);
	    }
	 
	 @Test
	 public void testAgregarActor() {
	     Pelicula pelicula = new Pelicula("El Padrino", "Drama", 175, "Francis Ford Coppola", new ArrayList<>(),"2d");
	     pelicula.agregarActor("Marlon Brando");
	     pelicula.agregarActor("Al Pacino");
	     List<String> reparto = pelicula.getReparto();
	     assertEquals(Arrays.asList("Marlon Brando", "Al Pacino"), reparto);
	 }
	 
	 
	 @Test
	 public void testGetDuracionHorasMinutos() {
	     Pelicula pelicula = new Pelicula("El Padrino", "Drama", 175, "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"),"2d");
	     String duracionHorasMinutos = pelicula.getDuracionHorasMinutos();
	     assertEquals("2h 55m", duracionHorasMinutos);
	 }

}
