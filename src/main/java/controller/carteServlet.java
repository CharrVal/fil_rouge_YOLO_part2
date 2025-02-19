package controller;

import java.io.IOException;

import bll.CarteBLL;
import bo.Carte;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/carte")
public class carteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private PlatBLL platbll = new PlatBLL();
	private CarteBLL cartebll = new CarteBLL();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		int id = Integer.parseInt(idParam);
		
		Carte carte = cartebll.selectById(id);
		
		request.setAttribute("carte", carte);
		request.getRequestDispatcher("/WEB-INF/jsp/carte.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}