package facades;

import java.util.HashMap;

import javax.ejb.Singleton;

import multimedia.Image;
import multimedia.Texte;
import multimedia.Video;
import notable.Notable.Vote;
import postit.*;
import utilisateur.Invite;
import utilisateur.Membre;

@Singleton
public class FacadePostIt
{
	private HashMap<Integer, PostIt> postits;
	private int currentId;
	
	public FacadePostIt() {
		this.postits = new HashMap<Integer, PostIt>();
		this.currentId = 0;
		
		//Pour tester j'ajoute le post-it "1" :)
		Membre m1 = new Membre("darktosteur");
		m1.setAvatarPath("https://avatars1.githubusercontent.com/u/8598621?v=3&u=0eab29e9e712d19b60152d2e0f6393c5ff81066f&s=400");
		m1.noter(m1, Vote.PLUS_1);
		
		Contenu cont = new Contenu();
		cont.addElement(new Texte("Mon premier texte de post-it :)"));
		cont.addElement(new Video("https://www.youtube.com/embed/m4-89PqmsOU"));
		
		Contenu com1 = new Contenu();
		com1.addElement(new Texte("lourd"));
		com1.addElement(new Video("https://www.youtube.com/embed/hY8ByWUca6U"));
		
		Commentaire comm1 = new Commentaire(m1, com1);
		comm1.noter(m1, Vote.MOINS_1);
		
		Contenu com2 = new Contenu();
		com2.addElement(new Image("http://www.webinette.fr/img/logo.jpg"));
		PostIt p = new PostIt(m1, "Mon premier post-it", cont, new PointGeo(0.2, 0.7));
		p.ajouterCommentaire(comm1);
		p.ajouterCommentaire(new Commentaire(new Invite("hikouno"), com2));
		postits.put(1, p);
	}
	
	public void ajouterPostIt(PostIt postit) {
		this.postits.put(new Integer(this.currentId++), postit);
	}
	
	public PostIt getPostItById(Integer id) {
		return this.postits.get(id);
	}
	
	public HashMap<Integer, PostIt> getPostIts() {
		return postits;
	}
}
