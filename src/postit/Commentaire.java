import java.util.Date;

import utilisateur.Utilisateur;
import postit.Contenu;

/** Un commentaire. */
public class Commentaire extends Notable
{
	private Utilisateur auteur;
	private Contenu contenu;
	private Date dateCreation;
	private PostIt postItAssocie;
	
	public Commentaire(Utilisateur auteur, Contenu contenu, PostIt postit) {
		super();
		this.auteur = auteur;
		this.contenu = contenu;
		this.postItAssocie = postit;
		this.dateCreation = new Date();
	}
	
	public Utilisateur getAuteur() {
		return this.auteur;
	}
	
	public Contenu getContenu() {
		return this.contenu;
	}
	
	public Date getDateCreation() {
		return this.dateCreation;
	}
	
	public PostIt getPostIt() {
		return this.postItAssocie;
	}
}
