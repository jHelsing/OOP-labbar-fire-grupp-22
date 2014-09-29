import java.util.ArrayList;
import java.util.Arrays;

/* A class to test the sum of several list of arrays to see if they are the same.
 * Group 22.
 *  @author Tobias Alldén
 *  @author Jonathan Helsing 
 * 	@version 1.0
 */ 
public class TestRse {
	public static ArrayList<Boolean> resultValues = new ArrayList<Boolean>();
	public static ArrayList<Boolean> checkAgainst = new ArrayList<Boolean>(Arrays.asList(true,false,true,true,false,true,true));
	public static void main( String[] args ) {
		
		//Declare lists of arrays.
		
		int[][] a = {{1,2,3},{3,2,1}}; //true
		int[][] b = {{},{2,3,4}}; //false
		int[][] c = {null}; //True
		int[][] d = {null,null}; //true
		int[][] e = {{1,4,5,6,7}, {2,4,5,6,6}, {3,4,5,6,7}}; //False
		int[][] f = {{},{}}; //true
		int[][] g = {{1,2,3,4},{4,3,2,1},{5,3,2}}; //true
		
		//Call the method "Evaluator" which will call RSE and compare the result.
		Evaluator( a, "a", 1 );
		Evaluator( b, "b", 2 );
		Evaluator( c, "c", 3 );
		Evaluator( d, "d", 4 );
		Evaluator( e, "e", 5 );
		Evaluator( f, "f", 6 );
		Evaluator( g, "g", 7 );
		
		CompareLists(resultValues, checkAgainst);		
	}
	//end main
	/* Checks the sum of the lists.
	 */
	public static void Evaluator( int [][] currentList, String name, int id ) {
		Boolean tmpBool = Rse.allRowSumsEqual(currentList);
			resultValues.add(tmpBool);
			System.out.println( "Test " + id + " List:" + name + " result: " + tmpBool );		
	}//end Evaluator
	public static void CompareLists (ArrayList<Boolean> setValues, ArrayList<Boolean> checkValues) {
		Boolean sumTest = true;
		for ( int i=0;i<resultValues.size();i++ ) {
			if ( checkValues.get(i)==setValues.get(i) ) {			
			} else {
				sumTest = false;
			}		
		}	 
		
		if( sumTest ){
			System.out.println( "Tests passed!" );
		} else {
			System.out.println( "Something went wrong" );
			System.out.println( "Tests were not passed :c" );
		}
		
	} //end CompareList
}//end TestRse
