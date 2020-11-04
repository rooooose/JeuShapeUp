package shapeUp;


public interface StrategieJoueur {
    Carte piocherCarte(Pioche pioche);

    void deplacerCarte(int ligneCase, int colonneCase, CarteJouable carte);

    void placerCarte(int ligneCase, int colonneCase, CarteJouable carte);

    CarteJouable definirCarteAJouer(Carte carte);

}
