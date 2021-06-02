package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.DtoCurso;
import repository.CursosRepository;
import util.Utilidades;

@Service
public class CursosServiceImpl implements CursosService {
	@Autowired
	CursosRepository cursosRep;
	
	@Override
	public List<DtoCurso> listadoCursos() {
		return cursosRep.findAll()
				.stream()
				.map(c->Utilidades.convertirADtoCurso(c))
				.collect(Collectors.toList());
	}

}
