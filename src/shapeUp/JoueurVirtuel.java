package shapeUp;


public class JoueurVirtuel extends Joueur{
	
	JoueurVirtuel(String nom) {
		super(nom);
		this.strategie = new StrategieJoueurVirtuel();
	}
	
}
