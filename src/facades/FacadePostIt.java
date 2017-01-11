package facades;

import java.util.HashMap;

import javax.ejb.Singleton;

import postit.*;

@Singleton
public class FacadePostIt
{
	private HashMap<Integer, PostIt> postits;
	private int currentId;
	
	public FacadePostIt() {
		this.listePostIts = new HashMap<Integer, PostIt>();
		this.currentId = 0;
	}
	
	public void ajouterPostIt(PostIt postit) {
		this.listePostIts.put(new Integer(this.currentId++), postit);
	}
	
	public PostIt getPostItById(int id) {
		return this.listePostIts.get(new Integer(id));
	}
	
	public HashMap<Integer, PostIt> getPostIts() {
		return listePostIts;
	}
}
