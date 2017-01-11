package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ejb.EJB;

import facades.FacadePostIt;
import postit.*;

/**
 * Servlet implementation class GestionPostItServlet
 */
@WebServlet("/GestionPostItServlet")
public class GestionPostItServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private FacadePostIt fcdPostIt;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionPostItServlet() {
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
			
		}
		else if(operation.equals("afPostIt"))
		{
			Integer postItId = Integer.parseInt(request.getParameter("postit"));
			
			
			
			PostIt postItAAfficher = fcdPostIt.getPostItById(postItId);
			
			System.out.println("Je vais afficher le post-it " + postItId + " : " + postItAAfficher);
			
			
			if (postItAAfficher != null) {
				
				request.setAttribute("postit", postItAAfficher);
				request.getRequestDispatcher("affichage_postit.jsp").forward(request, response);
				
			} else {
				//Afficher un message d'erreur à l'utilisateur est possible
				request.getRequestDispatcher("index.html").forward(request, response);
			}
			
		}
		else if(operation.equals("ajPostIt"))
		{
			
		}
		else if(operation.equals("rechPostIt"))
		{
			
		}
		
	}

}
