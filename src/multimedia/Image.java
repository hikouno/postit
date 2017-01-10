package multimedia;

public class Image
{
	private String chemin;
	
	public Image(String cheminImage) {
		this.chemin = cheminImage.trim();
		//Attention à la sécurité ici.
	}
	
	public String toHtml() {
		return "<img src=\""+this.chemin+"\" alt=\"image utilisateur\" />";
	}
}
