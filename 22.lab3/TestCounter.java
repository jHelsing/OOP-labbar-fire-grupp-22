	/*
	 * @author Tobias Alldén
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
		 * Testar så att cm1 och cm2 klarar av att nå positiva och
		 * negativa värden
		 */
		
		for(int i = 0; i < 100; i++) {
			cm1.increment();
			cm2.decrement();
		}
		
		System.out.println("cm1 = " + cm1.getValue());
		System.out.println("cm2 = " + cm2.getValue());
		
		/* 
		 * Testar så att de klarar av att gå från positiva värden till
		 * negativa värden och tvärt om.
		 * cm1 går från pos till neg
		 * cm2 går från neg till pos
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