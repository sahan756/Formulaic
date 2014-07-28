package formulator;

public class DivideFunctionElement extends FunctionElement {
	@Override
	public String toString() {
		String val1, val2;

		FormulaElement elem1 = getArg(0);
		FormulaElement elem2 = getArg(1);

		val1 = elem1.toString();
		val2 = elem2.toString();

		if (elem1 instanceof ConstantElement
				&& elem2 instanceof ConstantElement) {
			// if both elements are constants, divide and return result
			Double val = (((ConstantElement) elem1).getValue() / ((ConstantElement) elem2)
					.getValue());
			return val.toString();
		} else if (elem1 instanceof VariableElement
				&& elem2 instanceof VariableElement
				&& elem1.toString().equals(elem2.toString())) {
			// if both variable names are same, return 1
			return "1";
		}

		// insert parentheses if one or both arguments are plus or minus functions
		if (elem1 instanceof PlusFunctionElement
				|| elem1 instanceof MinusFunctionElement) {
			val1 = "(" + elem1.toString() + ")";
		}

		if (elem2 instanceof PlusFunctionElement
				|| elem2 instanceof MinusFunctionElement) {
			val2 = "(" + elem2.toString() + ")";
		}

		return val1 + "/" + val2;
	}
	
	public double evaluate(){
		return getArg(0).evaluate() / getArg(1).evaluate();
	}
	
}
