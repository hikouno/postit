package postit;

import java.util.Date;

import utilisateur.Utilisateur;
import postit.Contenu;

import notable.Notable;

/** Un commentaire. */
public class Commentaire extends Notable
{
	private Utilisateur auteur;
	private Contenu contenu;
	private Date dateCreation;
	
	public Commentaire(Utilisateur auteur, Contenu contenu) {
		super();
		this.auteur = auteur;
		this.contenu = contenu;
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
}
