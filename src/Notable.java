import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

import utilisateur.Membre;

/** Amélioration possible : ne pas recalculer la note à chaque fois*/
public abstract class Notable
{
	public enum Vote { PLUS_1, MOINS_1 };
	
	private HashMap<Membre, Vote> votes;
	private int note;
	
	public Notable() {
		this.votes = new HashMap<Membre, Vote>();
		this.note = 0;
	}
	
	/** Noter ou changer note */
	public void noter(Membre membre, Vote vote) {
		this.votes.put(membre, vote);
	}
	
	public void annulerNote(Membre membre) {
		this.votes.remove(membre);
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
			
			Vote vote = (Vote) pair.getValue();
			if (vote == Vote.PLUS_1) {
				note++;
			} else {
				note --;
			}
			it.remove();
		}
		
		return note;
	}
}
