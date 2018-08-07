
public class MultivariatePoly {
	
	private PolyList firstPolyList;
	private PolyList lastPolyList;
	
	MultivariatePoly(){
		this.firstPolyList = null;
		this.lastPolyList = null;
	}
	
	/*
	 * Add Polynomial Terms in Poly List 
	 * @param   coeff - Represent coefficient
	 * @param   variable - two dimensional array, 
	 * Where first Column represent Index of variable and 
	 * Second Column represent Power of variable
	 */
	public void add(int coeff, int variable[][]) {
		PolyList polyList = new PolyList(coeff, variable);
		if(this.firstPolyList == null) {
			this.firstPolyList = polyList;
			this.lastPolyList = polyList;
		}
		else {
			this.lastPolyList.nextPolyList = polyList;
			this.lastPolyList = this.lastPolyList.nextPolyList;
		}
	}
	
	/*
	 * Print Poly List
	 */
	public void printPolyList() {
		PolyList polyList = this.firstPolyList;
		while(polyList != null) {
			System.out.print((polyList.coeff > 0? "+"+polyList.coeff : polyList.coeff));
			if(polyList.printVarList()) {
				System.out.print(" * ");
			}
			System.out.print("   ");
			polyList = polyList.nextPolyList;
		}
		System.out.println("\n");
	}
	
	/*
	 * Represent multivariate polynomials with coefficient and their corresponding variable list
	 */
	static public class PolyList {
		
		private int coeff;
		private VariableList firstTermOfVarList;
		private PolyList nextPolyList;
		
		/*
		 * @param   coeff - Represent coefficient
		 * @param   variable - two dimensional array, 
		 * Where first Column represent Index of variable and 
		 * Second Column represent Power of variable
		 */
		PolyList(int coeff, int variable[][]){
			this.coeff = coeff;
			if(variable.length != 0) {
				this.firstTermOfVarList = new VariableList(variable[0][0], variable[0][1]);
				VariableList varList = this.firstTermOfVarList;
				for(int i=1; i<variable.length; i++) {
					varList.nextVariableList = new VariableList(variable[i][0], variable[i][1]);
					varList = varList.nextVariableList;
				}
				this.nextPolyList = null;
			}
			
		}
		
		/*
		 * Print Variable list element
		 */
		public boolean printVarList() {
			VariableList varList = this.firstTermOfVarList;
			if(varList == null) {
				return false;
			}
			while(varList.nextVariableList != null) {
				System.out.print("X"+varList.variableIndex+"^"+varList.variablePower+" * ");
				varList = varList.nextVariableList;
			}
			System.out.print("X"+varList.variableIndex+"^"+varList.variablePower);
			return true;
		}
		
		/*
		 * Represent Variable from index 1 to infinite with power
		 * For Example -> X1, X2, X3, ... , Xn, ....
		 */

		static public class VariableList {
			
			private int variableIndex;
			private int variablePower;
			private VariableList nextVariableList;
			
			VariableList(int variableIndex, int variablePower){
				this.variableIndex = variableIndex;
				this.variablePower = variablePower;
				this.nextVariableList = null;
			}
		}
	}
}
