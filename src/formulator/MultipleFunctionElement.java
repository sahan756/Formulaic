package formulator;

public class MultipleFunctionElement extends FunctionElement{
	@Override
	public String toString(){
		FormulaElement elem1, elem2;
		String val1, val2;
		//shift variable element as 2nd arg
		if(getArg(0) instanceof VariableElement){
			elem1 = getArg(1);
			elem2 = getArg(0);
		} else {
			elem1 = getArg(0);
			elem2 = getArg(1);
		} 
		
		val1 = elem1.toString();
		val2 = elem2.toString();
		
		//multiply and output result if both are constants
		if(elem1 instanceof ConstantElement && elem2 instanceof ConstantElement){
			//if both elements are constants, multiply and return result 
			Double val = (((ConstantElement)elem1).getValue()*((ConstantElement)elem2).getValue());
			return val.toString();
		} 
		
		// insert parentheses if one or both arguments are plus or minus functions
		if(elem1 instanceof PlusFunctionElement || elem1 instanceof MinusFunctionElement){
			val1 = "(" + elem1.toString() + ")";
		}
		
		if(elem2 instanceof PlusFunctionElement || elem2 instanceof MinusFunctionElement){
			val2 = "(" + elem2.toString() + ")";
		}
		
		return val1 + "" + val2;
	}
	
	public double evaluate(){
		return getArg(0).evaluate() * getArg(1).evaluate();
	}
}
