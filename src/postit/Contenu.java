package postit;

public class Contenu
{
	private List<EltMultimedia> contenu;
	
	public Contenu() {
		this.contenu = new ArrayList<EltMultimedia>();
	}
	
	public addContenu(EltMultimedia){
		this.contenu.add(EltMultimedia);
	}
	
	public String toHTML() {
		String html;
		for(EltMultimedia e : contenu){
			html+=e.toHtml();
		}
		return html;
	}
	
}
