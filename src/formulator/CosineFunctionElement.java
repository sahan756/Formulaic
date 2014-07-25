package formulator;

public class CosineFunctionElement extends FunctionElement{
	public CosineFunctionElement(FormulaElement value){
		super.addArg(value);
	}
	
	public FormulaElement getArg(){
		return getArg(0);
	}
	
	@Override
	public String toString(){
		return "cos(" + getArg(0).toString() + ")";
	}
	
	@Override
	public void addArg(FormulaElement arg){
		//not adding to argList
	}
	
	public double evaluate(){
		return Math.cos(Math.toRadians(getArg().evaluate()));
	}
}
