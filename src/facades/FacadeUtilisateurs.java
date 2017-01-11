package facades;

import java.util.HashMap;

import javax.ejb.Singleton;

import utilisateur.*;

@Singleton
public class FacadeUtilisateurs 
{
	private Integer nbUsers = new Integer(0); //nombre courrant d'utilisateurs enregistrés
	private HashMap<String, Membre> listeMembres = new HashMap<String, Membre> ();
	
	public Integer getNbUsers() {
		return nbUsers;
	}
	public void setNbUsers(Integer nbUsers) {
		this.nbUsers = nbUsers;
	}
	public HashMap<String, Membre> getListeMembres() {
		return listeMembres;
	}
	public void setListeMembres(HashMap<String, Membre> listeMembres) {
		this.listeMembres = listeMembres;
	}
	
	private Integer generateIdMembre()
	{
		return this.nbUsers+1;
	}
	
	private void enregistrerMembre(Membre mb)
	{
		this.listeMembres.put(mb.getPseudo(), mb);
		this.nbUsers+=1;
	}
	
	
	public void ajouterMembre(String nom, String prenoms, String pseudo, String password)
	{
		Integer id = this.generateIdMembre();
		Membre newMb = new Membre(pseudo);
		newMb.setId(id);
		newMb.setNom(nom);
		newMb.setPrenoms(prenoms);
		newMb.setPassword(password);;
		this.enregistrerMembre(newMb);
	}
	
	public Membre checkMembre(String pseudo, String mdp)
	{
		Membre mb = null;
		
		mb = this.listeMembres.get(pseudo);
		if(mb != null)
		{
			String passwd = mb.getPassword();
			if(!passwd.equals(mdp))
				mb = null;
		}
		
		return mb;
		
	}
	
	
	
	
}
