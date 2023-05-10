package ar.edu.unlam.pb2;

import java.util.ArrayList;

public abstract class SalaCine {
	
	private Integer numero;
    private Integer capacidad;
    private ArrayList<Pelicula> peliculas;
    private String visualizacion;
    private ArrayList<Cliente>listaDeClientes;
	
    public SalaCine(Integer numero, Integer capacidad, String visualizacion) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.setVisualizacion(visualizacion);
        peliculas = new ArrayList<>();
        this.listaDeClientes=new ArrayList<>(capacidad);
    }
    
    public SalaCine(Integer numero, Integer capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.visualizacion=" ";
        peliculas = new ArrayList<>();
        this.listaDeClientes=new ArrayList<>();

    }
    

	public Integer getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public ArrayList<Pelicula> getPeliculas() {
		return peliculas;
	}
	public void setPeliculas(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public abstract Boolean agregarPelicula(Pelicula pelicula);


	public abstract Boolean quitarPelicula(Pelicula pelicula);
	
	public abstract Boolean agregarCliente(Cliente nuevo) ;

	public abstract Boolean quitarCliente(Cliente nuevo);


	public String getVisualizacion() {
		return visualizacion;
	}

	public void setVisualizacion(String visualizacion) {
		this.visualizacion = visualizacion;
	}
	
			
	
	 public ArrayList<Cliente> getListaDeClientes() {
			return listaDeClientes;
		}

		public void setListaDeClientes(ArrayList<Cliente> listaDeClientes) {
			this.listaDeClientes = listaDeClientes;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((numero == null) ? 0 : numero.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SalaCine other = (SalaCine) obj;
			if (numero == null) {
				if (other.numero != null)
					return false;
			} else if (!numero.equals(other.numero))
				return false;
			return true;
		}

}
