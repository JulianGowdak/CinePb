package ar.edu.unlam.pb2;

import java.util.List;

public class Pelicula {
	private String titulo;
    private String genero;
    private Integer duracion;
    private String director;
    private List<String> reparto;
    private String formato;

    
    public Pelicula(String titulo, String genero, Integer duracion, String director, List<String> reparto,String formato) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.director = director;
        this.reparto = reparto;
        this.setFormato(formato);
        
    }
    
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public Integer getDuracion() {
        return duracion;
    }
    
    public String getDirector() {
        return director;
    }
    
    public List<String> getReparto() {
        return reparto;
    }
    

	public void agregarActor(String nombre) {
		this.reparto.add(nombre);
		
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setReparto(List<String> reparto) {
		this.reparto = reparto;
	}


	public String getDuracionHorasMinutos() {
		int horas = this.duracion / 60;
        int minutos = this.duracion % 60;
        return horas + "h " + minutos + "m";
	}


	public String getFormato() {
		return formato;
	}


	public void setFormato(String formato) {
		this.formato = formato;
	}
	

}
