package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.Alumno;
import model.Matricula;
import model.MatriculaPK;

public interface MatriculaRepository extends JpaRepository <Matricula, MatriculaPK> {
	
	/*
	@Query("SELECT a FROM Alumno a WHERE a.matriculas.curso.idCurso=?1")
	/*/
	//*
	@Query("SELECT a FROM Alumno a WHERE a.matriculas IN (SELECT m FROM Matricula m WHERE m.curso.idCurso=?1)")			
	//*/
	
	List<Alumno> buscarAlumnosCurso(Integer idCurso);

}
