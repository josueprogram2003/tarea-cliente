package webapp.tarea.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import webapp.tarea.dao.ProductoDao;
import webapp.tarea.dao.UsuarioDao;
import webapp.tarea.daoImpl.ProductoDaoImpl;
import webapp.tarea.daoImpl.UsuarioDaoImpl;

/**
 * Servlet implementation class UsuarioController
 */
public class UsuarioController extends HttpServlet {
	private Gson gson = new Gson();
	private UsuarioDao udao = new UsuarioDaoImpl();
	private ProductoDao pdao = new ProductoDaoImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		System.out.println(user+" / "+pass);
		if(udao.validar(user, pass)==1) {
			out.println(gson.toJson(pdao.readAll()));
		}else {
			out.println("Datos incorrectos...!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
