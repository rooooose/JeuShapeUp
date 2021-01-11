package shapeUp;


/**
 * 
 * La classe Carte représente une carte du jeu ShapeUp. 
 * A chaque carte sont associés une couleur, une forme et un remplissage (ou absence de remplissage).
 * (Une carte peut etre traitée de différentes manières selon son statut : Carte de Victoire, Carte Jouable ou Carte Cachée
 * @see StrategieMode)
 *
 *@author Mathéa Z, Shir F
 *@version 1.1
 */
public class Carte {
	
	//private static int nbCartes;
	
	/**
	 * Modélise la couleur de la carte. Les valeurs possibles sont celles de l'énumération CouleurType
	 * @see CouleurType
	 */
    protected CouleurType couleur;
    
    /**
	 * Modélise la forme de la carte. Les valeurs possibles sont celles de l'énumération FormeCarte
	 * @see FormeCarte
	 */
    protected FormeCarte forme;
    
    /**
     * Modélise le remplissage de la forme de la carte.
     * Valeurs possibles : true / false
     */
    protected boolean estRemplie;
    
    /**
     * Instancie une carte, en lui associant ses attributs
     * @param couleur
     * @param forme
     * @param estRemplie
     */
    public Carte(CouleurType couleur, FormeCarte forme, boolean estRemplie) {
    	
    	this.setCouleur(couleur);
    	this.setForme(forme);
    	this.setEstRemplie(estRemplie);
    	
    }
    
    /**
     * Getter de la couleur de la carte
     * @return la couleur
     */
	public CouleurType getCouleur() {
		return couleur;
	}
	/**
	 * Setter de la couleur de la carte
	 * @param couleur
	 */
	public void setCouleur(CouleurType couleur) {
		this.couleur = couleur;
	}
	
	/**
	 * Getter de la forme de la carte
	 * @return la forme
	 */
	public FormeCarte getForme() {
		return forme;
	}
	/**
	 * Setter de la forme de la carte
	 * @param forme
	 */
	public void setForme(FormeCarte forme) {
		this.forme = forme;
	}
	
	/**
	 * Getter du remplissage de la carte
	 * @return true - si la forme de la carte est remplie
	 */
	public boolean EstRemplie() {
		return estRemplie;
	}
	/**
	 * Setter du remplissage de la carte
	 * @param estRemplie
	 */
	public void setEstRemplie(boolean estRemplie) {
		this.estRemplie = estRemplie;
	}

    /**
     * Redéfinition de la méthode toString(), qui présente la carte grâce à ses 3 attributs
     * @return le String Buffer converti en String
     */
    public String toString() {
    	
		 StringBuffer sbCarte = new StringBuffer();
		 sbCarte.append(this.forme + " ");
		 sbCarte.append(this.couleur+ " ");
		 if(this.estRemplie) {
			 sbCarte.append("rempli");
		 } else {
			 sbCarte.append("vide");
		 }
		 
		 return sbCarte.toString();
	}  
}
