import java.awt.Color;

import javax.swing.Icon;

/* A class for cards to  be used in Memory.
 * @author Tobias Allden and Jonathan Helsing 
 * 
 */
public class Kort extends JColorfulButton{
	
	public enum Status {
		DOLT,SYNLIGT,SAKNAS
	}


	private Icon icon;//ikonen
	private Status status;
	
	public Kort(Icon i) {
		super(i);
		this.icon = i;
		this.setStatus(Status.SAKNAS);
	}//Konstruktor för icon
	
	public Kort(Icon i, Status status){
		super(i);
		this.icon = i;
		this.setStatus(status);
	}//Konstruktor för status och icon

	public void setStatus(Status status) {
		switch (status) {
		case DOLT:
			this.setBackground(Color.blue);
			this.status = Status.DOLT;
			setIcon(null);
			
			break;
		case SAKNAS:
			this.setBackground(Color.white);
			this.status = Status.SAKNAS;
			setIcon(null);
			
			break;
		case SYNLIGT:
			this.setBackground(Color.blue);
			this.status=Status.SYNLIGT;
			setIcon(icon);
			break;

		default:
			this.status = Status.SAKNAS;
			break;
		}

	} //För att setta statusen
	
	public Status getStatus(){
		return this.status;
	}//Returnar statusen
	
	public Kort copy(){
		return new Kort(this.icon,this.status);
		
	}//kopierar kort
	
	public boolean sammaBild(Kort k) {
		if (k.getIcon()==this.getIcon()) {
			return true;
		}
		else{
			return false;
		}
	}//Samma bild
	
	
	 	
	
	
}
