package shapeUp;



public class Carte {
    protected CouleurType couleur;
    protected FormeCarte forme;
    protected boolean estRemplie;
    

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

	

    

    public boolean estVisible (Joueur joueur) throws Exception {
 	throw new Exception(); // Je n'ai pas codé cette fonction pour le moment
 	// Quand on appelle cette fonction ça va nous dire : je ne suis pas implémentée (en gros)
    }
    
    public String toString() {
 StringBuffer sbCarte = new StringBuffer();
 sbCarte.append("Forme de la carte : " +this.forme);
 sbCarte.append("Couleur de la carte : " +this.couleur);
 sbCarte.append("La carte est remplie : " +this.estRemplie+ "(true -> la carte est remplie)");
 return sbCarte.toString();
}
    
}
