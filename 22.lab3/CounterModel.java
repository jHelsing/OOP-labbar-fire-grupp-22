	/*
	 * @author Tobias Alldén
	 * @author Jonathan Helsing
	 * Labbgrupp 22
	 */

public class CounterModel implements CounterInterface {
	
	private int count;
	private static int nbrOfCounters;
	
	public CounterModel() {
		this.count = 0;
		nbrOfCounters++;
	} // end CounterModel
	
	public void increment() {
		this.count++;
	} // end increment
	
	public void decrement() {
		this.count--;
	} // end decrement
	
	public void reset() {
		this.count = 0;
	} // end reset
	
	public int getValue() {
		return this.count;
	} // end getValue
	
	public static int getNbrOfCounters() {
		return nbrOfCounters;
	} // getNbrOfCounters
	
}