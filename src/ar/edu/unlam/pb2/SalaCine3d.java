package ar.edu.unlam.pb2;

public class SalaCine3d extends SalaCine{
	
	String visualizacion ;
	
	public SalaCine3d(Integer numero, Integer capacidad) {
		super(numero, capacidad);
		setVisualizacion("3d");
		
	}

	@Override
	public Boolean agregarPelicula(Pelicula pelicula) {
		if(pelicula.getFormato()=="3d")
		super.getPeliculas().add(pelicula);
		
		return true;
	}

	@Override
	public Boolean quitarPelicula(Pelicula pelicula) {
		if(super.getPeliculas().contains(pelicula)) {
			
		return super.getPeliculas().remove(pelicula);
		}
		return false;
	}

	@Override
	public Boolean agregarCliente(Cliente nuevo) {
		if(super.getListaDeClientes().size()<super.getCapacidad()) {
			super.getListaDeClientes().add(nuevo);
			return true;
		}
		return false;
	}
	
	
	@Override
	public Boolean quitarCliente(Cliente nuevo) {
		if(super.getListaDeClientes().contains(nuevo)) {
			
			return super.getListaDeClientes().remove(nuevo);
		}
		return false;
	}
	
	


}
