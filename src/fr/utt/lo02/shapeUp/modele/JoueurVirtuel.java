package fr.utt.lo02.shapeUp.modele;

import java.util.Random;

import fr.utt.lo02.shapeUp.vue.Console;

public class JoueurVirtuel extends Joueur implements StrategieJoueur{

	public JoueurVirtuel(String nom) {
		super(nom);
		
	}
    

    public Carte definirCarteAJouer(Joueur joueur, StrategieMode modeDeJeu) {

    	Carte carteAJouer;
    	
    	if (modeDeJeu instanceof StrategieDeBase || modeDeJeu instanceof StrategieVictoireEnnemie ) {
    		
    		carteAJouer = joueur.getMainDuJoueur().remove(0);
    		return carteAJouer;
    		
    	} else {
    		
    		int randomIndex = 0;
    		do {
    		  randomIndex = new Random().nextInt(joueur.getMainDuJoueur().size());
    		}while(joueur.getMainDuJoueur().get(randomIndex) == null);

    		carteAJouer = joueur.getMainDuJoueur().remove(randomIndex);
    		this.notifyObservers(joueur.getNom()+" a choisi la carte à jouer : " + carteAJouer);    		
    		//System.out.println(joueur.getNom()+" a choisi la carte à jouer : " + carteAJouer);
    		return carteAJouer;
    	
    	}
    	

	
    	
    }


	public int choisirLigneCarte(TapisDeJeu tapis) {
		Random rand = new Random();
		int nb;
	    nb = rand.nextInt(tapis.getContainer().size());
        return nb;
	}



	public int choisirColonneCarte(TapisDeJeu tapis) {
		
		Random rand = new Random();
		int nb;
	    nb = rand.nextInt(tapis.getContainer().get(0).size());
        return nb;
	}



	public boolean proposerDeplacement(TapisDeJeu tapis, Partie partie) {

//	   this.setLigCarteADepGUI(-1);
//	   this.setLigCarteDepGUI(-1);
       Random rand = new Random();
       int choix;
	   choix = rand.nextInt(2);
        	
       if(choix == 1) {

    	  this.notifyObservers("Le joueur souhaite déplacer une carte."); 
          //System.out.println("Le joueur souhaite déplacer une carte");
          this.deplacerCarte(tapis, partie);
          return true;
          
        } else return false;
		
	}
	
	
//	public void placerCarte(int lig, int col, Carte carteAJouer, TapisDeJeu tapis) {
//		
//    	int ligneCase;
//    	int colonneCase;
//    	this.notifyObservers(tapis);    	
//    	//System.out.println(tapis);
//    	
//    	if(tapis.getNbCartes()>0) {
//    		this.notifyObservers("Les cartes doivent être adjacentes.");    		
//    		//System.out.println("Les cartes doivent être adjacentes.");
//    	}
//    	
//    	do {
//    		ligneCase = this.choisirLigneCarte(tapis);
//        	colonneCase = this.choisirColonneCarte(tapis);
//        	
//        	if(!tapis.placementNormalPossible(ligneCase,colonneCase)) {
//        		this.notifyObservers("Désolée, cette case n'est pas disponible");        		
//        		//System.out.print("Désolée, cette case n'est pas disponible" + "\n");
//        	}
//        	if(ligneCase == lig && colonneCase == col) {
//        		this.notifyObservers("La carte était déjà placée ici" + "\n");        		
//        		//System.out.print("La carte était déjà placée ici" + "\n");
//        	}
//        	
//    	}while((!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase)) || (ligneCase == lig && colonneCase == col));
//    	
//    	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
//    			
//    			tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
//    			
//    	} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){
//    		
//    			this.notifyObservers("Décalage du tapis...");    		
//    			//System.out.println("Décalage du tapis...");
//    		    tapis.decalerCartes(ligneCase, colonneCase);
//    		    tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
//    	}
//    	this.notifyObservers(tapis);
//    	//System.out.println(tapis);
//    	tapis.setNbCartes(tapis.getNbCartes()+1);
//
//    }
//	
//	
//	public void placerCarte(Partie partie, TapisDeJeu tapis) {
//		
//    	int ligneCase;
//    	int colonneCase;
//    	Carte carteAJouer;
//    	this.notifyObservers(tapis);    	
//    	//System.out.println(tapis);
//    	
//    	if(tapis.getNbCartes()>0) {
//    		this.notifyObservers("Les cartes doivent être adjacentes.");    		
//    		//System.out.println("Les cartes doivent être adjacentes.");
//    	}
//    	this.notifyObservers("Carte(s) en main : " + this.getMainDuJoueur());    	
//    	//System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
//		carteAJouer = this.definirCarteAJouer(this, partie.getModeDeJeu());
//		partie.getModeDeJeu().voirCarteVictoire(partie, this);
//    	
//    	do {
//    		ligneCase = this.choisirLigneCarte(tapis);
//        	colonneCase = this.choisirColonneCarte(tapis);
//        	
//        	if(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase)) {
//        		this.notifyObservers("Désolée, cette case n'est pas disponible");          		
//        		//System.out.print("Désolée, cette case n'est pas disponible" + "\n");
//        	}
//        	
//    	}while(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase));
//
//    	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
//    			
//    		tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
//    			
//    	} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){
//
//    			this.notifyObservers("Décalage du tapis...");      		
//    			//System.out.println("Décalage du tapis...");
//    		    tapis.decalerCartes(ligneCase, colonneCase);
//    		    tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
//    	}
//    	this.notifyObservers(tapis);   
//    	//System.out.println(tapis);
//    	tapis.setNbCartes(tapis.getNbCartes()+1);
//
//    }
//	
//	
//	public void deplacerCarte(TapisDeJeu tapis) {
//    	
//    	int ligneCase;
//    	int colonneCase;
//    	this.notifyObservers(tapis);       	
//    	//System.out.println(tapis);
//    	this.notifyObservers("Veuillez choisir une carte à déplacer :");       	
//    	//System.out.println("Veuillez choisir une carte à déplacer :");
//    	
//    	do {
//    		ligneCase = this.choisirLigneCarte(tapis);
//        	colonneCase = this.choisirColonneCarte(tapis);
//        	
//        	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
//        		this.notifyObservers("Désolée, cette case est vide");           		
//        		//System.out.println("Désolée, cette case est vide");
//        	}
//    	}while(!tapis.caseRemplie(ligneCase,colonneCase));
//    	
//    	Carte carteADeplacer = tapis.getContainer().get(ligneCase).get(colonneCase);
//    	tapis.setNbCartes(tapis.getNbCartes()-1);
//    	tapis.getContainer().get(ligneCase).set(colonneCase, null);
//    	
//    	this.notifyObservers("Vous avez choisi de déplacer la carte " + carteADeplacer);   
//    	//System.out.println("Vous avez choisi de déplacer la carte " + carteADeplacer);
//    	
//    	this.placerCarte(ligneCase, colonneCase, carteADeplacer, tapis);
//
//	}	
	
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("- " + this.getNom() + " -> joueur virtuel" + "\n");
		
		return sb.toString();
	}
}


