package multimedia;

/** C'est une vidéo Youtube ici */
public class Video
{
	private String chemin;
	
	public Video(String cheminVideo) {
		this.chemin = cheminVideo.trim();
		//Attention à la sécurité ici.
	}
	
	public String toHtml() {
		return "<iframe width=\"280\" height=\"158\" src=\""+this.chemin+"\" frameborder=\"0\" allowfullscreen></iframe>";
	}
}
