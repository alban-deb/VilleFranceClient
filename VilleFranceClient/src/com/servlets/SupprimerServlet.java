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
 * Servlet implementation class SupprimerServlet
 */
@WebServlet("/Supprimer")
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerServlet() {
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
		String nomVille = request.getParameter("ville");
		
		RestTemplate restTemplate = new RestTemplate();
		Ville[] ville = restTemplate.getForObject("http://127.0.0.1:8181/villeget?filtre=Nom_commune&value=" + nomVille, Ville[].class);
		
		String codeCommune = ville[0].getCodeCommuneINSEE();
		String villeNom = ville[0].getNomCommune();
		
		restTemplate.delete("http://127.0.0.1:8181/villedelete/" + codeCommune);
		
		HttpSession session = request.getSession();
		session.setAttribute("ville", ville);
		session.setAttribute("villeNom", villeNom);
		RequestDispatcher dispat = request.getRequestDispatcher("supprimerVisualiser.jsp");
		dispat.forward(request,response);
	}

}
