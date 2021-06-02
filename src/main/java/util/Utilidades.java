package util;

import dto.DtoAlumno;
import dto.DtoCurso;
import dto.DtoMatricula;
import model.Alumno;
import model.Curso;
import model.Matricula;
import model.MatriculaPK;

public class Utilidades {
	
	public static DtoAlumno convertirADtoAlumno(Alumno alumno) {
		return new DtoAlumno(alumno.getUsuario(),
				alumno.getEdad(),
				alumno.getEmail(),
				alumno.getNombre(),
				alumno.getPassword());
	}
	
	public static DtoCurso convertirADtoCurso(Curso curso) {
		return new DtoCurso(curso.getIdCurso(),
				curso.getFechaInicio(),
				curso.getDuracion(),
				curso.getNombre());
	}
	
	public static DtoMatricula convertirADtoMatricula(Matricula matricula) {
		MatriculaPK matriculaPk= new MatriculaPK(matricula.getAlumno().getNombre(), matricula.getCurso().getIdCurso());
		return new DtoMatricula(matriculaPk, matricula.getNota());			
	}
	
	
}
