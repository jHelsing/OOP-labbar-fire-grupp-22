	/**
	 * @author Tobias Allden
	 * @author Jonathan Helsing
	 * Labbgrupp 22
	 */

package simpleCounter;

public class FastCounter extends CounterModel {
	
	private int step;
	
	/**
	 * Default constructor for FastCounter.
	 * Creates a new CounterModel with modulus 15 and seting the step to 5.
	 */
	
	public FastCounter() {
		super(15);
		this.step=5;
	}
	
	/**
	 * Generates a new FastCounter with a specified step and modulus.
	 * @param modulus - Gets sent to the superclass where it creates a new
	 * instance of CounterModel with this modulus.
	 * @param step - Tells the upMany and downMany methods how
	 * much it should increase the instances value with.
	 */
	
	public FastCounter(int modulus, int step) {
		super(modulus);
		this.step = step;
	}
	
	/**
	 * Increases the value of the instance with the amount of steps that
	 * was specified in the object in the constructor.
	 */
	
	public void upMany() {
		for(int i=0; i<this.step; i++) {
			this.increment();
		}
	}
	
	/**
	 * Decreses the value of the instance with the amount of steps that
	 * was specified in the object in the constructor.
	 */
	
	public void downMany() {
		for(int i=0; i<this.step; i++) {
			this.decrement();
		}
	}
	
	/**
	 * A getter for the value of steps the specified object has.
	 * @return step for the specified instance.
	 */
	
	public int getStep() {
		return this.step;
	}
	
	/**
	 * A equals method for two instances of FastCounter.
	 * Makes sure that value, modulus and step are identical and
	 * if they are the method will return true. If they are not, it will return false.
	 */
	
	public boolean equals(Object o) {
		if(o instanceof FastCounter) {
			FastCounter compareTo = (FastCounter) o;
			if(this.getValue() == compareTo.getValue()) {
				//they have identical value
				if(this.getModulus() == compareTo.getModulus()) {
					//they have identical modulus
					if(this.getStep() == compareTo.getStep()) {
						//if they have identical step
						return true;
					} else {
						//if they don't have identical step
						return false;
					}
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
	 * Generates a string containing Value, Stepa and Modulus for the object.
	 */
	
	public String toString() {
		return "Value: " + this.getValue() + " Step: " + this.getStep() +
				" Modulus: " + this.getModulus();
	}
	
}
