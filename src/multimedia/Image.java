package multimedia;

public class Image implements EltMultimedia
{
	private String chemin;
	
	public Image(String cheminImage) {
		this.chemin = cheminImage.trim();
		//Attention à la sécurité ici.
	}
	
	public String toHtml() {
		return "<div><img src=\""+this.chemin+"\" alt=\"image utilisateur\" style=\"max-width:400px;\" /></div>";
	}
}
