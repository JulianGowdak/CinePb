package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;

public class Cine {
	
	 private String nombre;
	 private HashSet<SalaCine> salas;
	 private HashSet <FuncionDeCine>funciones;
	 private ArrayList <Pelicula>peliculas;

	 public Cine(String nombre) {
	        this.nombre = nombre;
	        this.salas =new HashSet<>();
	        this.funciones=new HashSet<>();
	        this.peliculas=new ArrayList<>();
	    }

	 public Cine(String nombre, HashSet<SalaCine> listaSalas,ArrayList <Pelicula>listaPeliculas) {
			this.nombre = nombre;
			this.salas =new HashSet<>();
			salas = listaSalas;
			this.peliculas =new ArrayList<>();
			peliculas = listaPeliculas;
			
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
	        for (Pelicula pelicula : this.peliculas) {
                if (pelicula.getGenero().equals(genero)) {
                    peliculasPorGenero.add(pelicula);
                }
            }
        return peliculasPorGenero;
    }

	 public HashSet<SalaCine> buscarSalasPorCapacidad(Integer capacidad) {
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
	    
	 public Integer cantidadDeSalasAgregadas() {
	    	return this.salas.size();
	    }

	public HashSet<FuncionDeCine> getFunciones() {
		return funciones;
	}

	public void setFunciones(HashSet<FuncionDeCine> funciones) {
		this.funciones = funciones;
	}

	public ArrayList<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	 
	public SalaCine buscarSalaPorID(Integer idSala) {
		for (SalaCine salaCine : salas) {
			if(salaCine.getNumero().equals(idSala)) {
				return salaCine;
			}
		}
		return null;
	}
	 

}
