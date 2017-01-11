package utilisateur;

public class Membre extends Notable implements Utilisateur
{
	private int id;
	private String nom, prenoms;
	private String pseudo, password;
	private String avatarPath;
	
	public Membre(String pseudo) {
		super();
		this.pseudo = pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}
	
	public String getPrenoms() {
		return prenoms;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}
	
	public String getAvatarPath() {
		return avatarPath;
	}
}
