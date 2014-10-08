	/**
	 * @author Tobias Allden
	 * @author Jonathan Helsing
	 * Labbgrupp 22
	 */
package simpleCounter;

public class TestCounter {
	
	/**
	 * Main class method for the testing of CounterModel.
	 * @param args - unused.
	 */
	
	public static void main(String[] args) {
		
		CounterModel cmDefaultModulus = new CounterModel();
		CounterModel cm80Modulus = new CounterModel(80);
		CounterModel cm90Modulus = new CounterModel(90);
		
		// Testing if the default constructor gives the right modulus
		if(cmDefaultModulus.getModulus() != 10) {
			error(1);
		} else {
			System.out.println("Passed test: Default contstructor");
		}
		
		//Testing so that getting a higher count than modulus doesn't work
		for(int i = 1; i <= 90; i++) {
			cm80Modulus.increment();
			if(cm80Modulus.getValue() >= 80) {
				error(2);
			}
		}
		if(cm80Modulus.getValue() != 10) {
			error(3);
		} else {
			System.out.println("Passed test: increase value beyond modulus");
		}
		
		//Testing s that getting a count below 0 is not possible and
		//that the modulus sets the value as it should
		for(int i=1; i <= 5; i++) {
			cm90Modulus.decrement();
			if(cm90Modulus.getValue() <= 0) {
				error(5);
			}
		}
		if(cm90Modulus.getValue() != 86 ) {
			error(4);
		} else {
			System.out.println("Passed test: decrease value below 0");
		}
		
		//Testing the Equals method
		cm80Modulus.reset();
		cm90Modulus.reset();
		CounterModel cm80Modulus2 = new CounterModel(80);
		cm80Modulus2.increment();
		if(cm80Modulus.equals(cm80Modulus2)) {
			error(6);
		} else {
			cm80Modulus2.reset();
			cm80Modulus.reset();
			if(!cm80Modulus.equals(cm80Modulus2)) {
				error(8);
			} else {
				if(cm90Modulus.equals(cm80Modulus)) {
					error(7);
				} else {
					System.out.println("Passed Test: Equals");
				}
			}
		}

		//Testing the toString method
		String toString = "Value: " + cm90Modulus.getValue() + " Modulus: "
				+ cm90Modulus.getModulus();
		if(toString == cm90Modulus.toString()) {
			error(9);
		} else {
			System.out.println("Passed test: toString");
		}
		
		//Generating an array with CounterModels
		CounterModel[] cmArray = {new CounterModel(10), new CounterModel(20),
				new CounterModel(40), new CounterModel(10), new CounterModel(10)};
		for(int i=0; i<10; i++) {
			if(i%2 == 0) {
				cmArray[0].increment();
			} else {
				cmArray[1].decrement();
			}
			cmArray[2].increment();
			cmArray[3].decrement();
			cmArray[4].decrement();
		}
		
		//Testing toString with array
		System.out.println("Testing toString with cmArray[0]: " + cmArray[0].toString());
		
		//Testing equals with an array containing CounterModel objects
		if(cmArray[3].equals(cmArray[4])) {
			System.out.println("Passed test: equal with arrays");
		} else {
			error(11);
		}
		
		//Testing countTheCounter
		CounterModel countCounter = new CounterModel(20);
		System.out.print("Initial Value: " + countCounter.getValue());
		countTheCounter(countCounter);
		System.out.print(" New Value: " + countCounter.getValue());
		System.out.println("");
		
		//Testing FastCounter
		FastCounter x = new FastCounter(4,2);
		FastCounter x2 = new FastCounter(4,2);
		if(x.equals(x2)) {
			System.out.println("Passed test: Equals with FastCounter");
		} else {
			error(10);
		}
		System.out.println(x.toString());
		
		//Testing default constructor for FastCounter
		System.out.print("Default FastCounter: ");
		FastCounter x3 = new FastCounter();
		System.out.print(x3.toString());
		
	}
	
	/**
	 * All the error codes in this test-program goes here. 
	 * @param code - The specified error code.
	 */
	
	public static void error(int code) {
		switch(code) {
		case 1:
			System.out.println("Error Code 1: The default modulus is wrong");
			break;
		case 2:
			System.out.println("Error Code 2: The value of the counter is higher than modulus");
			break;
		case 3:
			System.out.println("Error Code 3: The value after reaching pass modulus is wrong");
			break;
		case 4:
			System.out.println("Error Code 4: The value after decrementing below 0 is wrong");
			break;
		case 5:
			System.out.println("Error code 5: The value of counter is below 0");
			break;
		case 6:
			System.out.println("Error Code 6: The CM are not supposed to be equals");
			System.out.println("Error Code 6: Only the modulus is supposed to be equals");
			break;
		case 7:
			System.out.println("Error Code 7: Different Modulus are not supposed to be equals");
			break;
		case 8:
			System.out.println("Error Code 8: Identical objects are suppoesd to be equals");
			break;
		case 9:
			System.out.println("Error Code 9: toString not working");
			break;
		case 10:
			System.out.println("Error Code 10: FastCounter equals not working");
			break;
		case 11:
			System.out.println("Error Code 11: Equals with array does not work.");
			break;
		}
	}
	
	/**
	 * Increases the count of a CounterModel by 10.
	 * @param cm - An instance of CounterModel.
	 */
	
	public static void countTheCounter(CounterModel cm) {
		for(int i=1; i<=10; i++) {
			cm.increment();
		}
	}
	
}