	/**
	 * @author Tobias Allden
	 * @author Jonathan Helsing
	 * Labbgrupp 22
	 */

public class ChainedCounterModel extends CounterModel {
	
	private int modulus;
	private CounterInterface next;
	
	/**
	 * The constructor for a ChainedCounterModel. Passes the modulus into the superclass
	 * and sets the initial value and the counter coming after it.
	 * @param init - Sets the initial value of the counter.
	 * @param modulus - Sets the max value of the counter.
	 * @param next - Sets what the next Counter is. It will increment the next counter
	 * when the value of the counter reaches modulus.
	 */
	
	public ChainedCounterModel(int init, int modulus, CounterInterface next) {
		super(modulus);
		for(int i=1; i <= init; i++) {
			this.increment();
		}
		this.next = next;
	}
	
	/**
	 * Increments the value of the counter by 1. If the counter reaches 1 below modulus
	 * it will check if the next counter is null or if it exists. If it exists it will
	 * increment that counter and then increment itself. 
	 */
	
	public void increment() {
		int temp = this.getValue() + 1;
		if(super.getValue() == 59) {
			if(next != null) {
				next.increment();
			}
			super.increment();
		} else {
			super.increment();
		}
	}

}