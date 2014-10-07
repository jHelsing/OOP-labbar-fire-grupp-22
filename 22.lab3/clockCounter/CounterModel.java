	/**
	 * @author Tobias Allden
	 * @author Jonathan Helsing
	 * Labbgrupp 22
	 */
package simpleCounter;

public class CounterModel implements CounterInterface {
	
	private int count;
	private static int nbrOfCounters;
	private int modulus;
	
	/**
	 * Standard constructor.
	 * Crates a new instance of CounterModel with modulus set to 10.
	 */
	
	public CounterModel() {
		this.count = 0;
		this.modulus = 10;
		nbrOfCounters++;
	} // end CounterModel
	
	/**
	 * The 2nd constructor with a parameter for a value for modulus.
	 * @param modulus
	 */
	
	public CounterModel(Integer modulus) {
		// If modulus is less than 0 we don't want to initiate a new CounterModel instance.
		if(modulus == null) {
			throw new NullPointerException("Modulus can not be null");
		} else if(modulus < 0) {
			throw new IllegalArgumentException("Modulus must have a positive value!");
		} else {
			this.count = 0;
			this.modulus = modulus;
			nbrOfCounters++;
		}
	} // end CounterModel
	
	public void increment() {
		this.count++;
		if((this.count % this.modulus) == 0) {
			this.count = 0;
		}
	} // end increment
	
	public void decrement() {
		int temp = this.count - 1;
		if(temp <= 0) {
			this.count = this.modulus;
		} else {
			this.count = temp;
		}
	} // end decrement
	
	public void reset() {
		this.count = 0;
	} // end reset
	
	public boolean equals(Object o) {
		if(o instanceof CounterModel) {
			CounterModel compareTo = (CounterModel) o;
			if(this.getValue() == compareTo.getValue()) {
				//they have identical value
				if(this.getModulus() == compareTo.getModulus()) {
					//they have identical modulus
					return true;
				} else {
					//if they don't have identical modulus
					return false;
				}
			} else {
				//if they don't have identical value
				return false;
			}
		} else {
			//if o isn't an instance of CounterModel
			return false;
		}
	}
	
	public String toString() {
		return "Value: " + this.count + " Modulus: " + this.modulus;
	}
	
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