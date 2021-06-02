package model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "matriculas")
public class Matricula {
	@EmbeddedId
	private MatriculaPK matriculaPk;
	private double nota;
	
	@ManyToOne
	@JoinColumn(name="usuario", referencedColumnName = "usuario",insertable = false, updatable = false)
	private Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name="idCurso", referencedColumnName = "idCurso",insertable = false, updatable = false)
	private Curso curso;
	
	public Matricula(MatriculaPK matriculaPk, double nota) {
		super();
		this.matriculaPk = matriculaPk;
		this.nota = nota;
	}
	public Matricula() {
		super();
	}
	public MatriculaPK getMatriculaPk() {
		return matriculaPk;
	}
	public void setMatriculaPk(MatriculaPK matriculaPk) {
		this.matriculaPk = matriculaPk;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
