package simpleCounter;

public class FastCounter extends CounterModel {
	
	private int step;
	
	public FastCounter() {
		super(15);
		this.step=5;
	}
	
	public FastCounter(int modulus, int step) {
		super(modulus);
		this.step = step;
	}
	
	public void upMany() {
		for(int i=0; i<this.step; i++) {
			this.increment();
		}
	}
	
	public void downMany() {
		for(int i=0; i<this.step; i++) {
			this.decrement();
		}
	}
	
	public int getStep() {
		return this.step;
	}
	
	
	
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
	
	public String toString() {
		return "Value: " + this.getValue() + " Step: " + this.getStep() +
				" Modulus: " + this.getModulus();
	}
	
}
