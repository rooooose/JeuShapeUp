package shapeUp;

import java.util.*;

public class StrategieJoueurReel implements StrategieJoueur {
    
	public Carte piocherCarte(Pioche pioche) {
		
		
		if (pioche.getNbreDeCartes() <0) {
		System.out.println("Aucune carte disponible dans la pioche");
		return null;
		}else {
		
		//On récupère les cartes de la pioche
		List<Carte> recupCartePioche = new ArrayList<Carte>(); 
    	recupCartePioche.addAll(pioche.getPioche()); 
    	
    	//On pioche une carte
    	Carte cartePiochee = recupCartePioche.get(0);
		
    	
    	//On enlève la carte de la pioche
    	
    	Set<Carte> transition = new HashSet();
    	transition = pioche.getPioche();
    	transition.remove(cartePiochee);
    	pioche.setPioche(transition);
    	
    	
    	
    	pioche.compterNbCartes(pioche.getNbreDeCartes() - 1);
    	
    	
    	System.out.println("Vous avez pioché une carte : ");
    	return cartePiochee;
    
		}	
    }

	/* 	public Carte piocherCarte(StrategieMode strategie) {
    	
    	
    	strategie.getPiocheDeLaPartie().compterNbCartes(pioche.getNbreDeCartes() - 1);
		return null;
    }
	 
	 
	 
	 */
    
	public void deplacerCarte(TapisDeJeu tapis) {
    	
    	int ligneCase;
    	int colonneCase;
    	System.out.println(tapis);
    	System.out.println("Veuillez choisir une carte à déplacer :");
    	
    	do {
    		ligneCase = choisirLigneCarte(tapis);
        	colonneCase = choisirColonneCarte(tapis);
        	
        	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
        		System.out.println("Désolée, cette case est vide");
        	}
    	}while(!tapis.caseRemplie(ligneCase,colonneCase));
    	
    	Carte carteADeplacer = tapis.getContainer().get(ligneCase).get(colonneCase);
    	tapis.setNbCartes(tapis.getNbCartes()-1);
    	tapis.getContainer().get(ligneCase).set(colonneCase, null);
    	
    	System.out.println(tapis);
    	System.out.println("Vous avez choisi de déplacer la carte " + carteADeplacer);
//    	carteADeplacer.setEstPlacee(false);
    	
    	this.placerCarte(carteADeplacer, tapis);
   	 
//    	carteADeplacer.setEstPlacee(true);
	}

    
    public void placerCarte(Carte carte, TapisDeJeu tapis) {
		
    	int ligneCase;
    	int colonneCase;
    	System.out.println(tapis);
    	
    	if(tapis.getNbCartes()>0) {
    		System.out.println("Les cartes doivent être adjacentes.");
    	}
    	
    	do {
    		ligneCase = choisirLigneCarte(tapis);
        	colonneCase = choisirColonneCarte(tapis);
        	
        	if(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase)) {
        		System.out.print("Désolée, cette case n'est pas disponible" + "\n");
        	}
        	
    	}while(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase));
    	
    	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
    			
    			tapis.getContainer().get(ligneCase).set(colonneCase, carte);
    			
    			//on diminue le nombre de lignes vides
//    			if(tapis.getContainer().get(ligneCase).isEmpty()) {
//    				tapis.setNbLignesVides(tapis.getNbLignesVides()-1);
//    			}
    			
    	} else if(tapis.caseRemplie(ligneCase,colonneCase)){
    		
    			System.out.println("DECALAGE POSSIBLE ");
    		    tapis.decalerCartes(ligneCase, colonneCase);
    		    
    		    //pas obligé ?
    		    //ligne.remove(colonneCase);

    		    tapis.getContainer().get(ligneCase).set(colonneCase, carte);
    			
    			//on diminue le nombre de lignes vides
//    			if(tapis.getContainer().get(ligneCase).isEmpty()) {
//    				tapis.setNbLignesVides(tapis.getNbLignesVides()-1);
//    			}
    		    
    	}

    	System.out.println(tapis);
    	tapis.setNbCartes(tapis.getNbCartes()+1);
    	System.out.println("NB CARTES : " + tapis.getNbCartes());
    	//carte.setEstPlacee(true); 
    	
    	//nbLignesVides FAUX
    	//System.out.println(tapis.getNbLignesVides());
    }
    

    public Carte definirCarteAJouer(Joueur joueur, StrategieMode modeDeJeu) {
    	
    	Carte carteAJouer;
    	
    	if (modeDeJeu instanceof StrategieDeBase || modeDeJeu instanceof StrategieVictoireEnnemie ) {
    		
    		carteAJouer = joueur.getMainDuJoueur().remove(0);
    		return carteAJouer;
    		
    	} else {
    		
    		Scanner scan = new Scanner (System.in);
    		int index = 0;
    		
    		do {
    			System.out.println("Il faut choisir la carte à jouer dans votre main entre la carte 0, 1 ou 2. ");
    		
    		index = scan.nextInt();
    		 
    		if (index != 0 && index != 1 && index != 2 ) {
    			System.out.println("Vous n'avez qu'un nombre limité de cartes, veuillez recommencer votre choix");
    		}
    	}while (index != 0 && index != 1 && index != 2 );
    		
    		int indexChoisi = index;
    		
    		carteAJouer = joueur.getMainDuJoueur().remove(indexChoisi);
    		return carteAJouer;
    	
    	}
    }

	@Override
	public int choisirLigneCarte(TapisDeJeu tapis) {
		
		Scanner scan = new Scanner (System.in);
		int nb;
        System.out.println("Veuillez choisir une ligne parmi celles disponibles :");
	    nb = scan.nextInt();

        return nb;
	}

	@Override
	public int choisirColonneCarte(TapisDeJeu tapis) {
		
		Scanner scan = new Scanner (System.in);
		int nb;
        System.out.println("Veuillez choisir une colonne parmi celles disponibles :");
	    nb = scan.nextInt();

        return nb;
	}

	@Override
	public boolean proposerDeplacement(TapisDeJeu tapis) {
		
		Scanner scan = new Scanner (System.in);
    	char choix='p';
    		
    	do {
        	System.out.println("Souhaitez-vous déplacer une carte ? \n \t-Oui (o)\n \t-Non (n)");
        	choix = scan.next().charAt(0);
    		scan.nextLine();
    			
        	if (choix!= 'o' && choix!= 'n') {
    		    System.out.println("Je n'ai pas compris votre choix...");
    		}
        		
    	}while (choix!= 'o' && choix!= 'n');
        	
        if(choix == 'o') {
        	this.deplacerCarte(tapis);
        	return true;
        } else return false;
    		
	}
	

	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("joueur réel");
		
		return sb.toString();
	}
}
