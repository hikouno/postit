package utilisateur;

public class Invite implements Utilisateur
{
	private String pseudo;
	
	public Invite(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
}
