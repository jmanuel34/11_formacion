package dto;

public class DtoMatriculaPk {
	private String usuario;
	private int idCurso;
	
	public DtoMatriculaPk() {
		super();
	}
	public DtoMatriculaPk(String usuario, int idCurso) {
		super();
		this.usuario = usuario;
		this.idCurso = idCurso;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	
	
}
