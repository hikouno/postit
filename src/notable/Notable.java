package notable;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import utilisateur.Membre;

/** Amélioration possible : ne pas recalculer la note à chaque fois. */
public abstract class Notable
{
	public enum Vote { PLUS_1, MOINS_1 };
	
	private HashMap<Membre, Vote> votes;
	
	public Notable() {
		this.votes = new HashMap<Membre, Vote>();
	}
	
	/** Noter ou changer note */
	public void noter(Membre membre, Vote vote) {
		this.votes.put(membre, vote);
	}
	
	public void annulerVote(Membre membre) {
		this.votes.remove(membre);
	}
	
	public boolean aVote(Membre membre) {
		return this.votes.containsKey(membre);
	}
	
	public Vote getNoteDUnMembre(Membre membre) {
		return this.votes.get(membre);
	}
	
	public HashMap<Membre, Vote> getNoteurs() {
		return this.votes;
	}

	public int getNote() {
		int note = 0;
		
		//Parcours des notes
		Iterator it = this.votes.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			System.out.println((Membre)pair.getKey() + " a voté");
			Vote vote = (Vote) pair.getValue();
			if (vote == Vote.PLUS_1) {
				note++;
			} else {
				note --;
			}
		}
		
		return note;
	}
}
