/* A class for testing Secant.java.
 * @author Tobias Allden and Jonathan Helsing
 * 
 */
public class TestaSecant {
	private static int nbrOfErrors = 0;
	static boolean error = false;

	//Print out header, then start declaring functions
	public static void main(String[] args) {
		Function f;
		double eps = 0.0000000001;
		System.out.println("=======================================");
		System.out.println("Functions test");
		System.out.println("Testresults as: ");
		System.out.println("Status: function : expected result: Calculated result: interval: ErrorMessage");
		System.out.println("---------------------------------------");

		//Declare functions, then test them with the method testFunction.
		f = new Function() {
			public double f(double x){return 3*x-6;}
			public String toString() {return "3*x-6";}
		};
		testFunction(f, eps, 0, 5,"2.0", "");
		testFunction(f, eps, 3, 5, "---", "Err: root outside interval");

		f = new Function() {
			public double f(double x){return 3*x+6;}
			public String toString() {return "3x+6";}
		};
		testFunction(f, eps, 0, 10,"---" , "Err: Root outside interval");

		f = new Function() {
			public double f(double x){return (x*x*x-8);}
			public String toString() {return "(x*x*x-8)";}
		};
		testFunction(f, eps, 0, 5,"2.0" , "");
		testFunction(f, eps, -8, 1,"---" , "Err: root outside interval");

		f = new Function() {
			public double f(double x){return 1E-16 * x*x-1E-17;}
			public String toString() {return "1E-16 * x*x-1E-17";}
		};
		testFunction(f, eps, 0, 10,"0.316" , "Small root");
		testFunction(f, eps, 0.312,0.317,"0.316" , "Tiny interval");
		
		f = new Function() {
			public double f(double x){return (x*x-2);}
			public String toString() {return "(x^2-2)";}
		};
		testFunction(f, eps, 0, 10,"1.41" , "Positive interval");
		testFunction(f, eps, -3, -1,"-1.41" , "Negative interval");
		testFunction(f, eps, -3, 5,"+-1.41" , "Err: Two roots");
		
		f = new Function() {
			public double f(double x){return (x*x*x-x*x+2*x );}
			public String toString() {return "(x^3-x^2-2x)";}
		};
		testFunction(f, eps, 0, 2, "0.0", "");
		
		f = new Function() {
			public double f(double x){return (Math.pow((x+10), 2) - 0.6 );}
			public String toString() {return "(x+10)^2-0.6";}
		};
		testFunction(f, eps, -10, -8, "-9.22", "");
		testFunction(f, eps, -11, -8, "---", "Err: Two roots");
		
		f = new Function() {
			public double f(double x){
				//Ifall x går mot oändlighet , kasta exception
				if ( x < 0.1 - 1E-6) {
					throw new IllegalArgumentException("X out of range" + x);
				}
				return Math.log(x);
				}
			public String toString() {return "log(x)";}
		};
		testFunction(f, eps, 0.1, 2, "1", "");
		
		f = new Function() {
			public double f(double x){return (Math.atan(x) );}
			public String toString() {return "arctan(x)";}
		};
		testFunction(f, eps, -1, 2, "0", "");
		
		f = new Function() {
			public double f(double x){return x-2E-16 ;}
			public String toString() {return "x-2*10^-16";}
		};
		testFunction(f, eps, -5, 2, "0", "Small root");
		
		
		f = new Function() {
			public double f(double x){return Math.sin(x)-(x/2)*(x/2) ;}
			public String toString() {return "sin(x)-(x/2)*(x/2)";}
		};
		testFunction(f, eps, -2, 0.5, "0", "");
		testFunction(f, eps, 0.5, 2, "1.9337", "");
		testFunction(f, eps, -2, 0.5, "---", "Err: two roots");
		
		
		//When all tests are completed, print status, and number of errors (if there are any)
	if (nbrOfErrors == 0) {
		System.out.println("-------------------------------");
			System.out.println("All tests passed! No errors");
	} else {
		System.out.println("-------------------------------");
		System.out.println("Tests passed");
		System.out.println("Number of errors: " + nbrOfErrors);
		}

	}
	
	//Tests the function. This method takes 6 arguments, the function, the interval(high and low), expected result, and a message
	private static void testFunction(Function f, double eps, double low, double high,String expectedResult, String msg) {
		//If no errors are discovered, boolean error should remain false. Set default values.
		boolean error = false;
		String resultTxt = "---";
		String tmpErrorMsg ="";
		double result = 0.0;
		double epsTest = 0.05;
		
		//Try to run the Secant method using the arguments, if completed, and result is same as expected(+-epsTest), then print out OK, otherwise print out error
		try {
			result = Secant.secant(f, low, high, eps);
			resultTxt = Double.toString(result);
			if(tmpErrorMsg == "" && (result<=(Double.parseDouble(expectedResult)+epsTest) 
					&& result>=(Double.parseDouble(expectedResult)-epsTest))){
				System.out.println("OK: " + f.toString() + ": " + expectedResult + ": " + resultTxt +": " + "[" + low + ","
						+ high +"]"  + msg);
			} else {
				System.out.println("ERROR: " + f.toString() + ": " + expectedResult + ": " + resultTxt +": " + "[" + low + ","
						+ high +"]"  + msg);
			}

			//If Secant fails, it will throw an exception. 
			//Here we catch them and decide if there should have been an exception (Message starts with \"Err: \"")
			//Will also print out the messega retrieved from the exception
		}
		catch(IllegalArgumentException e) {
			error = true; 
			tmpErrorMsg = e.getMessage();
			if (msg.startsWith("Err") && error ==true) {
				System.out.println("OK: " + f.toString() + ": " + expectedResult + ": " + resultTxt +": " + "[" + low + ","
						+ high +"] " + tmpErrorMsg + ": "+ msg);
			} else if (error == true) {
				System.out.println("ERROR: " + f.toString() + ": " + expectedResult + ": " + resultTxt +": " + "[" + low + ","
						+ high +"] " + tmpErrorMsg + ": "+ msg);
				nbrOfErrors++;
			}
		}
		catch(StackOverflowError e) {
			error = true;
			tmpErrorMsg = e.getMessage();
			if (msg.startsWith("Err") && error ==true) {
				System.out.println("OK: " + f.toString() + ": " + expectedResult + ": " + resultTxt +": " + "[" + low + ","
						+ high +"]" + tmpErrorMsg + msg);
			} else if (error == true) {
				System.out.println("ERROR: " + f.toString() + ": " + expectedResult + ": " + resultTxt +": " + "[" + low + ","
						+ high +"]" + tmpErrorMsg + msg);
				nbrOfErrors++;

			}
		}
	}    
}
