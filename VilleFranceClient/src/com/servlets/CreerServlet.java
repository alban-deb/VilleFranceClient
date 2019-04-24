package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.client.RestTemplate;

import com.APIRest.Ville;

/**
 * Servlet implementation class CreerServlet
 */
@WebServlet("/Creer")
public class CreerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codeCommuneINSEE = request.getParameter("codeCommuneINSEE");
		String nom = request.getParameter("nom");
		String codePostal = request.getParameter("codePostal");
		String libelle = request.getParameter("libelle");
		String ligne5 = request.getParameter("ligne5");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		
		HttpSession session = request.getSession();
		RestTemplate restTemplate = new RestTemplate();
		Ville newVille = new Ville(codeCommuneINSEE, nom, codePostal, libelle, ligne5, latitude, longitude);
		restTemplate.postForLocation("http://127.0.0.1:8181/villepost", newVille);
		
		session.setAttribute("codeCommuneINSEE", codeCommuneINSEE);
		session.setAttribute("nom", nom);
		session.setAttribute("codePostal", codePostal);
		session.setAttribute("libelle", libelle);
		session.setAttribute("ligne5", ligne5);
		session.setAttribute("latitude", latitude);
		session.setAttribute("longitude", longitude);
		
		session.setAttribute("newVille", newVille);
		
		RequestDispatcher dispat = request.getRequestDispatcher("creerVisualiser.jsp");
		dispat.forward(request,response);
	}

}
