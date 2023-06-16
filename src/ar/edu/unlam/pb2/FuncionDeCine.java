package ar.edu.unlam.pb2;

import java.time.LocalDate;
import java.time.LocalTime;

public class FuncionDeCine {
	private Integer id;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private TipoDeIdioma idioma;
	private Pelicula peliculas;
	private TipoDeVisualizacion visualizacion;
	
	public FuncionDeCine(Integer id, LocalDate fecha, LocalTime horaInicio, TipoDeIdioma idioma,Pelicula peliculas,TipoDeVisualizacion visualizacion) {
		this.id=id;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.idioma = idioma;
		this.peliculas=peliculas;
		this.visualizacion = visualizacion;
		
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public TipoDeIdioma getIdioma() {
		return idioma;
	}

	public void setIdioma(TipoDeIdioma idioma) {
		this.idioma = idioma;
	}

	public Pelicula getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Pelicula peliculas) {
		this.peliculas = peliculas;
	}
	
	public TipoDeVisualizacion getVisualizacion() {
		return visualizacion;
	}

	public void setVisualizacion(TipoDeVisualizacion visualizacion) {
		this.visualizacion = visualizacion;
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
		FuncionDeCine other = (FuncionDeCine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FuncionDeCine [id=" + id + ", fecha=" + fecha + ", horaInicio=" + horaInicio + ", idioma=" + idioma
				+ ", peliculas=" + peliculas + ", visualizacion=" + visualizacion + "]";
	}


}
