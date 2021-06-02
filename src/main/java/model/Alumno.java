package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the alumnos database table.
 * 
 */
@Entity
@Table(name="alumnos")
public class Alumno{	
	@Id
	private String usuario;

	private int edad;

	private String email;

	private String nombre;

	private String password;
	
	@OneToMany (mappedBy="alumno")
	public List<Matricula> matriculas;

	public Alumno() {
		super();
	}

	public Alumno(String usuario, int edad, String email, String nombre, String password, List<Matricula> matriculas) {
		super();
		this.usuario = usuario;
		this.edad = edad;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		this.matriculas = matriculas;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	
}