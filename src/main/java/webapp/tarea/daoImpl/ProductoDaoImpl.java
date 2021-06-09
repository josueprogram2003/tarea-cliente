package webapp.tarea.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webapp.tarea.config.Conexion;
import webapp.tarea.dao.ProductoDao;
import webapp.tarea.entity.Producto;


public class ProductoDaoImpl implements ProductoDao{
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection cx = null;
	@Override
	public int create(Producto u) {
		// TODO Auto-generated method stub
		int x = 0;
		String SQL = "insert into producto (idproducto, nombre, precio, cantidad) value(null, ?,?,?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, u.getNombre());
			ps.setDouble(2, u.getPrecio());
			ps.setInt(3, u.getCantidad());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public int update(Producto u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Producto read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> readAll() {
		// TODO Auto-generated method stub
		List<Producto> lista = new ArrayList<>();
		String SQL = "select *from producto";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				Producto a = new Producto();
				a.setIdproducto(rs.getInt("idproducto"));
				a.setNombre(rs.getString("nombre"));
				a.setPrecio(rs.getDouble("precio"));
				a.setCantidad(rs.getInt("cantidad"));
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
		// TODO Auto-generated method stub
		return 0;
	}

}
