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
 * Servlet implementation class ModifierServlet
 */
@WebServlet("/Modifier")
public class ModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierServlet() {
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
		String nomVilleAModifier = request.getParameter("ville");
		String codeCommuneINSEE = request.getParameter("codeCommuneINSEE");
		String nom = request.getParameter("nom");
		String codePostal = request.getParameter("codePostal");
		String libelle = request.getParameter("libelle");
		String ligne5 = request.getParameter("ligne5");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		
		RestTemplate restTemplate = new RestTemplate();
		Ville[] villeAModifier = restTemplate.getForObject("http://127.0.0.1:8181/villeget?filtre=Nom_commune&value=" + nomVilleAModifier, Ville[].class);
		Ville newVille = new Ville(codeCommuneINSEE, nom, codePostal, libelle, ligne5, latitude, longitude);
		String codeCommune = villeAModifier[0].getCodeCommuneINSEE();
		
		
		restTemplate.put("http://127.0.0.1:8181/villeput/" + codeCommune, newVille);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("ville", newVille);
		session.setAttribute("villeNom", newVille.getNomCommune());
		
		RequestDispatcher dispat = request.getRequestDispatcher("modifierVisualiser.jsp");
		dispat.forward(request,response);
	}

}
