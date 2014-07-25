package formulator;

public class PowerFunctionElement extends FunctionElement {
	@Override
	public String toString(){
		return getArg(0).toString() + "^" + getArg(1).toString();
	}
	
	public double evaluate(){
		return Math.pow(getArg(0).evaluate(), getArg(1).evaluate());
	}
}
