package postit;

import java.util.List;

import notable.Notable;

import java.util.ArrayList;
import java.util.Date;

import utilisateur.Utilisateur;

/** Un postit. */
public class PostIt extends Notable
{
	private Utilisateur auteur;
	private String titre;
	private Contenu contenu;
	private Date dateCreation;
	private PointGeo pointGeo;
	private List<Commentaire> commentaires;
	private Integer id;
	
	public PostIt(Utilisateur auteur, String titre, Contenu contenu, PointGeo pointGeo) {
		super();
		this.auteur = auteur;
		this.titre = titre;
		this.contenu = contenu;
		this.dateCreation = new Date();
		this.pointGeo = pointGeo;
		this.commentaires = new ArrayList<Commentaire>();
	}
	
	public void ajouterCommentaire(Commentaire commentaire) {
		this.commentaires.add(commentaire);
	}
	
	public List<Commentaire> getCommentaires() {
		return this.commentaires;
	}
	
	public String getTitre() {
		return this.titre;
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
	
	public PointGeo getPointGeo() {
		return this.pointGeo;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
}
