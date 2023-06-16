package ar.edu.unlam.pb2;

import java.util.HashSet;

public abstract class SalaCine {
	
	private Integer numero;
    private Integer capacidad;
    private TipoDeSala tipo;
    private HashSet<FuncionDeCine>funcionesEnSalas;
    private HashSet<Cliente>listaDeClientes;
	
    public SalaCine(Integer numero, Integer capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.funcionesEnSalas = new HashSet<>();
        this.listaDeClientes=new HashSet<>(capacidad);
    }
    
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	
	public TipoDeSala getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeSala tipo) {
		this.tipo = tipo;
	}

	public HashSet<FuncionDeCine> getFuncionesEnSalas() {
		return funcionesEnSalas;
	}

	public void setFuncionesEnSalas(HashSet<FuncionDeCine> funcionesEnSalas) {
		this.funcionesEnSalas = funcionesEnSalas;
	}
	
	public HashSet<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}

    public void setListaDeClientes(HashSet<Cliente> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}

	public abstract Boolean ingresarFuncionASalasDeCine(FuncionDeCine nuevaFuncion);
	public abstract Boolean quitarClienteDeSala(Cliente ingresado);
	
	public Boolean quitarFuncionDeSalaDeCine(FuncionDeCine funcion) {
		Boolean seQuito=false;
		for (FuncionDeCine funcionDeCine : funcionesEnSalas) {
			if(funcionDeCine.equals(funcion)) {
				return funcionesEnSalas.remove(funcion);
			}
		}	
		return seQuito;
	} 
		
	public Boolean agregarCliente(Cliente nuevo) {
		if(this.listaDeClientes.size()<getCapacidad()) {
			listaDeClientes.add(nuevo);
			return true;
		}
		return false;
	}
	
	public Cliente buscarCliente(Long dni) {
		for (Cliente clienteActual : listaDeClientes) {
			if(clienteActual.getDni().equals(dni)) {
				return clienteActual;
			}
		}
		return null;
	}
	
	public Integer cantidadDeFuncionesAgregadas() {
		return this.funcionesEnSalas.size();
	}	
	
	public Integer cantidadDeClientesAgregados() {
		return this.listaDeClientes.size();
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
			SalaCine other = (SalaCine) obj;
			if (numero == null) {
				if (other.numero != null)
					return false;
			} else if (!numero.equals(other.numero))
				return false;
			return true;
		}

}
