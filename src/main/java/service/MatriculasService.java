package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dto.DtoMatricula;
@Service
public interface MatriculasService {
	List<DtoMatricula> listadoMatriculas(String idCurso); 
}
