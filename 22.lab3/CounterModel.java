	/*
	 * @author Tobias Alldén
	 * @author Jonathan Helsing
	 * Labbgrupp 22
	 */

public class CounterModel implements CounterInterface {
	
	private int count;
	
	public void increment() {
		this.count++;
	}
	public void decrement() {
		this.count--;
	}
	public void reset() {
		this.count = 0;
	}
	public int getValue() {
		return this.count;
	}
	
}