package dp_solver;

/**
 *
 * @author Kevin Dittmar
 */
public class DP_solver
{

	Formula formula;

	// Read the provided input formula
	void readFormula ( String fileName ) 
        {
		// Stub
		formula = null;
		
	}

	// Returns true if the formula has an empty clause, false otherwise
	boolean hasEmptyClause ( Formula f ) 
        {
		return f.hasEmptyClause();
	}
	
	// Returns true if the formula has no clauses left, false otherwise
	boolean isEmpty ( Formula f ) 
        {
		return f.isEmpty();
	}
	
	// Return branch variable.
	int selectBranchVar ( Formula f ) 
        {
		// Stub
		return 0;
	}
	
	// Set given variable to given true/false value
	// Variable value may be positive or negative
	void setVar ( int var, Formula f, boolean tf) 
        {
		// Stub
		
	}
	
	// Set given variable to "unassigned" in the given formula
	void unset ( int var, Formula f) 
        {
		// Stub
		
	}

	// Formula is satisfiable
	void success (Formula f) {
		// Stub		
		System.out.println ( "Formula is satisfiable");
		
		// Print satisfying assignment
			
	}
	
	// Formula is unsatisfiable
	void failure (Formula f) {
		// Stub		
		System.out.println ("Formula is unsatisfiable");
				
	}
	
 	public void solve ( String fileName ) 
        {
 		
		readFormula ( fileName );
		
		if (dp ( formula ) )
			success ( formula );
		else
			failure ( formula );
		
	}
	
 	// Recursive backtracking solution
	boolean dp ( Formula formula ) 
        {
		
		
		if (isEmpty(formula)) // First base case: solution found
			return true;
		else if (hasEmptyClause (formula)) // Second base case: dead end found
			return false;
		else {
			
			// Pick a branch variable
			int var = selectBranchVar ( formula );
			
			// Try to set var = false in the formula
			
			setVar ( var, formula, false );
			
			if (dp(formula)) 
				return true;
			else {
				
				// Unset var in the formula 
				unset ( var, formula );
				
				// Setting var to false did not work. 
				// Now try var = true
				
				setVar ( var, formula, true );
				
				if (dp (formula))
					return true;
				else {
					// Neither true nor false worked, so unset the branch 
					// variable and head back
					unset ( var, formula );
					return false;			
				}
			}
		}	
	}
	

	public static void main(String[] args) 
        {
		
		if (args.length < 1) {
			System.err.println ("Usage: java DP_solver cnf-formula");
			System.exit(0);
		}
		
		// Insert timing code here...
		new DP_solver().solve ( args[0] );

	}
}
