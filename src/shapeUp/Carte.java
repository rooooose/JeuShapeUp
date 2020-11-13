package shapeUp;



public class Carte {
	
	//private static int nbCartes;
    protected CouleurType couleur;
    protected FormeCarte forme;
    protected boolean estRemplie;
    
    
    public Carte(CouleurType couleur, FormeCarte forme, boolean estRemplie) {
    	
    	this.setCouleur(couleur);
    	this.setForme(forme);
    	this.setEstRemplie(estRemplie);
    	//Carte.setNbCartes(Carte.getNbCartes() + 1);
    	
    }

    //Ne pas supprimer
    public Carte() {
		// TODO Auto-generated constructor stub
	}

	public CouleurType getCouleur() {
		return couleur;
	}
	public void setCouleur(CouleurType couleur) {
		this.couleur = couleur;
	}

	public FormeCarte getForme() {
		return forme;
	}
	public void setForme(FormeCarte forme) {
		this.forme = forme;
	}

	public boolean EstRemplie() {
		return estRemplie;
	}
	public void setEstRemplie(boolean estRemplie) {
		this.estRemplie = estRemplie;
	}

	/*public static int getNbCartes() {
		return nbCartes;
	}
	public static void setNbCartes(int nbCartes) {
		Carte.nbCartes = nbCartes;
	}*/

    

    public boolean estVisible (Joueur joueur) throws Exception {
 	throw new Exception(); // Je n'ai pas codé cette fonction pour le moment
 	// Quand on appelle cette fonction ça va nous dire : je ne suis pas implémentée (en gros)
    }
    
    public String toString() {
 StringBuffer sbCarte = new StringBuffer();
 sbCarte.append("Forme de la carte : " +this.forme);
 sbCarte.append(" Couleur de la carte : " +this.couleur);
 sbCarte.append(" La carte est remplie : " +this.estRemplie+ "(true -> la carte est remplie)");
 sbCarte.append("\n");
 return sbCarte.toString();
}

	
    
}
