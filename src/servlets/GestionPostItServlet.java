package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ejb.EJB;

import facades.FacadePostIt;
import notable.Notable;
import postit.*;
import utilisateur.Membre;

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
		HttpSession session = request.getSession();
		Membre membre = null;
		if (session.getAttribute("membre") != null)
			membre = (Membre) session.getAttribute("membre");
		
		String operation = request.getParameter("op");
		Integer postItId = Integer.parseInt(request.getParameter("postit"));
		
		if(operation.equals("accueil"))
		{
			
		}
		else if(operation.equals("afPostIt"))
		{
			PostIt postItAAfficher = fcdPostIt.getPostItById(postItId);
			
			System.out.println("Je vais afficher le post-it " + postItId + " : " + postItAAfficher);
			
			
			if (postItAAfficher != null) {
				
				request.setAttribute("postit", postItAAfficher);
				request.getRequestDispatcher("affichage_postit.jsp").forward(request, response);
				
			} else {
				//Afficher un message d'erreur à l'utilisateur est possible
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		}
		else if(operation.equals("noterPostIt")) {
			if (membre != null) {
				String rawVote = (String) request.getParameter("vote");
				Notable.Vote vote = (rawVote.equals("-1") ? Notable.Vote.MOINS_1 : Notable.Vote.PLUS_1);
				fcdPostIt.noterPostIt(postItId, membre, vote);
				
				request.getRequestDispatcher("GestionPostItServlet?op=afPostIt&postit="+postItId).forward(request, response);
				
			} else {
				
				//Afficher un message d'erreur à l'utilisateur est possible
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		else if(operation.equals("denoterPostIt")) {
			if (membre != null) {

				fcdPostIt.denoterPostIt(postItId, membre);
				request.getRequestDispatcher("GestionPostItServlet?op=afPostIt&postit="+postItId).forward(request, response);
				
			} else {
				
				//Afficher un message d'erreur à l'utilisateur est possible
				request.getRequestDispatcher("index.jsp").forward(request, response);
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
