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
 * Servlet implementation class CalculDistanceServlet
 */
@WebServlet("/CalculDistance")
public class CalculDistanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculDistanceServlet() {
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
		
		
		
		String nomVille1 = request.getParameter("ville1");
		String nomVille2 = request.getParameter("ville2");
		
	
		RestTemplate restTemplate = new RestTemplate();
		Ville[] ville1 = restTemplate.getForObject("http://127.0.0.1:8181/villeget?filtre=Nom_commune&value=" + nomVille1, Ville[].class);
		Ville[] ville2 = restTemplate.getForObject("http://127.0.0.1:8181/villeget?filtre=Nom_commune&value=" + nomVille2, Ville[].class);
		

		Double lat1 = Double.parseDouble(ville1[0].getLatitude()) * (Math.PI)/180;
		Double lon1 = Double.parseDouble(ville1[0].getLongitude()) * (Math.PI)/180;
		Double lat2 = Double.parseDouble(ville2[0].getLatitude()) * (Math.PI)/180;
		Double lon2 = Double.parseDouble(ville2[0].getLongitude()) * (Math.PI)/180;
		

		Double R = 6372.795477598;
		
	
		Double distance =  (R * Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2-lon1))) ;
		HttpSession session = request.getSession();
		

		session.setAttribute("ville1", ville1);
		session.setAttribute("ville2", ville2);
		session.setAttribute("distance", distance);
		

		RequestDispatcher dispat = request.getRequestDispatcher("visualiserDistance.jsp");
		dispat.forward(request,response);
	}

}
