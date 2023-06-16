package ar.edu.unlam.pb2;

import java.time.LocalDate;
import java.time.LocalTime;
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
	
	public Boolean agregarFuncionesAlCine(FuncionDeCine nuevaFuncion) {
		return this.funciones.add(nuevaFuncion);
	}
	
	public FuncionDeCine buscarfuncionPorID(Integer id) {
		for (FuncionDeCine funcionDeCine : funciones) {
			if(funcionDeCine.getId().equals(id)) {
				return funcionDeCine;
			}
		}
		return null;
	}
	 
	public Boolean cambiarHorarioDeUnaFuncion(Integer idFuncion,LocalTime horaNueva) {
		Boolean seCambio=false;
		FuncionDeCine buscada=buscarfuncionPorID(idFuncion);
		
		for (FuncionDeCine funcionDeCine : funciones) {
			if(funcionDeCine.equals(buscada)) {
				funcionDeCine.setHoraInicio(horaNueva);;
				return seCambio=true;
			}
		}
		return seCambio;
	}
	
	public FuncionDeCine crearFuncionDeCine(Integer idFuncion, LocalDate fecha, LocalTime horaInicio, TipoDeIdioma idioma, Pelicula pelicula, TipoDeVisualizacion visualizacion) {
		FuncionDeCine nuevaFuncion=new FuncionDeCine(idFuncion, fecha, horaInicio,idioma,null,visualizacion);
	    return nuevaFuncion;
		
	}
	
	public Integer cantidadDeFuncionesAgregadas() {
		return this.funciones.size();
		
	}
	
	public HashSet <FuncionDeCine> buscarfuncionesDelDia(LocalDate fechaFuncion) {
		HashSet<FuncionDeCine> funcionesDelDia= new HashSet<>();
		for (FuncionDeCine funcionDeCine : funciones) {
			if(funcionDeCine.getFecha().equals(fechaFuncion)) {
				funcionesDelDia.add(funcionDeCine);
			}
		}
		return funcionesDelDia;
	}
	
	public Boolean asignarUnaPeliculaAUnaFuncionDeCine(Integer idFuncion,Pelicula asignarPelicula) {
		Boolean seCambio=false;
		FuncionDeCine buscada=buscarfuncionPorID(idFuncion);
		
		for (FuncionDeCine funcionDeCine : funciones) {
			if(funcionDeCine.equals(buscada)) {
				funcionDeCine.setPeliculas(asignarPelicula);
				return seCambio=true;
			}	
		 }
		return seCambio;
	}
	
	public Boolean agregarFuncionDeCineAUnaSala(SalaCine salaAIngresar,FuncionDeCine agregarFuncion) {
		Boolean seAgrego=false;
		
		if(salaAIngresar!=null && salaAIngresar.getTipo().equals(TipoDeSala.SALA_2D)) {
		   salaAIngresar.ingresarFuncionASalasDeCine(agregarFuncion);
		   return seAgrego=true; 
	      }else if(salaAIngresar!=null && salaAIngresar.getTipo().equals(TipoDeSala.SALA_3D)) {
			      salaAIngresar.ingresarFuncionASalasDeCine(agregarFuncion);
			      return seAgrego=true;
		       }					
	        return seAgrego;	
	   }



}
