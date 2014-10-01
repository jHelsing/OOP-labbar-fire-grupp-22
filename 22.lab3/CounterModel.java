	/*
	 * @author Tobias Alldén
	 * @author Jonathan Helsing
	 * Labbgrupp 22
	 */

public class CounterModel implements CounterInterface {
	
	private int count;
	private static int nbrOfCounters;
	private int modulus;
	
	public CounterModel() {
		this.count = 0;
		this.modulus = 1;
		nbrOfCounters++;
	} // end CounterModel
	
	public CounterModel(int modulus) {
		this.count = 0;
		this.modulus = modulus;
		nbrOfCounters++;
	} // end CounterModel
	
	public void increment() {
		this.count = count + this.modulus;
	} // end increment
	
	public void decrement() {
		this.count = count - this.modulus;
	} // end decrement
	
	public void reset() {
		this.count = 0;
	} // end reset
	
	public int getValue() {
		return this.count;
	} // end getValue
	
	public static int getNbrOfCounters() {
		return nbrOfCounters;
	} // end getNbrOfCounters
	
	public int getModulus() {
		return this.modulus;
	} // end getModulus
	
}