package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import facades.FacadeUtilisateurs;
import utilisateur.Membre;

/**
 * Servlet implementation class GestionMembresServlet
 */
@WebServlet("/GestionMembresServlet")
public class GestionMembresServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	@EJB
	private FacadeUtilisateurs fcdUsers;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionMembresServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String operation = request.getParameter("op");

		if(operation.equals("accueil"))
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if(operation.equals("login"))
		{
			String pseudo = request.getParameter("pseudo");
			String password = request.getParameter("password");
			System.out.println("connexion de " + pseudo + " "+ password);
				
			Membre mb = fcdUsers.checkMembre(pseudo, password);
			if(mb != null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("membre", mb);

				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("echecCo", "echecConnexion");
				request.getRequestDispatcher("Login.html").forward(request, response);
			}	
		}
		else if(operation.equals("logout"))
		{
			request.getSession().invalidate();
			//request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if(operation.equals("inscrMbr"))
		{
			String nom = request.getParameter("nom");
			String prenoms = request.getParameter("prenom");
			String pseudo = request.getParameter("pseudo");
			String password = request.getParameter("password");
			
			System.out.println("inscription de " + nom +" "+ prenoms + " "+ pseudo + " "+ password);
			fcdUsers.ajouterMembre(nom, prenoms, pseudo, password);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if(operation.equals("afprofil"))
		{
		  	String pseudo = request.getParameter("pseudo_membre");
			request.setAttribute("membre", fcdUsers.getListeMembres().get(pseudo));
			request.getRequestDispatcher("profil.jsp").forward(request, response);
		}
		else if(operation.equals("modProfil"))
		{
			
		}
	}

}
