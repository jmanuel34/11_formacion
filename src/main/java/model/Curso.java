package model;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the cursos database table.
 * 
 */
@Entity
@Table(name="cursos")
@NamedQuery(name="Curso.findByMaxDuracion", query="select c from Curso c where c.duracion<?1")
public class Curso {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCurso;

	@Temporal(TemporalType.DATE)
	private Date fechaInicio;

	private int duracion;

	private String nombre;
	
	@OneToMany(mappedBy="curso")
	private List<Matricula> matriculas;

	

	public Curso(int idCurso, Date fechaInicio, int duracion, String nombre, List<Matricula> matriculas) {
		super();
		this.idCurso = idCurso;
		this.fechaInicio = fechaInicio;
		this.duracion = duracion;
		this.nombre = nombre;
		this.matriculas = matriculas;
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



	public List<Matricula> getMatriculas() {
		return matriculas;
	}



	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}


}