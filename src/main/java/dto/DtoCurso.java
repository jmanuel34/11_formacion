package dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class DtoCurso {
	private int idCurso;

	@Temporal(TemporalType.DATE)
	private Date fechaInicio;

	private int duracion;

	private String nombre;

	
	public DtoCurso() {
		super();
	}

	public DtoCurso(int idCurso, Date fechaInicio, int duracion, String nombre) {
		super();
		this.idCurso = idCurso;
		this.fechaInicio = fechaInicio;
		this.duracion = duracion;
		this.nombre = nombre;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
