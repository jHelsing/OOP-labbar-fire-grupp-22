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
		
		/*
		 * Testar s� att cm1 och cm2 klarar av att n� positiva och
		 * negativa v�rden
		 */
		
		for(int i = 0; i < 100; i++) {
			cm1.increment();
			cm2.decrement();
		}
		
		System.out.println("cm1 = " + cm1.getValue());
		System.out.println("cm2 = " + cm2.getValue());
		
		/* 
		 * Testar s� att de klarar av att g� fr�n positiva v�rden till
		 * negativa v�rden och tv�rt om.
		 * cm1 g�r fr�n pos till neg
		 * cm2 g�r fr�n neg till pos
		*/
		
		while(cm1.getValue() != -10) {
			cm1.decrement();
			System.out.print(cm1.getValue() + " ");
		}
		
		System.out.println("");
		
		while(cm2.getValue() != 20) {
			cm2.increment();
			System.out.print(cm2.getValue() + " ");
		}
	}
}