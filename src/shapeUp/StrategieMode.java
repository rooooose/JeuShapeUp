package shapeUp;

import java.util.List;

public interface StrategieMode {

	
    List<Carte> distribuerCartes(Partie maPartie);

    void voirCarteVictoire(Partie maPartie, Joueur joueur);
    
    Pioche creerLaPiocheDeLaPartie (Partie maPartie);
    
    void finirLaPartie (Partie maPartie);

}
