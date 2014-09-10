/*@author Tobias Alld�n och Jonathan Helsing
 * Labbgrupp 22
 * 
 */


public class Rse {
	public static String errorMsg = new String( "Summan/Summorna �r inte det samma,"
			+ " Summa1: " );

	public static boolean allRowSumsEqual( int[][] m ) {
		/*Kolla s� att inte matrisen �r tom, �r null, endast inneh�ller en array
		* eller inte inneh�ller n�gra arrays alls.
		* */
		if ( m == null ) {
			errorMsg = ( "Matrisen var null" );
			return false;
		
		}
		else if ( m.length == 1 ) {
			errorMsg = ( "Matrisen inneh�ll endast en lista" );
			return false;
			
		}
		else if ( m.length == 0 ) {
			errorMsg = ( "Matrisen inneh�ller inga listor" );
			return false;
		}
		/*Om den inte �r 0 eller icke existerande
		 * summerar den de induvidiella termerna i varje kolumn
		 * och j�mf�r sedan dem med det f�rsta v�rdet.
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
		//Returnera v�rdet
		return sumList;
		
	
	}

}

