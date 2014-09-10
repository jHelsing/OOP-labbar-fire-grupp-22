/*@author Tobias Alldén och Jonathan Helsing
 * Labbgrupp 22
 * 
 */


public class Rse {
	public static String errorMsg = new String( "Summan/Summorna är inte det samma,"
			+ " Summa1: " );

	public static boolean allRowSumsEqual( int[][] m ) {
		/*Kolla så att inte matrisen är tom, är null, endast innehåller en array
		* eller inte innehåller några arrays alls.
		* */
		if ( m == null ) {
			errorMsg = ( "Matrisen var null" );
			return false;
		
		}
		else if ( m.length == 1 ) {
			errorMsg = ( "Matrisen innehöll endast en lista" );
			return false;
			
		}
		else if ( m.length == 0 ) {
			errorMsg = ( "Matrisen innehåller inga listor" );
			return false;
		}
		/*Om den inte är 0 eller icke existerande
		 * summerar den de induvidiella termerna i varje kolumn
		 * och jämför sedan dem med det första värdet.
		 */
		else {
			int firstSum = rowSum( m[0] );
			errorMsg = errorMsg + firstSum + " ";
			//Initiera boolean som skall returneras efter 
			boolean returnVal = true;
			for ( int i = 0; i<m.length;i++ ) {
				int sumCol = rowSum( m[i] );
				
				
				if ( sumCol == firstSum ) {
					sumCol = 0;
				}
				else {
					errorMsg = errorMsg + (" | Summa" + ( i+1 ) + ": " + " " +  sumCol );
					returnVal = false;
					
				}
				
			
				
			}
			return returnVal;
		}
		
	}
	public static int rowSum( int[] v ) {
		//Initiera en variabel som skall vara summan av termerna i komumnen.
		int sumList = 0; 
		//Summera termerna;
		for (int col = 0; col<v.length; col++ ) {
			sumList = sumList + v[col];
		}
		//Returnera värdet
		return sumList;
		
	
	}

}

