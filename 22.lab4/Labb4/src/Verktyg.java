
/**
 * 	A class for tools
 * @author Tobias Allden and Jonathan Helsing 
 */

public class Verktyg {
	
	// Slumpa om platserna i arrayen
	public static void slumpOrdning(Object[] arr) {
		Object[] tempArr = new Object[arr.length];
		for(int i=0; i<tempArr.length; i++) {
			tempArr[i] = null;
		}
		int random = (int) (Math.random()*tempArr.length);
		for(int i=0; i<arr.length; i++) {
			while(tempArr[random] != null) {
				random = (int) (Math.random()*tempArr.length);
			}
			tempArr[random] = arr[i];
		}
		
		for(int i=0; i<tempArr.length; i++) {
			arr[i] = tempArr[i];
		}
	}

}
