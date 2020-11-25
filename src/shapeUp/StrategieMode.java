package shapeUp;

import java.util.List;

public interface StrategieMode {

	
    public List<Carte> distribuerCartes(Partie maPartie);

    public void voirCarteVictoire(Partie maPartie, Joueur joueur);
    
    public Pioche creerLaPiocheDeLaPartie (Partie maPartie);
    
    public void finirLaPartie (Partie maPartie);

}
