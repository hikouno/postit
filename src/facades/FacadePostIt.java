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
		this.postits = new HashMap<Integer, PostIt>();
		this.currentId = 0;
	}
	
	public void ajouterPostIt(PostIt postit) {
		this.postits.put(new Integer(this.currentId++), postit);
	}
	
	public PostIt getPostItById(Integer id) {
		return this.postits.get(id);
	}
	
	public HashMap<Integer, PostIt> getPostIts() {
		return postits;
	}
}
