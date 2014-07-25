package formulator;

public class SineFunctionElement extends FunctionElement{
	public SineFunctionElement(FormulaElement value){
		super.addArg(value);
	}
	
	public FormulaElement getArg(){
		return getArg(0);
	}
	
	@Override
	public String toString(){
		return "sin(" + getArg(0).toString() + ")";
	}
	
	@Override
	public void addArg(FormulaElement arg){
		//not adding to argList
	}
	
	public double evaluate(){
		return Math.sin(Math.toRadians(getArg().evaluate()));
	}
}
