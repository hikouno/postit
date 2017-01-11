package postit;

import java.util.List;
import java.util.ArrayList;

public class Contenu
{
	private List<EltMultimedia> contenu;
	
	public Contenu() {
		this.contenu = new ArrayList<EltMultimedia>();
	}
	
	public void addElement(EltMultimedia elt){
		this.contenu.add(elt);
	}
	
	public List<EltMultimedia> getElements(){
		return this.contenu;
	}
	
	public String toHTML() {
		String html = "<div>";
		for(EltMultimedia e : contenu){
			html+=e.toHtml();
		}
		
		html += "</div>";
		
		return html;
	}
	
}
