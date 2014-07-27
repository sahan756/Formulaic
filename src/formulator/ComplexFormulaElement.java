package formulator;

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;

public class ComplexFormulaElement extends FormulaElement{
	private HashMap<String, FormulaElement> storedFormulas;
	private String formulaName;
	
	public ComplexFormulaElement(String formulaName,HashMap<String, FormulaElement> storedFormulas){
		this.formulaName = formulaName;
		this.storedFormulas = storedFormulas;
		//parseComplexFormula(text);
	}
	
	public FormulaElement parseComplexFormula(String text){
		
		StringTokenizer tokenizer = new StringTokenizer(text, "+-/^()* ", true);
		//Vector<String> pass0 = new Vector<String>(); 
		Vector<Object> elements = new Vector<Object>();
		
		//Add to list with Removed white spaces and split compound tokens
		while(tokenizer.hasMoreTokens()){
			String token = tokenizer.nextToken();
			if(token.matches("\\s")) continue;
			
			elements.add(token);
		}
		return new FormulaElement();
	}
	
//	public Vector<Object> parseReferredFormulas(Vector<Object> pass0) {
//		
//	}
}
