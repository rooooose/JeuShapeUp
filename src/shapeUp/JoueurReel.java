package shapeUp;

import java.util.Scanner;

import vue.Console;

public class JoueurReel extends Joueur implements StrategieJoueur{
	
	public JoueurReel(String nom) {
		super(nom);
		
		// TODO Auto-generated constructor stub
	}

	/*JoueurReel(String nom) {
		super(nom);
		this.strategie = new StrategieJoueurReel();
	}*/
	
public Carte piocherCarte(Pioche pioche) {
		
		
		if (pioche.getNbreDeCartes() <0) {
		this.notifyObservers("Aucune carte disponible dans la pioche");					
		//System.out.println("Aucune carte disponible dans la pioche");
		return null;
		}else {
		
		/*//On récupère les cartes de la pioche
		List<Carte> recupCartePioche = new ArrayList<Carte>(); 
    	recupCartePioche.addAll(pioche.getPioche()); */
    	
    	//On pioche une carte
		Carte cartePiochee = pioche.getPioche().poll();
		
    	
    	/*On enlève la carte de la pioche
    	
    	Set<Carte> transition = new HashSet();
    	transition = pioche.getPioche();
    	transition.remove(cartePiochee);
    	pioche.setPioche(transition);*/
    	
    	
    	
    	pioche.compterNbCartes(pioche.getNbreDeCartes() - 1);
    	
    	this.notifyObservers("Vous avez pioché une carte : ");    	
    	//System.out.println("Vous avez pioché une carte : ");
    	return cartePiochee;
    
		}	
    }

	/* 	public Carte piocherCarte(StrategieMode strategie) {
    	
    	
    	strategie.getPiocheDeLaPartie().compterNbCartes(pioche.getNbreDeCartes() - 1);
		return null;
    }
	 
	 
	 
	 */
    
//	public void deplacerCarte(TapisDeJeu tapis) {
//    	
//    	int ligneCase;
//    	int colonneCase;
//    	System.out.println(tapis);
//    	System.out.println("Veuillez choisir une carte à déplacer :");
//    	
//    	do {
//    		ligneCase = choisirLigneCarte(tapis);
//        	colonneCase = choisirColonneCarte(tapis);
//        	
//        	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
//        		System.out.println("Désolée, cette case est vide");
//        	}
//    	}while(!tapis.caseRemplie(ligneCase,colonneCase));
//    	
//    	Carte carteADeplacer = tapis.getContainer().get(ligneCase).get(colonneCase);
//    	tapis.setNbCartes(tapis.getNbCartes()-1);
//    	tapis.getContainer().get(ligneCase).set(colonneCase, null);
//    	
//    	System.out.println(tapis);
//    	System.out.println("Vous avez choisi de déplacer la carte " + carteADeplacer);
////    	carteADeplacer.setEstPlacee(false);
//    	
//    	this.placerCarte(carteADeplacer, tapis);
//   	 
////    	carteADeplacer.setEstPlacee(true);
//	}

    
    
    

    public Carte definirCarteAJouer(Joueur joueur, StrategieMode modeDeJeu) {
    	
    	Carte carteAJouer;
    	
    	if (modeDeJeu instanceof StrategieDeBase || modeDeJeu instanceof StrategieVictoireEnnemie ) {
    		
    		carteAJouer = joueur.getMainDuJoueur().remove(0);
    		return carteAJouer;
    		
    	} else {
    		
    		Scanner scan = new Scanner (System.in);
    		int index = 0;
    		
    		do {
    			this.notifyObservers("Il faut choisir la carte à jouer dans votre main entre la carte 0, 1 ou 2.");    			
    			//System.out.println("Il faut choisir la carte à jouer dans votre main entre la carte 0, 1 ou 2. ");
    		
    		index = scan.nextInt();
    		 
    		if (index != 0 && index != 1 && index != 2 ) {
    			this.notifyObservers("Vous n'avez qu'un nombre limité de cartes, veuillez recommencer votre choix");    			
    			//System.out.println("Vous n'avez qu'un nombre limité de cartes, veuillez recommencer votre choix");
    		}
    	}while (index != 0 && index != 1 && index != 2 );
    		
    		int indexChoisi = index;
    		
    		carteAJouer = joueur.getMainDuJoueur().remove(indexChoisi);
    		return carteAJouer;
    	
    	}
    }


	public int choisirLigneCarte(TapisDeJeu tapis) {
		
		Scanner scan = new Scanner (System.in);
		int nb;
		do {
			this.notifyObservers("Veuillez choisir une ligne parmi celles disponibles");			
			//System.out.println("Veuillez choisir une ligne parmi celles disponibles :");
		    nb = scan.nextInt();
		    
		}while(nb < -1 && nb > tapis.getContainer().size());
		
		if(nb == -1) {
			nb=0;
		} else if(nb == tapis.getContainer().size()) {
			nb = tapis.getContainer().size()-1;
		}
        

        return nb;
	}


	public int choisirColonneCarte(TapisDeJeu tapis) {
		
		Scanner scan = new Scanner (System.in);
		int nb;
		
		do {
			this.notifyObservers("Veuillez choisir une colonne parmi celles disponibles");			
			//System.out.println("Veuillez choisir une colonne parmi celles disponibles :");
		    nb = scan.nextInt();
		    
		}while(nb < -1 && nb > tapis.getContainer().get(0).size());
		
		if(nb == -1) {
			nb = 0;
		} else if(nb == tapis.getContainer().get(0).size()) {
			nb = tapis.getContainer().get(0).size()-1;
		}

        return nb;
	}


	public boolean proposerDeplacement(TapisDeJeu tapis) {
		
		Scanner scan = new Scanner (System.in);
    	char choix='p';
    		
    	do {
    		this.notifyObservers("Souhaitez-vous déplacer une carte ? \n \t-Oui (o)\n \t-Non (n)");    		
        	//System.out.println("Souhaitez-vous déplacer une carte ? \n \t-Oui (o)\n \t-Non (n)");
        	choix = scan.next().charAt(0);
    		scan.nextLine();
    			
        	if (choix!= 'o' && choix!= 'n') {
        		this.notifyObservers("Je n'ai pas compris votre choix...");          		
    		    //System.out.println("Je n'ai pas compris votre choix...");
    		}
        		
    	}while (choix!= 'o' && choix!= 'n');
        	
        if(choix == 'o') {
        	this.deplacerCarte(tapis);
        	return true;
        } else return false;
    		
	}
	
	
//	public void jouer(Partie partie, TapisDeJeu tapis, Pioche pioche, StrategieMode modeDeJeu) {
//		
//		//this.addObserver(partie.getConsoleDuJeu());
//		Carte cartePiochee;
//		Carte carteAJouer;
//		
//		if(modeDeJeu instanceof StrategieDeBase || modeDeJeu instanceof StrategieVictoireEnnemie) {
//			
//			cartePiochee = this.piocherCarte(pioche);
//			this.getMainDuJoueur().add(cartePiochee);
//			//this.notifyObservers(cartePiochee);
//			System.out.println(cartePiochee);
//			//System.out.println(pioche);
//		}
//		
//    	if(tapis.getNbCartes()>1 && tapis.getNbCartes()<partie.getNbCartesJouables()) {
//    		
//    		boolean deplacementFait = this.proposerDeplacement(tapis);
//    		
////    		System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
////    		carteAJouer = this.strategie.definirCarteAJouer(this,partie.getModeDeJeu());
////    		modeDeJeu.voirCarteVictoire(partie, this);
//    		this.placerCarte(partie, tapis);
//    		
//    		if(!deplacementFait) {
//    			this.proposerDeplacement(tapis);
//    		}
//    		
//    	} else {
////        	System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
////    		carteAJouer = this.strategie.definirCarteAJouer(this,partie.getModeDeJeu());
////    		modeDeJeu.voirCarteVictoire(partie, this);
//    		//this.strategie.placerCarte(carteAJouer, tapis);
//    		this.placerCarte(partie, tapis);
//    	}
//    	
//    	if(modeDeJeu instanceof StrategieAvance) {
//    		
//			cartePiochee = this.piocherCarte(pioche);
//			this.getMainDuJoueur().add(cartePiochee);
//			//this.notifyObservers(cartePiochee);
//			System.out.println(cartePiochee);
//		}
//    }

	
	public void placerCarte(int lig, int col, Carte carteAJouer, TapisDeJeu tapis) {
		
    	int ligneCase;
    	int colonneCase;
    	this.notifyObservers(tapis);    	
    	//System.out.println(tapis);
    	
    	if(tapis.getNbCartes()>0) {
    		this.notifyObservers("Les cartes doivent être adjacentes.");    		
    		//System.out.println("Les cartes doivent être adjacentes.");
    	}
    	
    	do {
    		ligneCase = this.choisirLigneCarte(tapis);
        	colonneCase = this.choisirColonneCarte(tapis);
        	
        	if(!tapis.placementNormalPossible(ligneCase,colonneCase)) {
        		this.notifyObservers("Désolée, cette case n'est pas disponible" + "\n");        		
        		//System.out.print("Désolée, cette case n'est pas disponible" + "\n");
        	}
        	if(ligneCase == lig && colonneCase == col) {
        		this.notifyObservers("La carte était déjà placée ici" + "\n");        		
        		//System.out.print("La carte était déjà placée ici" + "\n");
        	}
        	
    	}while((!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase)) || (ligneCase == lig && colonneCase == col));
    	
    	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
    			
    			tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    			
    	} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){
    		
    			this.notifyObservers("Décalage du tapis...");    		
    			//System.out.println("Décalage du tapis...");
    		    tapis.decalerCartes(ligneCase, colonneCase);
    		    tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    	}
    	this.notifyObservers(tapis);
    	//System.out.println(tapis);
    	tapis.setNbCartes(tapis.getNbCartes()+1);

    }
	
	
	public void placerCarte(Partie partie, TapisDeJeu tapis) {
		
    	int ligneCase;
    	int colonneCase;
    	Carte carteAJouer;
    	this.notifyObservers(tapis);    	
    	//System.out.println(tapis);
    	
    	if(tapis.getNbCartes()>0) {
    		this.notifyObservers("Les cartes doivent être adjacentes.");    		
    		//System.out.println("Les cartes doivent être adjacentes.");
    	}
    	this.notifyObservers("Carte(s) en main : " + this.getMainDuJoueur());    	
    	//System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
		carteAJouer = this.definirCarteAJouer(this, partie.getModeDeJeu());
		partie.getModeDeJeu().voirCarteVictoire(partie, this);
    	
    	do {
    		ligneCase = this.choisirLigneCarte(tapis);
        	colonneCase = this.choisirColonneCarte(tapis);
        	
        	if(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase)) {
        		this.notifyObservers("Désolée, cette n'est pas disponible" + "\n");          		
        		//System.out.print("Désolée, cette case n'est pas disponible" + "\n");
        	}
        	
    	}while(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase));

    	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
    			
    		tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    			
    	} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){

    			this.notifyObservers("Décalage du tapis...");      		
    			//System.out.println("Décalage du tapis...");
    		    tapis.decalerCartes(ligneCase, colonneCase);
    		    tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    	}
    	this.notifyObservers(tapis);   
    	//System.out.println(tapis);
    	tapis.setNbCartes(tapis.getNbCartes()+1);

    }
	
	
	public void deplacerCarte(TapisDeJeu tapis) {
    	
    	int ligneCase;
    	int colonneCase;
    	this.notifyObservers(tapis);       	
    	//System.out.println(tapis);
    	this.notifyObservers("Veuillez choisir une carte à déplacer :");       	
    	//System.out.println("Veuillez choisir une carte à déplacer :");
    	
    	do {
    		ligneCase = this.choisirLigneCarte(tapis);
        	colonneCase = this.choisirColonneCarte(tapis);
        	
        	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
        		this.notifyObservers("Désolée, cette case est vide");           		
        		//System.out.println("Désolée, cette case est vide");
        	}
    	}while(!tapis.caseRemplie(ligneCase,colonneCase));
    	
    	Carte carteADeplacer = tapis.getContainer().get(ligneCase).get(colonneCase);
    	tapis.setNbCartes(tapis.getNbCartes()-1);
    	tapis.getContainer().get(ligneCase).set(colonneCase, null);
    	
    	this.notifyObservers("Vous avez choisi de déplacer la carte " + carteADeplacer);   
    	//System.out.println("Vous avez choisi de déplacer la carte " + carteADeplacer);
    	
    	this.placerCarte(ligneCase, colonneCase, carteADeplacer, tapis);

	}	
	

	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("- " + this.getNom() + " -> joueur réel" + "\n");
		
		return sb.toString();
	}
}


