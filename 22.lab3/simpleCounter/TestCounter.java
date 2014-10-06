	/*
	 * @author Tobias Alld�n
	 * @author Jonathan Helsing
	 * Labbgrupp 22
	 */

public class TestCounter {
	
	public static void main(String[] args) {
		
		CounterModel cm1 = new CounterModel();
		CounterModel cm2 = new CounterModel();
		System.out.println("cm1 = " + cm1.getValue());
		System.out.println("cm2 = " + cm2.getValue());
		
		cm1.decrement();
		cm2.increment();
		
		/*
		 * Testar s� att cm1 och cm2 klarar av att n� positiva och
		 * negativa v�rden
		 */
		
		System.out.println("cm1 = " + cm1.getValue());
		System.out.println("cm2 = " + cm2.getValue());
	}
}