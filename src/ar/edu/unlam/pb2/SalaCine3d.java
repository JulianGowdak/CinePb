package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class SalaCine3d extends SalaCine{
	
	private Set<Lente3D>listaDeLentes3D;
	
	public SalaCine3d(Integer numero, Integer capacidad) {
		super(numero, capacidad);
		setTipo(TipoDeSala.SALA_3D);
		this.listaDeLentes3D=new HashSet<>();
		
	}
	
	public Set<Lente3D> getListaDeLentes3D() {
		return listaDeLentes3D;
	}

	public void setListaDeLentes3D(Set<Lente3D> listaDeLentes3D) {
		this.listaDeLentes3D = listaDeLentes3D;
	}

	@Override
	public Boolean ingresarFuncionASalasDeCine(FuncionDeCine nuevaFuncion) {
		Boolean seAgrego=false;
		if(nuevaFuncion.getVisualizacion().equals(TipoDeVisualizacion.VISUALIZACION_3D)) {
			super.getFuncionesEnSalas().add(nuevaFuncion);
			return seAgrego=true;
		 } 
	   return seAgrego;
	}
	
	public Boolean agregarLentes3dASala(Lente3D nuevoLente) {
		if(this.listaDeLentes3D.size()<super.getCapacidad()) {
		   return listaDeLentes3D.add(nuevoLente);
		 }
		return false;
	}
	
	public Lente3D buscarLente3D(Lente3D lenteABuscar) {
		for (Lente3D lente3DActual : listaDeLentes3D) {
			if(lente3DActual.equals(lenteABuscar)) {
				return lente3DActual;
			 }
		 }
		return null;
	}
	
	public Boolean prestarLente3dACliente(Lente3D aPrestar, Long dniUsuario) {
		Boolean seRepartio=false;
		Cliente aRecibirLente=buscarCliente(dniUsuario);
		
		for (Lente3D lenteActual : listaDeLentes3D) {
			 if(lenteActual.equals(aPrestar)) {
				 lenteActual.setUsuario(aRecibirLente);
				 return seRepartio=true;
			}
		}
		return seRepartio;
	}

	public Boolean DevolverLentes3D(Lente3D aDevolver) {
		Boolean seDevolvio=false;
		
		for (Lente3D lenteActual : listaDeLentes3D) {
			 if(lenteActual.equals(aDevolver)) {
				lenteActual.setUsuario(null);
				    return seDevolvio=true;
			  }
		      
		  }
		return seDevolvio;
	}
	
	public Boolean quitarClienteSala3D(Cliente usuarioIngresado,Boolean DevolverLentes3D) {
		if(super.getListaDeClientes().contains(usuarioIngresado) && DevolverLentes3D == true) {
			return super.getListaDeClientes().remove(usuarioIngresado);
		}
		return false;
	
    }

	@Override
	public Boolean quitarClienteDeSala(Cliente nuevo) {
		if(super.getListaDeClientes().contains(nuevo)) {	
			return super.getListaDeClientes().remove(nuevo);
		}
		return false;
	}
	
}
