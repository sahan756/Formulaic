package fomulaic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		try {	
            // UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            // UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            // UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");      
         //   UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");   
         //   UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		//	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");	
	
			
            new MainWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			
		    EventQueue.invokeLater(new Runnable() {
			public void run() {				
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Fromulaic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 337, 112);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFormula = new JLabel("Formula ");
		lblFormula.setFont(new Font("Cambria", Font.BOLD, 12));
		lblFormula.setBounds(10, 14, 54, 14);
		panel.add(lblFormula);
		
		textField = new JTextField();
		textField.setBounds(61, 9, 266, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblResult = new JLabel("Result ");
		lblResult.setFont(new Font("Cambria", Font.BOLD, 12));
		lblResult.setBounds(10, 44, 54, 14);
		panel.add(lblResult);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(61, 39, 266, 27);
		panel.add(textField_1);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(115, 77, 64, 23);
		panel.add(btnLoad);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(189, 77, 64, 23);
		panel.add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(263, 77, 64, 23);
		panel.add(btnClear);
		
		JButton btnEvaluate = new JButton("Evaluate");
		btnEvaluate.setBounds(20, 77, 85, 23);
		panel.add(btnEvaluate);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 238, 337, 243);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("7");
		btnNewButton.setBounds(10, 11, 41, 25);
		panel_1.add(btnNewButton);
		
		JButton button = new JButton("8");
		button.setBounds(61, 11, 41, 25);
		panel_1.add(button);
		
		JButton button_1 = new JButton("9");
		button_1.setBounds(112, 11, 41, 25);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("4");
		button_2.setBounds(10, 47, 41, 25);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("5");
		button_3.setBounds(61, 47, 41, 25);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("6");
		button_4.setBounds(112, 47, 41, 25);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("1");
		button_5.setBounds(10, 83, 41, 25);
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("2");
		button_6.setBounds(61, 83, 41, 25);
		panel_1.add(button_6);
		
		JButton button_7 = new JButton("3");
		button_7.setBounds(112, 83, 41, 25);
		panel_1.add(button_7);
		
		JButton button_8 = new JButton("7");
		button_8.setBounds(10, 119, 41, 25);
		panel_1.add(button_8);
		
		JButton button_9 = new JButton(".");
		button_9.setBounds(61, 119, 41, 25);
		panel_1.add(button_9);
		
		JButton button_10 = new JButton("=");
		button_10.setBounds(112, 119, 41, 25);
		panel_1.add(button_10);
		
		JButton btnNewButton_1 = new JButton("Sin");
		btnNewButton_1.setBounds(170, 12, 55, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnCos = new JButton("cos");
		btnCos.setBounds(170, 48, 55, 23);
		panel_1.add(btnCos);
		
		JButton btnTan = new JButton("tan");
		btnTan.setBounds(170, 84, 55, 23);
		panel_1.add(btnTan);
		
		JButton button_11 = new JButton("+");
		button_11.setBounds(235, 12, 41, 25);
		panel_1.add(button_11);
		
		JButton button_12 = new JButton("-");
		button_12.setBounds(286, 12, 41, 25);
		panel_1.add(button_12);
		
		JButton button_13 = new JButton("*");
		button_13.setBounds(235, 48, 41, 25);
		panel_1.add(button_13);
		
		JButton button_14 = new JButton("/");
		button_14.setBounds(286, 48, 41, 25);
		panel_1.add(button_14);
		
		JButton button_15 = new JButton("(");
		button_15.setBounds(235, 84, 41, 25);
		panel_1.add(button_15);
		
		JButton button_16 = new JButton(")");
		button_16.setBounds(286, 84, 41, 25);
		panel_1.add(button_16);
		
		JButton button_17 = new JButton("^");
		button_17.setBounds(170, 120, 55, 23);
		panel_1.add(button_17);
		
		JButton btnX = new JButton("X");
		btnX.setPreferredSize(new Dimension(45, 23));
		btnX.setBounds(10, 172, 45, 25);
		panel_1.add(btnX);
		
		JButton btnA = new JButton("A");
		btnA.setBounds(10, 208, 45, 25);
		panel_1.add(btnA);
		
		JButton btnY = new JButton("Y");
		btnY.setPreferredSize(new Dimension(45, 23));
		btnY.setBounds(61, 173, 45, 25);
		panel_1.add(btnY);
		
		JButton btnB = new JButton("B");
		btnB.setPreferredSize(new Dimension(45, 23));
		btnB.setBounds(61, 209, 45, 25);
		panel_1.add(btnB);
		
		JButton btnZ = new JButton("Z");
		btnZ.setPreferredSize(new Dimension(45, 23));
		btnZ.setBounds(112, 173, 45, 25);
		panel_1.add(btnZ);
		
		JButton btnC = new JButton("C");
		btnC.setPreferredSize(new Dimension(45, 23));
		btnC.setBounds(112, 209, 45, 25);
		panel_1.add(btnC);
		
		JButton btnI = new JButton("I");
		btnI.setBounds(184, 172, 45, 25);
		panel_1.add(btnI);
		
		JButton btnJ = new JButton("J");
		btnJ.setBounds(235, 172, 45, 25);
		panel_1.add(btnJ);
		
		JButton btnK = new JButton("K");
		btnK.setBounds(286, 172, 45, 25);
		panel_1.add(btnK);
		
		JSeparator separator = new JSeparator();
		separator.setOpaque(true);
		separator.setBounds(10, 155, 317, 2);
		panel_1.add(separator);
		
		JButton btnL = new JButton("L");
		btnL.setBounds(184, 209, 45, 25);
		panel_1.add(btnL);
		
		JButton btnM = new JButton("M");
		btnM.setBounds(235, 209, 45, 25);
		panel_1.add(btnM);
		
		JButton btnN = new JButton("N");
		btnN.setBounds(286, 209, 45, 25);
		panel_1.add(btnN);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(357, 11, 297, 112);
		panel_2.setName("");
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblFormulaList = new JLabel("Formula List");
		lblFormulaList.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 11));
		lblFormulaList.setBounds(10, 11, 70, 14);
		panel_2.add(lblFormulaList);
		
		JList list = 	new JList();
		list.setBounds(171, 14, 0, 0);
		list.setValueIsAdjusting(true);
		panel_2.add(list);
		
		JButton btnNew = new JButton("New");
		btnNew.setBounds(198, 7, 89, 23);
		panel_2.add(btnNew);
		
		JButton btnUse = new JButton("Use");
		btnUse.setBounds(198, 41, 89, 23);
		panel_2.add(btnUse);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(198, 75, 89, 23);
		panel_2.add(btnEdit);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(357, 238, 297, 243);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblX = new JLabel("X = ");
		lblX.setBounds(28, 14, 33, 14);
		panel_3.add(lblX);
		
		textField_2 = new JTextField();
		textField_2.setBounds(74, 11, 45, 20);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblY = new JLabel("Y = ");
		lblY.setBounds(28, 53, 33, 14);
		panel_3.add(lblY);
		
		textField_3 = new JTextField();
		textField_3.setBounds(74, 50, 45, 20);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblZ = new JLabel("Z = ");
		lblZ.setBounds(28, 89, 33, 14);
		panel_3.add(lblZ);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(74, 86, 45, 20);
		panel_3.add(textField_4);
		
		JLabel lblA = new JLabel("A = ");
		lblA.setBounds(28, 140, 33, 14);
		panel_3.add(lblA);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(74, 137, 45, 20);
		panel_3.add(textField_5);
		
		JLabel lblC = new JLabel("C =");
		lblC.setBounds(28, 221, 33, 14);
		panel_3.add(lblC);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(74, 215, 45, 20);
		panel_3.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(74, 177, 45, 20);
		panel_3.add(textField_7);
		
		JLabel lblB = new JLabel("B =");
		lblB.setBounds(28, 180, 33, 14);
		panel_3.add(lblB);
		
		JLabel lblI = new JLabel("I = ");
		lblI.setBounds(173, 11, 36, 14);
		panel_3.add(lblI);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(219, 8, 45, 20);
		panel_3.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(219, 47, 45, 20);
		panel_3.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(219, 83, 45, 20);
		panel_3.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(219, 134, 45, 20);
		panel_3.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(219, 174, 45, 20);
		panel_3.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(219, 212, 45, 20);
		panel_3.add(textField_13);
		
		JLabel lblJ = new JLabel("J = ");
		lblJ.setBounds(173, 50, 36, 14);
		panel_3.add(lblJ);
		
		JLabel lblK = new JLabel("K = ");
		lblK.setBounds(173, 86, 36, 14);
		panel_3.add(lblK);
		
		JLabel lblL = new JLabel("L = ");
		lblL.setBounds(173, 137, 36, 14);
		panel_3.add(lblL);
		
		JLabel lblM = new JLabel("M = ");
		lblM.setBounds(173, 177, 36, 14);
		panel_3.add(lblM);
		
		JLabel lblN = new JLabel("N = ");
		lblN.setBounds(173, 218, 36, 14);
		panel_3.add(lblN);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(10, 134, 337, 99);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		textField_15 = new JTextField();
		textField_15.setBounds(132, 36, 195, 20);
		textField_15.setColumns(10);
		panel_4.add(textField_15);
		
		textField_14 = new JTextField();
		textField_14.setBounds(132, 67, 195, 20);
		panel_4.add(textField_14);
		textField_14.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(132, 11, 195, 20);
		panel_4.add(textField_16);
		
		JLabel lblStDerivative = new JLabel("1 st Derivative");
		lblStDerivative.setBounds(10, 14, 112, 14);
		panel_4.add(lblStDerivative);
		
		JLabel lblNdDerivative = new JLabel("2 nd Derivative");
		lblNdDerivative.setBounds(10, 39, 112, 14);
		panel_4.add(lblNdDerivative);
		
		JLabel lblSymbolicDifferentiation = new JLabel("Symbolic Differentiation");
		lblSymbolicDifferentiation.setBounds(10, 70, 127, 14);
		panel_4.add(lblSymbolicDifferentiation);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.setBounds(357, 134, 297, 99);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JCheckBox chckbxFromula = new JCheckBox("Fromula");
		chckbxFromula.setVerticalTextPosition(SwingConstants.BOTTOM);
		chckbxFromula.setVerticalAlignment(SwingConstants.BOTTOM);
		chckbxFromula.setBounds(168, 7, 110, 23);
		panel_5.add(chckbxFromula);
		
		JCheckBox chckbxStDerivative = new JCheckBox("1 st Derivative");
		chckbxStDerivative.setBounds(6, 8, 147, 23);
		panel_5.add(chckbxStDerivative);
		
		JCheckBox chckbxNdDerivative = new JCheckBox("2 nd Derivative");
		chckbxNdDerivative.setBounds(6, 34, 147, 23);
		panel_5.add(chckbxNdDerivative);
		
		JButton btnDrawGraph = new JButton("Draw Graph");
		btnDrawGraph.setBounds(6, 65, 110, 23);
		panel_5.add(btnDrawGraph);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.setBounds(138, 64, 63, 23);
		panel_5.add(btnSave_1);
		
		JButton btnLoad_1 = new JButton("Load");
		btnLoad_1.setBounds(215, 65, 63, 23);
		panel_5.add(btnLoad_1);
		

	}
}
