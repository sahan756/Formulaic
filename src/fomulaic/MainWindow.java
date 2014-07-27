package fomulaic;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.GridLayout;

import javax.swing.JTextField;

import formulator.FormulaElement;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollBar;

import java.awt.ScrollPane;
import java.text.Normalizer.Form;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JScrollPane;

//import jdk.nashorn.internal.scripts.JO;




import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainWindow {
	
	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	
	private Storage storage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		try{
//			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//		} catch(Exception e){
//			e.printStackTrace();
//		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		storage = new Storage();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(179, 6, 265, 150);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setAutoscrolls(false);
		textArea.setRows(6);
		textArea.setColumns(10);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					onClickAdd();
				}
			}
		});
		textField.setBounds(6, 6, 164, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickAdd();
			}
		});
		btnNewButton.setBounds(95, 46, 75, 29);
		frame.getContentPane().add(btnNewButton);
	}
	
	private void onClickAdd(){
		//textArea.setText(FormulaElement.parseFormula(textField.getText()).toString());
//		if(parseCommand())
//			textArea.append(textField.getText()+"\n");
		if(parseCommand()){
			textField.setText("");
		}
		printStoredFormulas();
	}
	
	private boolean parseCommand(){
		String text = textField.getText();
		boolean addFormula = false, appendFormula = false, appendValue = false;
		String trimmedText = text.replaceAll("\\s", ""); // Remove all white
															// spaces

		if (trimmedText.matches("^\\w=[^=]+$")) { // check for string with
													// character followed by '='
													// followed by any character
													// or digit other than '='
			String[] comps = text.split("=");
			// FormulaElement formula = FormulaElement.parseFormula(comps[1]);
			if (storage.getStoredFormulas().containsKey(comps[0])) {
				String message = "There's already a formula assigned to '"
						+ comps[0] + "'.\nWould you like to replace?";
				// Object[] options = {"Yes", "No"};
				int response = JOptionPane.showOptionDialog(frame, message,
						"Formula replace", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, null, null);

				if (response == JOptionPane.YES_OPTION) {
					addFormula = true;
				}
			} else {
				addFormula = true;
			}

			if (addFormula) {
				storage.addFormula(comps[0],
						FormulaElement.parseFormula(comps[1]));
				textArea.append(textField.getText() + "\n");
			}
		} else if(text.matches("^eval\\s[a-zA-Z]$")){
			String[] comps = text.split("\\s");
			FormulaElement elem = storage.getStoredFormulas().get(comps[1]);
			if(elem.isFullyGrounded())
				textArea.append(comps[1] + " = " + elem.evaluate() + "\n");
			else{
				textField.setText("Not grounded");
				return false;
			}
		} else {

			// new test with tokenizer
			StringTokenizer tokenizer = new StringTokenizer(text, "+-/^()*= ",
					true);
			String prevToken = "", formName = "", formulaText = "", varValueText = "", varName = "";
			int i = 0, action = 0, level = 0;
			while (tokenizer.hasMoreTokens()) {

				String token = tokenizer.nextToken();
				if (token.matches("\\s")) {
					continue;
				}
				i++;
				// if(token.matches("=") && prevToken.matches("\\w") && i==2){
				// formName = prevToken;
				// //FormulaElement formula =
				// FormulaElement.parseFormula(comps[1]);
				// action = KeyValues.COMMAND_ASSIGN_FORMULA;
				// appendFormula = true;
				// } else if(appendFormula) {
				// formulaText += token;
				// }

				if (token.matches("\\(") && prevToken.matches("\\w")
						&& prevToken.length() == 1 && i == 2) {
					if (storage.getStoredFormulas().containsKey(prevToken)) {
						// level++;
						appendValue = true;
						varName = prevToken;
					}
				} else if (appendValue) {
					if (token.matches("\\)")) {
						assignVariableValue(varName, varValueText);
						appendValue = false;
						varValueText = "";
					} else if (token.matches("^[a-zA-Z]$")
							&& varValueText.length() > 0) {
						assignVariableValue(varName, varValueText);
						// varName = token;
						varValueText = token;
					} else {
						varValueText += token;
					}
				}
				prevToken = token;
			}
		}
//		switch (action) {
//		case KeyValues.COMMAND_ASSIGN_FORMULA:
//			if(storage.getStoredFormulas().containsKey(formName)){
//				String message = "There's already a formula assigned to '" + formName + "'.\nWould you like to replace?";
//				//Object[] options = {"Yes", "No"};
//				int response = JOptionPane.showOptionDialog(frame, message, "Formula replace", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
//				
//				if(response == JOptionPane.YES_OPTION){
//					addFormula = true;
//				}
//			} else {
//				addFormula = true;
//			}
//			
//			if(addFormula){
//				//storage.addFormula(varName, formulaText);
//				storage.addFormula(formName, FormulaElement.parseFormula(formulaText));
//				textArea.append(textField.getText()+"\n");
//			}
//			break;
//			
//		default:
//			break;
//		}
		
		
		
		return true;
	}
	
	private void assignVariableValue(String formName, String valueText){
		try {
			FormulaElement element = storage.getStoredFormulas().get(formName);
			if(valueText.matches("^\\w=[\\d\\.]+$")){
				String[] comp = valueText.split("=");
				double value = Double.valueOf(comp[1]);
				element.setVariableValue(comp[0], value);
				System.out.println(comp[0] + " = " + element.getVariableValue(comp[0]));
			} else if(valueText.matches("^[\\d\\.]+$")){
				double value = Double.valueOf(valueText);
				element.setVariableValue(value);
				System.out.println("Value for "+ formName + " set to " + value);
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	private boolean reuseAvailable(String text){
//		StringTokenizer tokenizer = new StringTokenizer(text, "+-/^()*", true);
//		String prevToken = "";
//		while(tokenizer.hasMoreTokens()){
//			String token = tokenizer.nextToken();
//			if(token.matches("(") && prev)
//		}
//	}
	
	private void printStoredFormulas(){
//		for (Map.Entry<String, String> entry : storage.getStoredFormulas().entrySet()) {
//		    String key = entry.getKey();
//		    Object value = entry.getValue();
//		    System.out.println("name: " + key + " formula: " + value);
//		}
		for (Map.Entry<String, FormulaElement> entry : storage.getStoredFormulas().entrySet()) {
		    String key = entry.getKey();
		    Object value = entry.getValue();
		    System.out.println("name: " + key + " formula: " + value.toString());
		}
	}
}
