package shapeUp;



public class Carte {
    protected CouleurType couleur;

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

	public boolean isEstRemplie() {
		return estRemplie;
	}

	public void setEstRemplie(boolean estRemplie) {
		this.estRemplie = estRemplie;
	}

	protected FormeCarte forme;

    protected boolean estRemplie;

    public boolean estVisible (Joueur joueur) throws Exception {
 	throw new Exception(); // Je n'ai pas cod� cette fonction pour le moment
 	// Quand on appelle cette fonction �a va nous dire : je ne suis pas impl�ment�e (en gros)
    }
    

}
