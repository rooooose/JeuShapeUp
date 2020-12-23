package shapeUp;

import java.util.*;

import vue.Console;
import vue.VueShapeUp;

public class ShapeUp extends Observable {

//		private Console consoleDuJeu;
//	    public Console getConsoleDuJeu() {
//			return consoleDuJeu;
//		}
//
//		public void setConsoleDuJeu(Console consoleDuJeu) {
//			this.consoleDuJeu = consoleDuJeu;
//		}
		
		Queue<Joueur> queueJoueurs = new LinkedList<Joueur>();



		public Queue<Joueur> getQueueJoueurs() {
			return queueJoueurs;
		}

		public void setQueueJoueurs(Queue<Joueur> queueJoueurs) {
			this.queueJoueurs = queueJoueurs;
		}

		private Partie maPartie;
	    public Partie getMaPartie() {
			return maPartie;
		}

		public void setMaPartie(Partie maPartie) {
			this.maPartie = maPartie;
		}

	    private Set<String> nomsJoueurs = new HashSet<String>();
	    public Set<String> getNomsJoueurs() {
			return nomsJoueurs;
		}

		public void setNomsJoueurs(Set<String> nomsJoueurs) {
			this.nomsJoueurs = nomsJoueurs;
		}
	    
		private int nbDeJoueurs;
		
		public int getNbDeJoueurs() {
			return nbDeJoueurs;
		}

		public void setNbDeJoueurs(int nbDeJoueurs) {
			this.nbDeJoueurs = nbDeJoueurs;
			this.notifyObservers(nbDeJoueurs);
		}
		
		private TapisDeJeu formeTapis;
		
		private StrategieMode mode;
		
	    public TapisDeJeu getFormeTapis() {
			return formeTapis;
		}

		public void setFormeTapis(TapisDeJeu formeTapis) {
			this.formeTapis = formeTapis;
			
		}

		public StrategieMode getMode() {
			return mode;
		}

		public void setMode(StrategieMode mode) {
			this.mode = mode;
			
		}

		public ShapeUp() {
	    	
	    	//this.addObserver(console);
//	    	this.consoleDuJeu = new Console();
//	    	this.addObserver(this.consoleDuJeu);
	    	
	    	//int nbJoueurs = this.choisirNbJoueurs();
	    	
	    	//this.lancerLaPartie(this.creerJoueurs(nbJoueurs), this.choisirMode(), this.choisirFormeTapis(), this.consoleDuJeu);
	    	//this.lancerLaPartie(this.creerJoueurs(nbJoueurs), this.choisirMode(), this.choisirFormeTapis());
//	    	this.notifyObservers("Jeu ShapeUp créé\n");
	    	//System.out.print("Jeu ShapeUp créé\n");
	    }
	    
	    public String toString() {
	    	StringBuffer sb = new StringBuffer();
	    	sb.append(this.maPartie);
			return sb.toString();
	    }
	    

	    
	    public void lancerLaPartie(Queue<Joueur> queueJoueurs, StrategieMode mode, TapisDeJeu forme) {
	    	
	    	this.maPartie = new Partie(queueJoueurs, mode, forme);
	    }
	    
	    public void creerJoueur(char ty, String nm) {
	    	
	    	char type= ty;
	    	String nom = nm;

//        	type = ty;
//        	nom = nm;
        			
        	switch(type) {
	        	case 'v' :
	        		JoueurVirtuel nouveauJoueurV = new JoueurVirtuel(nom);
	        		this.getNomsJoueurs().add(nom);
	        		this.queueJoueurs.add(nouveauJoueurV);
	        		this.notifyObservers(nouveauJoueurV);
	        		break;
	        		//return nouveauJoueurV;
	        	case 'r' :
	        		JoueurReel nouveauJoueurR = new JoueurReel(nom);
	        		this.getNomsJoueurs().add(nom);
	        		this.queueJoueurs.add(nouveauJoueurR);
	        		this.notifyObservers(nouveauJoueurR);
	        		break;
	        		//return nouveauJoueurR;
//	        	default :
//	        		return null;
        	}

			
	    	
	    }


//	    public Queue<Joueur> creerJoueurs(int nbJoueurs) {
//	    	
//	    	char type='r';
//	    	String nom;
//	    	nomsJoueurs = new HashSet<String>();
//	    	Queue<Joueur> queueJoueurs = new LinkedList<Joueur>();
//        		
//        		for(int i=1; i<=nbJoueurs; i++) {
//        			
//        			//définition des types des joueurs
//        			type = definirTypeJoueur(i);
//        			
//        			//définition des noms  des joueurs
//        			nom = definirNomJoueur(i);
//        			
//        			switch(type) {
//	        			case 'v' :
//	        				//JoueurVirtuel nouveauJoueurV = new JoueurVirtuel(nom, this.consoleDuJeu);
//	        				JoueurVirtuel nouveauJoueurV = new JoueurVirtuel(nom);
//	        				//System.out.println("Nom du joueur " + i + ": " + nouveauJoueurV.getNom());
//
//	        				queueJoueurs.add(nouveauJoueurV);
//	        				nomsJoueurs.add(nom);
//	        				break;
//	        			case 'r' :
//	        				//JoueurReel nouveauJoueurR = new JoueurReel(nom, this.consoleDuJeu);
//	        				JoueurReel nouveauJoueurR = new JoueurReel(nom);
//	        				//System.out.println("Nom du joueur " + i + ": " + nouveauJoueurR.getNom());
////	        				nouveauJoueurR.addObserver(consoleDuJeu);
//	        				queueJoueurs.add(nouveauJoueurR);
//	        				nomsJoueurs.add(nom);
//	        				break;
////	        			default :
////	        				//this.notifyObservers("Aucun joueur créé");
////	        				System.out.println("Aucun joueur créé");
////	        				break;
//	        				
//        			}
//        		
//    			}
//			return queueJoueurs;
//	    	
//	    }
	    

//	    public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//	    	
//	    	ShapeUp jeuShapeUp = new ShapeUp();
//			
////			jeuShapeUp.notifyObservers(jeuShapeUp);
////			//System.out.println(jeuShapeUp);
////			
////			while(!jeuShapeUp.getMaPartie().isEstFinie()) {
////				jeuShapeUp.getMaPartie().tourDeJeu();
////			}
////			//System.out.println("Partie finie !"+"\n");
////			jeuShapeUp.getMaPartie().getModeDeJeu().finirLaPartie(jeuShapeUp.getMaPartie());
////			
//			VueShapeUp test = new VueShapeUp(jeuShapeUp);
//	    }

}
