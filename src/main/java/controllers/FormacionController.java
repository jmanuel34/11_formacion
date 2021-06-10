package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.DtoAlumno;
import dto.DtoMatricula;
import model.Matricula;
import service.CursosService;
import service.MatriculasService;

@Controller
public class FormacionController {
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
	
	@GetMapping(value="recuperarCursos")
	public String cursos( HttpServletRequest request) {
		request.setAttribute("cursos", cService.listadoCursos());
//		System.out.println("Recupero Cursos ");
		return "alumnosCurso";
	}
	/*
	@GetMapping(value="alumnosCurso",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<DtoAlumno> alumnosCurso(@RequestParam("idCurso") int idCurso){
		return mService.listadoAlumnos(idCurso);
	}
*/
	@GetMapping(value="recuperarAlumnosxCurso",produces=MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody List<DtoMatricula> recuperarAlumnosPorCurso(@RequestParam("idCurso") String idCurso){
		System.out.println("Paso de porametro"+ idCurso);
		List<DtoMatricula> matriculas;
		matriculas=mService.listadoMatriculas(idCurso);
		for (DtoMatricula m: matriculas) {
			System.out.println("Controller: " +m.getAlumno().getNombre());			
		}
		System.out.println("");
		
		// Comprobado que los datos solicitados son el Dto de Matricula, con curso y alumno incluidos.
		// No pasan a la vista.????
		return matriculas;
	}
	/*
	 * @GetMapping(value="alumnosCurso",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<DtoAlumno> alumnosCurso(@RequestParam("idCurso") int idCurso){
		return alumnosService.alumnosCurso(idCurso);
	 */
} 
