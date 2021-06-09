package webapp.tarea.entity;

public class Usuario {
	private int idusuario;
	private String username;
	private String password;
	private int estado;
	public Usuario() {

	}
	public Usuario(String username, String password, int estado) {
		this.username = username;
		this.password = password;
		this.estado = estado;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
