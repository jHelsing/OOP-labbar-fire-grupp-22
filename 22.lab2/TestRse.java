/*
 * @author Tobias Alldén
 * @author Jonathan Helsing
 * Labbgrupp 22
 */
public class TestRse {
	public static void main(String[] args) {
		//Deklarera matriser;
		int [][] a = { {1, 2, 1, 2, 1, 2}, };
		int [][] b = null;
		//Kontrollera ifall summorna är desamma via allRowSumsEqual();
		if( Rse.allRowSumsEqual(a)) {
		System.out.println("Summorna är desamma");
	} else {
			//Är de inte det, printa errorMsg
			System.out.println(Rse.errorMsg);
		}
	} // end main
}
