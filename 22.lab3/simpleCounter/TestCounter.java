	/*
	 * @author Tobias Allden
	 * @author Jonathan Helsing
	 * Labbgrupp 22
	 */
package simpleCounter;

public class TestCounter {
	
	public static void main(String[] args) {
		
		CounterModel cmDefaultModulus = new CounterModel();
		CounterModel cm80Modulus = new CounterModel(80);
		CounterModel cm90Modulus = new CounterModel(90);
		
		// Testing if the default constructor gives the right modulus
		if(cmDefaultModulus.getModulus() != 10) {
			error(1);
		}
		
		
		//Testing so that geting a higher count than modulus doesn't work
		for(int i = 1; i <= 90; i++) {
			cm80Modulus.increment();
			if(cm80Modulus.getValue() >= 80) {
				error(2);
			}
		}
		
		
		
		
	}
	
	public static void error(int code) {
		switch(code) {
		case 1:
			System.out.println("Error Code 1: The default modulus is wrong");
			break;
		case 2:
			System.out.println("Error Code 2: The value of the counter is higher than modulus");
			break;
		case 3:
			System.out.println("Error Code 3: The value after reaching passing modulus is wrong");
			break;
		case 4:
			System.out.println("Error Code 5: The value after decrementing below 0 is wrong");
		}
	}
}