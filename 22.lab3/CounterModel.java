	/*
	 * @author Tobias Alldén
	 * @author Jonathan Helsing
	 * Labbgrupp 22
	 */

public class CounterModel {
	
	private int count;
	
	public interface CounterInterface() {
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
	
}