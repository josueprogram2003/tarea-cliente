package webapp.tarea.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webapp.tarea.config.Conexion;
import webapp.tarea.dao.UsuarioDao;
import webapp.tarea.entity.Usuario;




public class UsuarioDaoImpl implements UsuarioDao {
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection cx = null;

	@Override
	public int validar(String user, String pass) {
		// TODO Auto-generated method stub
		int x = 0;
		String SQL = "select *from usuario where username=? and password=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				x = 1;
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Validar: " + e);
		} 
		return x;
	}

	@Override
	public int create(Usuario u) {
		int x = 0;
		String SQL = "insert into usuario (idusuario, username, password, estado) value(null, ?,?,1)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public int update(Usuario u) {
		int x = 0;
		String SQL = "update usuario set username = ?, password = ? where idusuario = ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setInt(3, u.getIdusuario());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public Usuario read(int id) {
		Usuario a = new Usuario();
		String SQL = "select *from usuario where idusuario=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {				
				a.setIdusuario(rs.getInt("idusuario"));
				a.setUsername(rs.getString("username"));
				a.setPassword(rs.getString("password"));
				a.setEstado(rs.getInt("estado"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return a;
	}

	@Override
	public List<Usuario> readAll() {
		// TODO Auto-generated method stub
		List<Usuario> lista = new ArrayList<>();
		String SQL = "select *from usuario";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario a = new Usuario();
				a.setIdusuario(rs.getInt("idusuario"));
				a.setUsername(rs.getString("username"));
				a.setPassword(rs.getString("password"));
				a.setEstado(rs.getInt("estado"));
				lista.add(a);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return lista;
	}

	@Override
	public int delete(int id) {
		int x = 0;
		String SQL = "delete from usuario where idusuario=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

}
