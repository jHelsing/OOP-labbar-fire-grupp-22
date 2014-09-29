	/*
	 * @author Tobias Alldén
	 * @author Jonathan Helsing
	 * Labbgrupp 22
	 */

public class TestCounter {
	
	public static void main(String[] args) {
		boolean b = true;
		CounterModel cm1 = new CounterModel();
		CounterModel cm2 = new CounterModel();
		System.out.println("cm1 = " + cm1.getValue());
		System.out.println("cm2 = " + cm2.getValue());
		
		for(int i = 0; i < 50; i++) {
			cm1.increment();
			cm2.decrement();
		}
		
		System.out.println("cm1 = " + cm1.getValue());
		System.out.println("cm2 = " + cm2.getValue());
		
		while(b) {
			cm1.decrement();
			if(cm1.getValue() == -10) {
				b = false;
			}
			System.out.print(cm1.getValue() + " ");
		}
	}
}