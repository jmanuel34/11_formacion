package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.DtoAlumno;
import dto.DtoCurso;
import repository.MatriculaRepository;
import util.Utilidades;
@Service
public class MatriculasServiceImpl implements MatriculasService {

	@Autowired
	MatriculaRepository matriculaRep;

	@Override

	public List<DtoAlumno> listadoAlumnos(String idCurso) {
		
		return matriculaRep.buscarAlumnosCurso(Integer.parseInt(idCurso))
				.stream()
				.map(a->Utilidades.convertirADtoAlumno(a))
				.collect(Collectors.toList());
	}
	

}
