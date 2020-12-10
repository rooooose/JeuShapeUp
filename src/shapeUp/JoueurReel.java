package shapeUp;

import java.util.Scanner;

public class JoueurReel extends Joueur implements StrategieJoueur{
	
	JoueurReel(String nom) {
		super(nom);
		
		// TODO Auto-generated constructor stub
	}

	/*JoueurReel(String nom) {
		super(nom);
		this.strategie = new StrategieJoueurReel();
	}*/
	
public Carte piocherCarte(Pioche pioche) {
		
		
		if (pioche.getNbreDeCartes() <0) {
		//this.notifyObservers("Aucune carte disponible dans la pioche");					
		System.out.println("Aucune carte disponible dans la pioche");
		return null;
		}else {
		
		/*//On r�cup�re les cartes de la pioche
		List<Carte> recupCartePioche = new ArrayList<Carte>(); 
    	recupCartePioche.addAll(pioche.getPioche()); */
    	
    	//On pioche une carte
		Carte cartePiochee = pioche.getPioche().poll();
		
    	
    	/*On enl�ve la carte de la pioche
    	
    	Set<Carte> transition = new HashSet();
    	transition = pioche.getPioche();
    	transition.remove(cartePiochee);
    	pioche.setPioche(transition);*/
    	
    	
    	
    	pioche.compterNbCartes(pioche.getNbreDeCartes() - 1);
    	
    	//this.notifyObservers("Vous avez pioch� une carte : ");    	
    	System.out.println("Vous avez pioch� une carte : ");
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
//    	System.out.println("Veuillez choisir une carte � d�placer :");
//    	
//    	do {
//    		ligneCase = choisirLigneCarte(tapis);
//        	colonneCase = choisirColonneCarte(tapis);
//        	
//        	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
//        		System.out.println("D�sol�e, cette case est vide");
//        	}
//    	}while(!tapis.caseRemplie(ligneCase,colonneCase));
//    	
//    	Carte carteADeplacer = tapis.getContainer().get(ligneCase).get(colonneCase);
//    	tapis.setNbCartes(tapis.getNbCartes()-1);
//    	tapis.getContainer().get(ligneCase).set(colonneCase, null);
//    	
//    	System.out.println(tapis);
//    	System.out.println("Vous avez choisi de d�placer la carte " + carteADeplacer);
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
    			//this.notifyObservers("Il faut choisir la carte � jouer dans votre main entre la carte 0, 1 ou 2.");    			
    			System.out.println("Il faut choisir la carte � jouer dans votre main entre la carte 0, 1 ou 2. ");
    		
    		index = scan.nextInt();
    		 
    		if (index != 0 && index != 1 && index != 2 ) {
    			//this.notifyObservers("Vous n'avez qu'un nombre limit� de cartes, veuillez recommencer votre choix");    			
    			System.out.println("Vous n'avez qu'un nombre limit� de cartes, veuillez recommencer votre choix");
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
		do {
			//this.notifyObservers("Veuillez choisir une ligne parmi celles disponibles");			
			System.out.println("Veuillez choisir une ligne parmi celles disponibles :");
		    nb = scan.nextInt();
		    
		}while(nb < -1 && nb > tapis.getContainer().size());
		
		if(nb == -1) {
			nb=0;
		} else if(nb == tapis.getContainer().size()) {
			nb = tapis.getContainer().size()-1;
		}
        

        return nb;
	}

	@Override
	public int choisirColonneCarte(TapisDeJeu tapis) {
		
		Scanner scan = new Scanner (System.in);
		int nb;
		
		do {
			//this.notifyObservers("Veuillez choisir une colonne parmi celles disponibles");			
			System.out.println("Veuillez choisir une colonne parmi celles disponibles :");
		    nb = scan.nextInt();
		    
		}while(nb < -1 && nb > tapis.getContainer().get(0).size());
		
		if(nb == -1) {
			nb = 0;
		} else if(nb == tapis.getContainer().get(0).size()) {
			nb = tapis.getContainer().get(0).size()-1;
		}

        return nb;
	}

	@Override
	public boolean proposerDeplacement(TapisDeJeu tapis, Joueur joueur) {
		
		Scanner scan = new Scanner (System.in);
    	char choix='p';
    		
    	do {
    		//this.notifyObservers("Souhaitez-vous d�placer une carte ? \n \t-Oui (o)\n \t-Non (n)");    		
        	System.out.println("Souhaitez-vous d�placer une carte ? \n \t-Oui (o)\n \t-Non (n)");
        	choix = scan.next().charAt(0);
    		scan.nextLine();
    			
        	if (choix!= 'o' && choix!= 'n') {
        		//this.notifyObservers("Je n'ai pas compris votre choix...");          		
    		    System.out.println("Je n'ai pas compris votre choix...");
    		}
        		
    	}while (choix!= 'o' && choix!= 'n');
        	
        if(choix == 'o') {
        	joueur.deplacerCarte(tapis);
        	return true;
        } else return false;
    		
	}
	

	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("joueur r�el");
		
		return sb.toString();
	}
}


