package ar.edu.unlam.pb2;

public class Lente3D {
	
	private Integer id;
	private Cliente usuario;
	
	public Lente3D(Integer id, Cliente usuario) {
		
		this.id = id;
		this.usuario = usuario;
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getUsuario() {
		return usuario;
	}

	public void setUsuario(Cliente usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Lente3D other = (Lente3D) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lente3D [id=" + id + ", usuario=" + usuario + "]";
	}
	

}
