package ar.edu.unlam.pb2;

public class Cliente {
	
	private Long dni;
	private Integer edad;
	private String nombre;
	private String apellido;
	
	public Cliente(Long dni, Integer edad, String nombre, String apellido) {
		
		this.dni = dni;
		this.edad = edad;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
