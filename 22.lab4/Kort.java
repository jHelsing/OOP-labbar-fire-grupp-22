import javax.swing.Icon;

/* A class fo cards to  be used in Memory.
 * @author Tobias Allden and Jonathan Helsing 
 * 
 */
public class Kort extends JColorfulButton{

	private String status;//Statusvariablen(instansvariablen)
	private Icon icon;//ikonen
	
	public Kort(Icon i) {}//Konstruktor för icon
	
	public Kort(Icon i, String status){}//Konstruktor för status och icon
	
	public void setStatus(Icon i, String status) {} //För att setta statusen
	
	public String getStatus(){
		return this.status;
	}//Returnar statusen
	
	public Kort copy(){
		return new Kort(this.icon,this.status);
		
	}//kopierar kort
	
	public boolean sameIcon(Kort k) {}//Samma bild
	
	
	 	
	
	
}
