package fr.utt.lo02.shapeUp.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;

public class VueTapisRectangle extends JFrame {
	
	private JButton case0x0;
	private JButton case0x1;
	private JButton case0x2;
	private JButton case0x3;
	private JButton case0x4;
	private JButton case1x0;
	private JButton case1x1;
	private JButton case1x2;
	private JButton case1x3;
	private JButton case1x4;
	private JButton case2x0;
	private JButton case2x1;
	private JButton case2x2;
	private JButton case2x3;
	private JButton case2x4;
	
	public JButton getCase0x0() {
		return case0x0;
	}

	public JButton getCase0x1() {
		return case0x1;
	}

	public JButton getCase0x2() {
		return case0x2;
	}

	public JButton getCase0x3() {
		return case0x3;
	}

	public JButton getCase0x4() {
		return case0x4;
	}

	public JButton getCase1x0() {
		return case1x0;
	}

	public JButton getCase1x1() {
		return case1x1;
	}

	public JButton getCase1x2() {
		return case1x2;
	}

	public JButton getCase1x3() {
		return case1x3;
	}

	public JButton getCase1x4() {
		return case1x4;
	}

	public JButton getCase2x0() {
		return case2x0;
	}

	public JButton getCase2x1() {
		return case2x1;
	}

	public JButton getCase2x2() {
		return case2x2;
	}

	public JButton getCase2x3() {
		return case2x3;
	}

	public JButton getCase2x4() {
		return case2x4;
	}

	public VueTapisRectangle() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		
		this.setBounds(100, 100, 1211, 748);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.getContentPane().setLayout(gridBagLayout);
		
		case0x0 = new JButton();
		case0x0.setIcon(new ImageIcon(VueTapisRectangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case0x0 = new GridBagConstraints();
		gbc_case0x0.insets = new Insets(0, 0, 5, 5);
		gbc_case0x0.gridx = 0;
		gbc_case0x0.gridy = 0;
		this.getContentPane().add(case0x0, gbc_case0x0);
		
		case0x1 = new JButton();
		case0x1.setIcon(new ImageIcon(VueTapisRectangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case0x1 = new GridBagConstraints();
		gbc_case0x1.insets = new Insets(0, 0, 5, 5);
		gbc_case0x1.gridx = 1;
		gbc_case0x1.gridy = 0;
		this.getContentPane().add(case0x1, gbc_case0x1);
		
		case0x2 = new JButton();
		case0x2.setIcon(new ImageIcon(VueTapisRectangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case0x2 = new GridBagConstraints();
		gbc_case0x2.insets = new Insets(0, 0, 5, 5);
		gbc_case0x2.gridx = 2;
		gbc_case0x2.gridy = 0;
		this.getContentPane().add(case0x2, gbc_case0x2);
		
		case0x3 = new JButton();
		case0x3.setIcon(new ImageIcon(VueTapisRectangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case0x3 = new GridBagConstraints();
		gbc_case0x3.insets = new Insets(0, 0, 5, 5);
		gbc_case0x3.gridx = 3;
		gbc_case0x3.gridy = 0;
		this.getContentPane().add(case0x3, gbc_case0x3);
		
		case0x4 = new JButton();
		case0x4.setIcon(new ImageIcon(VueTapisRectangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case0x4 = new GridBagConstraints();
		gbc_case0x4.insets = new Insets(0, 0, 5, 0);
		gbc_case0x4.gridx = 4;
		gbc_case0x4.gridy = 0;
		this.getContentPane().add(case0x4, gbc_case0x4);
		
		case1x0 = new JButton();
		case1x0.setIcon(new ImageIcon(VueTapisRectangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case1x0 = new GridBagConstraints();
		gbc_case1x0.insets = new Insets(0, 0, 5, 5);
		gbc_case1x0.gridx = 0;
		gbc_case1x0.gridy = 1;
		this.getContentPane().add(case1x0, gbc_case1x0);
		
		case1x1 = new JButton();
		case1x1.setIcon(new ImageIcon(VueTapisRectangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case1x1 = new GridBagConstraints();
		gbc_case1x1.insets = new Insets(0, 0, 5, 5);
		gbc_case1x1.gridx = 1;
		gbc_case1x1.gridy = 1;
		this.getContentPane().add(case1x1, gbc_case1x1);
		
		case1x2 = new JButton();
		case1x2.setIcon(new ImageIcon(VueTapisRectangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case1x2 = new GridBagConstraints();
		gbc_case1x2.insets = new Insets(0, 0, 5, 5);
		gbc_case1x2.gridx = 2;
		gbc_case1x2.gridy = 1;
		this.getContentPane().add(case1x2, gbc_case1x2);
		
		case1x3 = new JButton();
		case1x3.setIcon(new ImageIcon(VueTapisRectangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case1x3 = new GridBagConstraints();
		gbc_case1x3.insets = new Insets(0, 0, 5, 5);
		gbc_case1x3.gridx = 3;
		gbc_case1x3.gridy = 1;
		this.getContentPane().add(case1x3, gbc_case1x3);
		
		case1x4 = new JButton();
		case1x4.setIcon(new ImageIcon(VueTapisRectangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case1x4 = new GridBagConstraints();
		gbc_case1x4.insets = new Insets(0, 0, 5, 0);
		gbc_case1x4.gridx = 4;
		gbc_case1x4.gridy = 1;
		this.getContentPane().add(case1x4, gbc_case1x4);
		
		case2x0 = new JButton();
		case2x0.setIcon(new ImageIcon(VueTapisRectangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case2x0 = new GridBagConstraints();
		gbc_case2x0.insets = new Insets(0, 0, 0, 5);
		gbc_case2x0.gridx = 0;
		gbc_case2x0.gridy = 2;
		this.getContentPane().add(case2x0, gbc_case2x0);
		
		case2x1 = new JButton();
		case2x1.setIcon(new ImageIcon(VueTapisRectangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case2x1 = new GridBagConstraints();
		gbc_case2x1.insets = new Insets(0, 0, 0, 5);
		gbc_case2x1.gridx = 1;
		gbc_case2x1.gridy = 2;
		this.getContentPane().add(case2x1, gbc_case2x1);
		
		case2x2 = new JButton();
		case2x2.setIcon(new ImageIcon(VueTapisRectangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case2x2 = new GridBagConstraints();
		gbc_case2x2.insets = new Insets(0, 0, 0, 5);
		gbc_case2x2.gridx = 2;
		gbc_case2x2.gridy = 2;
		this.getContentPane().add(case2x2, gbc_case2x2);
		
		case2x3 = new JButton();
		case2x3.setIcon(new ImageIcon(VueTapisRectangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case2x3 = new GridBagConstraints();
		gbc_case2x3.insets = new Insets(0, 0, 0, 5);
		gbc_case2x3.gridx = 3;
		gbc_case2x3.gridy = 2;
		this.getContentPane().add(case2x3, gbc_case2x3);
		
		case2x4 = new JButton();
		case2x4.setIcon(new ImageIcon(VueTapisRectangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case2x4 = new GridBagConstraints();
		gbc_case2x4.gridx = 4;
		gbc_case2x4.gridy = 2;
		this.getContentPane().add(case2x4, gbc_case2x4);
		
		this.setVisible(true);
		this.pack();
	}

}
