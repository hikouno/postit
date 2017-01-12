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
import multimedia.Texte;
import multimedia.Video;
import notable.Notable;
import postit.*;
import utilisateur.Invite;
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
		Integer postItId = 0;
		if (request.getParameter("postit") != null)
			 postItId = Integer.parseInt(request.getParameter("postit"));
		
		
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
		else if(operation.equals("noterComm")) {
			if (membre != null) {
				
				Integer commIx = Integer.parseInt(request.getParameter("comm"));
				
				String rawVote = (String) request.getParameter("vote");
				Notable.Vote vote = (rawVote.equals("-1") ? Notable.Vote.MOINS_1 : Notable.Vote.PLUS_1);
				
				fcdPostIt.noterCommentaire(postItId, commIx, membre, vote);
				
				request.getRequestDispatcher("GestionPostItServlet?op=afPostIt&postit="+postItId).forward(request, response);
				
			} else {
				
				//Afficher un message d'erreur à l'utilisateur est possible
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		else if(operation.equals("denoterComm")) {
			if (membre != null) {
				
				Integer commIx = Integer.parseInt(request.getParameter("comm"));
				
				fcdPostIt.denoterCommentaire(postItId, commIx, membre);
				request.getRequestDispatcher("GestionPostItServlet?op=afPostIt&postit="+postItId).forward(request, response);
				
			} else {
				
				//Afficher un message d'erreur à l'utilisateur est possible
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		else if(operation.equals("ajPostIt"))
		{
			if (membre != null) 
			{
				StringBuffer text = new StringBuffer(request.getParameter("inputdesc"));
				String txtContenu = new String(text);
				String lienVideo = (String)request.getAttribute("inputVideo");
				String latitude = (String)request.getAttribute("inputlat");
				String longitude = (String)request.getAttribute("inputlng");
				String titre = (String)request.getAttribute("inputTitre");

				Contenu cont = new Contenu();
				cont.addElement(new Texte(txtContenu));
				cont.addElement(new Video(lienVideo));
				
				PointGeo pt = new PointGeo(Double.parseDouble(latitude), Double.parseDouble(longitude));
				PostIt p = new PostIt(membre, titre, cont, pt);
				
				fcdPostIt.ajouterPostIt(p);
				System.out.println("postit added " + p.getTitre());
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} 
			else
			{
				StringBuffer text = new StringBuffer(request.getParameter("inputdesc"));
				String txtContenu = new String(text);
				System.out.println(txtContenu);
				
				StringBuffer text1 = new StringBuffer(request.getParameter("inputVideo"));
				String lienVideo = new String(text1);
				System.out.println(lienVideo);
				
				StringBuffer text2 = new StringBuffer(request.getParameter("inputlat"));
				String latitude = new String(text2);
				System.out.println(latitude);
				
				StringBuffer text3 = new StringBuffer(request.getParameter("inputlng"));
				String longitude = new String(text3);
				System.out.println(longitude);
				
				StringBuffer text4 = new StringBuffer(request.getParameter("inputTitre"));
				String titre = new String(text4);
				System.out.println(titre);
				
				StringBuffer text5 = new StringBuffer(request.getParameter("inputpseudo"));
				String pseudo = new String(text5);
				System.out.println(pseudo);
				
				Contenu cont = new Contenu();
				cont.addElement(new Texte(txtContenu));
				cont.addElement(new Video(lienVideo));
				Invite inv = new Invite(pseudo);
				
				PointGeo pt = new PointGeo(Double.parseDouble(latitude), Double.parseDouble(longitude));
				PostIt p = new PostIt(inv, titre, cont, pt);
				
				fcdPostIt.ajouterPostIt(p);
				System.out.println("postit added " + p.getTitre());
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		else if(operation.equals("rechPostIt"))
		{
			
		}
		
	}

}
