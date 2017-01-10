package utilisateur;

public class Membre implements Utilisateur
{
	protected Integer id;
	protected String nom;
	protected String prenoms;
	protected String password;
	protected String pseudo;

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenoms() {
		return prenoms;
	}
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
