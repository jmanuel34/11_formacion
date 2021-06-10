package service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.DtoMatricula;
import model.Matricula;
import repository.MatriculaRepository;
import util.Utilidades;

@Service
public class MatriculasServiceImpl implements MatriculasService {

	@Autowired
	MatriculaRepository matriculaRep;

	@Override

	public List<DtoMatricula> listadoMatriculas(String idCurso) {
		Integer curso=Integer.parseInt(idCurso);
		List<Matricula> matriculas;
		matriculas = matriculaRep.buscarMatriculasCurso(curso);
		for (Matricula m: matriculas) {
			System.out.println("Service Alumno: " +m.getAlumno().getNombre());			
		}
		return matriculas
				.stream()
				.map(a->Utilidades.convertirADtoMatricula(a))
				.collect(Collectors.toList());
	}
	
}
