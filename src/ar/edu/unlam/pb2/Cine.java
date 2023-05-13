package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;

public class Cine {
	
	 private String nombre;
	   private HashSet<SalaCine> salas;

	    public Cine(String nombre) {
	        this.nombre = nombre;
	        this.salas = new HashSet<>();
	    }

	    public Cine(String nombre, HashSet<SalaCine> listaSalas) {
			this.nombre = nombre;
			this.salas = new HashSet <> ();
			salas = listaSalas;
		}

		public String getNombre() {
	        return this.nombre;
	    }

		public Boolean agregarSala(SalaCine nuevaSala) {
			return this.salas.add(nuevaSala);
		}

	    public HashSet<SalaCine> getSalas() {
	        return this.salas;
	    }

	    public ArrayList<Pelicula> buscarPeliculasPorGenero(String genero) {
	        ArrayList<Pelicula> peliculasPorGenero = new ArrayList<>();
	        for (SalaCine sala : this.salas) {
	            for (Pelicula pelicula : sala.getPeliculas()) {
	                if (pelicula.getGenero().equals(genero)) {
	                    peliculasPorGenero.add(pelicula);
	                }
	            }
	        }
	        return peliculasPorGenero;
	    }

	    public HashSet<SalaCine> buscarSalasPorCapacidad(int capacidad) {
	        HashSet<SalaCine> salasPorCapacidad = new HashSet<>();
	        for (SalaCine sala : this.salas) {
	            if (sala.getCapacidad() >= capacidad) {
	                salasPorCapacidad.add(sala);
	            }
	        }
	        return salasPorCapacidad;
	    }
	    
	    public Boolean eliminarUnaSala(SalaCine salaAEliminar) {
	    	Boolean seElimino=false;
	    	for(SalaCine salaCine:salas){
	    		if(salas.contains(salaAEliminar)) {
	    		   if(salaCine.getListaDeClientes().size()==0) {
	    		      return this.salas.remove(salaAEliminar);
	    		  
	    		}
	    	  }
	    	}
	    	 return seElimino;
	    }

}
