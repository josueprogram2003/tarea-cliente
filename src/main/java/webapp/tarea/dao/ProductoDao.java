package webapp.tarea.dao;

import java.util.List;

import webapp.tarea.entity.*;

public interface ProductoDao {
	public int create(Producto u);
	public int update(Producto u);
	public Producto read(int id);
	public List<Producto> readAll();
	public int delete(int id);
}
