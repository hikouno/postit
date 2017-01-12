package facades;

import java.util.HashMap;

import javax.ejb.Singleton;

import multimedia.Image;
import multimedia.Texte;
import multimedia.Video;
import notable.Notable;
import notable.Notable.Vote;
import postit.*;
import utilisateur.Invite;
import utilisateur.Membre;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Singleton
public class FacadePostIt
{
	private HashMap<Integer, PostIt> postits;
	private Integer currentId;
	
	public FacadePostIt() {
		this.postits = new HashMap<Integer, PostIt>();
		this.currentId = 0;
		
		//Pour tester j'ajoute le post-it "1" :)
		final Integer ID = this.getNextID();
		this.currentId +=1;
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
		PostIt p = new PostIt(m1, "Mon premier post-it", cont, new PointGeo(0.2, 0.7), ID);
		p.ajouterCommentaire(comm1);
		p.ajouterCommentaire(new Commentaire(new Invite("hikouno"), com2));
		postits.put(ID, p);
	}
	
	public void ajouterPostIt(PostIt postit) {
		this.postits.put(postit.getId(), postit);
		this.currentId +=1;
	}
	
	/// OPERATIONS DE NOTAGE
	// Post-it
	public void noterPostIt(Integer id, Membre membre, Notable.Vote vote) {
		PostIt postit = null;
		if ((postit = getPostItById(id)) != null) {
			postit.noter(membre, vote);
			System.out.println("On note " + postit + " avec " + membre);
		}
	}
	
	public void denoterPostIt(Integer id, Membre membre) {
		PostIt postit = null;
		if ((postit = getPostItById(id)) != null) {
			postit.annulerVote(membre);
		}
	}
	
	//Commentaire
	public void noterCommentaire(Integer id, int commentIx, Membre membre, Notable.Vote vote) {
		PostIt postit = null;
		if ((postit = getPostItById(id)) != null) {
			if (postit.getCommentaires().size() > commentIx) {
				postit.getCommentaires().get(commentIx).noter(membre, vote);
				System.out.println("On note le commentaire " + commentIx + " de " + postit + " avec " + membre);
			}
		}
	}
	
	public void denoterCommentaire(Integer id, int commentIx, Membre membre) {
		PostIt postit = null;
		if ((postit = getPostItById(id)) != null) {
			if (postit.getCommentaires().size() > commentIx) {
				postit.getCommentaires().get(commentIx).annulerVote(membre);
				System.out.println("On denote le commentaire " + commentIx + " de " + postit + " avec " + membre);
			}
		}
	}
	
	public PostIt getPostItById(Integer id) {
		return this.postits.get(id);
	}
	
	public HashMap<Integer, PostIt> getPostIts() {
		return postits;
	}
	
	public List<PostIt> recherchePostIts(double longitude, double latitude, double distance, Auteur auteur, double note){
		//remplir la liste avec tout les post-its
		List<PostIt> liste = new ArrayList<>();
		for(PostIt postIt : this.postits.values()){
			liste.add(postIt);
		}
		//enlever ceux du mauvais auteur
		if(auteur != null){
			Predicate<PostIt> conditionAuteur = p -> p.getAuteur() != auteur;
			liste.removeIf(conditionAuteur);
		}
		//enlever ceux trop loin
		if(latitude<=90 && latitude>=-90 && longitude<=180 && longitude>=180 && distance>=0){
			Predicate<PostIt> conditionDistance = p -> Facade.getDistance(p, latitude, longitude)> distance;
			liste.removeIf(conditionDistance);
		}
		//enlever ceux trop mauvais
		Predicate<PostIt> conditionNote = p -> p.getNote()<note;
		liste.removeIf(conditionNote);
		return liste;
	}
	
	public Integer getNextID()
	{
		return this.currentId +1;
	}
}
