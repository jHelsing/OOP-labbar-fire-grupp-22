/*@author Tobias Allden och Jonathan Helsing
 * Labbgrupp 22
 * 
 */
public class Rse {
	public static boolean allRowSumsEqual( int[][] m ) {
		/*Kolla så att inte matrisen är tom, är null, endast innehåller en array
		* eller inte innehåller några arrays alls.
		* */
		if ( m == null) {
			return true;		
		}
		else if ( m.length == 1 || m.length == 0 ) {
			return true;
		}
		/*Om den inte är 0 eller icke existerande
		 * summerar den de induvidiella termerna i varje kolumn
		 * och jämför sedan dem med det första värdet.
		 */
		else {
			//Initiera boolean som skall returneras efter
			for ( int i = 0; i<m.length;i++ ) {	
				int firstSum = rowSum(m[0]);
				if ( rowSum( m[i] ) == firstSum) {
					
				} else if (rowSum( m[i] ) != firstSum) {				
					return false;
				}				
			}
			return true;
		}
		
	}
	public static int rowSum( int[] v ) {
		//Kolla om kolumnen har längden 0 (Inga element)
		int sumList = 0;
		if (v == null || v.length == 0) {
			return 0;
		} else {
			//Annars summera termerna i kolumnen
			for (int col = 0; col<v.length; col++ ) {
				sumList = sumList + v[col];
			}
			//Returnera värdet
			return sumList;
		}	
	}
}

