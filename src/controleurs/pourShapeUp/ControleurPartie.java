package controleurs.pourShapeUp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import shapeUp.Carte;
import shapeUp.Partie;
import shapeUp.TapisDeJeu;
import vue.Console;
import vue.VueCirculaire;
import vue.VuePartie;

public class ControleurPartie {

	public ControleurPartie(Partie p, VuePartie vuePartie) {
		
		/*vuePartie.getBoutonPioche().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vuePartie.getCarte0().setIcon(new ImageIcon(VuePartie.class.getResource("/vue/imagesPourCartes/triangleBleuRempli.png")));

			}
		});
	}*/
		if(vuePartie.getTapisDeJeu() instanceof VueCirculaire) {
			
			((VueCirculaire) vuePartie.getTapisDeJeu()).getCase0x1().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					//System.out.println(p.getJoueurActif().getMainDuJoueur());
					Carte c = p.getJoueurActif().getCarteAJouer();
					p.getJoueurActif().placerCarteGUI(0,1,p.getTapisDeJeu(),c);
					p.getJoueurActif().setLigCarteGUI(0);
				}
			});
			
		}
		
	
	
	
	}
}



