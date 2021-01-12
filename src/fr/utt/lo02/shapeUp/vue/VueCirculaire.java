package fr.utt.lo02.shapeUp.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VueCirculaire extends JFrame {
	
	private JButton case0x1;
	private JButton case0x2;
	private JButton case1x0;
	private JButton case1x1;
	private JButton case1x2;
	private JButton case1x3;
	private JButton case2x0;
	private JButton case2x1;
	private JButton case2x2;
	private JButton case2x3;
	private JButton case3x0;
	private JButton case3x1;
	private JButton case3x2;
	private JButton case3x3;
	private JButton case4x1;
	private JButton case4x2;
	
	public JButton getCase0x1() {
		return case0x1;
	}

	public JButton getCase0x2() {
		return case0x2;
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

	public JButton getCase3x0() {
		return case3x0;
	}

	public JButton getCase3x1() {
		return case3x1;
	}

	public JButton getCase3x2() {
		return case3x2;
	}

	public JButton getCase3x3() {
		return case3x3;
	}

	public JButton getCase4x1() {
		return case4x1;
	}

	public JButton getCase4x2() {
		return case4x2;
	}
	

	public VueCirculaire() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setBounds(100, 100, 1187, 797);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		case0x1 = new JButton();
		String name = "/fr/utt/lo02/shapeUp/vue/imagesPourCartes/caseVide.png";
		case0x1.setIcon(new ImageIcon(VueCirculaire.class.getResource(name)));
		GridBagConstraints gbc_case0x1 = new GridBagConstraints();
		gbc_case0x1.insets = new Insets(0, 0, 5, 5);
		gbc_case0x1.gridx = 1;
		gbc_case0x1.gridy = 0;
		this.getContentPane().add(case0x1, gbc_case0x1);
		
		case0x2 = new JButton();
		case0x2.setIcon(new ImageIcon(VueCirculaire.class.getResource(name)));
		GridBagConstraints gbc_case0x2 = new GridBagConstraints();
		gbc_case0x2.insets = new Insets(0, 0, 5, 5);
		gbc_case0x2.gridx = 2;
		gbc_case0x2.gridy = 0;
		this.getContentPane().add(case0x2, gbc_case0x2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 0;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		case1x0 = new JButton();
		case1x0.setIcon(new ImageIcon(VueCirculaire.class.getResource(name)));
		GridBagConstraints gbc_case1x0 = new GridBagConstraints();
		gbc_case1x0.insets = new Insets(0, 0, 5, 5);
		gbc_case1x0.gridx = 0;
		gbc_case1x0.gridy = 1;
		this.getContentPane().add(case1x0, gbc_case1x0);
		
		case1x1 = new JButton();
		case1x1.setIcon(new ImageIcon(VueCirculaire.class.getResource(name)));
		GridBagConstraints gbc_case1x1 = new GridBagConstraints();
		gbc_case1x1.insets = new Insets(0, 0, 5, 5);
		gbc_case1x1.gridx = 1;
		gbc_case1x1.gridy = 1;
		this.getContentPane().add(case1x1, gbc_case1x1);
		
		case1x2 = new JButton();
		case1x2.setIcon(new ImageIcon(VueCirculaire.class.getResource(name)));
		GridBagConstraints gbc_case1x2 = new GridBagConstraints();
		gbc_case1x2.insets = new Insets(0, 0, 5, 5);
		gbc_case1x2.gridx = 2;
		gbc_case1x2.gridy = 1;
		this.getContentPane().add(case1x2, gbc_case1x2);
		
		case1x3 = new JButton();
		case1x3.setIcon(new ImageIcon(VueCirculaire.class.getResource(name)));
		GridBagConstraints gbc_case1x3 = new GridBagConstraints();
		gbc_case1x3.insets = new Insets(0, 0, 5, 0);
		gbc_case1x3.gridx = 3;
		gbc_case1x3.gridy = 1;
		this.getContentPane().add(case1x3, gbc_case1x3);
		
		case2x0 = new JButton();
		case2x0.setIcon(new ImageIcon(VueCirculaire.class.getResource(name)));
		GridBagConstraints gbc_case2x0 = new GridBagConstraints();
		gbc_case2x0.insets = new Insets(0, 0, 5, 5);
		gbc_case2x0.gridx = 0;
		gbc_case2x0.gridy = 2;
		this.getContentPane().add(case2x0, gbc_case2x0);
		
		case2x1 = new JButton();
		case2x1.setIcon(new ImageIcon(VueCirculaire.class.getResource(name)));
		GridBagConstraints gbc_case2x1 = new GridBagConstraints();
		gbc_case2x1.insets = new Insets(0, 0, 5, 5);
		gbc_case2x1.gridx = 1;
		gbc_case2x1.gridy = 2;
		this.getContentPane().add(case2x1, gbc_case2x1);
		
		case2x2 = new JButton();
		case2x2.setIcon(new ImageIcon(VueCirculaire.class.getResource(name)));
		GridBagConstraints gbc_case2x2 = new GridBagConstraints();
		gbc_case2x2.insets = new Insets(0, 0, 5, 5);
		gbc_case2x2.gridx = 2;
		gbc_case2x2.gridy = 2;
		this.getContentPane().add(case2x2, gbc_case2x2);
		
		case2x3 = new JButton();
		case2x3.setIcon(new ImageIcon(VueCirculaire.class.getResource(name)));
		GridBagConstraints gbc_case2x3 = new GridBagConstraints();
		gbc_case2x3.insets = new Insets(0, 0, 5, 0);
		gbc_case2x3.gridx = 3;
		gbc_case2x3.gridy = 2;
		this.getContentPane().add(case2x3, gbc_case2x3);
		
		case3x0 = new JButton();
		case3x0.setIcon(new ImageIcon(VueCirculaire.class.getResource(name)));
		GridBagConstraints gbc_case3x0 = new GridBagConstraints();
		gbc_case3x0.insets = new Insets(0, 0, 5, 5);
		gbc_case3x0.gridx = 0;
		gbc_case3x0.gridy = 3;
		this.getContentPane().add(case3x0, gbc_case3x0);
		
		case3x1 = new JButton();
		case3x1.setIcon(new ImageIcon(VueCirculaire.class.getResource(name)));
		GridBagConstraints gbc_case3x1 = new GridBagConstraints();
		gbc_case3x1.insets = new Insets(0, 0, 5, 5);
		gbc_case3x1.gridx = 1;
		gbc_case3x1.gridy = 3;
		this.getContentPane().add(case3x1, gbc_case3x1);
		
		case3x2 = new JButton();
		case3x2.setIcon(new ImageIcon(VueCirculaire.class.getResource(name)));
		GridBagConstraints gbc_case3x2 = new GridBagConstraints();
		gbc_case3x2.insets = new Insets(0, 0, 5, 5);
		gbc_case3x2.gridx = 2;
		gbc_case3x2.gridy = 3;
		this.getContentPane().add(case3x2, gbc_case3x2);
		
		case3x3 = new JButton();
		case3x3.setIcon(new ImageIcon(VueCirculaire.class.getResource(name)));
		GridBagConstraints gbc_case3x3 = new GridBagConstraints();
		gbc_case3x3.insets = new Insets(0, 0, 5, 0);
		gbc_case3x3.gridx = 3;
		gbc_case3x3.gridy = 3;
		this.getContentPane().add(case3x3, gbc_case3x3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		case4x1 = new JButton();
		case4x1.setIcon(new ImageIcon(VueCirculaire.class.getResource(name)));
		GridBagConstraints gbc_case4x1 = new GridBagConstraints();
		gbc_case4x1.insets = new Insets(0, 0, 0, 5);
		gbc_case4x1.gridx = 1;
		gbc_case4x1.gridy = 4;
		this.getContentPane().add(case4x1, gbc_case4x1);
		
		case4x2 = new JButton();
		case4x2.setIcon(new ImageIcon(VueCirculaire.class.getResource(name)));
		GridBagConstraints gbc_case4x2 = new GridBagConstraints();
		gbc_case4x2.insets = new Insets(0, 0, 0, 5);
		gbc_case4x2.gridx = 2;
		gbc_case4x2.gridy = 4;
		this.getContentPane().add(case4x2, gbc_case4x2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 4;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		this.setVisible(true);
		this.pack();
	}

}
