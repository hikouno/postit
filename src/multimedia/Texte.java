package multimedia;

public class Texte implements EltMultimedia
{
	private String htmlTexte;
	
	public Texte(String texte) {
		this.htmlTexte = texte;
		//StringUtils.replaceEach(htmlTexte, new String[]{"&", "\"", "<", ">"}, new String[]{"&amp;", "&quot;", "&lt;", "&gt;"});
		this.htmlTexte = this.htmlTexte.replaceAll("\n+", "<br />");
		this.htmlTexte = this.htmlTexte.replaceAll("[\n\r]+", "<br />");
	}
	
	public String toHtml() {
		return "<p>" + htmlTexte + "</p>";
	}
}
