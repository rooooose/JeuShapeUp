package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;

public class VueTriangle {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueTriangle window = new VueTriangle();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public VueTriangle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Tapis triangulaire");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton case0x0 = new JButton();
		case0x0.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case0x0 = new GridBagConstraints();
		gbc_case0x0.insets = new Insets(0, 0, 5, 5);
		gbc_case0x0.gridx = 0;
		gbc_case0x0.gridy = 0;
		frame.getContentPane().add(case0x0, gbc_case0x0);
		
		JButton case1x0 = new JButton();
		case1x0.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case1x0 = new GridBagConstraints();
		gbc_case1x0.insets = new Insets(0, 0, 5, 5);
		gbc_case1x0.gridx = 0;
		gbc_case1x0.gridy = 1;
		frame.getContentPane().add(case1x0, gbc_case1x0);
		
		JButton case1x1 = new JButton();
		case1x1.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case1x1 = new GridBagConstraints();
		gbc_case1x1.insets = new Insets(0, 0, 5, 5);
		gbc_case1x1.gridx = 1;
		gbc_case1x1.gridy = 1;
		frame.getContentPane().add(case1x1, gbc_case1x1);
		
		JButton case2x0 = new JButton();
		case2x0.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case2x0 = new GridBagConstraints();
		gbc_case2x0.insets = new Insets(0, 0, 5, 5);
		gbc_case2x0.gridx = 0;
		gbc_case2x0.gridy = 2;
		frame.getContentPane().add(case2x0, gbc_case2x0);
		
		JButton case2x1 = new JButton();
		case2x1.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case2x1 = new GridBagConstraints();
		gbc_case2x1.insets = new Insets(0, 0, 5, 5);
		gbc_case2x1.gridx = 1;
		gbc_case2x1.gridy = 2;
		frame.getContentPane().add(case2x1, gbc_case2x1);
		
		JButton case2x2 = new JButton();
		case2x2.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case2x2 = new GridBagConstraints();
		gbc_case2x2.insets = new Insets(0, 0, 5, 5);
		gbc_case2x2.gridx = 2;
		gbc_case2x2.gridy = 2;
		frame.getContentPane().add(case2x2, gbc_case2x2);
		
		JButton case3x0 = new JButton();
		case3x0.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case3x0 = new GridBagConstraints();
		gbc_case3x0.insets = new Insets(0, 0, 5, 5);
		gbc_case3x0.gridx = 0;
		gbc_case3x0.gridy = 3;
		frame.getContentPane().add(case3x0, gbc_case3x0);
		
		JButton case3x1 = new JButton();
		case3x1.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case3x1 = new GridBagConstraints();
		gbc_case3x1.insets = new Insets(0, 0, 5, 5);
		gbc_case3x1.gridx = 1;
		gbc_case3x1.gridy = 3;
		frame.getContentPane().add(case3x1, gbc_case3x1);
		
		JButton case3x2 = new JButton();
		case3x2.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case3x2 = new GridBagConstraints();
		gbc_case3x2.insets = new Insets(0, 0, 5, 5);
		gbc_case3x2.gridx = 2;
		gbc_case3x2.gridy = 3;
		frame.getContentPane().add(case3x2, gbc_case3x2);
		
		JButton case3x3 = new JButton();
		case3x3.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case3x3 = new GridBagConstraints();
		gbc_case3x3.insets = new Insets(0, 0, 5, 5);
		gbc_case3x3.gridx = 3;
		gbc_case3x3.gridy = 3;
		frame.getContentPane().add(case3x3, gbc_case3x3);
		
		JButton case4x0 = new JButton();
		case4x0.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case4x0 = new GridBagConstraints();
		gbc_case4x0.insets = new Insets(0, 0, 0, 5);
		gbc_case4x0.gridx = 0;
		gbc_case4x0.gridy = 4;
		frame.getContentPane().add(case4x0, gbc_case4x0);
		
		JButton case4x1 = new JButton();
		case4x1.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case4x1 = new GridBagConstraints();
		gbc_case4x1.insets = new Insets(0, 0, 0, 5);
		gbc_case4x1.gridx = 1;
		gbc_case4x1.gridy = 4;
		frame.getContentPane().add(case4x1, gbc_case4x1);
		
		JButton case4x2 = new JButton();
		case4x2.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case4x2 = new GridBagConstraints();
		gbc_case4x2.insets = new Insets(0, 0, 0, 5);
		gbc_case4x2.gridx = 2;
		gbc_case4x2.gridy = 4;
		frame.getContentPane().add(case4x2, gbc_case4x2);
		
		JButton case4x3 = new JButton();
		case4x3.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case4x3 = new GridBagConstraints();
		gbc_case4x3.insets = new Insets(0, 0, 0, 5);
		gbc_case4x3.gridx = 3;
		gbc_case4x3.gridy = 4;
		frame.getContentPane().add(case4x3, gbc_case4x3);
		
		JButton case4x4 = new JButton();
		case4x4.setIcon(new ImageIcon(VueTriangle.class.getResource("/vue/imagesPourCartes/caseVide.png")));
		GridBagConstraints gbc_case4x4 = new GridBagConstraints();
		gbc_case4x4.gridx = 4;
		gbc_case4x4.gridy = 4;
		frame.getContentPane().add(case4x4, gbc_case4x4);
		
		frame.setVisible(true);
		frame.pack();
	}

}
