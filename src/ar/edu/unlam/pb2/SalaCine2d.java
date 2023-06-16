package ar.edu.unlam.pb2;

public class SalaCine2d extends SalaCine{
		
	public SalaCine2d(Integer numero, Integer capacidad) {
		super(numero, capacidad);
		setTipo(TipoDeSala.SALA_2D);
		
	}

	@Override
	public Boolean ingresarFuncionASalasDeCine(FuncionDeCine nuevaFuncion) {
		Boolean seAgrego=false;
		if(nuevaFuncion.getVisualizacion().equals(TipoDeVisualizacion.VISUALIZACION_2D)) {
			super.getFuncionesEnSalas().add(nuevaFuncion);
			return seAgrego=true;
		 } 
	   return seAgrego;
	}

	@Override
	public Boolean quitarClienteDeSala(Cliente nuevo) {
		if(super.getListaDeClientes().contains(nuevo)) {
			
			return super.getListaDeClientes().remove(nuevo);
		}
		return false;
	}
	

}
