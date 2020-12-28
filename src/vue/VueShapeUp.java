package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import controleurs.pourShapeUp.ControleurShapeUp;
import shapeUp.JoueurReel;
import shapeUp.JoueurVirtuel;
import shapeUp.Observable;
import shapeUp.Observer;
import shapeUp.ShapeUp;
import shapeUp.StrategieAvance;
import shapeUp.StrategieDeBase;
import shapeUp.StrategieMode;
import shapeUp.StrategieVictoireEnnemie;
import shapeUp.TapisCercle;
import shapeUp.TapisDeJeu;
import shapeUp.TapisRectangle;
import shapeUp.TapisTriangleRectangle;

public class VueShapeUp implements Observer {
	
	private VuePartie maPartie;
	
	public VuePartie getMaPartie() {
		return maPartie;
	}


	public void setMaPartie(VuePartie maPartie) {
		this.maPartie = maPartie;
	}


	private ShapeUp jeuShapeUp;
	
	private JFrame fenetreChoix;
	private JLabel choix;
	
	private JButton okAll;
	
	
	public JButton getOkAll() {
		return okAll;
	}


	public void setOkAll(JButton okAll) {
		this.okAll = okAll;
	}


	private JPanel containerNbre;
	private ButtonGroup choixNbre;
	private JButton okNbre;
	private JRadioButton deuxJoueurs;

	

	public JFrame getFenetreChoix() {
		return fenetreChoix;
	}


	public void setFenetreChoix(JFrame fenetreChoix) {
		this.fenetreChoix = fenetreChoix;
	}


	public JLabel getChoix() {
		return choix;
	}


	public void setChoix(JLabel choix) {
		this.choix = choix;
	}


	public JPanel getContainerNbre() {
		return containerNbre;
	}


	public void setContainerNbre(JPanel containerNbre) {
		this.containerNbre = containerNbre;
	}


	public ButtonGroup getChoixNbre() {
		return choixNbre;
	}


	public void setChoixNbre(ButtonGroup choixNbre) {
		this.choixNbre = choixNbre;
	}


	public JButton getOkNbre() {
		return okNbre;
	}


	public void setOkNbre(JButton okNbre) {
		this.okNbre = okNbre;
	}


	public JRadioButton getDeuxJoueurs() {
		return deuxJoueurs;
	}


	public void setDeuxJoueurs(JRadioButton deuxJoueurs) {
		this.deuxJoueurs = deuxJoueurs;
	}


	public JRadioButton getTroisJoueurs() {
		return troisJoueurs;
	}


	public void setTroisJoueurs(JRadioButton troisJoueurs) {
		this.troisJoueurs = troisJoueurs;
	}


	public JLabel getNbreJoueurs() {
		return nbreJoueurs;
	}


	public void setNbreJoueurs(JLabel nbreJoueurs) {
		this.nbreJoueurs = nbreJoueurs;
	}


	public JPanel getContainerType() {
		return containerType1;
	}


	public void setContainerType(JPanel containerType) {
		this.containerType1 = containerType;
	}

	public JPanel getContainerMode() {
		return containerMode;
	}


	public void setContainerMode(JPanel containerMode) {
		this.containerMode = containerMode;
	}


	public ButtonGroup getChoixMode() {
		return choixMode;
	}


	public void setChoixMode(ButtonGroup choixMode) {
		this.choixMode = choixMode;
	}


	public JButton getOkMode() {
		return okMode;
	}


	public void setOkMode(JButton okMode) {
		this.okMode = okMode;
	}


	public JRadioButton getAvance() {
		return avance;
	}


	public void setAvance(JRadioButton avance) {
		this.avance = avance;
	}


	public JRadioButton getVictoireEnnemie() {
		return victoireEnnemie;
	}


	public void setVictoireEnnemie(JRadioButton victoireEnnemie) {
		this.victoireEnnemie = victoireEnnemie;
	}


	public JRadioButton getDeBase() {
		return deBase;
	}


	public void setDeBase(JRadioButton deBase) {
		this.deBase = deBase;
	}


	public JLabel getModeDeJeu() {
		return modeDeJeu;
	}


	public void setModeDeJeu(JLabel modeDeJeu) {
		this.modeDeJeu = modeDeJeu;
	}


	public JPanel getContainerForme() {
		return containerForme;
	}


	public void setContainerForme(JPanel containerForme) {
		this.containerForme = containerForme;
	}


	public ButtonGroup getChoixForme() {
		return choixForme;
	}


	public void setChoixForme(ButtonGroup choixForme) {
		this.choixForme = choixForme;
	}


	public JButton getOkForme() {
		return okForme;
	}


	public void setOkForme(JButton okForme) {
		this.okForme = okForme;
	}


	public JRadioButton getRectangle() {
		return rectangle;
	}


	public void setRectangle(JRadioButton rectangle) {
		this.rectangle = rectangle;
	}


	public JRadioButton getTriangle() {
		return triangle;
	}


	public void setTriangle(JRadioButton triangle) {
		this.triangle = triangle;
	}


	public JRadioButton getCercle() {
		return cercle;
	}


	public void setCercle(JRadioButton cercle) {
		this.cercle = cercle;
	}


	public JLabel getFormeTapis() {
		return formeTapis;
	}


	public void setFormeTapis(JLabel formeTapis) {
		this.formeTapis = formeTapis;
	}
	
	public ShapeUp getJeuShapeUp() {
		return jeuShapeUp;
	}


	public void setJeuShapeUp(ShapeUp jeuShapeUp) {
		this.jeuShapeUp = jeuShapeUp;
	}


	public JPanel getContainerType1() {
		return containerType1;
	}


	public void setContainerType1(JPanel containerType1) {
		this.containerType1 = containerType1;
	}


	public JLabel getTypeDuJoueur1() {
		return typeDuJoueur1;
	}


	public void setTypeDuJoueur1(JLabel typeDuJoueur1) {
		this.typeDuJoueur1 = typeDuJoueur1;
	}


	public JButton getOkType1() {
		return okType1;
	}


	public void setOkType1(JButton okType1) {
		this.okType1 = okType1;
	}


	public ButtonGroup getChoixType1() {
		return choixType1;
	}


	public void setChoixType1(ButtonGroup choixType1) {
		this.choixType1 = choixType1;
	}


	public JRadioButton getVirtuel1() {
		return virtuel1;
	}


	public void setVirtuel1(JRadioButton virtuel1) {
		this.virtuel1 = virtuel1;
	}


	public JRadioButton getReel1() {
		return reel1;
	}


	public void setReel1(JRadioButton reel1) {
		this.reel1 = reel1;
	}


	public JPanel getContainerType2() {
		return containerType2;
	}


	public void setContainerType2(JPanel containerType2) {
		this.containerType2 = containerType2;
	}


	public JLabel getTypeDuJoueur2() {
		return typeDuJoueur2;
	}


	public void setTypeDuJoueur2(JLabel typeDuJoueur2) {
		this.typeDuJoueur2 = typeDuJoueur2;
	}


	public JButton getOkType2() {
		return okType2;
	}


	public void setOkType2(JButton okType2) {
		this.okType2 = okType2;
	}


	public ButtonGroup getChoixType2() {
		return choixType2;
	}


	public void setChoixType2(ButtonGroup choixType2) {
		this.choixType2 = choixType2;
	}


	public JRadioButton getVirtuel2() {
		return virtuel2;
	}


	public void setVirtuel2(JRadioButton virtuel2) {
		this.virtuel2 = virtuel2;
	}


	public JRadioButton getReel2() {
		return reel2;
	}


	public void setReel2(JRadioButton reel2) {
		this.reel2 = reel2;
	}


	public JPanel getContainerType3() {
		return containerType3;
	}


	public void setContainerType3(JPanel containerType3) {
		this.containerType3 = containerType3;
	}


	public JLabel getTypeDuJoueur3() {
		return typeDuJoueur3;
	}


	public void setTypeDuJoueur3(JLabel typeDuJoueur3) {
		this.typeDuJoueur3 = typeDuJoueur3;
	}


	public JButton getOkType3() {
		return okType3;
	}


	public void setOkType3(JButton okType3) {
		this.okType3 = okType3;
	}


	public ButtonGroup getChoixType3() {
		return choixType3;
	}


	public void setChoixType3(ButtonGroup choixType3) {
		this.choixType3 = choixType3;
	}


	public JRadioButton getVirtuel3() {
		return virtuel3;
	}


	public void setVirtuel3(JRadioButton virtuel3) {
		this.virtuel3 = virtuel3;
	}


	public JRadioButton getReel3() {
		return reel3;
	}


	public void setReel3(JRadioButton reel3) {
		this.reel3 = reel3;
	}


	public JPanel getContainerNom1() {
		return containerNom1;
	}


	public void setContainerNom1(JPanel containerNom1) {
		this.containerNom1 = containerNom1;
	}


	public JTextField getNomJoueur1() {
		return nomJoueur1;
	}


	public void setNomJoueur1(JTextField nomJoueur1) {
		this.nomJoueur1 = nomJoueur1;
	}


	public JButton getOkNom1() {
		return okNom1;
	}


	public void setOkNom1(JButton okNom1) {
		this.okNom1 = okNom1;
	}


	public JLabel getNomDuJoueur1() {
		return nomDuJoueur1;
	}


	public void setNomDuJoueur1(JLabel nomDuJoueur1) {
		this.nomDuJoueur1 = nomDuJoueur1;
	}


	public JPanel getContainerNom2() {
		return containerNom2;
	}


	public void setContainerNom2(JPanel containerNom2) {
		this.containerNom2 = containerNom2;
	}


	public JTextField getNomJoueur2() {
		return nomJoueur2;
	}


	public void setNomJoueur2(JTextField nomJoueur2) {
		this.nomJoueur2 = nomJoueur2;
	}


	public JButton getOkNom2() {
		return okNom2;
	}


	public void setOkNom2(JButton okNom2) {
		this.okNom2 = okNom2;
	}


	public JLabel getNomDuJoueur2() {
		return nomDuJoueur2;
	}


	public void setNomDuJoueur2(JLabel nomDuJoueur2) {
		this.nomDuJoueur2 = nomDuJoueur2;
	}


	public JPanel getContainerNom3() {
		return containerNom3;
	}


	public void setContainerNom3(JPanel containerNom3) {
		this.containerNom3 = containerNom3;
	}


	public JTextField getNomJoueur3() {
		return nomJoueur3;
	}


	public void setNomJoueur3(JTextField nomJoueur3) {
		this.nomJoueur3 = nomJoueur3;
	}


	public JButton getOkNom3() {
		return okNom3;
	}


	public void setOkNom3(JButton okNom3) {
		this.okNom3 = okNom3;
	}


	public JLabel getNomDuJoueur3() {
		return nomDuJoueur3;
	}


	public void setNomDuJoueur3(JLabel nomDuJoueur3) {
		this.nomDuJoueur3 = nomDuJoueur3;
	}


	public JPanel getJoueur1() {
		return joueur1;
	}


	public void setJoueur1(JPanel joueur1) {
		this.joueur1 = joueur1;
	}


	public JPanel getJoueur2() {
		return joueur2;
	}


	public void setJoueur2(JPanel joueur2) {
		this.joueur2 = joueur2;
	}


	public JPanel getJoueur3() {
		return joueur3;
	}


	public void setJoueur3(JPanel joueur3) {
		this.joueur3 = joueur3;
	}


	public JPanel getJoueurs() {
		return joueurs;
	}


	public void setJoueurs(JPanel joueurs) {
		this.joueurs = joueurs;
	}


	private JRadioButton troisJoueurs;
	private JLabel nbreJoueurs;
	
	private JPanel containerType1;
	private JLabel typeDuJoueur1;
	private JButton okType1;
	private ButtonGroup choixType1; 
	private JRadioButton virtuel1;
	private JRadioButton reel1;
	
	private JPanel containerType2;
	private JLabel typeDuJoueur2;
	private JButton okType2;
	private ButtonGroup choixType2; 
	private JRadioButton virtuel2;
	private JRadioButton reel2;
	
	private JPanel containerType3;
	private JLabel typeDuJoueur3;
	private JButton okType3;
	private ButtonGroup choixType3; 
	private JRadioButton virtuel3;
	private JRadioButton reel3;
	
	
	private JPanel containerNom1;
	private JTextField nomJoueur1;
	private JButton okNom1;
	private JLabel nomDuJoueur1;
	
	private JPanel containerNom2;
	private JTextField nomJoueur2;
	private JButton okNom2;
	private JLabel nomDuJoueur2;
	
	private JPanel containerNom3;
	private JTextField nomJoueur3;
	private JButton okNom3;
	private JLabel nomDuJoueur3;
	
	private JPanel joueur1;
	
	private JPanel joueur2;
	
	private JPanel joueur3;
	
	private JPanel joueurs;
	
	private JPanel containerMode;
	private ButtonGroup choixMode;
	private JButton okMode;
	private JRadioButton avance;
	private JRadioButton victoireEnnemie;
	private JRadioButton deBase;
	private JLabel modeDeJeu;
	
	private JPanel containerForme;
	private ButtonGroup choixForme;
	private JButton okForme;
	private JRadioButton rectangle;
	private JRadioButton triangle;
	private JRadioButton cercle;
	private JLabel formeTapis;
	
	public VueShapeUp (ShapeUp sU) {
		
		
		initialize();
		
		this.jeuShapeUp = sU;
		jeuShapeUp.addObserver(this);
		//jeuShapeUp.addObserver(this);
		
		
		
		new ControleurShapeUp (jeuShapeUp, this);
		
	}
	
	public void initialize() {
		
		fenetreChoix = new JFrame("Paramètres de jeu");
		JPanel container =(JPanel) fenetreChoix.getContentPane();
		
		choix = new JLabel ("Choix de vos paramètres de jeu :) ");
		choix.setFont(new Font("Verdana", Font.BOLD, 18));
		
		
		nbreJoueurs = new JLabel ("Choix du nombre de joueurs : ");
		choixNbre = new ButtonGroup();
		deuxJoueurs = new JRadioButton("2 joueurs");
		troisJoueurs = new JRadioButton ("3 joueurs");
		okNbre = new JButton("OK");
		okNbre.setForeground(Color.white);
		okNbre.setBackground(Color.BLACK);
		
		
		containerNbre = new JPanel();
		
		nbreJoueurs.setForeground(Color.BLUE);
		containerNbre.add(nbreJoueurs);
		

		containerNbre.add(deuxJoueurs, FlowLayout.CENTER);
		containerNbre.add(troisJoueurs);
		containerNbre.add(okNbre);
		choixNbre.add(deuxJoueurs);
		choixNbre.add(troisJoueurs);
		
		
		typeDuJoueur1 = new JLabel("Veuillez choisir le type du joueur 1");
		okType1 = new JButton(); 
		//nbreJoueurs = new JLabel ("Choix du nombre de joueurs : ");
		choixType1 = new ButtonGroup();
		virtuel1 = new JRadioButton("Virtuel");
		reel1 = new JRadioButton ("Réel");
		okType1 = new JButton("OK");
		okType1.setForeground(Color.black);
		okType1.setBackground(Color.pink);
		
		
		joueur1 = new JPanel();
		containerType1 = new JPanel();

	
		typeDuJoueur1.setForeground(Color.pink);
		containerType1.add(typeDuJoueur1);
		

		containerType1.add(virtuel1, FlowLayout.CENTER);
		containerType1.add(reel1);
		containerType1.add(okType1);
		choixType1.add(virtuel1);
		choixType1.add(reel1);
		
		
		
		nomDuJoueur1 = new JLabel("Veuillez saisir le nom du joueur 1 : ");
		okNom1 = new JButton ("OK pour ce nom");
		okNom1.setForeground(Color.black);
		okNom1.setBackground(Color.pink);
		nomJoueur1 = new JTextField();
		nomJoueur1.setColumns(10);
	
		containerNom1 = new JPanel();
		
		nomDuJoueur1.setForeground(Color.BLUE);
		containerNom1.add(nomDuJoueur1);
		containerNom1.add(nomJoueur1, FlowLayout.CENTER);
		containerNom1.add(okNom1);
		containerNom1.setVisible(false);
		
		joueur1.setLayout(new BoxLayout(joueur1, BoxLayout.Y_AXIS));
		joueur1.add(containerType1);
		joueur1.add(containerNom1);
		
		
		joueurs = new JPanel();
		
		joueurs.add(joueur1, BorderLayout.LINE_START);
		
		
		
		////////
		typeDuJoueur2 = new JLabel("Veuillez choisir le type du joueur 2");
		okType2 = new JButton(); 
		//nbreJoueurs = new JLabel ("Choix du nombre de joueurs : ");
		choixType2 = new ButtonGroup();
		virtuel2 = new JRadioButton("Virtuel");
		reel2 = new JRadioButton ("Réel");
		okType2 = new JButton("OK");
		okType2.setForeground(Color.black);
		okType2.setBackground(Color.orange);
		
		
		joueur2 = new JPanel();
		containerType2 = new JPanel();

	
		typeDuJoueur2.setForeground(Color.ORANGE);
		containerType2.add(typeDuJoueur2);
		

		containerType2.add(virtuel2, FlowLayout.CENTER);
		containerType2.add(reel2);
		containerType2.add(okType2);
		choixType2.add(virtuel2);
		choixType2.add(reel2);
		
		
		
		nomDuJoueur2 = new JLabel("Veuillez saisir le nom du joueur 2 : ");
		okNom2 = new JButton ("OK pour ce nom");
		okNom2.setForeground(Color.black);
		okNom2.setBackground(Color.orange);
		nomJoueur2 = new JTextField();
		nomJoueur2.setColumns(10);
	
		containerNom2 = new JPanel();
		
		nomDuJoueur2.setForeground(Color.BLUE);
		containerNom2.add(nomDuJoueur2);
		containerNom2.add(nomJoueur2, FlowLayout.CENTER);
		containerNom2.add(okNom2);
		containerNom2.setVisible(false);
		
		joueur2.setLayout(new BoxLayout(joueur2, BoxLayout.Y_AXIS));
		joueur2.add(containerType2);
		joueur2.add(containerNom2);
		

		
		joueurs.add(joueur2, BorderLayout.CENTER);
		
		/////
		typeDuJoueur3 = new JLabel("Veuillez choisir le type du joueur 3");
		okType3 = new JButton(); 
		//nbreJoueurs = new JLabel ("Choix du nombre de joueurs : ");
		choixType3 = new ButtonGroup();
		virtuel3 = new JRadioButton("Virtuel");
		reel3 = new JRadioButton ("Réel");
		okType3 = new JButton("OK");
		okType3.setForeground(Color.black);
		okType3.setBackground(Color.blue);
		
		
		joueur3 = new JPanel();
		containerType3 = new JPanel();

	
		typeDuJoueur3.setForeground(Color.BLUE);
		containerType3.add(typeDuJoueur3);
		

		containerType3.add(virtuel3, FlowLayout.CENTER);
		containerType3.add(reel3);
		containerType3.add(okType3);
		choixType3.add(virtuel3);
		choixType3.add(reel3);
		
		
		
		nomDuJoueur3 = new JLabel("Veuillez saisir le nom du joueur 3 : ");
		okNom3 = new JButton ("OK pour ce nom");
		okNom3.setForeground(Color.black);
		okNom3.setBackground(Color.blue);
		nomJoueur3 = new JTextField();
		nomJoueur3.setColumns(10);
	
		containerNom3 = new JPanel();
		
		nomDuJoueur3.setForeground(Color.BLUE);
		containerNom3.add(nomDuJoueur3);
		containerNom3.add(nomJoueur3, FlowLayout.CENTER);
		containerNom3.add(okNom3);
		containerNom3.setVisible(false);
		
		joueur3.setLayout(new BoxLayout(joueur3, BoxLayout.Y_AXIS));
		joueur3.add(containerType3);
		joueur3.add(containerNom3);
		

		
		joueurs.add(joueur3, BorderLayout.LINE_END);
		
		
		
		
		
		modeDeJeu = new JLabel("Choix du mode de jeu : ");
		choixMode = new ButtonGroup();
		avance = new JRadioButton("Avancé");
		victoireEnnemie = new JRadioButton("Victoire ennemie");
		deBase = new JRadioButton("Règles de base");
		okMode = new JButton("OK");
		okMode.setForeground(Color.white);
		okMode.setBackground(Color.black);
		
		containerMode = new JPanel();
		
		modeDeJeu.setForeground(Color.BLUE);
		containerMode.add(modeDeJeu);
		containerMode.add(deBase, FlowLayout.CENTER);
		containerMode.add(avance);
		containerMode.add(victoireEnnemie);
		containerMode.add(okMode);
		

		
		choixMode.add(deBase);
		choixMode.add(victoireEnnemie);
		choixMode.add(avance);
		
		containerForme = new JPanel();
		
		formeTapis = new JLabel("Choix de la forme du tapis : ");
		choixForme = new ButtonGroup();
		rectangle = new JRadioButton("Rectangle");
		triangle = new JRadioButton("Triangle rectangle");
		cercle = new JRadioButton("Disque");
		okForme = new JButton("OK");
		okForme.setForeground(Color.white);
		okForme.setBackground(Color.BLACK);
		
		formeTapis.setForeground(Color.BLUE);
		containerForme.add(formeTapis);
		containerForme.add(rectangle, FlowLayout.CENTER);
		containerForme.add(triangle);
		containerForme.add(cercle);
		containerForme.add(okForme);
		choixForme.add(rectangle);
		choixForme.add(triangle);
		choixForme.add(cercle);
		
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		//container.add(choix, BorderLayout.CENTER);
		okAll = new JButton("J'ai fini de choisir mes paramètres, je veux lancer la partie.");
		
		container.add(containerNbre);
		container.add(joueurs);
		//container.add(containerType);
		//container.add(containerNom);
		container.add(containerMode);
		container.add(containerForme);
		container.add(okAll);
		okAll.setVisible(false);
		joueurs.setVisible(false);
		fenetreChoix.setVisible(true);
		//fenetreChoix.getContentPane()
		fenetreChoix.pack();
		
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		if (this.jeuShapeUp.getNbDeJoueurs() == 2) {
			deuxJoueurs.setSelected(true);
			okNbre.doClick();
			
		}
		
		if (this.jeuShapeUp.getNbDeJoueurs() == 3) {
			troisJoueurs.setSelected(true);
			okNbre.doClick();
		}
		
		//choix des options joueurs
		Object[] noms = this.jeuShapeUp.getNomsJoueurs().toArray();
		
		if(this.jeuShapeUp.getTypes().size()==1) {
			String ty1 = this.jeuShapeUp.getTypes().get(0);
			if (ty1.equals("v")) {
				virtuel1.setSelected(true);		
						
			} else if (ty1.equals("r")) {
				reel1.setSelected(true);		
			}
			this.getContainerNom1().setVisible(true);
			
			
		}
		if(this.jeuShapeUp.getNomsJoueurs().size() == 1) {
			nomJoueur1.setText((String) noms[0]);
			okNom1.doClick();
			okType1.doClick();
		}
		
		if(this.jeuShapeUp.getTypes().size()==2) {
			String ty2 = this.jeuShapeUp.getTypes().get(1);
			
			if (ty2.equals("v")) {
				virtuel2.setSelected(true);		
						
			} else if (ty2.equals("r")) {
				reel2.setSelected(true);		
			}
			this.getContainerNom2().setVisible(true);
		}
		if(this.jeuShapeUp.getNomsJoueurs().size() == 2) {
			nomJoueur2.setText((String) noms[1]);
			okNom2.doClick();
			okType2.doClick();
		}
		
		if(this.jeuShapeUp.getTypes().size()==3) {
			String ty3 = this.jeuShapeUp.getTypes().get(2);
			if (ty3.equals("v")) {
				virtuel3.setSelected(true);		
						
			} else if (ty3.equals("r")) {
				reel3.setSelected(true);		
			}
			this.getContainerNom3().setVisible(true);
			
		}
		if(this.jeuShapeUp.getNomsJoueurs().size() == 3) {
			nomJoueur3.setText((String) noms[2]);
			okNom3.doClick();
			okType3.doClick();
		}
		
		
		//choix du mode de jeu
		if(this.jeuShapeUp.getMode() instanceof StrategieDeBase) {
			deBase.setSelected(true);
			okMode.doClick();
			
		} else if (this.jeuShapeUp.getMode() instanceof StrategieAvance) {
			avance.setSelected(true);
			okMode.doClick();
		} else if (this.jeuShapeUp.getMode() instanceof StrategieVictoireEnnemie) {
			victoireEnnemie.setSelected(true);
			okMode.doClick();
		}
		
		if (this.jeuShapeUp.getFormeTapis() instanceof TapisRectangle) {
			rectangle.setSelected(true);
			okForme.doClick();
			
		} else if (this.jeuShapeUp.getFormeTapis() instanceof TapisTriangleRectangle) {
			triangle.setSelected(true);
			okForme.doClick();
			
		} else if (this.jeuShapeUp.getFormeTapis() instanceof TapisCercle) {
			cercle.setSelected(true);
			okForme.doClick();
			
		} 
		
	}
	
    public static void main(String[] args) {
	// TODO Auto-generated method stub
    	ShapeUp jeuShapeUp = new ShapeUp();
    	
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueShapeUp test = new VueShapeUp(jeuShapeUp);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    	
    	Console console = new Console(jeuShapeUp);
//    	jeuShapeUp.addObserver(console);
//    	console.setJeuShapeUp(jeuShapeUp);
		
		
    }


}
