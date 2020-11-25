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
    	
    }

//    private boolean estPlacee;
	

//	public void setEstPlacee(boolean estPlacee) {
//		this.estPlacee = estPlacee;
//	}
//	public boolean estPlacee() { // J'ai enlevé l'argument TapisDeJeu tapis car il n'y qu'1 tapis
//
//    	return estPlacee;
//    	
//    }

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
    
    
//    public boolean equals(Object o) {
//    	if (o instanceof Carte) {
//    		Carte c = (Carte) o;
//    		return (this.couleur == c.couleur && this.forme == c.forme && this.estRemplie == c.estRemplie );
//    	} else {
//    	return false;
//    	}
//    }
    

       
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
