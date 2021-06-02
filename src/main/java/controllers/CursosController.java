package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import dto.DtoAlumno;
import model.Curso;
import service.CursosService;
import service.MatriculasService;

@Controller
public class CursosController {
	@Autowired
	MatriculasService mService;
	@Autowired
	CursosService cService;
	
	@GetMapping(value="altaCurso")
	public String altaCurso() {
		return "menu";
	}
	
	@GetMapping(value="altaAlumno")
	public String altaAlumno() {
		return "menu";
	}
	
	@GetMapping(value="buscarCursosDuracion")
	public String buscaCursosDuracion() {
		return "";
	}
	
	@GetMapping(value="cursos")
	public String cursos( HttpServletRequest request) {
		request.setAttribute("cursos", cService.listadoCursos());
		return "cursos";
	}

	@GetMapping(value="recuperarAlumnosPorCurso",produces=MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody List<DtoAlumno> recuperarAlumnosPorCurso(@RequestParam("curso") String curso){
		return mService.listadoAlumnos(curso);

	}
	
}
