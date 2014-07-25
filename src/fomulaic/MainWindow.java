package fomulaic;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JTextArea;

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
import java.util.Map;

import javax.swing.JScrollPane;

public class MainWindow {
	
	private Storage storage;
	
	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		if(parseCommand())
			textArea.append(textField.getText()+"\n");
		printStoredFormulas();
	}
	
	private boolean parseCommand(){
		String text = textField.getText();
		text = text.replaceAll("\\s", ""); //Remove all white spaces
		if(text.matches("^\\w=[^=]+$")){
			String[] comps = text.split("=");
			//FormulaElement formula = FormulaElement.parseFormula(comps[1]);
			storage.addFormula(comps[0], comps[1]);
			
		}
		return true;
	}
	
	private void printStoredFormulas(){
		for (Map.Entry<String, String> entry : storage.getStoredFormulas().entrySet()) {
		    String key = entry.getKey();
		    Object value = entry.getValue();
		    System.out.println("name: " + key + " formula: " + value);
		}
	}
}
