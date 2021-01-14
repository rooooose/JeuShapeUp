package fr.utt.lo02.shapeUp.modele;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import fr.utt.lo02.shapeUp.vue.Console;

/**
 * 
 * Repr�sente un joueur r�el du jeu ShapeUp qui peut interagir avec le programme via une classe de flux d'entr�e
 * Il peut �tre actif (en train de jouer) ou non.
 * 
 * @see Joueur
 *
 * @author Math�a Z, Shir F
 */
public class JoueurReel extends Joueur implements StrategieJoueur{
	
	/**
	 * Instancie un nouveau joueur r�el en appelant le constructeur de la classe m�re
	 * @param nom - le nom du joueur
	 * 
	 */
	public JoueurReel(String nom) {
		super(nom);
	}

    /**
     * Permet au joueur de d�finir sa carte � placer, dans sa main.
     * @param joueur - lui-m�me
     * @param modeDeJeu - le mode de la partie en cours (Victoire Ennemie, Avanc�, Base)
     * @return la carte choisie pour �tre plac�e - Parmi celles pr�sentes dans la main du joueur
     * 
     * @exception NullPointerException - Si tout ou partie des param�tres sont null
     * 
     * Si le mode de jeu est le mode avanc�, le joueur va choisir manuellement sa carte entre 0 1 et 2, qui sera retir�e de sa main.
     * Sinon, on prend la seule carte disponible dans la main, � l'index 0.
     */
    public Carte definirCarteAJouer(Joueur joueur, StrategieMode modeDeJeu) {
    	
    	Carte carteAJouer;
    	
    	if (modeDeJeu instanceof StrategieDeBase || modeDeJeu instanceof StrategieVictoireEnnemie ) {
    		
    		carteAJouer = joueur.getMainDuJoueur().remove(0);
    		return carteAJouer;
    		
    	} else {
    		
    		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    		String resultat = ""; 
    		int index = 0;
    		
    		do {
    			this.notifyObservers("Il faut choisir la carte � jouer dans votre main entre la carte 0, 1 ou 2.");    			
    	
    			 try {
    					resultat = br.readLine();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			    if(this.getNumCarteGUI() != -1) {
    			    	index = this.getNumCarteGUI();
    			    	//System.out.println("NB : "+ nb);
    			    } else {
    					index = Integer.parseInt(resultat);
    				}
    			
    		if (index != 0 && index != 1 && index != 2 ) {
    			this.notifyObservers("Vous n'avez qu'un nombre limit� de cartes, veuillez recommencer votre choix");    			
    		}
    	}while (index != 0 && index != 1 && index != 2 );
    		
    		int indexChoisi = index;
    		
    		carteAJouer = joueur.getMainDuJoueur().remove(indexChoisi);
    		return carteAJouer;
    	
    	}
    }

    /**
     * Permet au joueur de choisir une ligne de destination pour une carte � placer ou d�placer, ou une ligne pour r�cup�rer une carte du tapis.
     * @param tapis
     * @return la ligne choisie, un entier
     * @exception NullPointerException - Si le tapis est null
     * 
     * Un buffered Reader lit le num�ro de ligne entr� (ou transmis par l'interface graphique), qui est directement converti en entier. Tant que la ligne n'est pas valide, on r�it�re la demande.
     * Une ligne est valide si elle est comprise entre -1 et le nombre de lignes du tapis.
     * Entrer l'une des 2 valeurs aux bornes de l'intervalle signifie que l'on veut d�caler le tapis. 
     * Elles seront directement converties pour consid�rer que -1 = 0 et tapis.size() = tapis.size()-1
     */
	public int choisirLigneCarte(TapisDeJeu tapis) {
		
		if(this.isDeplacementEnCours()) {
			this.setLigCarteDepGUI(-1);
		}
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String resultat = "";
		int nb = 0;
		do {
			this.notifyObservers("Veuillez choisir une ligne parmi celles disponibles");			
		    try {
				resultat = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    if(this.getLigCarteGUI() != -1) {
		    	nb = this.getLigCarteGUI();
		    	
		    } else if(this.getLigCarteADepGUI() != -1) {
		    	nb = this.getLigCarteADepGUI();
		    	
		    } else if(this.getLigCarteDepGUI() != -1) {
		    	nb = this.getLigCarteDepGUI();
		    	
		    }
		    if(!resultat.equals("")) {
		    	nb= Integer.parseInt(resultat);
		    }
			
		}while(nb < -1 && nb > tapis.getContainer().size());
		
		if(nb == -1) {
			nb=0;
		} else if(nb == tapis.getContainer().size()) {
			nb = tapis.getContainer().size()-1;
		}
       
        return nb;
	}

	/**
     * Permet au joueur de choisir une colonne de destination pour une carte � placer ou d�placer, ou une colonne pour r�cup�rer une carte du tapis.
     * @param tapis
     * @return la colonne choisie, un entier
     * @exception NullPointerException - Si le tapis est null
     * 
     * Un buffered Reader lit le num�ro de colonne entr�, qui est directement converti en entier. Tant que la colonne n'est pas valide, on r�it�re la demande.
     * Une colonne est valide si elle est comprise entre -1 et le nombre de colonnes du tapis.
     * Entrer l'une des 2 valeurs aux bornes de l'intervalle signifie que l'on veut d�caler le tapis. 
     * Elles seront directement converties pour consid�rer que -1 = 0 et tapis.getContainer().get(0).size() = tapis.getContainer().get(0).size()-1
     */
	public int choisirColonneCarte(TapisDeJeu tapis) {
		
		Scanner scan = new Scanner (System.in);
		int nb;
		
		do {
			this.notifyObservers("Veuillez choisir une colonne parmi celles disponibles");			
		    nb = scan.nextInt();
		    
		}while(nb < -1 && nb > tapis.getContainer().get(0).size());
		
		if(nb == -1) {
			nb = 0;
		} else if(nb == tapis.getContainer().get(0).size()) {
			nb = tapis.getContainer().get(0).size()-1;
		}

        return nb;
	}

	/**
	 * Propose au joueur de d�placer une carte.
	 * @param tapis
	 * @param partie
	 * @return la r�ponse de l'utilisateur : true/false
	 * 
	 * @exception NullPointerException - Si tout ou partie des param�tres sont null
	 * 
	 * On demande au joueur s'il souhaite d�placer une carte gr�ce � un scanner. Il doit entrer 'o' ou 'n'.
	 * Si 'o', on appelle deplacerCarte() d�finie dans la classe m�re.
	 */
	public boolean proposerDeplacement(TapisDeJeu tapis, Partie partie) {
		
		this.setLigCarteADepGUI(-1);
		Scanner scan = new Scanner (System.in);
    	char choix='p';
    		
    	do {
    		this.notifyObservers("Souhaitez-vous d�placer une carte ? \n \t-Oui (o)\n \t-Non (n)");    		
        	choix = scan.next().charAt(0);
    		scan.nextLine();
    			
        	if (choix!= 'o' && choix!= 'n') {
        		this.notifyObservers("Je n'ai pas compris votre choix...");          		
    		}
        		
    	}while (choix!= 'o' && choix!= 'n');
        	
        if(choix == 'o') {
        	this.setDeplacementPossible(true);
        	this.deplacerCarte(tapis, partie);
        	return true;
        } else return false;
    		
	}
	
	/**
     * Red�finition de la m�thode toString(), qui pr�sente le joueur par son nom et son type
     * @return le String Buffer converti en String
     */
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("- " + this.getNom() + " -> joueur r�el" + "\n");
		
		return sb.toString();
	}
}


