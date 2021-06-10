package dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import model.Alumno;
import model.Curso;
import model.MatriculaPK;

public class DtoMatricula {
	private MatriculaPK matriculaPk;
	private double nota;
	private DtoAlumno alumno;
	private DtoCurso curso;
	public DtoMatricula() {
		super();
	}
	public DtoMatricula(MatriculaPK matriculaPk, double nota, DtoAlumno alumno, DtoCurso curso) {
		super();
		this.matriculaPk = matriculaPk;
		this.nota = nota;
		this.alumno = alumno;
		this.curso = curso;
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
	public DtoAlumno getAlumno() {
		return alumno;
	}
	public void setAlumno(DtoAlumno alumno) {
		this.alumno = alumno;
	}
	public DtoCurso getCurso() {
		return curso;
	}
	public void setCurso(DtoCurso curso) {
		this.curso = curso;
	}
	
	
	
}
