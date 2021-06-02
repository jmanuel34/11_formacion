package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dto.DtoAlumno;
@Service
public interface MatriculasService {
	List<DtoAlumno> listadoAlumnos(String idCurso); 
}
