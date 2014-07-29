package formulator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

public class ComplexFormulaElement extends FormulaElement{
	private HashMap<String, FormulaElement> storedFormulas;
	private String formulaName;
	
	public ComplexFormulaElement(HashMap<String, FormulaElement> storedFormulas){
		this.storedFormulas = storedFormulas;
		//parseComplexFormula(text);
	}
	
	public ComplexFormulaElement(String formulaName,HashMap<String, FormulaElement> storedFormulas){
		this.formulaName = formulaName;
		this.storedFormulas = storedFormulas;
		//parseComplexFormula(text);
	}
	
	public FormulaElement parseComplexFormula(String text){
		
		StringTokenizer tokenizer = new StringTokenizer(text, "+-/^()* ", true);
		Vector<String> pass0 = new Vector<String>(); 
		Vector<Object> elements = new Vector<Object>();
		
		//Add to list with Removed white spaces and split compound tokens
		while(tokenizer.hasMoreTokens()){
			String token = tokenizer.nextToken();
			if(token.matches("\\s")) continue;
			
			//elements.add(token);
			Vector<String> splits = splitCompund(token); //Split compound tokens e.g. 2X, 7cos
			for (String split : splits) {
				pass0.add(split);
			}
		}
		
		elements = pass1(pass0);
		
		elements = parseReferredFormulas(elements);
		
		if(elements.size() > 0){
			return (FormulaElement)elements.get(0);
		} else {
			return null;
		}
		
		//return new FormulaElement();
	}
	
	//pass 1 - create constants and variables
	private Vector<Object> pass1(Vector<String> list) {
		Vector<Object> pass1 = new Vector<Object>();
		for (String val : list) {
			if (val.matches("^(\\d+)(\\.?\\d+)?")) {
				ConstantElement constant = new ConstantElement(
						Double.parseDouble(val));
				pass1.add(constant);
			} else if (isWord(val) && !storedFormulas.containsKey(val)) {
				VariableElement variable = new VariableElement(val);
				pass1.add(variable);
			} else {
				pass1.add(val);
			}
		}
		return pass1;
	}
	
	public Vector<Object> parseReferredFormulas(Vector<Object> elems) {
		String[] keywords = {"sin", "cos"};
		List<String> keywordList = Arrays.asList(keywords);
		
		Vector<Object> elements = new Vector<Object>();
		Vector<Object> subElements = new Vector<Object>();
		int level = 0, removeStart = 0, removeEnd = 0;
		boolean addElements = false, sine = false;
		String formulaName = "";
		for (int i = 0; i < elems.size(); i++) {
			Object object = elems.get(i);
			elements.add(object);
			if(object.toString().matches("\\(")){
				level++;
				if (!addElements) {
					if(i>0 && elems.get(i-1) instanceof String && !keywordList.contains(elems.get(i-1).toString()) && storedFormulas.containsKey(elems.get(i-1).toString())){ 
						addElements = true;
						formulaName = elems.get(i-1).toString();
					}
					removeStart = elements.size() - 2;
					//removeStart = elements.size() - 1;
				} else {
					subElements.add(object);
				}
			} else if(object.toString().matches("\\)")){
				level--;
				if(level == 0){
					if (addElements) {
						addElements = false;
						removeEnd = elements.size();
						elements.subList(removeStart, removeEnd).clear();
						// elements.addAll(parseElements(subElements));
						FormulaElement formula = storedFormulas
								.get(formulaName);
						if (formula != null) {
							FormulaElement assign = null;
							ComplexFormulaElement c = new ComplexFormulaElement(storedFormulas);
							assign = (FormulaElement)c.parseReferredFormulas(subElements).get(0);
							//FormulaElement assign = (FormulaElement) parseElements(subElements).get(0);

							ReferenceFormulaElement ref = new ReferenceFormulaElement(
									formulaName, this, assign);
							elements.add(ref);
						}
					}
					subElements.clear();
					//break;
				} else {
					subElements.add(object);
				}
			} else if(addElements){
				subElements.add(object);
			} 
			
			
		}
		
		elements = FormulaElement.parseElements(elements);
		
		return elements;
	}
	
	public FormulaElement getStoredFormula(String formulaName){
		return storedFormulas.get(formulaName);
	}
}
