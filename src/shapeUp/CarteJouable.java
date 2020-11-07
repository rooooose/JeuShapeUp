package shapeUp;


public class CarteJouable extends Carte {
	private boolean estPlacee;
	

	public void setEstPlacee(boolean estPlacee) {
		this.estPlacee = estPlacee;
	}

	public boolean estPlacee() { // J'ai enlevé l'argument TapisDeJeu tapis car il n'y qu'1 tapis

    	return estPlacee;
    	
    }

}
