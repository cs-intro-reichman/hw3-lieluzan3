// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter = 0;    // Number of iterations 
	
	
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		rate=rate/100;
		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	
	public  static double endBalance(double loan, double rate, int n, double payment) {	
		double balance = loan;
		for (int i = 0; i < n; i++) {
			balance = (balance - payment) * (1 + rate); // חישוב היתרה בסוף כל שנה
		}
		return balance;
	}
	
	
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		double payment = loan / n; 
		iterationCounter=0;
		while (endBalance(loan, rate, n, payment) > 0) {
			payment += epsilon; // הגדל את התשלום בצעד קטן
			iterationCounter++; // עדכן את מספר האיטרציות
		}
		return payment;		
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		double low = 0; 
		double high = loan * Math.pow(1 + rate, n) / n; 
		double mid = 0; 
		 
		iterationCounter=0;
		while ((high - low) > epsilon) {
			mid = (low + high) / 2;
			if (endBalance(loan, rate, n, mid) > 0) {
				low = mid; 
			} else {
				high = mid;
			}
			iterationCounter++;
		}
		return mid; // החזר את האומדן לתשלום
	}
		
    }
