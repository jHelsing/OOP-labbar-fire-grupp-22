	/**
	 * @author Tobias Allden
	 * @author Jonathan Helsing
	 * Labbgrupp 22
	 */

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
	 * @param Modulus - The max value for the counter. If the counter
	 * value reaches modulus it will reset to 0. If the counter reaches
	 * below 0 it will reset to modulus.
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
	
	/**
	 * Increases the value of the counter by one.
	 * If count reaches modulus it will reset the count to 0.
	 */
	
	public void increment() {
		this.count++;
		if((this.count % this.modulus) == 0) {
			this.count = 0;
		}
	} // end increment
	
	/**
	 * Decreases the value of the counter by one.
	 * if count get's below or equals 0 after decrementing
	 * it will set the count ot modulus instead.
	 */
	
	public void decrement() {
		int temp = this.count - 1;
		if(temp <= 0) {
			this.count = this.modulus;
		} else {
			this.count = temp;
		}
	} // end decrement
	
	/**
	 * Resets the value of the counter.
	 */
	
	public void reset() {
		this.count = 0;
	} // end reset
	
	/**
	 * Comparing two CounterModel objects by checking if their modulus
	 * and their value is the same. If they are the method will return true.
	 * If not, it will return false.
	 */
	
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
	
	/**
	 * Generates a string containing the value and modulus for the
	 * specified CounterModel.
	 */
	
	public String toString() {
		return "Value: " + this.count + " Modulus: " + this.modulus;
	}
	
	/**
	 * A getter for the value of the specified CounterModel.
	 * @return The value of the instance.
	 */
	
	public int getValue() {
		return this.count;
	} // end getValue
	
	/**
	 * A getter for the amount of counters that has been generated.
	 * @return The number of instances of CounterModel that has been created.
	 */
	
	public static int getNbrOfCounters() {
		return nbrOfCounters;
	} // end getNbrOfCounters
	
	/**
	 * A getter for the modulus of the specified CounterModel
	 * @return The modulus of the instance.
	 */
	
	public int getModulus() {
		return this.modulus;
	} // end getModulus
	
}