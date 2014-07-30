package formulator;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

public class FormulaElement implements Serializable{
	Vector<VariableElement> variableList;
//	protected String type;
//	public String getType(){
//		return type;
//	}
//	double diffValue = 0.0000001;
//	double firstDiff = 0;
	
	public String toString() {
		return this.toString();
	}
	
	public void setVariableValue(String varName, double value) {
		this.setVariableValue(varName, value);
	}
	
	public void setVariableValue(double value) {
		this.setVariableValue(value);
	}
	
//	public void setVariableValue(FormulaElement value) {
//		this.setVariableValue(value);
//	}
	
	public double getVariableValue(String varName) {
		return this.getVariableValue(varName);
	}
	
	public boolean isFullyGrounded(){
		return this.isFullyGrounded();
	}
	
	public double evaluate(){
//		double value = this.evaluate();
//		this.firstDiff = this.evaluate(getVariableValue("x")+diffValue)-value;
//		return value;
		return this.evaluate();
	}
	
	public Vector<VariableElement> getVariableList(){
		return this.getVariableList();
	}
	
//	public double getFirstDerivative(){
//		return this.firstDiff;
//	}
	
//	public static void main(String[] args) {
////		FormulaElement formula = parseFormula("(X+2)(X-(Y^3+7)-7cos(2^X+5X))");
////		System.out.println(formula.toString());
////		
////		formula.setVariableValue("X", 2);
////		formula.setVariableValue("Y", 3);
////		
//////		Vector<FormulaElement> args0 = ((FunctionElement)formula).getArgList();
//////		
//////		for (FormulaElement formulaElement : args0) {
//////			System.out.println(formulaElement.getVariableValue("X"));
//////		}
////		System.out.println("X = " + formula.getVariableValue("X"));
////		System.out.println("Y = " + formula.getVariableValue("Y"));
////		System.out.println("isGrounded? " + formula.isFullyGrounded());
////		System.out.println("Evaluate = " + formula.evaluate());
////		
//////		System.out.println(parseFormula("2X + 7cos(2Y)").toString());
//////		System.out.println(parseFormula("cos(3X)/2^sin(X)").toString());
//////		System.out.println(parseFormula("(X+2)(X-(Y^3+7)-7cos(2^X+5x))").toString());
//////		System.out.println(parseFormula("(X+2)(Y-3)").toString());
//////		System.out.println(parseFormula("X-Y").toString());
//		
//		FormulaElement formula = parseFormula("(x+2)(x+3)(x+2)");
//		System.out.println(formula.toString());
//		formula.setVariableValue("x", 5);
//		//formula.setVariableValue("Y", 4);
//		System.out.println("Evaluate = " + formula.evaluate());
//	}
	
	public static FormulaElement parseFormula(String text){
		text = text.replaceAll("\\s", ""); //Remove all white spaces
		//String[] functionNames = {"cos", "sin"};
		StringTokenizer tokenizer = new StringTokenizer(text, "+-/^()*", true);
		Vector<String> pass0 = new Vector<String>(); 
		Vector<Object> elements = new Vector<Object>();
		
		//Add to list with Removed white spaces and split compound tokens
		while(tokenizer.hasMoreTokens()){
			String token = tokenizer.nextToken();
			//System.out.println(token);
			Vector<String> splits = splitCompund(token); //Split compound tokens e.g. 2X, 7cos
			for (String split : splits) {
				pass0.add(split);
			}
			
		}
		
		// pass 1 - create constants and variables
		elements = pass1(pass0);

		elements = parseElements(elements); //recursive parser
		
//		for (Object val : elements) {
//			System.out.println(val.getClass().toString() + "\t" + val);
//		}
		if(elements.size() > 0){
			return (FormulaElement)elements.get(0);
		} else {
			return null;
		}
	}
	
	//parse elements within brackets recursively
	public static Vector<Object> parseElements(Vector<Object> pass0) {
		String[] keywords = {"sin", "cos"};
		List<String> keywordList = Arrays.asList(keywords);
		
		Vector<Object> elements = new Vector<Object>();
		Vector<Object> subElements = new Vector<Object>();
		int level = 0, removeStart = 0, removeEnd = 0;
		boolean addElements = false, sine = false;;
		for (int i = 0; i < pass0.size(); i++) {
			Object object = pass0.get(i);
			elements.add(object);
			if(object.toString().matches("\\(")){
				level++;
				if (!addElements) {
					addElements = true;
					if(i>0 && keywordList.contains(pass0.get(i-1).toString())) sine = true;
					removeStart = sine ? elements.size() : elements.size() - 1;
					//removeStart = elements.size() - 1;
				} else {
					subElements.add(object);
				}
			} else if(object.toString().matches("\\)")){
				level--;
				if(level == 0){
					addElements = false;
					removeEnd = elements.size();
					elements.subList(removeStart, removeEnd).clear();
					elements.addAll(parseElements(subElements));
					if(sine){
						sine = false;
						elements.add(")");
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
		
		// pass 4 - add power function
		// Moved power function before mutiple, to avoid something like 3x^3 misinterpreted as (3x)^5
		elements = pass4(elements);
		
		// pass 2 - create multiple functions for constants and variables
		elements = pass2(elements);
		
		// pass 3 - create sine and cosine functions 
		// Used pass2 again to multiply something like 7cos(x)
		elements = pass3(elements);

//		// pass 4 - add power function
//		elements = pass4(elements);

		// pass 5 - divide function
		elements = pass5(elements);

		// pass 6 - plus and minus function
		elements = pass6(elements);

		// pass 7 - minus function
		//elements = pass7(elements);
		
		
		
		
//		for (Object val : elements) {
//			System.out.println(val.getClass().toString() + "\t" + val);
//		}
		
		
		return elements;
	}
	
	//Split compound tokens e.g. 2X, 7cos
	public static Vector<String> splitCompund(String text){
		Vector<String> tokens = new Vector<String>();
		if(text.matches("^(\\d+)(\\.?\\d+)?([a-zA-Z]+\\d*)$")){
			String constant = text.split("([a-zA-Z]+\\d*)$")[0];
			String variable = text.split("^(\\d+)(\\.?\\d+)?")[1];
			//System.out.println(constant);
			
			//System.out.println(variable);
			tokens.add(constant);
			tokens.add(variable);
		} else {
			tokens.add(text);
		}
		return tokens;
	}
	
	//Check if token is a word or not	
	public static boolean isWord(String token){
		String[] keywords = {"sin", "cos"};
		if(token.matches("^[^a-zA-Z]+")){
			return false;
		}
		if(Arrays.asList(keywords).contains(token)){
			return false;
		}
		return true;
	}
	
	//pass 1 - create constants and variables
	private static Vector<Object> pass1(Vector<String> list){
		Vector<Object> pass1 = new Vector<Object>();
		for (String val : list) {
			if(val.matches("^(\\d+)(\\.?\\d+)?")){
				ConstantElement constant = new ConstantElement(Double.parseDouble(val));
				pass1.add(constant);
			} else if(isWord(val)){
				VariableElement variable = new VariableElement(val);
				pass1.add(variable);
			} else {
				pass1.add(val);
			}
		}
		return pass1;
	}
	
	//pass 2 - create multiple functions for adjacent constants and variables
	private static Vector<Object> pass2(Vector<Object> list) {
		Object prevElement = null;
		Vector<Object> pass2 = new Vector<Object>();
		for (int i = 0; i < list.size(); i++) {
			Object val = list.get(i);
			if (val instanceof FormulaElement
					&& prevElement instanceof FormulaElement) {
				MultipleFunctionElement multi = new MultipleFunctionElement();
				multi.addArg((FormulaElement) prevElement);
				multi.addArg((FormulaElement) val);
				pass2.remove(pass2.size()-1);
				pass2.add(multi);
				val = multi;
			} else {
				pass2.add(val);
			}
			prevElement = val;
		}
		return pass2;
	}
	
	//pass 3 - create sine and cosine functions (Assuming simple formula element within '(' and ')')
	private static Vector<Object> pass3(Vector<Object> list) {
		Object prevElement = null;
		Vector<Object> pass3 = new Vector<Object>();
		String[] keywords = {"sin", "cos"};
		List<String> keywordList = Arrays.asList(keywords);
		boolean inBracket = false;
		for (int i = 0; i < list.size(); i++) {
			Object val = list.get(i);
			//System.out.println(val);
			if(val.toString().matches("\\(") && keywordList.contains(prevElement) && list.get(i+1) instanceof FormulaElement){
				inBracket = true;
				pass3.remove(pass3.size()-1);
				if(prevElement.toString().matches("sin")){
					SineFunctionElement sin = new SineFunctionElement((FormulaElement)list.get(i+1));
					pass3.add(sin);
				} else if(prevElement.toString().matches("cos")){
					FormulaElement elem = (FormulaElement)list.get(i+1);
					CosineFunctionElement cos = new CosineFunctionElement(elem);
					pass3.add(cos);
				}
			} else if(val.toString().matches("\\)") && inBracket){
				inBracket = false;
				continue;
			} else if(!inBracket){
				pass3.add(val);
			}
			prevElement = val;
		}
		pass3 = pass2(pass3); //apply multiple function after cosine or sine e.g 7cos(2x);
		return pass3;
	}
	
	//Pass 4 - add power function
	private static Vector<Object> pass4(Vector<Object> list) {
		Object prevElement = null;
		Vector<Object> pass4 = new Vector<Object>();
		boolean skipNext = false;
		for (int i = 0; i < list.size(); i++) {
			Object val = list.get(i);
			if(skipNext){
				skipNext = false;
				continue;
			}
			
			if(val.toString().matches("\\^") && prevElement instanceof FormulaElement){
				//System.out.println(val);
				pass4.remove(pass4.size()-1);
				skipNext = true;
				PowerFunctionElement power = new PowerFunctionElement();
				power.addArg((FormulaElement)prevElement);
				power.addArg((FormulaElement)list.get(i+1));
				pass4.add(power);
			} else {
				pass4.add(val);
			}
			prevElement = val;
		}
		return pass4;
	}
	
	//pass 5 - divide function
	private static Vector<Object> pass5(Vector<Object> list) {
		Object prevElement = null;
		Vector<Object> pass5 = new Vector<Object>();
		boolean skipNext = false;
		for (int i = 0; i < list.size(); i++) {
			Object val = list.get(i);
			if(skipNext){
				skipNext = false;
				continue;
			}
			
			if(val.toString().matches("\\/") && prevElement instanceof FormulaElement){
				//System.out.println(val);
				pass5.remove(pass5.size()-1);
				skipNext = true;
				DivideFunctionElement divide = new DivideFunctionElement();
				divide.addArg((FormulaElement)prevElement);
				divide.addArg((FormulaElement)list.get(i+1));
				pass5.add(divide);
			} else {
				pass5.add(val);
			}
			prevElement = val;
		}
		return pass5;
	}
	
	//pass 6 - plus function
	private static Vector<Object> pass6(Vector<Object> list) {
		Object prevElement = null;
		Vector<Object> pass6 = new Vector<Object>();
		boolean skipNext = false;
		for (int i = 0; i < list.size(); i++) {
			Object val = list.get(i);
			if (skipNext) {
				skipNext = false;
				continue;
			}

			if (val.toString().matches("\\+")
					&& prevElement instanceof FormulaElement) {
				// System.out.println(val);
				pass6.remove(pass6.size() - 1);
				skipNext = true;
				PlusFunctionElement plus = new PlusFunctionElement();
				plus.addArg((FormulaElement) prevElement);
				plus.addArg((FormulaElement) list.get(i + 1));
				pass6.add(plus);
				prevElement = plus;
				continue;
			} 
			else if (val.toString().matches("\\-")
					&& prevElement instanceof FormulaElement) {
				// System.out.println(val);
				pass6.remove(pass6.size() - 1);
				skipNext = true;
				MinusFunctionElement minus = new MinusFunctionElement();
				minus.addArg((FormulaElement) prevElement);
				minus.addArg((FormulaElement) list.get(i + 1));
				pass6.add(minus);
				prevElement = minus;
				continue;
			} 
			else {
				pass6.add(val);
			}
			prevElement = val;
		}
		return pass6;
	}
	
}
